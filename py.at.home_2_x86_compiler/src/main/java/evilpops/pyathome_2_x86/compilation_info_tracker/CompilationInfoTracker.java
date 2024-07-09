package main.java.evilpops.pyathome_2_x86.compilation_info_tracker;

import lombok.Getter;
import main.java.evilpops.pyathome_2_x86.compilation_info_tracker.components.*;

import java.util.Stack;

public class CompilationInfoTracker {
    private static CompilationInfoTracker compilationInfoTracker;

    private final Stack<FunctionInfoTracker> funcContexts;

    @Getter
    protected final IfStatementLblTracker ifStatementLblTracker;
    @Getter
    protected final WhileStatementInfoTracker whileStatementInfoTracker;
    @Getter
    protected final DefParamsLblTracker defParamsLblTracker;
    @Getter
    protected final LiteralsLblTracker literalsLblTracker;
    @Getter
    protected final NonIdArgCountTracker nonIdArgCountTracker;
    @Getter
    protected final FunctionScopeTracker functionScopeTracker;
    @Getter
    protected final BlockScopeTracker blockScopeTracker;
    @Getter
    protected final ReturnStatInfoTracker returnStatInfoTracker;
    @Getter
    protected final MultiAssignInfoTracker multiAssignInfoTracker;

    private CompilationInfoTracker() {
        this.funcContexts = new Stack<>();
        this.ifStatementLblTracker = new IfStatementLblTracker();
        this.whileStatementInfoTracker = new WhileStatementInfoTracker();
        this.defParamsLblTracker = new DefParamsLblTracker();
        this.literalsLblTracker = new LiteralsLblTracker();
        this.nonIdArgCountTracker = new NonIdArgCountTracker();
        this.functionScopeTracker = new FunctionScopeTracker();
        this.blockScopeTracker = new BlockScopeTracker();
        this.returnStatInfoTracker = new ReturnStatInfoTracker();
        this.multiAssignInfoTracker = new MultiAssignInfoTracker();
        this.onNewFunctionStart(-1);
    }

    public static CompilationInfoTracker getInstance() {
        if (compilationInfoTracker == null)
            compilationInfoTracker = new CompilationInfoTracker();
        return compilationInfoTracker;
    }

    public FunctionInfoTracker getCurrFuncTracker() {
        return this.funcContexts.peek();
    }

    public void onNewFunctionStart(int funcRef) {
        this.funcContexts.push(new FunctionInfoTracker(funcRef));
    }

    public void onFunctionEnd() {
        this.funcContexts.pop();
    }
}
