package main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.if_statement_domain;

import main.java.evilpops.pyathome_2_x86.compilation_info_tracker.CompilationInfoTracker;

public class IfElifElseStatementCtxProcessor {
    private static final CompilationInfoTracker compilationInfoTracker = CompilationInfoTracker.getInstance();

    public static void processOnEnter() {
        compilationInfoTracker.getIfStatLblTracker().onNewIfStatementStart();
        compilationInfoTracker.getReturnStatInfoTracker().onIfStatementCreate();
    }

    public static void processOnExit() {
        compilationInfoTracker.getIfStatLblTracker().onIfStatementEnd();
    }
}
