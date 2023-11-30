package main.java.evilpops.pyathome_2_x86.grammar_listener.utils;

import java.util.ArrayList;
import java.util.List;

public class VariableCounter {
    protected List<Integer> varCounters;

    public VariableCounter() {
        this.varCounters = new ArrayList<>();
        this.varCounters.add(0);
    }

    public int incAndGetCurrCounter() {
        int incremented = this.varCounters.get(this.varCounters.size() - 1) + 1;
        this.varCounters.set(
                this.varCounters.size() - 1,
                incremented
        );
        return incremented;
    }

    public void blockStart() {
        this.varCounters.add(0);
    }

    public void blockEnd() {
        this.varCounters.remove(this.varCounters.size() - 1);
    }

}
