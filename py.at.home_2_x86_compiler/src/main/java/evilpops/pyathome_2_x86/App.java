package main.java.evilpops.pyathome_2_x86;

import main.java.evilpops.pyathome_2_x86.assembly_generator.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.cfg.Configuration;
import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeLexer;
import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86.grammar_listener.PyAtHomeListenerImpl;
import main.java.evilpops.pyathome_2_x86.log_handler.LogHandler;
import main.java.evilpops.pyathome_2_x86.log_handler.SyntaxErrorListener;
import main.java.evilpops.pyathome_2_x86.log_handler.exceptions.CompilationError;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;




public class App {
    public static void main( String[] args ) throws IOException {
        try {
            PyAtHomeParser parser = new PyAtHomeParser(
                new CommonTokenStream(
                    new PyAtHomeLexer(
                            CharStreams.fromFileName(Configuration.INPUT_FILE_PATH)
                    )
                )
            );
            parser.removeParseListeners();
            parser.removeErrorListeners();
            parser.addParseListener(new PyAtHomeListenerImpl());
            parser.addErrorListener(new SyntaxErrorListener());
            parser.program();

            LogHandler.getInstance().printWarningMessagesIfAny();
            AssemblyGenerator.getInstance().writeToFile("./src/main/java/evilpops/pyathome_2_x86/output/output.txt");
        } catch (CompilationError compilationError) {
            LogHandler.getInstance().printErrorMessage(compilationError.getMessage());
        }

    }
}
