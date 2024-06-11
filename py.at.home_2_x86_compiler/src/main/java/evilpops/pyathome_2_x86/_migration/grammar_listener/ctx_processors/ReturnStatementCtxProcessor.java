package main.java.evilpops.pyathome_2_x86._migration.grammar_listener.ctx_processors;

import main.java.evilpops.pyathome_2_x86._migration.assembly_generator.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86._migration.assembly_generator.IAssemblyGenerator;
import main.java.evilpops.pyathome_2_x86._migration.compilation_info_tracker.CompilationInfoTracker;
import main.java.evilpops.pyathome_2_x86._migration.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86._migration.grammar_listener.utils.AssemblySymbolProcessor;
import main.java.evilpops.pyathome_2_x86._migration.log_handler.LogHandler;
import main.java.evilpops.pyathome_2_x86._migration.symbol_table.ISymTabController;
import main.java.evilpops.pyathome_2_x86._migration.symbol_table.SymTabController;
import main.java.evilpops.pyathome_2_x86._migration.symbol_table.enums.DataType;


public class ReturnStatementCtxProcessor {
    private static final IAssemblyGenerator assemblyGenerator = AssemblyGenerator.getInstance();
    private static final ISymTabController symTabController = SymTabController.getInstance();
    private static final CompilationInfoTracker compilationInfoTracker = CompilationInfoTracker.getInstance();

    public static void processOnExit(PyAtHomeParser.ReturnStatementContext ctx) {
        DataType funcRetDataType = symTabController.getDataType(compilationInfoTracker.getCurrFuncRef());

        boolean is64bit = !funcRetDataType.equals(DataType.FLOAT);

        int numExpRef = ctx.numExpression() != null
                ? ctx.numExpression().getRefToSymTab()
                : symTabController.getNoneLiteralRef();

        if (!symTabController.getDataType(numExpRef).equals(funcRetDataType))
            LogHandler.getInstance().addWarning("Return type of the function is not the same as value returned!");

        int returnRegRef = symTabController.takeReturnReg(funcRetDataType);

        assemblyGenerator.genMoveSymbolToReg(
                AssemblySymbolProcessor.createAssemblySymbol(numExpRef),
                symTabController.getRegName(returnRegRef),
                is64bit
        );
        assemblyGenerator.genStackPointerInc(compilationInfoTracker.getCurrVarCounter());
        assemblyGenerator.genNonCondJmpToFuncEnd(
                symTabController.getFuncName(compilationInfoTracker.getCurrFuncRef())
        );

    }

}
