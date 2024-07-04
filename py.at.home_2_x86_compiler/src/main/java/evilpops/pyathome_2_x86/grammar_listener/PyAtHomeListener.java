package main.java.evilpops.pyathome_2_x86.grammar_listener;


import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeBaseListener;
import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.expressions_domain.ExpressionCtxProcessor;
import main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.expressions_domain.LiteralCtxProcessor;
import main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.expressions_domain.NumExpressionCtxProcessor;
import main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.function_call_domain.ArgNumExpressionCtxProcessor;
import main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.function_call_domain.FuncCallExpressionCtxProcessor;
import main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.function_call_domain.FunctionCallCtxProcessor;
import main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.function_call_domain.PrintFunctionCallCtxProcessor;
import main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.function_def_domain.*;
import main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.if_statement_domain.*;
import main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.shared_domain.BlockCtxProcessor;
import main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.shared_domain.ProgramCtxProcessor;
import main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.simple_statements_domain.AssignStatementCtxProcessor;
import main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.simple_statements_domain.ReturnStatementCtxProcessor;
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
    public void enterIfElifElseStatement(PyAtHomeParser.IfElifElseStatementContext ignored) {
        if (!logHandler.isCompilationErrorDetected())
            IfElifElseStatementCtxProcessor.processOnEnter();
    }

    @Override
    public void exitIfElifElseStatement(PyAtHomeParser.IfElifElseStatementContext ignored) {
        if (!logHandler.isCompilationErrorDetected())
            IfElifElseStatementCtxProcessor.processOnExit();
    }

    @Override
    public void enterIfStatPart(PyAtHomeParser.IfStatPartContext ignored) {
        if (!logHandler.isCompilationErrorDetected())
            IfStatPartCtxProcessor.processOnEnter();
    }

    @Override
    public void exitIfStatPart(PyAtHomeParser.IfStatPartContext ignored) {
        if (!logHandler.isCompilationErrorDetected())
            IfStatPartCtxProcessor.processOnExit();
    }

    @Override
    public void exitIfConditionPart(PyAtHomeParser.IfConditionPartContext ctx) {
        if (!logHandler.isCompilationErrorDetected())
            IfConditionPartCtxProcessor.processOnExit(ctx);
    }

    @Override
    public void enterElifStatPart(PyAtHomeParser.ElifStatPartContext ignored) {
        if (!logHandler.isCompilationErrorDetected())
            ElifStatPartCtxProcessor.processOnEnter();
    }

    @Override
    public void exitElifStatPart(PyAtHomeParser.ElifStatPartContext ignored) {
        if (!logHandler.isCompilationErrorDetected())
            ElifStatPartCtxProcessor.processOnExit();
    }

    @Override
    public void exitElifConditionPart(PyAtHomeParser.ElifConditionPartContext ctx) {
        if (!logHandler.isCompilationErrorDetected())
            ElifConditionPartCtxProcessor.processOnExit(ctx);
    }

    @Override
    public void enterElseStatPart(PyAtHomeParser.ElseStatPartContext ignored) {
        if (!logHandler.isCompilationErrorDetected())
            ElseStatPartCtxProcessor.processOnEnter();
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
    public void exitPrintFunctionCall(PyAtHomeParser.PrintFunctionCallContext ctx) {
        if (!logHandler.isCompilationErrorDetected())
            PrintFunctionCallCtxProcessor.processOnExit(ctx);
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
    public void exitFuncCallExpression(PyAtHomeParser.FuncCallExpressionContext ctx) {
        if (!logHandler.isCompilationErrorDetected())
            ctx.setRefToSymTab(FuncCallExpressionCtxProcessor.processOnExit(ctx));
    }

    @Override
    public void exitFunctionCall(PyAtHomeParser.FunctionCallContext ctx) {
        if (!logHandler.isCompilationErrorDetected())
            FunctionCallCtxProcessor.processOnExit(ctx);
    }

    @Override
    public void exitLiteral(PyAtHomeParser.LiteralContext ctx) {
        if (!logHandler.isCompilationErrorDetected())
            ctx.setRefToSymTab(LiteralCtxProcessor.processOnExit(ctx));
    }

}
