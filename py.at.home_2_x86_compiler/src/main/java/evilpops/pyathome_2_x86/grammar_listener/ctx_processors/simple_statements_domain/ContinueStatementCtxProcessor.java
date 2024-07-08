package main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.simple_statements_domain;

import main.java.evilpops.pyathome_2_x86.assembly_generator.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.assembly_generator.IAssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.compilation_info_tracker.CompilationInfoTracker;
import main.java.evilpops.pyathome_2_x86.exceptions.compilation.errors.InvalidContinueStatementException;
import main.java.evilpops.pyathome_2_x86.symbol_table.ISymTabController;
import main.java.evilpops.pyathome_2_x86.symbol_table.SymTabController;

public class ContinueStatementCtxProcessor {
    private static final IAssemblyGenerator assemblyGenerator = AssemblyGenerator.getInstance();
    private static final ISymTabController symTabController = SymTabController.getInstance();
    private static final CompilationInfoTracker compilationInfoTracker = CompilationInfoTracker.getInstance();

    public static void processOnExit() {
        if (!compilationInfoTracker.getWhileStatementInfoTracker().canDoContinueOrBreak())
            throw new InvalidContinueStatementException();

        assemblyGenerator.genJmpWhileConditionStartLbl(
                compilationInfoTracker.getWhileStatementInfoTracker().getCurrLblNum()
        );
    }
}
