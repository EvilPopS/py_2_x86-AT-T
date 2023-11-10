package main.java.evilpops.pyathome_2_x86.listener.exceptions;

public class ListenerNotInSyncWithGrammarException extends RuntimeException {
    public ListenerNotInSyncWithGrammarException(String customMess) {
        super(
                String.format(
                    "Listener implementation appears not to be in sync with defined grammar.\n-- %s --",
                    customMess
                )
        );
    }
    public ListenerNotInSyncWithGrammarException() {
        super("Listener implementation appears not to be in sync with defined grammar.");
    }
}
