package main.java.evilpops.pyathome_2_x86.exceptions.compilation.errors;

import main.java.evilpops.pyathome_2_x86.log_handler.exceptions.CompilationError;

public class InvalidContinueStatementException extends CompilationError {

    public InvalidContinueStatementException() {
        super("Invalid 'continue statement', it must be in while loop!");
    }
}
