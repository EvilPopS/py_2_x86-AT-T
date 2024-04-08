package main.java.evilpops.pyathome_2_x86.grammar_listener;

import main.java.evilpops.pyathome_2_x86.log_handlers.LogHandler;
import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeBaseListener;
import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86.grammar_listener.utils.ListenerHelpers;

public class PyAtHomeListener extends PyAtHomeBaseListener {

    @Override
    public void exitProgram(PyAtHomeParser.ProgramContext ignored) {
        if (!LogHandler.getInstance().isSyntaxErrDetected())
            ListenerHelpers.processProgramCtxExit();
    }

    @Override
    public void exitFunctionDef(PyAtHomeParser.FunctionDefContext ignored) {
        if (!LogHandler.getInstance().isSyntaxErrDetected())
            ListenerHelpers.processFuncDefCtxExit();
    }

    @Override
    public void exitFunctionDeclaration(PyAtHomeParser.FunctionDeclarationContext ctx) {
        if (!LogHandler.getInstance().isSyntaxErrDetected())
            ListenerHelpers.processFuncDeclCtxExit(ctx);
    }

    @Override
    public void exitFunctionIdentifier(PyAtHomeParser.FunctionIdentifierContext ctx) {
        if (!LogHandler.getInstance().isSyntaxErrDetected())
            ListenerHelpers.processFuncIdentifierCtxExit(ctx);
    }

    @Override
    public void exitParamNonDefVal(PyAtHomeParser.ParamNonDefValContext ctx) {
        if (!LogHandler.getInstance().isSyntaxErrDetected())
            ListenerHelpers.processParamNonDefValCtxExit(ctx);
    }

    @Override
    public void exitParamDefVal(PyAtHomeParser.ParamDefValContext ctx) {
        if (!LogHandler.getInstance().isSyntaxErrDetected())
            ListenerHelpers.processParamDefValCtxExit(ctx);
    }

    @Override
    public void exitAssignStatement(PyAtHomeParser.AssignStatementContext ctx) {
        if (!LogHandler.getInstance().isSyntaxErrDetected())
            ListenerHelpers.processAssignStatementCtxExit(ctx);
    }

    @Override
    public void exitReturnStatement(PyAtHomeParser.ReturnStatementContext ctx) {
        if (!LogHandler.getInstance().isSyntaxErrDetected())
            ListenerHelpers.processReturnStatementCtxExit(ctx);
    }

    @Override
    public void enterBlock(PyAtHomeParser.BlockContext ctx) {
        if (!LogHandler.getInstance().isSyntaxErrDetected())
            ListenerHelpers.processBlockCtxEnter();
    }

    @Override
    public void exitBlock(PyAtHomeParser.BlockContext ctx) {
        if (!LogHandler.getInstance().isSyntaxErrDetected())
            ListenerHelpers.processBlockCtxExit();
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
