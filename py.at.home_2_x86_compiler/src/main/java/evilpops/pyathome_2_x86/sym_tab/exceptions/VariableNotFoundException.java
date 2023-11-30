package main.java.evilpops.pyathome_2_x86.sym_tab.exceptions;

import main.java.evilpops.pyathome_2_x86.error_handlers.exceptions.CleanRuntimeException;

public class VariableNotFoundException extends CleanRuntimeException {
    public VariableNotFoundException() {
        super("No variable has been found by the given name!");
    }
}
