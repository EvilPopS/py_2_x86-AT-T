package main.java.evilpops.pyathome_2_x86.compilation_info_tracker.components;

import lombok.Getter;

@Getter
public class NonIdArgCountTracker {
    protected int funcCallArgsCounter;

    public NonIdArgCountTracker() {
        this.funcCallArgsCounter = 0;
    }

    public void incCounter() {
        this.funcCallArgsCounter++;
    }

    public void resetCounter() {
        this.funcCallArgsCounter = 0;
    }
}
