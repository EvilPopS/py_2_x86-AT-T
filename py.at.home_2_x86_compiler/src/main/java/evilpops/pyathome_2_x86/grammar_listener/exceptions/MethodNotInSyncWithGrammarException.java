package main.java.evilpops.pyathome_2_x86.grammar_listener.exceptions;

public class MethodNotInSyncWithGrammarException extends RuntimeException {
    public MethodNotInSyncWithGrammarException(String customMess) {
        super(
                String.format(
                    "Method implementation appears not to be in sync with defined grammar.\nMethod Name: -- %s --\n",
                    customMess
                )
        );
    }
    public MethodNotInSyncWithGrammarException() {
        super("Method implementation appears not to be in sync with defined grammar.");
    }
}
