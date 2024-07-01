package main.java.evilpops.pyathome_2_x86.exceptions.other;

public class BadImplementationException extends RuntimeException{
    public BadImplementationException() {
        super("Unexpected error. Bad implementation!");
    }
}
