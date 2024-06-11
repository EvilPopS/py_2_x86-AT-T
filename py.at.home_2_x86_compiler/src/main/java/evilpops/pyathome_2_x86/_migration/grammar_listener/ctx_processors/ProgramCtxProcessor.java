package main.java.evilpops.pyathome_2_x86._migration.grammar_listener.ctx_processors;

import main.java.evilpops.pyathome_2_x86._migration.assembly_generator.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86._migration.assembly_generator.IAssemblyGenerator;
import main.java.evilpops.pyathome_2_x86._migration.grammar.grammar_classes.PyAtHomeParser;

public class ProgramCtxProcessor {
    public static IAssemblyGenerator assemblyGenerator = AssemblyGenerator.getInstance();

    public static void processOnExit(PyAtHomeParser.ProgramContext ignored) {
        assemblyGenerator.genCodeEnd();
    }
}
