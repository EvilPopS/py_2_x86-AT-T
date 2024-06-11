package main.java.evilpops.pyathome_2_x86._migration.grammar_listener;


import main.java.evilpops.pyathome_2_x86._migration.grammar.grammar_classes.PyAtHomeBaseListener;
import main.java.evilpops.pyathome_2_x86._migration.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86._migration.grammar_listener.ctx_processors.*;
import main.java.evilpops.pyathome_2_x86._migration.log_handler.LogHandler;
import main.java.evilpops.pyathome_2_x86.grammar_listener.utils.ListenerHelpers;

public class PyAtHomeListener extends PyAtHomeBaseListener {
    private static final LogHandler logHandler = LogHandler.getInstance();

    @Override
    public void exitProgram(PyAtHomeParser.ProgramContext ctx) {
        if (!logHandler.isSyntaxErrDetected())
            ProgramCtxProcessor.processOnExit(ctx);
    }

    @Override
    public void enterFunctionDef(PyAtHomeParser.FunctionDefContext ctx) {
        if (!logHandler.isSyntaxErrDetected())
            FunctionDefCtxProcessor.processOnEnter(ctx);
    }

    @Override
    public void exitFunctionDef(PyAtHomeParser.FunctionDefContext ctx) {
        if (!logHandler.isSyntaxErrDetected())
            FunctionDefCtxProcessor.processOnExit(ctx);
    }

    @Override
    public void exitFunctionDeclaration(PyAtHomeParser.FunctionDeclarationContext ctx) {
        if (!logHandler.isSyntaxErrDetected())
            FunctionDeclarationProcessor.processOnExit(ctx);
    }

    @Override
    public void exitFunctionIdentifier(PyAtHomeParser.FunctionIdentifierContext ctx) {
        if (!logHandler.isSyntaxErrDetected())
            FunctionIdentifierCtxProcessor.processOnExit(ctx);
    }

    @Override
    public void exitParamNonDefVal(PyAtHomeParser.ParamNonDefValContext ctx) {
        if (!logHandler.isSyntaxErrDetected())
            ParamNonDefValCtxProcessor.processOnExit(ctx);
    }

    @Override
    public void exitParamDefVal(PyAtHomeParser.ParamDefValContext ctx) {
        if (!logHandler.isSyntaxErrDetected())
            ParamDefValCtxProcessor.processOnExit(ctx);
    }

    @Override
    public void exitAssignStatement(PyAtHomeParser.AssignStatementContext ctx) {
        if (!logHandler.isSyntaxErrDetected())
            AssignStatementCtxProcessor.processOnExit(ctx);
    }

    @Override
    public void exitReturnStatement(PyAtHomeParser.ReturnStatementContext ctx) {
        if (!logHandler.isSyntaxErrDetected())
            ReturnStatementCtxProcessor.processOnExit(ctx);
    }

    @Override
    public void enterBlock(PyAtHomeParser.BlockContext ctx) {
        if (!logHandler.isSyntaxErrDetected())
            BlockCtxProcessor.processOnEnter(ctx);
    }

    @Override
    public void exitBlock(PyAtHomeParser.BlockContext ctx) {
        if (!logHandler.isSyntaxErrDetected())
            BlockCtxProcessor.processOnExit(ctx);
    }

    @Override
    public void exitNumExpression(PyAtHomeParser.NumExpressionContext ctx) {
        if (!logHandler.isSyntaxErrDetected())
            ctx.setRefToSymTab(NumExpressionCtxProcessor.processOnExit(ctx));
    }

    @Override
    public void exitExpression(PyAtHomeParser.ExpressionContext ctx) {
        if (!logHandler.isSyntaxErrDetected())
            ctx.setRefToSymTab(ExpressionCtxProcessor.processOnExit(ctx));
    }

    @Override
    public void exitFunctionCall(PyAtHomeParser.FunctionCallContext ctx) {
        if (!logHandler.isSyntaxErrDetected())
            ctx.setRefToSymTab(FunctionCallCtxProcessor.processOnExit(ctx));
    }

    @Override
    public void exitLiteral(PyAtHomeParser.LiteralContext ctx) {
        if (!logHandler.isSyntaxErrDetected())
            ctx.setRefToSymTab(LiteralCtxProcessor.processOnExit(ctx));
    }

}
