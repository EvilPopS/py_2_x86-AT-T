package main.java.evilpops.pyathome_2_x86.exceptions.compilation.errors;

import main.java.evilpops.pyathome_2_x86.log_handler.exceptions.CompilationError;

public class ReturnStatementMissingForFunctionException extends CompilationError {

    public ReturnStatementMissingForFunctionException(String funcName) {
        super(String.format(
                "At least one terminal code execution branch in function '%s' is not returning from function!",
                funcName)
        );
    }
}
