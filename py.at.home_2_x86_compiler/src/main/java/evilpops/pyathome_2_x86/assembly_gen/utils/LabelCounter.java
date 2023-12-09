package main.java.evilpops.pyathome_2_x86.assembly_gen.utils;

public class LabelCounter {
    protected int comparisonLblCount;

    public LabelCounter() {
        this.comparisonLblCount = -1;
    }

    public String getComparisonLblCount() {
        return Integer.toString(this.comparisonLblCount);
    }

    public void incrementComparisonLblCount() {
        this.comparisonLblCount++;
    }
}
