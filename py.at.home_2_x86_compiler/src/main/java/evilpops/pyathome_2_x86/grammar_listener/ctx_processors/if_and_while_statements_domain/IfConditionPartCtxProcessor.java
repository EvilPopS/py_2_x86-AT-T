package main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.if_and_while_statements_domain;

import main.java.evilpops.pyathome_2_x86.assembly_generator.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.assembly_generator.IAssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.compilation_info_tracker.CompilationInfoTracker;
import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86.grammar_listener.utils.AssemblySymbolProcessor;
import main.java.evilpops.pyathome_2_x86.grammar_listener.utils.ConversionProcessor;
import main.java.evilpops.pyathome_2_x86.symbol_table.enums.DataType;

public class IfConditionPartCtxProcessor {
    private static final IAssemblyGenerator assemblyGenerator = AssemblyGenerator.getInstance();
    private static final CompilationInfoTracker compilationInfoTracker = CompilationInfoTracker.getInstance();


    public static void processOnExit(PyAtHomeParser.IfConditionPartContext ctx) {
        int conditionExpRef = ConversionProcessor.processTypeConversion(
                ctx.numExpression().getRefToSymTab(),
                DataType.BOOLEAN
        );

        assemblyGenerator.genCmpToZero(
                AssemblySymbolProcessor.createAssemblySymbol(conditionExpRef),
                true
        );

        assemblyGenerator.genJmpAfterIfStatCondition(
                compilationInfoTracker.getIfAndWhileStatementLblTracker().getCurrLblNum()
        );
    }
}
