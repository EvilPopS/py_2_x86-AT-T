package main.java.evilpops.pyathome_2_x86.listener.utils;

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

    public static void processAssignStatementCtxExit(PyAtHomeParser.AssignStatementContext ctx) {
        int idRef;
        String idName = ctx.ID().getText();
        try {
            idRef = symTabController.getVarRefByName(idName);
        } catch (VariableNotFoundException ignored) {
            idRef = symTabController.addVariable(
                    idName,
                    symTabController.getDataTypeByInd(ctx.numExpression().getRefToSymTab())
            );
        }
        // here goes assembly generator
    }

    public static int processNumExpressionCtxExit(PyAtHomeParser.NumExpressionContext ctx) {
        if (ctx.expression() != null)
            return ctx.expression().getRefToSymTab();
        else if (ctx.addSubOperators() != null) {
            /* Here goes assembly generator */
        }
        else
            throw new ListenerNotInSyncWithGrammarException(String.format(EXC_MESSAGE_F, "processNumExpressionCtxExit"));
        return -1;
    }

    public static int processExpressionCtxExit(PyAtHomeParser.ExpressionContext ctx) {
        if (ctx.literal() != null)
            return ctx.literal().getRefToSymTab();
        else if (ctx.ID() != null) {
            return symTabController.getVarRefByName(ctx.ID().getText());
        }
        else
            throw new ListenerNotInSyncWithGrammarException(String.format(EXC_MESSAGE_F, "transferReferenceToExpressionContext"));
    }

    public static int processLiteralCtxExit(PyAtHomeParser.LiteralContext ctx) {
        if (ctx.NUMBER() != null)
            return symTabController.addLiteral(ctx.NUMBER().getText(), DataType.NUMBER);
        else if (ctx.BOOLEAN() != null)
            return symTabController.addLiteral(ctx.BOOLEAN().getText(), DataType.BOOLEAN);
        else
            throw new ListenerNotInSyncWithGrammarException(String.format(EXC_MESSAGE_F, "insertLiteralIntoSymTab"));
    }

}
