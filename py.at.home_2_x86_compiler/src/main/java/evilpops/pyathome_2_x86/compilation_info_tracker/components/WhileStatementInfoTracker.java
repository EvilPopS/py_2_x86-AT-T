package main.java.evilpops.pyathome_2_x86.compilation_info_tracker.components;

import lombok.Getter;

import java.util.Stack;

public class WhileStatementInfoTracker {
    @Getter
    protected int lblCounter;

    protected int globalCounter;
    protected final Stack<Integer> countersStack;

    protected int whileLoopDepth;

    public WhileStatementInfoTracker() {
        this.globalCounter = 0;
        this.countersStack = new Stack<>();
        this.whileLoopDepth = 0;
    }

    public void onNewStatementStart() {
        this.countersStack.push(++this.globalCounter);
    }

    public void onStatementEnd() {
        this.countersStack.pop();
    }

    public int getCurrLblNum() {
        return this.countersStack.peek();
    }

    public boolean canDoContinueOrBreak() {
        return this.whileLoopDepth > 0;
    }

    public void incWhileLoopDepth() {
        this.whileLoopDepth++;
    }

    public void decWhileLoopDepth() {
        this.whileLoopDepth--;
    }
}
