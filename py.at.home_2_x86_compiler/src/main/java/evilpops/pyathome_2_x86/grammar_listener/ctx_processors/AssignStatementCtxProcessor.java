package main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors;

import main.java.evilpops.pyathome_2_x86.assembly_generator.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.assembly_generator.IAssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.compilation_info_tracker.CompilationInfoTracker;
import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86.grammar_listener.utils.AssemblySymbolProcessor;
import main.java.evilpops.pyathome_2_x86.grammar_listener.utils.TypesContextProcessor;
import main.java.evilpops.pyathome_2_x86.log_handler.LogHandler;
import main.java.evilpops.pyathome_2_x86.log_handler.exceptions.CompilationWarning;
import main.java.evilpops.pyathome_2_x86.semantics.SemanticAnalyzer;
import main.java.evilpops.pyathome_2_x86.symbol_table.ISymTabController;
import main.java.evilpops.pyathome_2_x86.symbol_table.SymTabController;
import main.java.evilpops.pyathome_2_x86.symbol_table.enums.DataType;
import main.java.evilpops.pyathome_2_x86.symbol_table.exceptions.VariableNotFoundException;

public class AssignStatementCtxProcessor {
    private static final IAssemblyGenerator assemblyGenerator = AssemblyGenerator.getInstance();
    private static final ISymTabController symTabController = SymTabController.getInstance();
    private static final CompilationInfoTracker compilationInfoTracker = CompilationInfoTracker.getInstance();

    public static void processOnExit(PyAtHomeParser.AssignStatementContext ctx) {
        int numExpRef = ctx.numExpression().getRefToSymTab();
        DataType numExpDataType = symTabController.getDataType(numExpRef);

        DataType explicitType = (ctx.varType() != null)
                ? TypesContextProcessor.convertTypingCtxToDataType(ctx.varType().types())
                : DataType.UNKNOWN;

        int idRef = processVarRefSearchOrCreate(ctx.ID().getText(), numExpDataType, explicitType);

        try {
            SemanticAnalyzer.areImplicitAndExplicitDataTypesTheSame(numExpDataType, explicitType);
        } catch (CompilationWarning warning) {
            LogHandler.getInstance().addWarning(warning.getMessage());
        }

        processNumExpToVarAssignment(idRef, numExpRef, numExpDataType);
    }

    private static int processVarRefSearchOrCreate(String idName, DataType numExpDataType, DataType explicitType) {
        int idRef;
        try {
            idRef = symTabController.getVarRefByNameInCurrentScope(idName, compilationInfoTracker.getScope());
            if (!explicitType.equals(DataType.UNKNOWN)) symTabController.setExplicitType(idRef, explicitType);
            else explicitType = symTabController.getExplicitType(idRef);
            symTabController.setDataType(idRef, numExpDataType);
        } catch (VariableNotFoundException ignored) {
            idRef = symTabController.addVariable(
                    numExpDataType,
                    compilationInfoTracker.getScope(),
                    explicitType,
                    idName,
                    compilationInfoTracker.incAndGetCurrVarCounter()
            );
            assemblyGenerator.genStackPointerDec(1);
        }
        return idRef;
    }

    private static void processNumExpToVarAssignment(int idRef, int numExpRef, DataType numExpDataType ) {
        boolean is64bit = !numExpDataType.equals(DataType.FLOAT);
        if (
                (symTabController.checkIfIsLiteral(numExpRef) && symTabController.checkIfDataTypeIsFloat(numExpRef))
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
    }

}
