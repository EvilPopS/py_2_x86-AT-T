package main.java.evilpops.pyathome_2_x86.semantic_analyzer.exceptions;

public class DataTypesNotCompatibleException extends RuntimeException {
    public DataTypesNotCompatibleException(String operator, String lType, String rType) {
        super(
                String.format(
                        "Operator '%s' is not supported for operands of types '%s' and '%s'",
                        operator, lType, rType
                )
        );
    }

}
