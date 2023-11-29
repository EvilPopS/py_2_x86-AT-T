package main.java.evilpops.pyathome_2_x86.assembly_gen.exceptions;

public class CannotConvertGivenDataTypeToFloatException extends RuntimeException {
    public CannotConvertGivenDataTypeToFloatException(String givenType) {
        super(String.format("Cannot convert %s to float!", givenType));
    }
}
