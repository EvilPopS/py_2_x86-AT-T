package main.java.evilpops.pyathome_2_x86.log_handler;

import main.java.evilpops.pyathome_2_x86.log_handler.exceptions.SyntaxErrorException;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SyntaxErrorListener extends BaseErrorListener {
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        LogHandler.getInstance().setSyntaxErrDetected(true);
        String offendingToken = ((Parser) recognizer).getCurrentToken().getText();
        if (offendingToken.equals("INVALID_DENT"))
            throw new SyntaxErrorException("Invalid indentation!");
        else
            throw new SyntaxErrorException(
                    String.format(
                            "Unexpected symbol '%s'. Expecting: {%s}",
                            offendingToken.replace("\n", "\\n"),
                            Arrays.stream(((Parser)recognizer).getExpectedTokens().toArray()).mapToObj(recognizer.getVocabulary()::getDisplayName)
                                    .collect(Collectors.joining(", "))
                    )
            );
    }
}
