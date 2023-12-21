package main.java.evilpops.pyathome_2_x86.sym_tab.exceptions;

import main.java.evilpops.pyathome_2_x86.log_handlers.exceptions.CompilationError;

public class VariableNotFoundException extends CompilationError {
    public VariableNotFoundException() {
        super("No variable has been found by the given name!");
    }
}
