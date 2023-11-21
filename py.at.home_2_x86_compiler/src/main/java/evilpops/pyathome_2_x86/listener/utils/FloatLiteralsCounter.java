package main.java.evilpops.pyathome_2_x86.listener.utils;

public class FloatLiteralsCounter {
    protected int floatLiteralsCounter;

    public FloatLiteralsCounter() {
        this.floatLiteralsCounter = 0;
    }

    public int getAndIncCounter() {
        return ++this.floatLiteralsCounter;
    }
}
