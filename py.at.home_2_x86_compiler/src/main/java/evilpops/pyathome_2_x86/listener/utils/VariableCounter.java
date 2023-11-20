package main.java.evilpops.pyathome_2_x86.listener.utils;

import java.util.ArrayList;
import java.util.List;

public class VariableCounter {
    protected List<Integer> varCounters;

    public VariableCounter() {
        this.varCounters = new ArrayList<>();
        this.varCounters.add(0);
    }

    public int incAndGetCurrCounter() {
        return customIncAndGetCurrCounter(1);
    }

    public int doubleIncAndGetCurrCounter() {
        /* For float values because they take double the space on stack */
        return customIncAndGetCurrCounter(2);
    }

    public void blockStart() {
        this.varCounters.add(0);
    }

    public void blockEnd() {
        this.varCounters.remove(this.varCounters.size() - 1);
    }

    private int customIncAndGetCurrCounter(int custom) {
        int incremented = this.varCounters.get(this.varCounters.size() - 1) + custom;
        this.varCounters.set(
                this.varCounters.size() - 1,
                incremented
        );
        return incremented;
    }
}
