package main.java.evilpops.pyathome_2_x86.compilation_info_tracker.components;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Stack;

public class FunctionInfoTracker {
    @Getter
    @AllArgsConstructor
    protected static class VarCounter {
        protected int count;

        public void incVarCount() {
            this.count++;
        }

        public void decVarCountByAmount(int amount) {
            this.count -= amount;
        }
    }

    @Getter
    protected final int funcRef;

    protected int nonFloatParamCnt;
    protected int floatParamCnt;
    protected int[] takenGenPurposeRegs;

    protected Stack<VarCounter> varCounters;

    public FunctionInfoTracker(int funcRef) {
        this.funcRef = funcRef;
        this.varCounters = new Stack<>();
        this.varCounters.push(
                new VarCounter(0)
        );
        this.nonFloatParamCnt = 0;
        this.floatParamCnt = 0;
        this.takenGenPurposeRegs = null;
    }

    public int getNumOfNewVarsFromCurrBlock() {
        return this.varCounters.peek().count - this.varCounters.get(this.varCounters.size()-2).count;
    }

    public void varCounterOnBlockStart() {
        this.varCounters.push(
                new VarCounter(this.varCounters.peek().getCount())
        );
    }

    public void varCounterOnBlockEnd() {
        this.varCounters.pop();
    }

    public int incAndGetVarCounter() {
        this.varCounters.peek().incVarCount();
        return this.varCounters.peek().getCount();
    }

    public void decVarCounterByAmount(int amount) {
        this.varCounters.peek().decVarCountByAmount(amount);
    }

    public int incAndGetNonFloatParamCnt() {
        return ++this.nonFloatParamCnt;
    }

    public int incAndGetFloatParamCnt() {
        return ++this.floatParamCnt;
    }

    public int getTotalParamCnt() {
        return this.floatParamCnt + this.nonFloatParamCnt;
    }

    public void setTakenGenPurposeRegsState(int[] state) {
        this.takenGenPurposeRegs = state;
    }

    public int[] getTakenGenPurposeRegsState() {
        return this.takenGenPurposeRegs;
    }
}
