package main.java.evilpops.pyathome_2_x86.listener.utils;

import main.java.evilpops.pyathome_2_x86.assembly_gen.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.assembly_gen.IAssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86.listener.exceptions.ListenerNotInSyncWithGrammarException;
import main.java.evilpops.pyathome_2_x86.semantic_analyzer.SemanticAnalyzer;
import main.java.evilpops.pyathome_2_x86.sym_tab.ISymTabController;
import main.java.evilpops.pyathome_2_x86.sym_tab.SymTabController;
import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;
import main.java.evilpops.pyathome_2_x86.sym_tab.exceptions.VariableNotFoundException;

public class ListenerHelpers {
    private static final String EXC_MESSAGE_F = "ListenerHelpers::%s -> is not in sync with defined grammar!";
    private static final ISymTabController symTabController = SymTabController.getInstance();
    private static final IAssemblyGenerator assemblyGen = AssemblyGenerator.getInstance();

    private static final VariableCounter varCounter = new VariableCounter();

    public static void processAssignStatementCtxExit(PyAtHomeParser.AssignStatementContext ctx) {
        int idRef;
        int numExpRef = ctx.numExpression().getRefToSymTab();
        DataType numExpDataType = symTabController.getDataTypeByInd(numExpRef);
        String idName = ctx.ID().getText();
        try {
            idRef = symTabController.getVarRefByName(idName);
            symTabController.setDataTypeByInd(idRef, numExpDataType);
        } catch (VariableNotFoundException ignored) {

            idRef = symTabController.addVariable(
                    numExpDataType,
                    idName,
                    varCounter.incAndGetCurrCounter()
            );

            assemblyGen.genStackPointerDec(symTabController.checkIfDataTypeIsFloat(idRef));
        }

        if (symTabController.checkIfIsVarByInd(numExpRef)) {
            int regRef = symTabController.addRegister(numExpDataType);
            assemblyGen.genMove(regRef, numExpRef);
            numExpRef = regRef;
        }

        assemblyGen.genMove(idRef, numExpRef);
    }

    public static int processNumExpressionCtxExit(PyAtHomeParser.NumExpressionContext ctx) {
        if (ctx.expression() != null)
            return ctx.expression().getRefToSymTab();
        else if (ctx.addSubOperators() != null) {
            int leftExpRef = ctx.numExpression().get(0).getRefToSymTab();
            int rightExpRef = ctx.numExpression().get(1).getRefToSymTab();
            SemanticAnalyzer.areTypesCompatibleForAddition(
                    leftExpRef,
                    rightExpRef
            );
            if (symTabController.checkIfIsRegByInd(leftExpRef)) {

            } else if (symTabController.checkIfIsRegByInd(rightExpRef)) {

            } else {

            }

        } else
            throw new ListenerNotInSyncWithGrammarException(String.format(EXC_MESSAGE_F, "processNumExpressionCtxExit"));
        return -1;
    }

    public static int processExpressionCtxExit(PyAtHomeParser.ExpressionContext ctx) {
        if (ctx.literal() != null)
            return ctx.literal().getRefToSymTab();
        else if (ctx.ID() != null) {
            return symTabController.getVarRefByName(ctx.ID().getText());
        } else
            throw new ListenerNotInSyncWithGrammarException(String.format(EXC_MESSAGE_F, "transferReferenceToExpressionContext"));
    }

    public static int processLiteralCtxExit(PyAtHomeParser.LiteralContext ctx) {
        if (ctx.INTEGER() != null)
            return symTabController.addLiteral(ctx.INTEGER().getText(), DataType.INTEGER);
        else if (ctx.FLOAT() != null)
            return symTabController.addLiteral(ctx.FLOAT().getText(), DataType.FLOAT);
        else if (ctx.BOOLEAN() != null)
            return symTabController.addLiteral(ctx.BOOLEAN().getText(), DataType.BOOLEAN);
        else
            throw new ListenerNotInSyncWithGrammarException(String.format(EXC_MESSAGE_F, "insertLiteralIntoSymTab"));
    }

}
