package main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors;

import main.java.evilpops.pyathome_2_x86.assembly_generator.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.assembly_generator.IAssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.compilation_info_tracker.CompilationInfoTracker;
import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86.grammar_listener.utils.AssemblySymbolProcessor;
import main.java.evilpops.pyathome_2_x86.symbol_table.ISymTabController;
import main.java.evilpops.pyathome_2_x86.symbol_table.SymTabController;
import main.java.evilpops.pyathome_2_x86.symbol_table.enums.DataType;

public class ArgNumExpressionCtxProcessor {
    private static final IAssemblyGenerator assemblyGenerator = AssemblyGenerator.getInstance();
    private static final ISymTabController symTabController = SymTabController.getInstance();
    private static final CompilationInfoTracker compilationInfoTracker = CompilationInfoTracker.getInstance();

    public static int processOnExit(PyAtHomeParser.ArgNumExpressionContext ctx) {
        int numExpRef = ctx.numExpression().getRefToSymTab();
        DataType numExpDataType = symTabController.getDataType(numExpRef);

        boolean is64bit = !numExpDataType.equals(DataType.FLOAT);

        int idRef = symTabController.addVariable(
                numExpDataType,
                compilationInfoTracker.getScope(),
                "",
                compilationInfoTracker.incAndGetCurrVarCounter()
        );
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
                    AssemblySymbolProcessor.createAssemblySymbol(idRef),
                    is64bit
            );
            symTabController.freeIfIsRegister(regRef);
        } else {
            assemblyGenerator.genMoveSymbolToSymbol(
                    AssemblySymbolProcessor.createAssemblySymbol(numExpRef),
                    AssemblySymbolProcessor.createAssemblySymbol(idRef),
                    is64bit
            );
        }
        symTabController.freeIfIsRegister(numExpRef);
        return idRef;
    }
}
