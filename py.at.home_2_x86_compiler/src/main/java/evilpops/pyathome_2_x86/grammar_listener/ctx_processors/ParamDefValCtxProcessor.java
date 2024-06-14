package main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors;


import main.java.evilpops.pyathome_2_x86.assembly_generator.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.assembly_generator.IAssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.compilation_info_tracker.CompilationInfoTracker;
import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86.grammar_listener.utils.AssemblySymbolProcessor;
import main.java.evilpops.pyathome_2_x86.grammar_listener.utils.TypesContextProcessor;
import main.java.evilpops.pyathome_2_x86.log_handler.exceptions.CompilationError;
import main.java.evilpops.pyathome_2_x86.symbol_table.ISymTabController;
import main.java.evilpops.pyathome_2_x86.symbol_table.SymTabController;
import main.java.evilpops.pyathome_2_x86.symbol_table.enums.DataType;

public class ParamDefValCtxProcessor {
    private static final IAssemblyGenerator assemblyGenerator = AssemblyGenerator.getInstance();
    private static final ISymTabController symTabController = SymTabController.getInstance();
    private static final CompilationInfoTracker compilationInfoTracker = CompilationInfoTracker.getInstance();

    public static void processOnEnter() {
        compilationInfoTracker.incGlobalTotalCountOfDefParams();
        int lblNum = compilationInfoTracker.getGlobalTotalCountOfDefParams();
        assemblyGenerator.genNonCondJmpToDefParamCondStart(lblNum);
        assemblyGenerator.genDefParamNumExpLabel(lblNum);
    }

    public static void processOnExit(PyAtHomeParser.ParamDefValContext ctx) {
        if (ctx.COMMA() != null)
            return;

        int numExpRef = ctx.numExpression().getRefToSymTab();
        DataType numExpDataType = symTabController.getDataType(numExpRef);

        if (
                ctx.varType() != null
                        && numExpDataType.equals(
                        TypesContextProcessor.convertTypingCtxToDataType(
                                ctx.varType().types()
                        )
                )
        ) {
            throw new CompilationError("Explicit and implicit parameter types must be the same!");
        }

        boolean is64bit = !numExpDataType.equals(DataType.FLOAT);

        int perDataTypeParamOrdinality = is64bit
                ? compilationInfoTracker.incAndGetNonFloatParamCnt()
                : compilationInfoTracker.incAndGetFloatParamCnt();

        int paramRef = symTabController.addParameter(
                numExpDataType,
                compilationInfoTracker.getScope(),
                ctx.ID().getText(),
                compilationInfoTracker.getCurrFuncRef(),
                true,
                compilationInfoTracker.getCurrFuncTotalParamCount(),
                perDataTypeParamOrdinality
        );

        int paramAsVarRef = symTabController.transferParamToVar(
                paramRef,
                compilationInfoTracker.incAndGetCurrVarCounter()
        );

        genAfterNumExpCode(paramAsVarRef, numExpRef, is64bit);
        genParamDefConditionCode(paramRef, paramAsVarRef);
    }

    private static void genAfterNumExpCode(int paramRef, int numExpRef, boolean is64bit) {
        assemblyGenerator.genStackPointerDec(1);
        assemblyGenerator.genMoveSymbolToSymbol(
                AssemblySymbolProcessor.createAssemblySymbol(numExpRef),
                AssemblySymbolProcessor.createAssemblySymbol(paramRef),
                is64bit
        );
        assemblyGenerator.genNonCondJmpToDefParamCondEnd(
                compilationInfoTracker.getGlobalTotalCountOfDefParams()
        );

    }

    private static void genParamDefConditionCode(int paramRef, int paramAsVarRef) {
        int lblNum = compilationInfoTracker.getGlobalTotalCountOfDefParams();
        assemblyGenerator.genDefParamCondStartLabel(lblNum);

        int paramRegRef = symTabController.takeParamReg(
                symTabController.getPerDataTypeParamOrdinality(paramRef),
                symTabController.getDataType(paramRef)
        );

        if (symTabController.checkIfDataTypeIsFloat(paramRef))
            genParamDefConditionWhen128bit(paramRegRef, paramAsVarRef);
        else
            genParamDefConditionWhen64bit(paramRegRef, paramAsVarRef);

        assemblyGenerator.genDefParamCondEndLabel(lblNum);
    }

    private static void genParamDefConditionWhen64bit(int paramRegRef, int paramAsVarRef) {
        assemblyGenerator.genCmpToUndefined64bit(
                AssemblySymbolProcessor.createAssemblySymbol(paramRegRef)
        );
        assemblyGenerator.genJmpIfEqToDefParamNumExpStart(
                compilationInfoTracker.getGlobalTotalCountOfDefParams()
        );
        assemblyGenerator.genStackPointerDec(1);
        assemblyGenerator.genMoveSymbolToSymbol(
                AssemblySymbolProcessor.createAssemblySymbol(paramRegRef),
                AssemblySymbolProcessor.createAssemblySymbol(paramAsVarRef),
                true
        );
    }

    private static void genParamDefConditionWhen128bit(int paramRegRef, int paramAsVarRef) {
        int undefinedAddressRegRef = symTabController.takeRegister(DataType.INTEGER);
        int undefinedAddressRefRefAs128bit = symTabController.takeRegister(DataType.FLOAT);

        assemblyGenerator.genMovUndefinedToReg(symTabController.getRegName(undefinedAddressRegRef));
        assemblyGenerator.genIntToFloatConversion(
                AssemblySymbolProcessor.createAssemblySymbol(undefinedAddressRegRef),
                AssemblySymbolProcessor.createAssemblySymbol(undefinedAddressRefRefAs128bit)
        );
        symTabController.freeIfIsRegister(undefinedAddressRegRef);

        assemblyGenerator.genCmpSymbolToSymbol(
                AssemblySymbolProcessor.createAssemblySymbol(paramRegRef),
                AssemblySymbolProcessor.createAssemblySymbol(undefinedAddressRefRefAs128bit),
                false
        );
        symTabController.freeIfIsRegister(undefinedAddressRefRefAs128bit);

        assemblyGenerator.genJmpIfEqToDefParamNumExpStart(
                compilationInfoTracker.getGlobalTotalCountOfDefParams()
        );
        assemblyGenerator.genStackPointerDec(1);
        assemblyGenerator.genMoveSymbolToSymbol(
                AssemblySymbolProcessor.createAssemblySymbol(paramRegRef),
                AssemblySymbolProcessor.createAssemblySymbol(paramAsVarRef),
                false
        );
    }
}
