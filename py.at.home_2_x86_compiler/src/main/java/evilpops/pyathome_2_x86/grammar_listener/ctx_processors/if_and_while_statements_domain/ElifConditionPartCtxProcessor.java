package main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.if_and_while_statements_domain;

import main.java.evilpops.pyathome_2_x86.assembly_generator.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.assembly_generator.IAssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.compilation_info_tracker.CompilationInfoTracker;
import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86.grammar_listener.utils.AssemblySymbolProcessor;
import main.java.evilpops.pyathome_2_x86.grammar_listener.utils.ConversionProcessor;
import main.java.evilpops.pyathome_2_x86.symbol_table.enums.DataType;

public class ElifConditionPartCtxProcessor {
    private static final IAssemblyGenerator assemblyGenerator = AssemblyGenerator.getInstance();
    private static final CompilationInfoTracker compilationInfoTracker = CompilationInfoTracker.getInstance();

    public static void processOnExit(PyAtHomeParser.ElifConditionPartContext ctx) {
        int conditionExpRef = ConversionProcessor.processTypeConversion(
                ctx.numExpression().getRefToSymTab(),
                DataType.BOOLEAN
        );

        assemblyGenerator.genCmpToZero(
                AssemblySymbolProcessor.createAssemblySymbol(conditionExpRef),
                true
        );

        assemblyGenerator.genJmpAfterElifStatCondition(
                compilationInfoTracker.getIfAndWhileStatementLblTracker().getCurrLblNum(),
                compilationInfoTracker.getIfAndWhileStatementLblTracker().getCurrElifLblNum()
        );
    }

}
