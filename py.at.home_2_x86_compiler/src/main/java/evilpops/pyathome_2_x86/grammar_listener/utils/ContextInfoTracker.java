package main.java.evilpops.pyathome_2_x86.grammar_listener.utils;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class ContextInfoTracker {
    private static class FuncCtxInfo {
        @Getter
        protected int funcRef;
        @Getter
        protected int varCounter;
        protected int nonFloatParamCnt;
        protected int floatParamCnt;

        public FuncCtxInfo(int funcRef) {
            this.funcRef = funcRef;
            this.varCounter = 0;
            this.nonFloatParamCnt = 0;
            this.floatParamCnt = 0;
        }

        public int incAndGetVarCounter() {
            return ++this.varCounter;
        }

        public int incAndGetNonFloatParamCnt() {
            return ++this.nonFloatParamCnt;
        }

        public int incAndGetFloatParamCnt() {
            return ++this.floatParamCnt;
        }
    }

    protected int literalLblCounter;

    @Getter
    protected int scope;

    @Getter
    protected int currFuncRef;

    private final List<FuncCtxInfo> funcContexts;

    public ContextInfoTracker() {
        this.literalLblCounter = 0;
        this.scope = 0;
        this.funcContexts = new ArrayList<>();
        this.incFuncCtx(-1);
    }

    public void incFuncCtx(int funcRef) {
        this.funcContexts.add(new FuncCtxInfo(funcRef));
        this.currFuncRef = funcRef;
    }

    public void decFuncCtx() {
        this.funcContexts.remove(this.funcContexts.size() - 1);
        this.currFuncRef = this.getCurrFuncCtx().getFuncRef();
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

    public int getCurrVarCounter() {
        return this.getCurrFuncCtx().getVarCounter();
    }

    public int incAndGetNonFloatParamCnt() {
        return this.getCurrFuncCtx().incAndGetNonFloatParamCnt();
    }

    public int incAndGetFloatParamCnt() {
        return this.getCurrFuncCtx().incAndGetFloatParamCnt();
    }

    private FuncCtxInfo getCurrFuncCtx() {
        return this.funcContexts.get(this.funcContexts.size() - 1);
    }
}


