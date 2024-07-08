package main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.shared_domain;

import main.java.evilpops.pyathome_2_x86.assembly_generator.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.assembly_generator.IAssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.compilation_info_tracker.CompilationInfoTracker;
import main.java.evilpops.pyathome_2_x86.symbol_table.ISymTabController;
import main.java.evilpops.pyathome_2_x86.symbol_table.SymTabController;

public class NonTerminalBlockCtxProcessor {
    private static final IAssemblyGenerator assemblyGenerator = AssemblyGenerator.getInstance();
    private static final CompilationInfoTracker compilationInfoTracker = CompilationInfoTracker.getInstance();
    private static final ISymTabController symTabController = SymTabController.getInstance();

    public static void processOnEnter() {
        compilationInfoTracker.getCurrFuncTracker().varCounterOnBlockStart();
        compilationInfoTracker.getBlockScopeTracker().incScope();
        compilationInfoTracker.getReturnStatInfoTracker().onBlockStart();
    }
}
