package main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors;

import main.java.evilpops.pyathome_2_x86.assembly_generator.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.assembly_generator.IAssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.compilation_info_tracker.CompilationInfoTracker;
import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86.symbol_table.ISymTabController;
import main.java.evilpops.pyathome_2_x86.symbol_table.SymTabController;

public class FunctionDefCtxProcessor {
    public static IAssemblyGenerator assemblyGenerator = AssemblyGenerator.getInstance();
    private static final ISymTabController symTabController = SymTabController.getInstance();
    private static final CompilationInfoTracker compilationInfoTracker = CompilationInfoTracker.getInstance();

    public static void processOnEnter(PyAtHomeParser.FunctionDefContext ignored) {
        compilationInfoTracker.incScope();
        compilationInfoTracker.setCurrFuncTakenGenPurposeRegsState(
                symTabController.getAndFreeAllTakenGenPurposeRegs()
        );
    }

    public static void processOnExit(PyAtHomeParser.FunctionDefContext ignored) {
        assemblyGenerator.genFuncEnd(
                symTabController.getFuncName(compilationInfoTracker.getCurrFuncRef()),
                compilationInfoTracker.getCurrVarCounter(),
                false //TODO check whether it's default return
        );
        compilationInfoTracker.decFuncCtx();
        compilationInfoTracker.decScope();
        symTabController.restoreTakenStateOfGivenGenPurposeRegs(
                compilationInfoTracker.getCurrFuncTakenGenPurposeRegsState()
        );
    }

}
