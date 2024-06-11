package main.java.evilpops.pyathome_2_x86.symbol_table.exceptions;


import main.java.evilpops.pyathome_2_x86.log_handler.exceptions.CompilationError;

public class VariableNotFoundException extends CompilationError {
    public VariableNotFoundException() {
        super("No variable has been found by the given name!");
    }
}
