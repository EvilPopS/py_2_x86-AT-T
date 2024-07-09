package main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.multi_assign_statement_domain;

import main.java.evilpops.pyathome_2_x86.assembly_generator.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.assembly_generator.IAssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.compilation_info_tracker.CompilationInfoTracker;
import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86.grammar_listener.utils.AssemblySymbolProcessor;
import main.java.evilpops.pyathome_2_x86.symbol_table.ISymTabController;
import main.java.evilpops.pyathome_2_x86.symbol_table.SymTabController;
import main.java.evilpops.pyathome_2_x86.symbol_table.enums.DataType;

public class MultiAssignNumExpressionCtxProcessor {
    private static final IAssemblyGenerator assemblyGenerator = AssemblyGenerator.getInstance();
    private static final ISymTabController symTabController = SymTabController.getInstance();
    private static final CompilationInfoTracker compilationInfoTracker = CompilationInfoTracker.getInstance();

    public static void processOnExit(PyAtHomeParser.MultiAssignNumExpressionContext ctx) {
        int numExpRef = ctx.numExpression().getRefToSymTab();

        int varOrdinality = compilationInfoTracker.getCurrFuncTracker().incAndGetVarCounter();
        compilationInfoTracker.getMultiAssignInfoTracker().onMultiAssignNumExpEnd(
                varOrdinality,
                symTabController.getDataType(numExpRef)
        );

        processNumExpToMemMove(
                numExpRef,
                varOrdinality
        );
    }

    private static void processNumExpToMemMove(int numExpRef, int memOrdinality) {
        DataType numExpDataType = symTabController.getDataType(numExpRef);
        boolean is64bit = !numExpDataType.equals(DataType.FLOAT);

        assemblyGenerator.genStackPointerDec(1);
        if (
                (symTabController.checkIfIsLiteral(numExpRef) && !is64bit)
                        || symTabController.checkIfIsVar(numExpRef)
        ) {
            int regRef = symTabController.takeRegister(numExpDataType);
            assemblyGenerator.genMoveSymbolToReg(
                    AssemblySymbolProcessor.createAssemblySymbol(numExpRef),
                    symTabController.getRegName(regRef),
                    is64bit

            );
            assemblyGenerator.genMoveSymbolToSymbol(
                    AssemblySymbolProcessor.createAssemblySymbol(regRef),
                    assemblyGenerator.makeVarAccessSymbol(memOrdinality),
                    is64bit
            );
            symTabController.freeIfIsRegister(regRef);
        } else {
            assemblyGenerator.genMoveSymbolToSymbol(
                    AssemblySymbolProcessor.createAssemblySymbol(numExpRef),
                    assemblyGenerator.makeVarAccessSymbol(memOrdinality),
                    is64bit
            );
        }
        symTabController.freeIfIsRegister(numExpRef);
    }
}
