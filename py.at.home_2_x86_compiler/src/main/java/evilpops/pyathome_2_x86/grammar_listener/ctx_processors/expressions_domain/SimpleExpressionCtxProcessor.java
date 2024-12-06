package main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.expressions_domain;

import main.java.evilpops.pyathome_2_x86.assembly_generator.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.assembly_generator.IAssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.assembly_generator.enums.AssemblyRegister;
import main.java.evilpops.pyathome_2_x86.compilation_info_tracker.CompilationInfoTracker;
import main.java.evilpops.pyathome_2_x86.exceptions.other.BadImplementationException;
import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86.symbol_table.ISymTabController;
import main.java.evilpops.pyathome_2_x86.symbol_table.SymTabController;
import main.java.evilpops.pyathome_2_x86.symbol_table.enums.DataType;

public class SimpleExpressionCtxProcessor {
    private static final IAssemblyGenerator assemblyGenerator = AssemblyGenerator.getInstance();
    private static final ISymTabController symTabController = SymTabController.getInstance();
    private static final CompilationInfoTracker compilationInfoTracker = CompilationInfoTracker.getInstance();

    public static int processOnExit(PyAtHomeParser.SimpleExpressionContext ctx) {
        if (ctx.literal() != null)
            return processIfLiteral(ctx);
        else if (ctx.ID() != null)
            return processIfId(ctx);
        else if (ctx.funcCallExpression() != null)
            return processIfFuncCall(ctx);
        else
            throw new BadImplementationException();
    }

    private static int processIfLiteral(PyAtHomeParser.SimpleExpressionContext ctx) {
        return ctx.literal().getRefToSymTab();
    }

    private static int processIfId(PyAtHomeParser.SimpleExpressionContext ctx) {
        int varRef = symTabController.getVarRefByNameInAnyScope(ctx.ID().getText());
        int varScope = symTabController.getFuncScope(varRef);
        int currentScope = compilationInfoTracker.getFunctionScopeTracker().getScope();
        if (varScope == currentScope)
            return varRef;
        else
            return processIdIfVarOutOfCurrScope(varRef, varScope, currentScope);
    }

    private  static int processIfFuncCall(PyAtHomeParser.SimpleExpressionContext ctx) {
        return ctx.funcCallExpression().getRefToSymTab();
    }

    private static int processIdIfVarOutOfCurrScope(int varRef, int varScope, int currentScope) {
        int tempRegRef = symTabController.takeRegister(DataType.INTEGER);
        AssemblyRegister tempRegName = symTabController.getRegName(tempRegRef);

        assemblyGenerator.genMoveMemOfBasePointerToReg64bit(tempRegName);
        while (varScope < --currentScope)
            assemblyGenerator.genMoveMemOfRegToReg64bit(tempRegName, tempRegName);

        if (symTabController.getDataType(varRef).equals(DataType.FLOAT)) {
            int floatTempRegRef = symTabController.takeRegister(DataType.FLOAT);
            assemblyGenerator.genMoveVarFromCustomBasePointerToReg(
                    tempRegName,
                    symTabController.getRegName(floatTempRegRef),
                    symTabController.getVarOrdinality(varRef),
                    false
            );
            symTabController.freeIfIsRegister(tempRegRef);
            return floatTempRegRef;
        } else {
            symTabController.setDataType(tempRegRef, symTabController.getDataType(varRef));
            assemblyGenerator.genMoveVarFromCustomBasePointerToReg(
                    tempRegName,
                    tempRegName,
                    symTabController.getVarOrdinality(varRef),
                    true
            );
            return tempRegRef;
        }
    }

}
