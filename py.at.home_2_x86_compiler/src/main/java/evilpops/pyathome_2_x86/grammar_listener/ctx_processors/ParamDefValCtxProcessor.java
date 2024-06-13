package main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors;


import main.java.evilpops.pyathome_2_x86.assembly_generator.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.assembly_generator.IAssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.compilation_info_tracker.CompilationInfoTracker;
import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86.grammar_listener.utils.TypesContextProcessor;
import main.java.evilpops.pyathome_2_x86.symbol_table.ISymTabController;
import main.java.evilpops.pyathome_2_x86.symbol_table.SymTabController;
import main.java.evilpops.pyathome_2_x86.symbol_table.enums.DataType;

public class ParamDefValCtxProcessor {
    private static final IAssemblyGenerator assemblyGenerator = AssemblyGenerator.getInstance();
    private static final ISymTabController symTabController = SymTabController.getInstance();
    private static final CompilationInfoTracker compilationInfoTracker = CompilationInfoTracker.getInstance();

    public static void processOnExit(PyAtHomeParser.ParamDefValContext ctx) {
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
                true,
                paramOrdinality
        );
    }
}
