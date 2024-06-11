package main.java.evilpops.pyathome_2_x86._migration.grammar_listener.ctx_processors;

import main.java.evilpops.pyathome_2_x86._migration.assembly_generator.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86._migration.assembly_generator.IAssemblyGenerator;
import main.java.evilpops.pyathome_2_x86._migration.compilation_info_tracker.CompilationInfoTracker;
import main.java.evilpops.pyathome_2_x86._migration.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86._migration.grammar_listener.utils.AssemblySymbolProcessor;
import main.java.evilpops.pyathome_2_x86._migration.grammar_listener.utils.TypesContextProcessor;
import main.java.evilpops.pyathome_2_x86._migration.symbol_table.ISymTabController;
import main.java.evilpops.pyathome_2_x86._migration.symbol_table.SymTabController;
import main.java.evilpops.pyathome_2_x86._migration.symbol_table.enums.DataType;

public class ParamNonDefValCtxProcessor {
    private static final IAssemblyGenerator assemblyGenerator = AssemblyGenerator.getInstance();
    private static final ISymTabController symTabController = SymTabController.getInstance();
    private static final CompilationInfoTracker compilationInfoTracker = CompilationInfoTracker.getInstance();

    public static void processOnExit(PyAtHomeParser.ParamNonDefValContext ctx) {
        if (ctx.ID() == null)
            return;

        DataType explicitType = (ctx.varType() != null)
                ? TypesContextProcessor.convertTypingCtxToDataType(ctx.varType().types())
                : DataType.UNKNOWN;

        boolean is64bit = !explicitType.equals(DataType.FLOAT);

        int paramOrdinality = is64bit
                ? compilationInfoTracker.incAndGetNonFloatParamCnt()
                : compilationInfoTracker.incAndGetFloatParamCnt();

        int paramRef = symTabController.addParameter(
                explicitType,
                compilationInfoTracker.getScope(),
                explicitType,
                ctx.ID().getText(),
                compilationInfoTracker.getCurrFuncRef(),
                false,
                paramOrdinality
        );

        paramRef = symTabController.transferParamToVar(
                paramRef,
                compilationInfoTracker.incAndGetCurrVarCounter()
        );

        assemblyGenerator.genStackPointerDec(1);
        assemblyGenerator.genMoveSymbolToSymbol(
                AssemblySymbolProcessor.createAssemblySymbol(
                        symTabController.takeParamReg(paramOrdinality, symTabController.getDataType(paramRef))
                ),
                AssemblySymbolProcessor.createAssemblySymbol(paramRef),
                is64bit
        );
    }

}
