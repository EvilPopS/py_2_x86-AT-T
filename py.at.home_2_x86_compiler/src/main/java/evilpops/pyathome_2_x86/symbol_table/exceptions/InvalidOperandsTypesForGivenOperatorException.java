package main.java.evilpops.pyathome_2_x86.symbol_table.exceptions;

import main.java.evilpops.pyathome_2_x86.log_handler.exceptions.CompilationError;

public class InvalidOperandsTypesForGivenOperatorException extends CompilationError {
    public InvalidOperandsTypesForGivenOperatorException() {
        super("Given operands types are not compatible for given operator.");
    }
}
