package main.java.evilpops.pyathome_2_x86.grammar_listener;

import main.java.evilpops.pyathome_2_x86.log_handlers.LogHandler;
import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeBaseListener;
import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86.grammar_listener.utils.ListenerHelpers;
import org.antlr.v4.runtime.ParserRuleContext;

public class PyAtHomeListener extends PyAtHomeBaseListener {

    @Override
    public void exitProgram(PyAtHomeParser.ProgramContext ignored) {
        if (!LogHandler.getInstance().isSyntaxErrDetected())
            ListenerHelpers.processProgramCtxExit();
    }

    @Override
    public void exitAssignStatement(PyAtHomeParser.AssignStatementContext ctx) {
        if (!LogHandler.getInstance().isSyntaxErrDetected())
            ListenerHelpers.processAssignStatementCtxExit(ctx);
    }

    @Override
    public void exitNumExpression(PyAtHomeParser.NumExpressionContext ctx) {
        if (!LogHandler.getInstance().isSyntaxErrDetected())
            ctx.setRefToSymTab(ListenerHelpers.processNumExpressionCtxExit(ctx));
    }

    @Override
    public void exitExpression(PyAtHomeParser.ExpressionContext ctx) {
        if (!LogHandler.getInstance().isSyntaxErrDetected())
            ctx.setRefToSymTab(ListenerHelpers.processExpressionCtxExit(ctx));
    }

    @Override
    public void exitLiteral(PyAtHomeParser.LiteralContext ctx) {
        if (!LogHandler.getInstance().isSyntaxErrDetected())
            ctx.setRefToSymTab(ListenerHelpers.processLiteralCtxExit(ctx));
    }

}
