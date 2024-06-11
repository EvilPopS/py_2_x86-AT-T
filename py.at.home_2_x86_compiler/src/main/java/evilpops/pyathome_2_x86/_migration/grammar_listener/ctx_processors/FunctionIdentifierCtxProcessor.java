package main.java.evilpops.pyathome_2_x86._migration.grammar_listener.ctx_processors;

import main.java.evilpops.pyathome_2_x86._migration.assembly_generator.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86._migration.assembly_generator.IAssemblyGenerator;
import main.java.evilpops.pyathome_2_x86._migration.compilation_info_tracker.CompilationInfoTracker;
import main.java.evilpops.pyathome_2_x86._migration.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86._migration.symbol_table.ISymTabController;
import main.java.evilpops.pyathome_2_x86._migration.symbol_table.SymTabController;

public class FunctionIdentifierCtxProcessor {
    private static final IAssemblyGenerator assemblyGenerator = AssemblyGenerator.getInstance();
    private static final ISymTabController symTabController = SymTabController.getInstance();
    private static final CompilationInfoTracker compilationInfoTracker = CompilationInfoTracker.getInstance();


    public static void processOnExit(PyAtHomeParser.FunctionIdentifierContext ctx) {
        String funcName = ctx.ID().getText();
        int funcRef = symTabController.addFunction(compilationInfoTracker.getScope()-1, funcName);
        compilationInfoTracker.incFuncCtx(funcRef);
        assemblyGenerator.genFuncStart(funcName);
    }
}
