package main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.shared_domain;

import main.java.evilpops.pyathome_2_x86.assembly_generator.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.assembly_generator.IAssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.compilation_info_tracker.CompilationInfoTracker;
import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86.symbol_table.ISymTabController;
import main.java.evilpops.pyathome_2_x86.symbol_table.SymTabController;

public class BlockCtxProcessor {
    public static final IAssemblyGenerator assemblyGenerator = AssemblyGenerator.getInstance();
    private static final CompilationInfoTracker compilationInfoTracker = CompilationInfoTracker.getInstance();
    private static final ISymTabController symTabController = SymTabController.getInstance();

    public static void processOnEnter(PyAtHomeParser.BlockContext ignored) {
        compilationInfoTracker.getCurrFuncTracker().varCounterOnBlockStart();
        compilationInfoTracker.getBlockScopeTracker().incScope();
        compilationInfoTracker.getReturnStatInfoTracker().onBlockStart();
    }


    public static void processOnExit(PyAtHomeParser.BlockContext ignored) {
        int newBlockVarsNum = compilationInfoTracker.getCurrFuncTracker().getNumOfNewVarsFromCurrBlock();
        if (newBlockVarsNum != 0)
            assemblyGenerator.genStackPointerInc(newBlockVarsNum);

        compilationInfoTracker.getCurrFuncTracker().varCounterOnBlockEnd();
        symTabController.deleteCurrentBlockScope(
                compilationInfoTracker.getBlockScopeTracker().getScope()
        );
        compilationInfoTracker.getBlockScopeTracker().decScope();
        compilationInfoTracker.getReturnStatInfoTracker().onBlockEnd();
    }
}
