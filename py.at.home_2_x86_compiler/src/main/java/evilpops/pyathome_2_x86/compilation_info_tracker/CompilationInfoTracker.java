package main.java.evilpops.pyathome_2_x86.compilation_info_tracker;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CompilationInfoTracker {
    private static class FuncCtxInfo {
        @Getter
        protected int funcRef;
        @Getter
        protected int varCounter;
        protected int nonFloatParamCnt;
        protected int floatParamCnt;
        protected int[] takenGenPurposeRegs;

        public FuncCtxInfo(int funcRef) {
            this.funcRef = funcRef;
            this.varCounter = 0;
            this.nonFloatParamCnt = 0;
            this.floatParamCnt = 0;
            this.takenGenPurposeRegs = null;
        }

        public int incAndGetVarCounter() {
            return ++this.varCounter;
        }

        public void decVarCounter(int amount) {
            this.varCounter -= amount;
        }

        public int incAndGetNonFloatParamCnt() {
            return ++this.nonFloatParamCnt;
        }

        public int incAndGetFloatParamCnt() {
            return ++this.floatParamCnt;
        }

        public void setTakenGenPurposeRegsState(int[] state) {
            this.takenGenPurposeRegs = state;
        }

        public int[] getTakenGenPurposeRegsState() {
            return this.takenGenPurposeRegs;
        }
    }

    private static CompilationInfoTracker compilationInfoTracker;

    protected Stack<Integer> argsCounters;

    @Getter
    protected int funcCallArgsCounter;

    protected int literalLblCounter;

    @Getter
    protected int scope;

    @Getter
    protected int currFuncRef;

    private final List<FuncCtxInfo> funcContexts;

    private CompilationInfoTracker() {
        this.argsCounters = new Stack<>();
        this.funcCallArgsCounter = 0;
        this.literalLblCounter = 0;
        this.scope = 0;
        this.funcContexts = new ArrayList<>();
        this.incFuncCtx(-1);
    }

    public static CompilationInfoTracker getInstance() {
        if (compilationInfoTracker == null)
            compilationInfoTracker = new CompilationInfoTracker();
        return compilationInfoTracker;
    }

    public void incFuncCtx(int funcRef) {
        this.funcContexts.add(new FuncCtxInfo(funcRef));
        this.currFuncRef = funcRef;
    }

    public void decFuncCtx() {
        this.funcContexts.remove(this.funcContexts.size() - 1);
        this.currFuncRef = this.getCurrFuncCtx().getFuncRef();
    }

    public void incFuncCallArgsCounter() {
        this.funcCallArgsCounter++;
    }

    public void resetFuncCallArgsCounter() {
        this.funcCallArgsCounter = 0;
    }

    public int getAndIncLitLblCounter() {
        return this.literalLblCounter++;
    }

    public void incScope() {
        this.scope++;
    }

    public void decScope() {
        this.scope--;
    }

    public int incAndGetCurrVarCounter() {
        return this.getCurrFuncCtx().incAndGetVarCounter();
    }

    public void decCurrVarCounter(int amount) {
        this.getCurrFuncCtx().decVarCounter(amount);
    }

    public int getCurrVarCounter() {
        return this.getCurrFuncCtx().getVarCounter();
    }

    public int incAndGetNonFloatParamCnt() {
        return this.getCurrFuncCtx().incAndGetNonFloatParamCnt();
    }

    public int incAndGetFloatParamCnt() {
        return this.getCurrFuncCtx().incAndGetFloatParamCnt();
    }

    public void setCurrFuncTakenGenPurposeRegsState(int[] state) {
        this.getCurrFuncCtx().setTakenGenPurposeRegsState(state);
    }

    public int[] getCurrFuncTakenGenPurposeRegsState() {
        return this.getCurrFuncCtx().getTakenGenPurposeRegsState();
    }

    private FuncCtxInfo getCurrFuncCtx() {
        return this.funcContexts.get(this.funcContexts.size() - 1);
    }
}
