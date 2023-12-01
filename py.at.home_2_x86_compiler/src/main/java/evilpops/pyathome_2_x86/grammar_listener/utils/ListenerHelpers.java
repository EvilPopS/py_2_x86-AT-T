package main.java.evilpops.pyathome_2_x86.grammar_listener.utils;

import main.java.evilpops.pyathome_2_x86.assembly_gen.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.assembly_gen.IAssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86.grammar_listener.exceptions.ListenerNotInSyncWithGrammarException;
import main.java.evilpops.pyathome_2_x86.semantic_analyzer.SemanticAnalyzer;
import main.java.evilpops.pyathome_2_x86.sym_tab.ISymTabController;
import main.java.evilpops.pyathome_2_x86.sym_tab.SymTabController;
import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;
import main.java.evilpops.pyathome_2_x86.sym_tab.exceptions.VariableNotFoundException;
import main.java.evilpops.pyathome_2_x86.sym_tab.utils.data_type_utils.DataTypeConvertor;

public class ListenerHelpers {
    private static final String EXC_MESSAGE_F = "ListenerHelpers::%s -> is not in sync with defined grammar!";
    private static final ISymTabController symTabController = SymTabController.getInstance();
    private static final IAssemblyGenerator assemblyGen = AssemblyGenerator.getInstance();

    private static final VariableCounter varCounter = new VariableCounter();
    private static final FloatLiteralsCounter floatLitCounter = new FloatLiteralsCounter();


    public static void processProgramCtxExit() {
        assemblyGen.genCodeEnd();
    }

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

        if (symTabController.checkIfIsVarByInd(numExpRef) || (symTabController.checkIfIsLiteralByInd(numExpRef) && symTabController.checkIfDataTypeIsFloat(numExpRef))) {
            int regRef = symTabController.takeRegister(numExpDataType);
            assemblyGen.genMoveInst(regRef, numExpRef);
            assemblyGen.genMoveInst(idRef, regRef);
            symTabController.freeRegisterByInd(regRef);
        } else
            assemblyGen.genMoveInst(idRef, numExpRef);
    }

    public static int processNumExpressionCtxExit(PyAtHomeParser.NumExpressionContext ctx) {
        if (ctx.expression() != null)
            return ctx.expression().getRefToSymTab();

        else if (ctx.addSubOperators() != null) {
            int leftExpRef = ctx.numExpression().get(0).getRefToSymTab();
            int rightExpRef = ctx.numExpression().get(1).getRefToSymTab();
            if (ctx.addSubOperators().PLUS() != null)
                return performAddition(leftExpRef, rightExpRef);
            else
                return performSubtraction(leftExpRef, rightExpRef);

        } else if (ctx.mulDivOperators() != null) {
            int leftExpRef = ctx.numExpression().get(0).getRefToSymTab();
            int rightExpRef = ctx.numExpression().get(1).getRefToSymTab();
            if (ctx.mulDivOperators().MUL() != null) {
                return -1; // TODO
            } else {
                return -1; // TODO
            }

        } else
            throw new ListenerNotInSyncWithGrammarException(String.format(EXC_MESSAGE_F, "processNumExpressionCtxExit"));
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
        else if (ctx.FLOAT() != null) {
            int literalRef = symTabController.addLiteralFloat(ctx.FLOAT().getText(), DataType.FLOAT, floatLitCounter.getAndIncCounter());
            assemblyGen.genFloatLiteral(literalRef);
            return literalRef;
        } else if (ctx.BOOLEAN() != null)
            return symTabController.addLiteral(ctx.BOOLEAN().getText().equals("True") ? "1" : "0", DataType.BOOLEAN);
        else
            throw new ListenerNotInSyncWithGrammarException(String.format(EXC_MESSAGE_F, "insertLiteralIntoSymTab"));
    }

    private static int performAddition(int leftExpRef, int rightExpRef) {
        SemanticAnalyzer.areTypesCompatibleForAddition(
                leftExpRef,
                rightExpRef
        );

        DataType lExpType = symTabController.getDataTypeByInd(leftExpRef);
        DataType rExpType = symTabController.getDataTypeByInd(rightExpRef);

        DataType resType = DataTypeConvertor.getAdditionResultDataType(lExpType, rExpType);

        if (!lExpType.equals(resType))
            leftExpRef = assemblyGen.genToDataTypeConversion(leftExpRef, resType);

        if (!rExpType.equals(resType))
            rightExpRef = assemblyGen.genToDataTypeConversion(rightExpRef, resType);

        return assemblyGen.genAdditionExpr(leftExpRef, rightExpRef, resType);
    }

    private static int performSubtraction(int leftExpRef, int rightExpRef) {
        SemanticAnalyzer.areTypesCompatibleForSubtraction(
                leftExpRef,
                rightExpRef
        );

        DataType lExpType = symTabController.getDataTypeByInd(leftExpRef);
        DataType rExpType = symTabController.getDataTypeByInd(rightExpRef);

        DataType resType = DataTypeConvertor.getSubtractionResultDataType(lExpType, rExpType);

        if (!lExpType.equals(resType))
            leftExpRef = assemblyGen.genToDataTypeConversion(leftExpRef, resType);

        if (!rExpType.equals(resType))
            rightExpRef = assemblyGen.genToDataTypeConversion(rightExpRef, resType);

        return assemblyGen.genSubtractionExpr(leftExpRef, rightExpRef, resType);
    }

}
