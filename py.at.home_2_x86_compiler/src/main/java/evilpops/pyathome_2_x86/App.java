package main.java.evilpops.pyathome_2_x86;

import main.java.evilpops.pyathome_2_x86._migration.assembly_generator.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86._migration.grammar.grammar_classes.PyAtHomeLexer;
import main.java.evilpops.pyathome_2_x86._migration.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86._migration.grammar_listener.PyAtHomeListener;
import main.java.evilpops.pyathome_2_x86._migration.log_handler.LogHandler;
import main.java.evilpops.pyathome_2_x86._migration.log_handler.SyntaxErrorListener;
import main.java.evilpops.pyathome_2_x86._migration.log_handler.exceptions.CompilationError;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

import static main.java.evilpops.pyathome_2_x86.config.Configuration.INPUT_FILE_PATH;



public class App {
    public static void main( String[] args ) throws IOException {
        try {
            PyAtHomeParser parser = new PyAtHomeParser(
                new CommonTokenStream(
                    new PyAtHomeLexer(
                            CharStreams.fromFileName(INPUT_FILE_PATH)
                    )
                )
            );
            parser.removeParseListeners();
            parser.removeErrorListeners();
            parser.addParseListener(new PyAtHomeListener());
            parser.addErrorListener(new SyntaxErrorListener());
            parser.program();

            LogHandler.getInstance().printWarningMessagesIfAny();
            AssemblyGenerator.getInstance().printToConsole();
        } catch (CompilationError compilationError) {
            LogHandler.getInstance().printErrorMessage(compilationError.getMessage());
        }

    }
}
