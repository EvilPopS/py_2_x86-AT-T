package main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.if_statement_domain;

import main.java.evilpops.pyathome_2_x86.assembly_generator.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.assembly_generator.IAssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.compilation_info_tracker.CompilationInfoTracker;

public class ElifStatPartCtxProcessor {
    private static final IAssemblyGenerator assemblyGenerator = AssemblyGenerator.getInstance();
    private static final CompilationInfoTracker compilationInfoTracker = CompilationInfoTracker.getInstance();

    public static void processOnEnter() {
        compilationInfoTracker.getIfStatLblTracker().incCurrElifLblNum();
        assemblyGenerator.genElifStatStartLabel(
                compilationInfoTracker.getIfStatLblTracker().getCurrLblNum(),
                compilationInfoTracker.getIfStatLblTracker().getCurrElifLblNum()
        );
    }

    public static void processOnExit() {
        int ifElifElseLblNum = compilationInfoTracker.getIfStatLblTracker().getCurrLblNum();
        assemblyGenerator.genJmpIfElifElseEnd(ifElifElseLblNum);
        assemblyGenerator.genElifStatEndLabel(
                ifElifElseLblNum,
                compilationInfoTracker.getIfStatLblTracker().getCurrElifLblNum()
        );
    }
}
