package main.java.evilpops.pyathome_2_x86.grammar_listener;


import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeBaseListener;
import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.*;
import main.java.evilpops.pyathome_2_x86.log_handler.LogHandler;

public class PyAtHomeListener extends PyAtHomeBaseListener {
    private static final LogHandler logHandler = LogHandler.getInstance();

    @Override
    public void exitProgram(PyAtHomeParser.ProgramContext ctx) {
        if (!logHandler.isCompilationErrorDetected())
            ProgramCtxProcessor.processOnExit(ctx);
    }

    @Override
    public void enterFunctionDef(PyAtHomeParser.FunctionDefContext ctx) {
        if (!logHandler.isCompilationErrorDetected())
            FunctionDefCtxProcessor.processOnEnter(ctx);
    }

    @Override
    public void exitFunctionDef(PyAtHomeParser.FunctionDefContext ctx) {
        if (!logHandler.isCompilationErrorDetected())
            FunctionDefCtxProcessor.processOnExit(ctx);
    }

    @Override
    public void exitFunctionDeclaration(PyAtHomeParser.FunctionDeclarationContext ctx) {
        if (!logHandler.isCompilationErrorDetected())
            FunctionDeclarationProcessor.processOnExit(ctx);
    }

    @Override
    public void exitFunctionIdentifier(PyAtHomeParser.FunctionIdentifierContext ctx) {
        if (!logHandler.isCompilationErrorDetected())
            FunctionIdentifierCtxProcessor.processOnExit(ctx);
    }

    @Override
    public void exitParamNonDefVal(PyAtHomeParser.ParamNonDefValContext ctx) {
        if (!logHandler.isCompilationErrorDetected())
            ParamNonDefValCtxProcessor.processOnExit(ctx);
    }

    @Override
    public void enterParamDefVal(PyAtHomeParser.ParamDefValContext ignored) {
        if (!logHandler.isCompilationErrorDetected())
            ParamDefValCtxProcessor.processOnEnter();
    }

    @Override
    public void exitParamDefVal(PyAtHomeParser.ParamDefValContext ctx) {
        if (!logHandler.isCompilationErrorDetected())
            ParamDefValCtxProcessor.processOnExit(ctx);
    }

    @Override
    public void exitAssignStatement(PyAtHomeParser.AssignStatementContext ctx) {
        if (!logHandler.isCompilationErrorDetected())
            AssignStatementCtxProcessor.processOnExit(ctx);
    }

    @Override
    public void exitReturnStatement(PyAtHomeParser.ReturnStatementContext ctx) {
        if (!logHandler.isCompilationErrorDetected())
            ReturnStatementCtxProcessor.processOnExit(ctx);
    }

    @Override
    public void enterBlock(PyAtHomeParser.BlockContext ctx) {
        if (!logHandler.isCompilationErrorDetected())
            BlockCtxProcessor.processOnEnter(ctx);
    }

    @Override
    public void exitBlock(PyAtHomeParser.BlockContext ctx) {
        if (!logHandler.isCompilationErrorDetected())
            BlockCtxProcessor.processOnExit(ctx);
    }

    @Override
    public void exitArgNumExpression(PyAtHomeParser.ArgNumExpressionContext ctx) {
        if (!logHandler.isCompilationErrorDetected())
            ctx.setRefToSymTab(ArgNumExpressionCtxProcessor.processOnExit(ctx));
    }

    @Override
    public void exitNumExpression(PyAtHomeParser.NumExpressionContext ctx) {
        if (!logHandler.isCompilationErrorDetected())
            ctx.setRefToSymTab(NumExpressionCtxProcessor.processOnExit(ctx));
    }

    @Override
    public void exitExpression(PyAtHomeParser.ExpressionContext ctx) {
        if (!logHandler.isCompilationErrorDetected())
            ctx.setRefToSymTab(ExpressionCtxProcessor.processOnExit(ctx));
    }

    @Override
    public void exitFunctionCall(PyAtHomeParser.FunctionCallContext ctx) {
        if (!logHandler.isCompilationErrorDetected())
            ctx.setRefToSymTab(FunctionCallCtxProcessor.processOnExit(ctx));
    }

    @Override
    public void exitLiteral(PyAtHomeParser.LiteralContext ctx) {
        if (!logHandler.isCompilationErrorDetected())
            ctx.setRefToSymTab(LiteralCtxProcessor.processOnExit(ctx));
    }

}
