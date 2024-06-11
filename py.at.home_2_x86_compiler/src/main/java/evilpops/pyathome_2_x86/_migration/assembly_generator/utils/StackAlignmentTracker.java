package main.java.evilpops.pyathome_2_x86._migration.assembly_generator.utils;

import java.util.ArrayList;
import java.util.List;

public class StackAlignmentTracker {
    protected List<Boolean> stackAlignments;

    public StackAlignmentTracker() {
        this.stackAlignments = new ArrayList<>() {{
            add(true);
        }};
    }

    public boolean isCurrentBlockStackAligned() {
        return this.stackAlignments.get(this.stackAlignments.size() - 1);
    }

    public void invCurrStackAlignment() {
        this.stackAlignments.set(
                this.stackAlignments.size() - 1,
                !this.stackAlignments.get(this.stackAlignments.size() - 1)
        );
    }

    public void increaseBlock() {
        this.stackAlignments.add(true);
    }

    public void decreaseBlock() {
        this.stackAlignments.remove(this.stackAlignments.size()-1);
    }

}
