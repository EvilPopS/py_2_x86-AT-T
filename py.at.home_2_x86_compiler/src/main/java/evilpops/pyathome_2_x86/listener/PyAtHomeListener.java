package main.java.evilpops.pyathome_2_x86.listener;

import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeBaseListener;
import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86.listener.utils.ListenerHelpers;

public class PyAtHomeListener extends PyAtHomeBaseListener {
    @Override
    public void exitAssignStatement(PyAtHomeParser.AssignStatementContext ctx) {
        ListenerHelpers.processAssignStatementCtxExit(ctx);
    }

    @Override
    public void exitNumExpression(PyAtHomeParser.NumExpressionContext ctx) {
        ctx.setRefToSymTab(ListenerHelpers.processNumExpressionCtxExit(ctx));
    }

    @Override
    public void exitExpression(PyAtHomeParser.ExpressionContext ctx) {
        ctx.setRefToSymTab(ListenerHelpers.processExpressionCtxExit(ctx));
    }

    @Override
    public void exitLiteral(PyAtHomeParser.LiteralContext ctx) {
        ctx.setRefToSymTab(ListenerHelpers.processLiteralCtxExit(ctx));
    }

}
