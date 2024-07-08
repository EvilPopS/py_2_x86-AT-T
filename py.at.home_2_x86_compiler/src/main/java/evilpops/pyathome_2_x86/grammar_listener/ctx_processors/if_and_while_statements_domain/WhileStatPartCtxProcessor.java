package main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.if_and_while_statements_domain;

import main.java.evilpops.pyathome_2_x86.assembly_generator.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.assembly_generator.IAssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.compilation_info_tracker.CompilationInfoTracker;
import main.java.evilpops.pyathome_2_x86.symbol_table.ISymTabController;
import main.java.evilpops.pyathome_2_x86.symbol_table.SymTabController;

public class WhileStatPartCtxProcessor {
    private static final IAssemblyGenerator assemblyGenerator = AssemblyGenerator.getInstance();
    private static final CompilationInfoTracker compilationInfoTracker = CompilationInfoTracker.getInstance();
    private static final ISymTabController symTabController = SymTabController.getInstance();

    public static void processOnEnter() {
        compilationInfoTracker.getWhileStatementInfoTracker().incWhileLoopDepth();
    }

    public static void processOnExit() {
        int lblNum = compilationInfoTracker.getWhileStatementInfoTracker().getCurrLblNum();
        assemblyGenerator.genJmpWhileConditionStartLbl(lblNum);

        assemblyGenerator.genWhileBlockEndLbl(lblNum);

        int newBlockVarsNum = compilationInfoTracker.getCurrFuncTracker().getNumOfNewVarsFromCurrBlock();
        if (newBlockVarsNum != 0)
            assemblyGenerator.genStackPointerInc(newBlockVarsNum);

        compilationInfoTracker.getCurrFuncTracker().varCounterOnBlockEnd();
        symTabController.deleteCurrentBlockScope(
                compilationInfoTracker.getBlockScopeTracker().getScope()
        );
        compilationInfoTracker.getBlockScopeTracker().decScope();
        compilationInfoTracker.getReturnStatInfoTracker().onBlockEnd();

        assemblyGenerator.genStackPointerInc(1);
        compilationInfoTracker.getCurrFuncTracker().decVarCounterByAmount(1);

        assemblyGenerator.genJmpWhileElseStatEnd(lblNum);

        assemblyGenerator.genWhileStatPartEndLbl(lblNum);

        compilationInfoTracker.getWhileStatementInfoTracker().decWhileLoopDepth();
    }
}
