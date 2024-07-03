package main.java.evilpops.pyathome_2_x86.exceptions.compilation.errors;

import main.java.evilpops.pyathome_2_x86.log_handler.exceptions.CompilationError;

public class ReturnNotAllowedOutsideOfFuncDefException extends CompilationError {

    public ReturnNotAllowedOutsideOfFuncDefException() {
        super("Return statement is not allowed outside of a function definition!");
    }
}
