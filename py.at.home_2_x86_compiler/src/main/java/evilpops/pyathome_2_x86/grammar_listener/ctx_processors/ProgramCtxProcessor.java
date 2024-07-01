package main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors;

import main.java.evilpops.pyathome_2_x86.assembly_generator.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.assembly_generator.IAssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeParser;

public class ProgramCtxProcessor {
    public static IAssemblyGenerator assemblyGenerator = AssemblyGenerator.getInstance();

    public static void processOnExit(PyAtHomeParser.ProgramContext ignored) {
        assemblyGenerator.genCodeEnd();
    }
}
