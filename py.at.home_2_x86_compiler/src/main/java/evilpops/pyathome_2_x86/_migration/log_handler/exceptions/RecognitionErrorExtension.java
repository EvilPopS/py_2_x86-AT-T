package main.java.evilpops.pyathome_2_x86._migration.log_handler.exceptions;

import org.antlr.v4.runtime.*;

public class RecognitionErrorExtension extends RecognitionException {

    public RecognitionErrorExtension(String message, Recognizer<?, ?> recognizer, IntStream input, ParserRuleContext ctx, Token offendingTk) {
        super(message, recognizer, input, ctx);
        this.setOffendingToken(offendingTk);
    }
}
