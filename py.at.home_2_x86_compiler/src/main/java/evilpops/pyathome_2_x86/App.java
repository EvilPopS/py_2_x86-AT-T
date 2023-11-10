package main.java.evilpops.pyathome_2_x86;

import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeLexer;
import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86.listener.PyAtHomeListener;
import main.java.evilpops.pyathome_2_x86.sym_tab.ISymTabController;
import main.java.evilpops.pyathome_2_x86.sym_tab.SymTabController;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

import static main.java.evilpops.pyathome_2_x86.config.Configuration.INPUT_FILE_PATH;

public class App {
    public static void main( String[] args ) throws IOException {
        PyAtHomeParser parser = new PyAtHomeParser(
            new CommonTokenStream(
                new PyAtHomeLexer(
                        CharStreams.fromFileName(INPUT_FILE_PATH)
                )
            )
        );
        parser.addParseListener(new PyAtHomeListener());
        parser.program();
        ISymTabController a = SymTabController.getInstance();

    }
}
