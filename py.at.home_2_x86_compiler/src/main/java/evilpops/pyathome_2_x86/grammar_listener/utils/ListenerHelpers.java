package main.java.evilpops.pyathome_2_x86.grammar_listener.utils;

import main.java.evilpops.pyathome_2_x86.assembly_gen.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.assembly_gen.IAssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.assembly_gen.enums.ConditionalJump;
import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86.grammar_listener.exceptions.ListenerNotInSyncWithGrammarException;
import main.java.evilpops.pyathome_2_x86.log_handlers.LogHandler;
import main.java.evilpops.pyathome_2_x86.log_handlers.exceptions.CompilationWarning;
import main.java.evilpops.pyathome_2_x86.semantic_analyzer.SemanticAnalyzer;
import main.java.evilpops.pyathome_2_x86.sym_tab.ISymTabController;
import main.java.evilpops.pyathome_2_x86.sym_tab.SymTabController;
import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;
import main.java.evilpops.pyathome_2_x86.sym_tab.exceptions.VariableNotFoundException;
import main.java.evilpops.pyathome_2_x86.sym_tab.utils.data_type_utils.ResultDataTypeCalculator;

public class ListenerHelpers {
    private static final String EXC_MESSAGE_F = "ListenerHelpers::%s -> is not in sync with defined grammar!";
    private static final ISymTabController symTabController = SymTabController.getInstance();
    private static final IAssemblyGenerator assemblyGen = AssemblyGenerator.getInstance();

    private static final ContextInfoTracker ctxInfoTracker = new ContextInfoTracker();

    public static void processProgramCtxExit() {
        assemblyGen.genCodeEnd();
    }

    public static void processFuncDefCtxExit() {
        assemblyGen.onFuncEnd(
                symTabController.getFuncName(ctxInfoTracker.currFuncRef),
                ctxInfoTracker.getCurrVarCounter()
        );
        ctxInfoTracker.decFuncCtx();
    }

    public static void processFuncDeclCtxExit(PyAtHomeParser.FunctionDeclarationContext ctx) {
        // TODO put explicit function type
    }

    public static void processFuncIdentifierCtxExit(PyAtHomeParser.FunctionIdentifierContext ctx) {
        int funcRef = symTabController.addFunction(ctxInfoTracker.getScope(), ctx.ID().getText());
        ctxInfoTracker.incFuncCtx(funcRef);
        assemblyGen.onFuncStart(funcRef);
    }

    public static void processParamNonDefValCtxExit(PyAtHomeParser.ParamNonDefValContext ctx) {
        if (ctx.ID() == null)
            return;

        DataType explicitType = (ctx.varType() != null)
                ? Convertors.convertTypingCtxToDataType(ctx.varType().types())
                : DataType.UNKNOWN;

        int paramRef = symTabController.addParameter(
                explicitType,
                ctxInfoTracker.getScope(),
                explicitType,
                ctx.ID().getText(),
                ctxInfoTracker.getCurrFuncRef(),
                false
        );

        assemblyGen.genNonDefParam(
                explicitType == DataType.FLOAT ? ctxInfoTracker.incAndGetFloatParamCnt() : ctxInfoTracker.incAndGetNonFloatParamCnt(),
                paramRef
        );

        ctxInfoTracker.incAndGetCurrVarCounter();
    }

    public static void processParamDefValCtxExit(PyAtHomeParser.ParamDefValContext ctx) {
        if (ctx.ID() == null)
            return; // TODO default params
    }

