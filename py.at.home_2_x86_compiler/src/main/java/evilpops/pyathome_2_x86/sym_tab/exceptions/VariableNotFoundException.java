package main.java.evilpops.pyathome_2_x86.sym_tab.exceptions;

public class VariableNotFoundException extends RuntimeException {
    public VariableNotFoundException() {
        super("No variable has been found by the given name!");
    }
}
