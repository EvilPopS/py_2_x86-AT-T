package main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors;

import main.java.evilpops.pyathome_2_x86.assembly_generator.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.assembly_generator.IAssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.assembly_generator.enums.AssemblyRegister;
import main.java.evilpops.pyathome_2_x86.exceptions.other.BadImplementationException;
import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86.symbol_table.ISymTabController;
import main.java.evilpops.pyathome_2_x86.symbol_table.SymTabController;
import main.java.evilpops.pyathome_2_x86.symbol_table.enums.DataType;

public class ExpressionCtxProcessor {
    private static final IAssemblyGenerator assemblyGenerator = AssemblyGenerator.getInstance();
    private static final ISymTabController symTabController = SymTabController.getInstance();

    public static int processOnExit(PyAtHomeParser.ExpressionContext ctx) {
        if (ctx.literal() != null)
            return processIfLiteral(ctx);
        else if (ctx.ID() != null)
            return processIfId(ctx);
        else
            throw new BadImplementationException();
    }

    private static int processIfLiteral(PyAtHomeParser.ExpressionContext ctx) {
        return ctx.literal().getRefToSymTab();
    }

    private static int processIfId(PyAtHomeParser.ExpressionContext ctx) {
        int varRef = symTabController.getVarRefByName(ctx.ID().getText());
        int varScope = symTabController.getScope(varRef);
        int currentScope = symTabController.getCurrentScope();
        if (varScope == currentScope)
            return varRef;
        else
            return processIdIfVarOutOfCurrScope(varRef, varScope, currentScope);

    }

    private static int processIdIfVarOutOfCurrScope(int varRef, int varScope, int currentScope) {
        boolean isVarFloat = symTabController.getDataType(varRef).equals(DataType.FLOAT);
        int tempRegRef = symTabController.takeRegister(DataType.INTEGER);
        AssemblyRegister tempRegName = symTabController.getRegName(tempRegRef);

        assemblyGenerator.genMoveMemOfBasePointerToReg64bit(tempRegName);
        while (varScope < --currentScope)
            assemblyGenerator.genMoveMemOfRegToReg64bit(tempRegName, tempRegName);

        if (isVarFloat) {
            int floatTempRegRef = symTabController.takeRegister(DataType.FLOAT);
            assemblyGenerator.genMoveVarFromCustomBasePointerToReg(
                    tempRegName,
                    symTabController.getRegName(floatTempRegRef),
                    symTabController.getVarOrdinality(varRef),
                    true
            );
            return floatTempRegRef;
        } else {
            assemblyGenerator.genMoveVarFromCustomBasePointerToReg(
                    tempRegName,
                    tempRegName,
                    symTabController.getVarOrdinality(varRef),
                    false
            );
            return tempRegRef;
        }
    }

}
