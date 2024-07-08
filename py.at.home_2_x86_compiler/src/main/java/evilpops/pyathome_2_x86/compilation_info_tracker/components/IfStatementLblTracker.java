package main.java.evilpops.pyathome_2_x86.compilation_info_tracker.components;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Stack;

public class IfStatementLblTracker {
    @Getter
    @AllArgsConstructor
    protected static class Counters {
        protected int lblCounter;
        protected int elifCounter;

        public void incElifCounter() {
            this.elifCounter++;
        }
    }

    protected int globalCounter;
    protected final Stack<Counters> countersStack;

    public IfStatementLblTracker() {
        this.globalCounter = 0;
        this.countersStack = new Stack<>();
    }

    public void onNewStatementStart() {
        this.countersStack.push(new Counters(++this.globalCounter, 1));
    }

    public void onStatementEnd() {
        this.countersStack.pop();
    }

    public int getCurrLblNum() {
        return this.countersStack.peek().getLblCounter();
    }

    public int getCurrElifLblNum() {
        return this.countersStack.peek().getElifCounter();
    }

    public void incCurrElifLblNum() {
        this.countersStack.peek().incElifCounter();
    }
}
