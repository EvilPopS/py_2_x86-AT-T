package main.java.evilpops.pyathome_2_x86.compilation_info_tracker.components;

import lombok.Getter;

@Getter
public class LiteralsLblTracker {
    protected int lblCounter;

    public LiteralsLblTracker() {
        this.lblCounter = 0;
    }

    public void incLblCounter() {
        this.lblCounter++;
    }

}