    public static void processAssignStatementCtxExit(PyAtHomeParser.AssignStatementContext ctx) {
        int idRef;
        int numExpRef = ctx.numExpression().getRefToSymTab();
        DataType numExpDataType = symTabController.getDataType(numExpRef);

        DataType explicitType = (ctx.varType() != null) ? Convertors.convertTypingCtxToDataType(ctx.varType().types()) : DataType.UNKNOWN;

        String idName = ctx.ID().getText();
        try {
            idRef = symTabController.getVarRefByNameInCurrentScope(idName, ctxInfoTracker.getScope());
            if (!explicitType.equals(DataType.UNKNOWN)) symTabController.setExplicitType(idRef, explicitType);
            else explicitType = symTabController.getExplicitType(idRef);
            symTabController.setDataType(idRef, numExpDataType);
        } catch (VariableNotFoundException ignored) {
            idRef = symTabController.addVariable(numExpDataType, ctxInfoTracker.getScope(), explicitType, idName, ctxInfoTracker.incAndGetCurrVarCounter());
            assemblyGen.genStackPointerDec(1);
        }

        try {
            SemanticAnalyzer.areImplicitAndExplicitDataTypesTheSame(numExpDataType, explicitType);
        } catch (CompilationWarning warning) {
            LogHandler.getInstance().addWarning(warning.getMessage());
        }

        if (symTabController.checkIfIsVar(numExpRef) || (symTabController.checkIfIsLiteral(numExpRef) && symTabController.checkIfDataTypeIsFloat(numExpRef))) {
            int regRef = symTabController.takeRegister(numExpDataType);
            assemblyGen.genMoveInst(regRef, numExpRef);
            assemblyGen.genMoveInst(idRef, regRef);
            symTabController.freeIfIsRegister(regRef);
        } else assemblyGen.genMoveInst(idRef, numExpRef);

    }

    public static void processReturnStatementCtxExit(PyAtHomeParser.ReturnStatementContext ctx) {
        assemblyGen.genReturnStatement(
                ctxInfoTracker.currFuncRef,
                ctx.numExpression() != null
                        ? ctx.numExpression().getRefToSymTab()
                        : symTabController.getNoneLiteralRef(),
                ctxInfoTracker.getCurrVarCounter()
        );

    }

    public static void processBlockCtxEnter() {
        ctxInfoTracker.incScope();
    }

    public static void processBlockCtxExit() {
        ctxInfoTracker.decScope();
    }

    public static int processNumExpressionCtxExit(PyAtHomeParser.NumExpressionContext ctx) {
        if (ctx.expression() != null) return ctx.expression().getRefToSymTab();
        else if (ctx.L_PAREN() != null && ctx.R_PAREN() != null) return ctx.numExpression(0).getRefToSymTab();
        else if (ctx.numExpression() != null || !ctx.numExpression().isEmpty()) {
            int leftExpRef = ctx.numExpression(0).getRefToSymTab();
            int rightExpRef = ctx.numExpression(1).getRefToSymTab();
            if (ctx.addSubOperators() != null) {
                if (ctx.addSubOperators().PLUS() != null) return performAddition(leftExpRef, rightExpRef);
                else return performSubtraction(leftExpRef, rightExpRef);
            } else if (ctx.mulDivOperators() != null) {
                if (ctx.mulDivOperators().MUL() != null) return performMultiplication(leftExpRef, rightExpRef);
                else return performDivision(leftExpRef, rightExpRef);
            } else if (ctx.relOperators() != null) {
                if (ctx.relOperators().EQ() != null)
                    return performEqualityRelOp(leftExpRef, rightExpRef, ConditionalJump.JE);
                else if (ctx.relOperators().NEQ() != null)
                    return performEqualityRelOp(leftExpRef, rightExpRef, ConditionalJump.JNE);
                else if (ctx.relOperators().GR() != null)
                    return performNonEqualityRelOp(leftExpRef, rightExpRef, ConditionalJump.JG);
                else if (ctx.relOperators().LS() != null)
                    return performNonEqualityRelOp(leftExpRef, rightExpRef, ConditionalJump.JL);
                else if (ctx.relOperators().GREQ() != null)
                    return performNonEqualityRelOp(leftExpRef, rightExpRef, ConditionalJump.JGE);
                else if (ctx.relOperators().LSEQ() != null)
                    return performNonEqualityRelOp(leftExpRef, rightExpRef, ConditionalJump.JLE);
            } else if (ctx.logicAndOperator() != null) return performLogicalOp(leftExpRef, rightExpRef, true);
            else if (ctx.logicOrOperator() != null) return performLogicalOp(leftExpRef, rightExpRef, false);
        }
        throw new ListenerNotInSyncWithGrammarException(String.format(EXC_MESSAGE_F, "processNumExpressionCtxExit"));
    }

