package main.java.evilpops.pyathome_2_x86.error_handlers;

public class SemanticErrorHandler {
    private static final SemanticErrorHandler semanticErrorHandler = new SemanticErrorHandler();
    private int line;

    private SemanticErrorHandler() {
        this.line = 0;
    }

    public static SemanticErrorHandler getInstance() {
        return semanticErrorHandler;
    }

    public void updateLine(int line) {
        this.line = line;
    }

    public void printErrorMessage(String message) {
        System.err.printf("At line %d: %s%n", line, message);
    }

}
