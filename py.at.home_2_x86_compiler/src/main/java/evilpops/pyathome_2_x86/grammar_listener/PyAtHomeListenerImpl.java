package main.java.evilpops.pyathome_2_x86.grammar_listener;


import main.java.evilpops.pyathome_2_x86.compilation_info_tracker.components.MultiAssignStatementCtxProcessor;
import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeBaseListener;
import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.expressions_domain.SimpleExpressionCtxProcessor;
import main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.expressions_domain.LiteralCtxProcessor;
import main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.expressions_domain.ComplexExpressionCtxProcessor;
import main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.function_call_domain.ArgNumExpressionCtxProcessor;
import main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.function_call_domain.FuncCallExpressionCtxProcessor;
import main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.function_call_domain.FunctionCallCtxProcessor;
import main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.function_call_domain.PrintFunctionCallCtxProcessor;
import main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.function_def_domain.*;
import main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.if_and_while_statements_domain.*;
import main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.multi_assign_statement_domain.MultiAssignNumExpressionCtxProcessor;
import main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.shared_domain.NonTerminalBlockCtxProcessor;
import main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.shared_domain.TerminalBlockCtxProcessor;
import main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.shared_domain.ProgramCtxProcessor;
import main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.simple_statements_domain.AssignStatementCtxProcessor;
import main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.simple_statements_domain.BreakStatementCtxProcessor;
import main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.simple_statements_domain.ContinueStatementCtxProcessor;
import main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.simple_statements_domain.ReturnStatementCtxProcessor;
import main.java.evilpops.pyathome_2_x86.log_handler.LogHandler;

public class PyAtHomeListenerImpl extends PyAtHomeBaseListener {
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
    public void enterWhileElseStatement(PyAtHomeParser.WhileElseStatementContext ignored) {
        if (!logHandler.isCompilationErrorDetected())
            WhileElseStatementProcessor.processOnEnter();
    }

    @Override
    public void exitWhileElseStatement(PyAtHomeParser.WhileElseStatementContext ignored) {
        if (!logHandler.isCompilationErrorDetected())
            WhileElseStatementProcessor.processOnExit();
    }

    @Override
    public void enterWhileStatPart(PyAtHomeParser.WhileStatPartContext ignored) {
        if (!logHandler.isCompilationErrorDetected())
            WhileStatPartCtxProcessor.processOnEnter();
    }

    @Override
    public void exitWhileStatPart(PyAtHomeParser.WhileStatPartContext ignored) {
        if (!logHandler.isCompilationErrorDetected())
            WhileStatPartCtxProcessor.processOnExit();
    }

    @Override
    public void enterWhileConditionPart(PyAtHomeParser.WhileConditionPartContext ignored) {
        if (!logHandler.isCompilationErrorDetected())
            WhileConditionPartProcessor.processOnEnter();
    }

    @Override
    public void exitWhileConditionPart(PyAtHomeParser.WhileConditionPartContext ctx) {
        if (!logHandler.isCompilationErrorDetected())
            WhileConditionPartProcessor.processOnExit(ctx);
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
    public void enterMultiAssignStatement(PyAtHomeParser.MultiAssignStatementContext ignored) {
        if (!logHandler.isCompilationErrorDetected())
            MultiAssignStatementCtxProcessor.processOnEnter();
    }

    @Override
    public void exitMultiAssignStatement(PyAtHomeParser.MultiAssignStatementContext ctx) {
        if (!logHandler.isCompilationErrorDetected())
            MultiAssignStatementCtxProcessor.processOnExit(ctx);
    }

    @Override
    public void exitMultiAssignNumExpression(PyAtHomeParser.MultiAssignNumExpressionContext ctx) {
        if (!logHandler.isCompilationErrorDetected())
            MultiAssignNumExpressionCtxProcessor.processOnExit(ctx);
    }

    @Override
    public void exitReturnStatement(PyAtHomeParser.ReturnStatementContext ctx) {
        if (!logHandler.isCompilationErrorDetected())
            ReturnStatementCtxProcessor.processOnExit(ctx);
    }

    @Override
    public void exitContinueStatement(PyAtHomeParser.ContinueStatementContext ignored) {
        if (!logHandler.isCompilationErrorDetected())
            ContinueStatementCtxProcessor.processOnExit();
    }

    @Override
    public void exitBreakStatement(PyAtHomeParser.BreakStatementContext ignored) {
        if (!logHandler.isCompilationErrorDetected())
            BreakStatementCtxProcessor.processOnExit();
    }

    @Override
    public void exitPrintFunctionCall(PyAtHomeParser.PrintFunctionCallContext ctx) {
        if (!logHandler.isCompilationErrorDetected())
            PrintFunctionCallCtxProcessor.processOnExit(ctx);
    }

    @Override
    public void enterNonTerminalBlock(PyAtHomeParser.NonTerminalBlockContext ignored) {
        if (!logHandler.isCompilationErrorDetected())
            NonTerminalBlockCtxProcessor.processOnEnter();
    }

    @Override
    public void enterTerminalBlock(PyAtHomeParser.TerminalBlockContext ignored) {
        if (!logHandler.isCompilationErrorDetected())
            TerminalBlockCtxProcessor.processOnEnter();
    }

    @Override
    public void exitTerminalBlock(PyAtHomeParser.TerminalBlockContext ignored) {
        if (!logHandler.isCompilationErrorDetected())
            TerminalBlockCtxProcessor.processOnExit();
    }

    @Override
    public void exitArgNumExpression(PyAtHomeParser.ArgNumExpressionContext ctx) {
        if (!logHandler.isCompilationErrorDetected())
            ctx.setRefToSymTab(ArgNumExpressionCtxProcessor.processOnExit(ctx));
    }

    @Override
    public void exitComplexExpression(PyAtHomeParser.ComplexExpressionContext ctx) {
        if (!logHandler.isCompilationErrorDetected())
            ctx.setRefToSymTab(ComplexExpressionCtxProcessor.processOnExit(ctx));
    }

    @Override
    public void exitSimpleExpression(PyAtHomeParser.SimpleExpressionContext ctx) {
        if (!logHandler.isCompilationErrorDetected())
            ctx.setRefToSymTab(SimpleExpressionCtxProcessor.processOnExit(ctx));
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
