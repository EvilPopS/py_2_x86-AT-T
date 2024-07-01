package main.java.evilpops.pyathome_2_x86.symbol_table.exceptions;

import main.java.evilpops.pyathome_2_x86.log_handler.exceptions.CompilationError;

public class ParameterNotFoundException extends CompilationError {
    public ParameterNotFoundException() {
        super("No parameter of given function has been found by the given name!");
    }
}
