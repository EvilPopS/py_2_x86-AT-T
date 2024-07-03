package main.java.evilpops.pyathome_2_x86.compilation_info_tracker.components;

import lombok.Getter;

@Getter
public class DefParamsLblTracker {
    protected int lblCounter;

    public DefParamsLblTracker() {
        lblCounter = 0;
    }

    public void incLblCount() {
        this.lblCounter++;
    }
}
