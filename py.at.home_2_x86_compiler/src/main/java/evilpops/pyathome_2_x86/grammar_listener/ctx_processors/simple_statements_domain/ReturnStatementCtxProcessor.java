package main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.simple_statements_domain;

import main.java.evilpops.pyathome_2_x86.assembly_generator.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.assembly_generator.IAssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.compilation_info_tracker.CompilationInfoTracker;
import main.java.evilpops.pyathome_2_x86.exceptions.compilation.errors.ReturnNotAllowedOutsideOfFuncDefException;
import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86.grammar_listener.utils.AssemblySymbolProcessor;
import main.java.evilpops.pyathome_2_x86.log_handler.LogHandler;
import main.java.evilpops.pyathome_2_x86.symbol_table.ISymTabController;
import main.java.evilpops.pyathome_2_x86.symbol_table.SymTabController;
import main.java.evilpops.pyathome_2_x86.symbol_table.enums.DataType;


public class ReturnStatementCtxProcessor {
    private static final IAssemblyGenerator assemblyGenerator = AssemblyGenerator.getInstance();
    private static final ISymTabController symTabController = SymTabController.getInstance();
    private static final CompilationInfoTracker compilationInfoTracker = CompilationInfoTracker.getInstance();

    public static void processOnExit(PyAtHomeParser.ReturnStatementContext ctx) {
        if (!compilationInfoTracker.getReturnStatInfoTracker().isReturnAllowed())
            throw new ReturnNotAllowedOutsideOfFuncDefException();

        compilationInfoTracker.getReturnStatInfoTracker().onReturnStatementCreate();

        DataType funcRetDataType = symTabController.getDataType(
                compilationInfoTracker.getCurrFuncTracker().getFuncRef()
        );

        boolean is64bit = !funcRetDataType.equals(DataType.FLOAT);

        int numExpRef = ctx.complexExpression() != null
                ? ctx.complexExpression().getRefToSymTab()
                : symTabController.addLiteralNone(
                        compilationInfoTracker.getFunctionScopeTracker().getScope(),
                        compilationInfoTracker.getBlockScopeTracker().getScope()
                );

        if (!symTabController.getDataType(numExpRef).equals(funcRetDataType))
            LogHandler.getInstance().addWarning("Return type of the function is not the same as value returned!");

        int returnRegRef = symTabController.takeReturnReg(funcRetDataType);

        assemblyGenerator.genMoveSymbolToReg(
                AssemblySymbolProcessor.createAssemblySymbol(numExpRef),
                symTabController.getRegName(returnRegRef),
                is64bit
        );
        assemblyGenerator.genNonCondJmpToFuncEnd(
                symTabController.getFuncName(compilationInfoTracker.getCurrFuncTracker().getFuncRef())
        );

    }

}
