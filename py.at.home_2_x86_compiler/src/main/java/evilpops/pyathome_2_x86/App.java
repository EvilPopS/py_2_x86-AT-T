package main.java.evilpops.pyathome_2_x86;

import main.java.evilpops.pyathome_2_x86.assembly_gen.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.log_handlers.LogHandler;
import main.java.evilpops.pyathome_2_x86.log_handlers.SyntaxErrorHandler;
import main.java.evilpops.pyathome_2_x86.log_handlers.exceptions.CompilationError;
import main.java.evilpops.pyathome_2_x86.log_handlers.exceptions.CompilationWarning;
import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeLexer;
import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86.grammar_listener.PyAtHomeListener;
import main.java.evilpops.pyathome_2_x86.sym_tab.ISymTabController;
import main.java.evilpops.pyathome_2_x86.sym_tab.SymTabController;
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
            parser.addErrorListener(new SyntaxErrorHandler());
            parser.program();

            LogHandler.getInstance().printWarningMessagesIfAny();
            AssemblyGenerator.getInstance().printToConsole();
        } catch (CompilationError compilationError) {
            LogHandler.getInstance().printErrorMessage(compilationError.getMessage());
        }

    }
}
