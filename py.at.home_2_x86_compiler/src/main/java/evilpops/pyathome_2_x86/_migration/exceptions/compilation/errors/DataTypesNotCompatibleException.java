package main.java.evilpops.pyathome_2_x86._migration.exceptions.compilation.errors;

import main.java.evilpops.pyathome_2_x86.log_handlers.exceptions.CompilationError;

public class DataTypesNotCompatibleException extends CompilationError {
    public DataTypesNotCompatibleException(String operator, String lType, String rType) {
        super(
                String.format(
                        "Operator '%s' is not supported for operands of types '%s' and '%s'",
                        operator, lType, rType
                )
        );
    }

}
