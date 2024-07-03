package main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.function_def_domain;

import main.java.evilpops.pyathome_2_x86.assembly_generator.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.assembly_generator.IAssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.compilation_info_tracker.CompilationInfoTracker;
import main.java.evilpops.pyathome_2_x86.exceptions.compilation.errors.ReturnStatementMissingForFunctionException;
import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86.grammar_listener.utils.AssemblySymbolProcessor;
import main.java.evilpops.pyathome_2_x86.log_handler.LogHandler;
import main.java.evilpops.pyathome_2_x86.symbol_table.ISymTabController;
import main.java.evilpops.pyathome_2_x86.symbol_table.SymTabController;
import main.java.evilpops.pyathome_2_x86.symbol_table.enums.DataType;

public class FunctionDefCtxProcessor {
    public static final IAssemblyGenerator assemblyGenerator = AssemblyGenerator.getInstance();
    private static final ISymTabController symTabController = SymTabController.getInstance();
    private static final CompilationInfoTracker compilationInfoTracker = CompilationInfoTracker.getInstance();

    public static void processOnEnter(PyAtHomeParser.FunctionDefContext ignored) {
        compilationInfoTracker.getReturnStatInfoTracker().onNewFuncStart();
        compilationInfoTracker.getFunctionScopeTracker().incScope();
        compilationInfoTracker.getCurrFuncTracker().setTakenGenPurposeRegsState(
                symTabController.getAndFreeAllTakenGenPurposeRegs()
        );
    }

    public static void processOnExit(PyAtHomeParser.FunctionDefContext ignored) {
        int funcRef = compilationInfoTracker.getCurrFuncTracker().getFuncRef();
        String funcName = symTabController.getFuncName(funcRef);

        if (!compilationInfoTracker.getReturnStatInfoTracker().doesFunctionHasReturn()) {
            if (symTabController.checkIfDataTypeIsNone(funcRef)) {
                assemblyGenerator.genMoveSymbolToReg(
                        AssemblySymbolProcessor.createAssemblySymbol(
                                symTabController.addLiteralNone(
                                        compilationInfoTracker.getFunctionScopeTracker().getScope(),
                                        compilationInfoTracker.getBlockScopeTracker().getScope()
                                )
                        ),
                        symTabController.getRegName(symTabController.takeReturnReg(DataType.NONE)),
                        true
                );
            } else {
                throw new ReturnStatementMissingForFunctionException(funcName);
            }
        }

        compilationInfoTracker.getReturnStatInfoTracker().onFuncEnd();

        assemblyGenerator.genFuncEnd(funcName);

        compilationInfoTracker.onFunctionEnd();

        symTabController.deleteCurrentFuncScope(
                compilationInfoTracker.getFunctionScopeTracker().getScope()
        );

        compilationInfoTracker.getFunctionScopeTracker().decScope();

        symTabController.restoreTakenStateOfGivenGenPurposeRegs(
                compilationInfoTracker.getCurrFuncTracker().getTakenGenPurposeRegsState()
        );
    }

}
