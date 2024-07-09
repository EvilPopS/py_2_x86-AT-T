package main.java.evilpops.pyathome_2_x86.compilation_info_tracker.components;

import main.java.evilpops.pyathome_2_x86.assembly_generator.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.assembly_generator.IAssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.compilation_info_tracker.CompilationInfoTracker;
import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86.grammar_listener.utils.AssemblySymbolProcessor;
import main.java.evilpops.pyathome_2_x86.grammar_listener.utils.TypesContextProcessor;
import main.java.evilpops.pyathome_2_x86.log_handler.exceptions.CompilationError;
import main.java.evilpops.pyathome_2_x86.symbol_table.ISymTabController;
import main.java.evilpops.pyathome_2_x86.symbol_table.SymTabController;
import main.java.evilpops.pyathome_2_x86.symbol_table.enums.DataType;
import main.java.evilpops.pyathome_2_x86.symbol_table.exceptions.VariableNotFoundException;


public class MultiAssignStatementCtxProcessor {
    private static final IAssemblyGenerator assemblyGenerator = AssemblyGenerator.getInstance();
    private static final ISymTabController symTabController = SymTabController.getInstance();
    private static final CompilationInfoTracker compilationInfoTracker = CompilationInfoTracker.getInstance();

    public static void processOnEnter() {
        compilationInfoTracker.getMultiAssignInfoTracker().onMultiAssignStatementStart();
    }

    public static void processOnExit(PyAtHomeParser.MultiAssignStatementContext ctx) {
        for (PyAtHomeParser.MultiAssignIdContext varCtx : ctx.multiAssignIdPart().multiAssignId()) {
            String varName = varCtx.ID().getText();
            int numExpMemOrdinality = compilationInfoTracker.getMultiAssignInfoTracker().getNestNumExpOrdinality();
            DataType numExpDataType = compilationInfoTracker.getMultiAssignInfoTracker().getNestNumExpDataType();

            DataType explicitType = (varCtx.varType() != null)
                    ? TypesContextProcessor.convertTypingCtxToDataType(varCtx.varType().types())
                    : DataType.UNKNOWN;

            if (!explicitType.equals(DataType.UNKNOWN) && !explicitType.equals(numExpDataType))
                throw new CompilationError("Expl and impl types not same.");

            int idRef;
            try {
                idRef = processFindVarInCurrFuncScope(varName, numExpDataType);
            } catch (VariableNotFoundException ignored) {
                idRef = processVarRefCreate(varName, numExpDataType);
            }

            processNumExpToVarAssignment(idRef, numExpMemOrdinality, numExpDataType);
            compilationInfoTracker.getMultiAssignInfoTracker().popNextVarInfoFromHead();
        }

        int varsLeftToRemove = compilationInfoTracker.getMultiAssignInfoTracker().getNumOfMemOrdinalitiesLeft();
        if (varsLeftToRemove > 0) {
            assemblyGenerator.genStackPointerInc(varsLeftToRemove);
            compilationInfoTracker.getCurrFuncTracker().decVarCounterByAmount(varsLeftToRemove);
        }
    }


    private static int processFindVarInCurrFuncScope(String varName, DataType numExpDataType) {
        int idRef = symTabController.getVarRefByNameInCurrentFuncScope(
                varName,
                compilationInfoTracker.getFunctionScopeTracker().getScope()
        );
        symTabController.setDataType(idRef, numExpDataType);
        return idRef;
    }

    private static int processVarRefCreate(String varName, DataType numExpDataType) {
        return symTabController.addVariable(
                numExpDataType,
                compilationInfoTracker.getFunctionScopeTracker().getScope(),
                compilationInfoTracker.getBlockScopeTracker().getScope(),
                varName,
                compilationInfoTracker.getMultiAssignInfoTracker().getNextFreeMemOrdinality()
        );
    }

    private static void processNumExpToVarAssignment(int idRef, int numExpMemOrdinality, DataType numExpDataType) {
        boolean is64bit = !numExpDataType.equals(DataType.FLOAT);
        int regRef = symTabController.takeRegister(numExpDataType);
        assemblyGenerator.genMoveSymbolToReg(
                assemblyGenerator.makeVarAccessSymbol(numExpMemOrdinality),
                symTabController.getRegName(regRef),
                is64bit

        );
        assemblyGenerator.genMoveSymbolToSymbol(
                AssemblySymbolProcessor.createAssemblySymbol(regRef),
                AssemblySymbolProcessor.createAssemblySymbol(idRef),
                is64bit
        );
        symTabController.freeIfIsRegister(regRef);
    }
}