    public static int processExpressionCtxExit(PyAtHomeParser.ExpressionContext ctx) {
        if (ctx.literal() != null) return ctx.literal().getRefToSymTab();
        else if (ctx.ID() != null) {
            return assemblyGen.genVarOutOfScopeGetter(symTabController.getVarRefByName(ctx.ID().getText()));
        } else
            throw new ListenerNotInSyncWithGrammarException(String.format(EXC_MESSAGE_F, "transferReferenceToExpressionContext"));
    }

    public static int processLiteralCtxExit(PyAtHomeParser.LiteralContext ctx) {
        if (ctx.INTEGER() != null) return symTabController.addLiteral(ctx.INTEGER().getText(), DataType.INTEGER);
        else if (ctx.FLOAT() != null) {
            int literalRef = symTabController.addLiteralFloat(ctx.FLOAT().getText(), DataType.FLOAT, ctxInfoTracker.getAndIncLitLblCounter());
            assemblyGen.genFloatLiteral(literalRef);
            return literalRef;
        } else if (ctx.BOOLEAN() != null)
            return symTabController.addLiteral(ctx.BOOLEAN().getText().equals("True") ? "1" : "0", DataType.BOOLEAN);
        else if (ctx.STRING() != null) {
            String strVal = ctx.STRING().getText();
            int literalRef = symTabController.addLiteralString(strVal.substring(1, strVal.length() - 1), DataType.STRING, ctxInfoTracker.getAndIncLitLblCounter());
            assemblyGen.genStringLiteral(literalRef);
            return literalRef;
        } else if (ctx.NONE() != null) {
            return symTabController.getNoneLiteralRef();
        } else throw new ListenerNotInSyncWithGrammarException(String.format(EXC_MESSAGE_F, "insertLiteralIntoSymTab"));
    }

    private static int performAddition(int leftExpRef, int rightExpRef) {
        SemanticAnalyzer.areTypesCompatibleForAddition(leftExpRef, rightExpRef);
        return assemblyGen.genAdditionExpr(leftExpRef, rightExpRef, ResultDataTypeCalculator.getAdditionResultDataType(symTabController.getDataType(leftExpRef), symTabController.getDataType(rightExpRef)));
    }

    private static int performSubtraction(int leftExpRef, int rightExpRef) {
        SemanticAnalyzer.areTypesCompatibleForSubtraction(leftExpRef, rightExpRef);
        return assemblyGen.genSubtractionExpr(leftExpRef, rightExpRef, ResultDataTypeCalculator.getSubtractionResultDataType(symTabController.getDataType(leftExpRef), symTabController.getDataType(rightExpRef)));
    }

    private static int performMultiplication(int leftExpRef, int rightExpRef) {
        SemanticAnalyzer.areTypesCompatibleForMultiplication(leftExpRef, rightExpRef);
        return assemblyGen.genMultiplicationExpr(leftExpRef, rightExpRef, ResultDataTypeCalculator.getMultiplicationResultDataType(symTabController.getDataType(leftExpRef), symTabController.getDataType(rightExpRef)));
    }

    private static int performDivision(int leftExpRef, int rightExpRef) {
        SemanticAnalyzer.areTypesCompatibleForDivision(leftExpRef, rightExpRef);
        return assemblyGen.genDivisionExpr(leftExpRef, rightExpRef, ResultDataTypeCalculator.getDivisionResultDataType());
    }

    private static int performEqualityRelOp(int leftExpRef, int rightExpRef, ConditionalJump jump) {
        SemanticAnalyzer.areTypesCompatibleForEqualityRelOp(leftExpRef, rightExpRef);
        return assemblyGen.genComparisonExpr(leftExpRef, rightExpRef, jump);
    }

    private static int performNonEqualityRelOp(int leftExpRef, int rightExpRef, ConditionalJump jump) {
        SemanticAnalyzer.areTypesCompatibleForNonEqualityRelOp(leftExpRef, rightExpRef);
        return assemblyGen.genComparisonExpr(leftExpRef, rightExpRef, jump);
    }

    private static int performLogicalOp(int leftExpRef, int rightExpRef, boolean isAnd) {
        return isAnd ? assemblyGen.genLogicalAndOpExpr(leftExpRef, rightExpRef) : assemblyGen.genLogicalOrOpExpr(leftExpRef, rightExpRef);
    }


}
