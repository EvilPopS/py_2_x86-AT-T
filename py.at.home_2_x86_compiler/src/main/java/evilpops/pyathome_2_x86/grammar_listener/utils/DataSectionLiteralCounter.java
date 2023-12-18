package main.java.evilpops.pyathome_2_x86.grammar_listener.utils;

public class DataSectionLiteralCounter {
    protected int literalCounter;

    public DataSectionLiteralCounter() {
        this.literalCounter = 0;
    }

    public int getAndIncCounter() {
        return ++this.literalCounter;
    }
}
