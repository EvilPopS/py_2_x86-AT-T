package main.java.evilpops.pyathome_2_x86.log_handlers;

import main.java.evilpops.pyathome_2_x86.log_handlers.exceptions.SyntaxErrorException;
import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CustomErrorStrategy extends DefaultErrorStrategy {
    @Override
    public void recover(Parser parser, RecognitionException exception) {
        String offendingToken = exception.getOffendingToken().getText();
        if (offendingToken.equals("INVALID_DENT"))
            throw new SyntaxErrorException("Invalid indentation!");
        else
            throw new SyntaxErrorException(
                String.format(
                    "Unexpected symbol '%s'. Expecting: {%s}",
                    offendingToken.replace("\n", "\\n"),
                    Arrays.stream(parser.getExpectedTokens().toArray()).mapToObj(parser.getVocabulary()::getDisplayName)
                            .collect(Collectors.joining(", "))
                )
            );
    }
}
