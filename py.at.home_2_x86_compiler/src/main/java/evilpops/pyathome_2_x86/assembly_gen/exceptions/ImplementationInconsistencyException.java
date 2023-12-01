package main.java.evilpops.pyathome_2_x86.assembly_gen.exceptions;

public class ImplementationInconsistencyException extends RuntimeException {
    public ImplementationInconsistencyException(String methodName) {
        super(String.format("Implementation in method '%s' is not in sync with the other code or vice versa!", methodName));
    }
}
