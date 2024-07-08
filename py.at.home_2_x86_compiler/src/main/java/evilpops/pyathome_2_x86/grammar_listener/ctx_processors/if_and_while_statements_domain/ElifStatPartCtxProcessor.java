package main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.if_and_while_statements_domain;

import main.java.evilpops.pyathome_2_x86.assembly_generator.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.assembly_generator.IAssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.compilation_info_tracker.CompilationInfoTracker;

public class ElifStatPartCtxProcessor {
    private static final IAssemblyGenerator assemblyGenerator = AssemblyGenerator.getInstance();
    private static final CompilationInfoTracker compilationInfoTracker = CompilationInfoTracker.getInstance();

    public static void processOnEnter() {
        compilationInfoTracker.getIfStatementLblTracker().incCurrElifLblNum();
        assemblyGenerator.genElifStatStartLabel(
                compilationInfoTracker.getIfStatementLblTracker().getCurrLblNum(),
                compilationInfoTracker.getIfStatementLblTracker().getCurrElifLblNum()
        );
    }

    public static void processOnExit() {
        int ifElifElseLblNum = compilationInfoTracker.getIfStatementLblTracker().getCurrLblNum();
        assemblyGenerator.genJmpIfElifElseEnd(ifElifElseLblNum);
        assemblyGenerator.genElifStatEndLabel(
                ifElifElseLblNum,
                compilationInfoTracker.getIfStatementLblTracker().getCurrElifLblNum()
        );
    }
}
