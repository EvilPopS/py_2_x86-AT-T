package main.java.evilpops.pyathome_2_x86.listener.utils;

import main.java.evilpops.pyathome_2_x86.assembly_gen.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.assembly_gen.IAssemblyGenerator;
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
    private static final IAssemblyGenerator assemblyGen = AssemblyGenerator.getInstance();

    private static final VariableCounter varCounter = new VariableCounter();
    private static final FloatLiteralsCounter floatLitCounter = new FloatLiteralsCounter();

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
            int regRef = symTabController.addRegister(numExpDataType);
            assemblyGen.genMove(regRef, numExpRef);
            assemblyGen.genMove(idRef, regRef);
            symTabController.freeRegisterByInd(regRef);
        } else
            assemblyGen.genMove(idRef, numExpRef);
    }

    public static int processNumExpressionCtxExit(PyAtHomeParser.NumExpressionContext ctx) {
        if (ctx.expression() != null)
            return ctx.expression().getRefToSymTab();
        else if (ctx.addSubOperators() != null)
            return performAddition(
                    ctx.numExpression().get(0).getRefToSymTab(),
                    ctx.numExpression().get(1).getRefToSymTab()
            );
        else
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
            return symTabController.addLiteral(ctx.BOOLEAN().getText(), DataType.BOOLEAN);
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
        else if (!rExpType.equals(resType))
            rightExpRef = assemblyGen.genToDataTypeConversion(rightExpRef, resType);


        if (symTabController.checkIfIsRegByInd(leftExpRef)) {
            assemblyGen.genAdd(leftExpRef, rightExpRef);
            return leftExpRef;
        } else if (symTabController.checkIfIsRegByInd(rightExpRef)) {
            assemblyGen.genAdd(rightExpRef, leftExpRef);
            return rightExpRef;
        } else {
            int destRegRef = symTabController.addRegister(resType);
            assemblyGen.genMove(destRegRef, leftExpRef);
            assemblyGen.genAdd(destRegRef, rightExpRef);
            return destRegRef;
        }
    }
}
