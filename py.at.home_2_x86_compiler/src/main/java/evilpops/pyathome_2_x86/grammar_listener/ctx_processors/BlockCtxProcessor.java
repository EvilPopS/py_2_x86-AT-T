package main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors;

import main.java.evilpops.pyathome_2_x86.compilation_info_tracker.CompilationInfoTracker;
import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeParser;

public class BlockCtxProcessor {
    private static final CompilationInfoTracker compilationInfoTracker = CompilationInfoTracker.getInstance();

    public static void processOnEnter(PyAtHomeParser.BlockContext ignored) {
        compilationInfoTracker.incScope();
    }


    public static void processOnExit(PyAtHomeParser.BlockContext ignored) {
        compilationInfoTracker.decScope();
    }


}
