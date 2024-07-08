package main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.if_and_while_statements_domain;

import main.java.evilpops.pyathome_2_x86.assembly_generator.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.assembly_generator.IAssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.compilation_info_tracker.CompilationInfoTracker;

public class IfStatPartCtxProcessor {
    private static final IAssemblyGenerator assemblyGenerator = AssemblyGenerator.getInstance();
    private static final CompilationInfoTracker compilationInfoTracker = CompilationInfoTracker.getInstance();

    public static void processOnEnter() {
        assemblyGenerator.genIfStatStartLabel(
                compilationInfoTracker.getIfStatementLblTracker().getCurrLblNum()
        );
    }

    public static void processOnExit() {
        int ifElifElseLblNum = compilationInfoTracker.getIfStatementLblTracker().getCurrLblNum();
        assemblyGenerator.genJmpIfElifElseEnd(ifElifElseLblNum);
        assemblyGenerator.genIfStatEndLabel(ifElifElseLblNum);
    }

}
