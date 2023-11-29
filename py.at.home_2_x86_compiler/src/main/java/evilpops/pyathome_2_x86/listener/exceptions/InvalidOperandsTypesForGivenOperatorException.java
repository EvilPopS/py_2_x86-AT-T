package main.java.evilpops.pyathome_2_x86.listener.exceptions;

public class InvalidOperandsTypesForGivenOperatorException extends RuntimeException {
    public InvalidOperandsTypesForGivenOperatorException() {
        super("Convertor is asked to perform conversion from two incompatible types for the given operator!.");
    }
}
