package main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.function_def_domain;

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

public class ParamNonDefValCtxProcessor {
    private static final IAssemblyGenerator assemblyGenerator = AssemblyGenerator.getInstance();
    private static final ISymTabController symTabController = SymTabController.getInstance();
    private static final CompilationInfoTracker compilationInfoTracker = CompilationInfoTracker.getInstance();

    public static void processOnExit(PyAtHomeParser.ParamNonDefValContext ctx) {
        if (ctx.COMMA() != null)
            return;

        if (ctx.varType() == null)
            throw new CompilationError("Function parameter without default value must have explicit datatype.");

        DataType paramDataType = TypesContextProcessor.convertTypingCtxToDataType(ctx.varType().types());

        boolean is64bit = !paramDataType.equals(DataType.FLOAT);

        int perDataTypeParamOrdinality = is64bit
                ? compilationInfoTracker.getCurrFuncTracker().incAndGetNonFloatParamCnt()
                : compilationInfoTracker.getCurrFuncTracker().incAndGetFloatParamCnt();

        int paramRef = symTabController.addParameter(
                paramDataType,
                symTabController.getFuncScope(
                        compilationInfoTracker.getCurrFuncTracker().getFuncRef()
                ),
                compilationInfoTracker.getBlockScopeTracker().getScope(),
                ctx.ID().getText(),
                compilationInfoTracker.getCurrFuncTracker().getFuncRef(),
                false,
                compilationInfoTracker.getCurrFuncTracker().getTotalParamCnt(),
                perDataTypeParamOrdinality);

        paramRef = symTabController.transferParamToVar(
                paramRef,
                compilationInfoTracker.getCurrFuncTracker().incAndGetVarCounter(),
                compilationInfoTracker.getFunctionScopeTracker().getScope(),
                compilationInfoTracker.getBlockScopeTracker().getScope()
        );

        assemblyGenerator.genStackPointerDec(1);
        assemblyGenerator.genMoveSymbolToSymbol(
                AssemblySymbolProcessor.createAssemblySymbol(
                        symTabController.takeParamReg(
                                perDataTypeParamOrdinality,
                                symTabController.getDataType(paramRef)
                        )
                ),
                AssemblySymbolProcessor.createAssemblySymbol(paramRef),
                is64bit
        );
    }

}
