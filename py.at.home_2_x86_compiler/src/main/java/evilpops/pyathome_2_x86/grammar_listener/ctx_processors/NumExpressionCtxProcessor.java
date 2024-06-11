package main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors;

import main.java.evilpops.pyathome_2_x86.assembly_generator.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.assembly_generator.IAssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.assembly_generator.enums.ConditionalJump;
import main.java.evilpops.pyathome_2_x86.exceptions.other.BadImplementationException;
import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86.grammar_listener.utils.AssemblySymbolProcessor;
import main.java.evilpops.pyathome_2_x86.grammar_listener.utils.ConversionProcessor;
import main.java.evilpops.pyathome_2_x86.semantics.SemanticAnalyzer;
import main.java.evilpops.pyathome_2_x86.symbol_table.ISymTabController;
import main.java.evilpops.pyathome_2_x86.symbol_table.SymTabController;
import main.java.evilpops.pyathome_2_x86.symbol_table.data_type_utils.ResultDataTypeCalculator;
import main.java.evilpops.pyathome_2_x86.symbol_table.enums.DataType;


public class NumExpressionCtxProcessor {
    private static final IAssemblyGenerator assemblyGenerator = AssemblyGenerator.getInstance();
    private static final ISymTabController symTabController = SymTabController.getInstance();

    public static int processOnExit(PyAtHomeParser.NumExpressionContext ctx) {
        if (ctx.expression() != null)
            return processIfExpression(ctx);
        else if (ctx.L_PAREN() != null && ctx.R_PAREN() != null)
            return processIfParenthesis(ctx);
        else if (ctx.numExpression() != null || !ctx.numExpression().isEmpty())
            return processIfOperator(ctx);
        else
            throw new BadImplementationException();
    }

    private static int processIfExpression(PyAtHomeParser.NumExpressionContext ctx) {
        return ctx.expression().getRefToSymTab();
    }

    private static int processIfParenthesis(PyAtHomeParser.NumExpressionContext ctx) {
        return ctx.numExpression(0).getRefToSymTab();
    }

    private static int processIfOperator(PyAtHomeParser.NumExpressionContext ctx) {
        int leftExpRef = ctx.numExpression(0).getRefToSymTab();
        int rightExpRef = ctx.numExpression(1).getRefToSymTab();
        if (ctx.addSubOperators() != null)
            return processIfAddSubOperator(ctx.addSubOperators(), leftExpRef, rightExpRef);
        else if (ctx.mulDivOperators() != null)
            return processIfMulDivOperator(ctx.mulDivOperators(), leftExpRef, rightExpRef);
        else if (ctx.relOperators() != null)
            return processIfRelOperator(ctx.relOperators(), leftExpRef, rightExpRef);
        else if (ctx.logicAndOperator() != null)
            return processIfLogicalAndOperator(leftExpRef, rightExpRef);
        else if (ctx.logicOrOperator() != null)
            return processIfLogicalOrOperator(leftExpRef, rightExpRef);
        else
            throw new BadImplementationException();
    }

    private static int processIfAddSubOperator(
            PyAtHomeParser.AddSubOperatorsContext ctx,
            int leftExpRef,
            int rightExpRef
    ) {
        if (ctx.PLUS() != null)
            return processAddition(leftExpRef, rightExpRef);
        else if (ctx.MINUS() != null)
            return processSubtraction(leftExpRef, rightExpRef);
        else
            throw new BadImplementationException();
    }

    private static int processIfMulDivOperator(
            PyAtHomeParser.MulDivOperatorsContext ctx,
            int leftExpRef,
            int rightExpRef
    ) {
        if (ctx.MUL() != null)
            return processMultiplication(leftExpRef, rightExpRef);
        else if (ctx.DIV() != null)
            return processDivision(leftExpRef, rightExpRef);
        else
            throw new BadImplementationException();
    }

    private static int processIfRelOperator(
            PyAtHomeParser.RelOperatorsContext ctx,
            int leftExpRef,
            int rightExpRef
    ) {
        if (ctx.EQ() != null)
            return processEqualityRelOp(leftExpRef, rightExpRef, ConditionalJump.JE);
        else if (ctx.NEQ() != null)
            return processEqualityRelOp(leftExpRef, rightExpRef, ConditionalJump.JNE);
        else if (ctx.GR() != null)
            return processNonEqualityRelOp(leftExpRef, rightExpRef, ConditionalJump.JG);
        else if (ctx.LS() != null)
            return processNonEqualityRelOp(leftExpRef, rightExpRef, ConditionalJump.JL);
        else if (ctx.GREQ() != null)
            return processNonEqualityRelOp(leftExpRef, rightExpRef, ConditionalJump.JGE);
        else if (ctx.LSEQ() != null)
            return processNonEqualityRelOp(leftExpRef, rightExpRef, ConditionalJump.JLE);
        else
            throw new BadImplementationException();
    }


    private static int processIfLogicalAndOperator(int leftExpRef, int rightExpRef) {
        return processLogicalOpAnd(leftExpRef, rightExpRef);
    }

    private static int processIfLogicalOrOperator(int leftExpRef, int rightExpRef) {
        return processLogicalOpOr(leftExpRef, rightExpRef);
    }

    private static int processAddition(int leftExpRef, int rightExpRef) {
        DataType leftExpDataType = symTabController.getDataType(leftExpRef);
        DataType rightExpDataType = symTabController.getDataType(rightExpRef);

        SemanticAnalyzer.areTypesCompatibleForAddition(leftExpDataType, rightExpDataType);

        DataType resultDataType = ResultDataTypeCalculator.getAdditionResultDataType(leftExpDataType, rightExpDataType);
        leftExpRef = ConversionProcessor.processTypeConversion(leftExpRef, resultDataType);
        rightExpRef = ConversionProcessor.processTypeConversion(rightExpRef, resultDataType);

        return switch (resultDataType) {
            case INTEGER, FLOAT -> processNumberAddition(leftExpRef, rightExpRef, resultDataType);
            case STRING -> processStringAddition(leftExpRef, rightExpRef);
            default -> throw new BadImplementationException();
        };
    }

    private static int processSubtraction(int leftExpRef, int rightExpRef) {
        DataType leftExpDataType = symTabController.getDataType(leftExpRef);
        DataType rightExpDataType = symTabController.getDataType(rightExpRef);

        SemanticAnalyzer.areTypesCompatibleForSubtraction(leftExpDataType, rightExpDataType);

        DataType resultDataType = ResultDataTypeCalculator.getSubtractionResultDataType(leftExpDataType, rightExpDataType);
        leftExpRef = ConversionProcessor.processTypeConversion(leftExpRef, resultDataType);
        rightExpRef = ConversionProcessor.processTypeConversion(rightExpRef, resultDataType);

        return switch (resultDataType) {
            case INTEGER, FLOAT -> processNumberSubtraction(leftExpRef, rightExpRef, resultDataType);
            default -> throw new BadImplementationException();
        };
    }

    private static int processMultiplication(int leftExpRef, int rightExpRef) {
        DataType leftExpDataType = symTabController.getDataType(leftExpRef);
        DataType rightExpDataType = symTabController.getDataType(rightExpRef);

        SemanticAnalyzer.areTypesCompatibleForMultiplication(leftExpDataType, rightExpDataType);

        DataType resultDataType = ResultDataTypeCalculator.getMultiplicationResultDataType(leftExpDataType, rightExpDataType);
        leftExpRef = ConversionProcessor.processTypeConversion(leftExpRef, resultDataType);
        rightExpRef = ConversionProcessor.processTypeConversion(rightExpRef, resultDataType);

        if (!resultDataType.equals(DataType.STRING)) {
            leftExpRef = ConversionProcessor.processTypeConversion(leftExpRef, resultDataType);
            rightExpRef = ConversionProcessor.processTypeConversion(rightExpRef, resultDataType);
        }

        return switch (resultDataType) {
            case INTEGER, FLOAT -> processNumberMultiplication(leftExpRef, rightExpRef, resultDataType);
            case STRING -> processStringMultiplication(leftExpRef, rightExpRef);
            default -> throw new BadImplementationException();
        };
    }

    private static int processDivision(int leftExpRef, int rightExpRef) {
        DataType leftExpDataType = symTabController.getDataType(leftExpRef);
        DataType rightExpDataType = symTabController.getDataType(rightExpRef);

        SemanticAnalyzer.areTypesCompatibleForDivision(leftExpDataType, rightExpDataType);

        DataType resultDataType = ResultDataTypeCalculator.getDivisionResultDataType();
        leftExpRef = ConversionProcessor.processTypeConversion(leftExpRef, resultDataType);
        rightExpRef = ConversionProcessor.processTypeConversion(rightExpRef, resultDataType);

        return switch (resultDataType) {
            case INTEGER, FLOAT -> processNumberDivision(leftExpRef, rightExpRef, resultDataType);
            default -> throw new BadImplementationException();
        };
    }

    private static int processEqualityRelOp(int leftExpRef, int rightExpRef, ConditionalJump jmpType) {
        SemanticAnalyzer.areTypesCompatibleForEqualityRelOp(
                symTabController.getDataType(leftExpRef),
                symTabController.getDataType(rightExpRef)
        );
        return processComparisonExpr(leftExpRef, rightExpRef, jmpType);
    }

    private static int processNonEqualityRelOp(int leftExpRef, int rightExpRef, ConditionalJump jmpType) {
        SemanticAnalyzer.areTypesCompatibleForNonEqualityRelOp(
                symTabController.getDataType(leftExpRef),
                symTabController.getDataType(rightExpRef)
        );
        return processComparisonExpr(leftExpRef, rightExpRef, jmpType);
    }

    private static int processLogicalOpAnd(int leftExpRef, int rightExpRef) {
        return processLogicalOperator(leftExpRef, rightExpRef, true);
    }

    private static int processLogicalOpOr(int leftExpRef, int rightExpRef) {
        return processLogicalOperator(leftExpRef, rightExpRef, false);
    }

    private static int processNumberAddition(int leftExpRef, int rightExpRef, DataType resultDataType) {
        if (symTabController.checkIfIsReg(leftExpRef)) {
            assemblyGenerator.genAdditionSymbolToReg(
                    AssemblySymbolProcessor.createAssemblySymbol(rightExpRef),
                    symTabController.getRegName(leftExpRef),
                    !resultDataType.equals(DataType.FLOAT)
            );
            symTabController.freeIfIsRegister(rightExpRef);
            return leftExpRef;
        } else if (symTabController.checkIfIsReg(rightExpRef)) {
            assemblyGenerator.genAdditionSymbolToReg(
                    AssemblySymbolProcessor.createAssemblySymbol(leftExpRef),
                    symTabController.getRegName(rightExpRef),
                    !resultDataType.equals(DataType.FLOAT)
            );
            symTabController.freeIfIsRegister(leftExpRef);
            return rightExpRef;
        } else {
            int destRegRef = symTabController.takeRegister(resultDataType);
            assemblyGenerator.genMoveSymbolToReg(
                    AssemblySymbolProcessor.createAssemblySymbol(leftExpRef),
                    symTabController.getRegName(destRegRef),
                    !resultDataType.equals(DataType.FLOAT)
            );
            assemblyGenerator.genAdditionSymbolToReg(
                    AssemblySymbolProcessor.createAssemblySymbol(rightExpRef),
                    symTabController.getRegName(destRegRef),
                    !resultDataType.equals(DataType.FLOAT)
            );
            return destRegRef;
        }
    }

    private static int processStringAddition(int leftExpRef, int rightExpRef) {
        assemblyGenerator.genStringAdditionBuiltInFuncCall(
                AssemblySymbolProcessor.createAssemblySymbol(leftExpRef),
                AssemblySymbolProcessor.createAssemblySymbol(rightExpRef),
                symTabController.getAllGenPurposeRegsInUse()
        );

        symTabController.freeIfIsRegister(leftExpRef);
        symTabController.freeIfIsRegister(rightExpRef);

        int regRef = symTabController.takeRegister(DataType.STRING);
        assemblyGenerator.genMoveFuncRetRegToSymbol(
                AssemblySymbolProcessor.createAssemblySymbol(regRef),
                true
        );
        return regRef;
    }

    private static int processNumberSubtraction(int leftExpRef, int rightExpRef, DataType resultDataType) {
        if (symTabController.checkIfIsReg(leftExpRef)) {
            assemblyGenerator.genSubtractionSymbolToReg(
                    AssemblySymbolProcessor.createAssemblySymbol(rightExpRef),
                    symTabController.getRegName(leftExpRef),
                    !resultDataType.equals(DataType.FLOAT)
            );
            symTabController.freeIfIsRegister(rightExpRef);
            return leftExpRef;
        } else {
            int destRegRef = symTabController.takeRegister(resultDataType);
            assemblyGenerator.genMoveSymbolToReg(
                    AssemblySymbolProcessor.createAssemblySymbol(leftExpRef),
                    symTabController.getRegName(destRegRef),
                    !resultDataType.equals(DataType.FLOAT)
            );
            assemblyGenerator.genSubtractionSymbolToReg(
                    AssemblySymbolProcessor.createAssemblySymbol(rightExpRef),
                    symTabController.getRegName(destRegRef),
                    !resultDataType.equals(DataType.FLOAT)
            );
            symTabController.freeIfIsRegister(rightExpRef);
            return destRegRef;
        }
    }

    private static int processNumberMultiplication(int leftExpRef, int rightExpRef, DataType resultDataType) {
        if (symTabController.getDataType(leftExpRef).equals(resultDataType)) {
            if (!symTabController.checkIfIsReg(leftExpRef)) {
                int destRegRef = symTabController.takeRegister(resultDataType);
                assemblyGenerator.genMoveSymbolToReg(
                        AssemblySymbolProcessor.createAssemblySymbol(leftExpRef),
                        symTabController.getRegName(destRegRef),
                        !resultDataType.equals(DataType.FLOAT)
                );
                leftExpRef = destRegRef;
            }
            assemblyGenerator.genMultiplicationSymbolToReg(
                    AssemblySymbolProcessor.createAssemblySymbol(rightExpRef),
                    symTabController.getRegName(leftExpRef),
                    !resultDataType.equals(DataType.FLOAT)
            );
            symTabController.freeIfIsRegister(rightExpRef);
            return leftExpRef;
        } else {
            if (!symTabController.checkIfIsReg(rightExpRef)) {
                int destRegRef = symTabController.takeRegister(resultDataType);
                assemblyGenerator.genMoveSymbolToReg(
                        AssemblySymbolProcessor.createAssemblySymbol(rightExpRef),
                        symTabController.getRegName(destRegRef),
                        !resultDataType.equals(DataType.FLOAT)
                );
                rightExpRef = destRegRef;
                return rightExpRef;
            }
            assemblyGenerator.genMultiplicationSymbolToReg(
                    AssemblySymbolProcessor.createAssemblySymbol(leftExpRef),
                    symTabController.getRegName(rightExpRef),
                    !resultDataType.equals(DataType.FLOAT)
            );
            symTabController.freeIfIsRegister(leftExpRef);
            return rightExpRef;
        }
    }


    private static int processStringMultiplication(int leftExpRef, int rightExpRef) {
        boolean isLeftExpStr = symTabController.checkIfDataTypeIsString(leftExpRef);
        int strValRef = isLeftExpStr ? leftExpRef : rightExpRef;
        int mulValRef = isLeftExpStr ? rightExpRef : leftExpRef;
        assemblyGenerator.genStringMultiplicationBuiltInFuncCall(
                AssemblySymbolProcessor.createAssemblySymbol(strValRef),
                AssemblySymbolProcessor.createAssemblySymbol(mulValRef),
                symTabController.getAllGenPurposeRegsInUse()
        );
        symTabController.freeIfIsRegister(strValRef);
        symTabController.freeIfIsRegister(mulValRef);

        int regRef = symTabController.takeRegister(DataType.STRING);
        assemblyGenerator.genMoveFuncRetRegToSymbol(
                AssemblySymbolProcessor.createAssemblySymbol(regRef),
                true
        );
        return regRef;
    }

    private static int processNumberDivision(int leftExpRef, int rightExpRef, DataType resultDataType) {
        if (symTabController.checkIfIsReg(leftExpRef)) {
            assemblyGenerator.genDivisionSymbolToReg(
                    AssemblySymbolProcessor.createAssemblySymbol(rightExpRef),
                    symTabController.getRegName(leftExpRef)
            );
            symTabController.freeIfIsRegister(rightExpRef);
            return leftExpRef;
        } else {
            int destRegRef = symTabController.takeRegister(resultDataType);
            assemblyGenerator.genMultiplicationSymbolToReg(
                    AssemblySymbolProcessor.createAssemblySymbol(leftExpRef),
                    symTabController.getRegName(destRegRef),
                    false
            );
            assemblyGenerator.genDivisionSymbolToReg(
                    AssemblySymbolProcessor.createAssemblySymbol(rightExpRef),
                    symTabController.getRegName(destRegRef)
            );
            symTabController.freeIfIsRegister(rightExpRef);
            return destRegRef;
        }
    }

    private static int processComparisonExpr(int leftExpRef, int rightExpRef, ConditionalJump jmpType) {
        DataType leftExpDataType = symTabController.getDataType(leftExpRef);
        DataType rightExpDataType = symTabController.getDataType(rightExpRef);

        if (leftExpDataType.equals(DataType.NONE) || rightExpDataType.equals(DataType.NONE)) {
            int resultRef = symTabController.takeRegister(DataType.BOOLEAN);
            boolean exprRes = (leftExpDataType.equals(DataType.NONE) && rightExpDataType.equals(DataType.NONE))
                    == jmpType.equals(ConditionalJump.JE);
            assemblyGenerator.genMoveBoolToSymbol(
                    exprRes,
                    assemblyGenerator.makeRegisterAccessSymbol(symTabController.getRegName(resultRef))
            );
            symTabController.freeIfIsRegister(leftExpRef);
            symTabController.freeIfIsRegister(rightExpRef);
            return resultRef;
        } else {
            if (leftExpDataType.equals(DataType.STRING) && rightExpDataType.equals(DataType.STRING))
                return processStringComparison(leftExpRef, rightExpRef, jmpType);
            else {
                return processNumberComparison(leftExpRef, rightExpRef, jmpType);
            }
        }
    }

    private static int processLogicalOperator(int leftExpRef, int rightExpRef, boolean isAnd) {
        leftExpRef = ConversionProcessor.processTypeConversion(leftExpRef, DataType.BOOLEAN);
        rightExpRef = ConversionProcessor.processTypeConversion(rightExpRef, DataType.BOOLEAN);

        int resRef;
        if (symTabController.checkIfIsReg(leftExpRef)) {
            genLogicalInst(leftExpRef, rightExpRef, isAnd);
            symTabController.freeIfIsRegister(rightExpRef);
            resRef = leftExpRef;
        } else if (symTabController.checkIfIsReg(rightExpRef)) {
            genLogicalInst(rightExpRef, leftExpRef, isAnd);
            symTabController.freeIfIsRegister(leftExpRef);
            resRef = rightExpRef;
        } else {
            resRef = symTabController.takeRegister(DataType.BOOLEAN);
            assemblyGenerator.genMoveSymbolToReg(
                    AssemblySymbolProcessor.createAssemblySymbol(leftExpRef),
                    symTabController.getRegName(resRef),
                    true
            );
            genLogicalInst(resRef, rightExpRef, isAnd);
        }
        return resRef;
    }

    private static int processStringComparison(int leftExpRef, int rightExpRef, ConditionalJump jmpType) {
        assemblyGenerator.genStringComparisonBuiltInFuncCall(
                AssemblySymbolProcessor.createAssemblySymbol(leftExpRef),
                AssemblySymbolProcessor.createAssemblySymbol(rightExpRef),
                symTabController.getAllGenPurposeRegsInUse()
        );
        symTabController.freeIfIsRegister(leftExpRef);
        symTabController.freeIfIsRegister(rightExpRef);

        int funcRetValRef = symTabController.takeRegister(DataType.INTEGER);
        assemblyGenerator.genMoveFuncRetRegToSymbol(
                AssemblySymbolProcessor.createAssemblySymbol(funcRetValRef),
                true
        );
        assemblyGenerator.genCmpToZero(
                assemblyGenerator.makeRegisterAccessSymbol(symTabController.getRegName(funcRetValRef)),
                true
        );
        symTabController.freeIfIsRegister(funcRetValRef);

        int cmpResRef = symTabController.takeRegister(DataType.BOOLEAN);
        assemblyGenerator.genCmpAfterFlow(symTabController.getRegName(cmpResRef), jmpType, true);
        return cmpResRef;
    }

    private static int processNumberComparison(int leftExpRef, int rightExpRef, ConditionalJump jmpType) {
        boolean is64bit = !(symTabController.checkIfDataTypeIsFloat(leftExpRef)
                || symTabController.checkIfDataTypeIsFloat(rightExpRef));
        DataType resDT = is64bit ? DataType.INTEGER : DataType.FLOAT;
        leftExpRef = ConversionProcessor.processTypeConversion(leftExpRef, resDT);
        rightExpRef = ConversionProcessor.processTypeConversion(rightExpRef, resDT);

        if (!symTabController.checkIfIsReg(leftExpRef)) {
            int regRef = symTabController.takeRegister(resDT);
            assemblyGenerator.genMoveSymbolToReg(
                    AssemblySymbolProcessor.createAssemblySymbol(leftExpRef),
                    symTabController.getRegName(regRef),
                    is64bit
            );
            leftExpRef = regRef;
        }
        assemblyGenerator.genCmpSymbolToSymbol(
                AssemblySymbolProcessor.createAssemblySymbol(leftExpRef),
                AssemblySymbolProcessor.createAssemblySymbol(rightExpRef),
                is64bit
        );

        symTabController.freeIfIsRegister(leftExpRef);
        symTabController.freeIfIsRegister(rightExpRef);

        int resRef = symTabController.takeRegister(DataType.BOOLEAN);
        assemblyGenerator.genCmpAfterFlow(symTabController.getRegName(resRef), jmpType, is64bit);
        return resRef;
    }

    private static void genLogicalInst(int leftExpRef, int rightExpRef, boolean isAnd) {
        if (isAnd)
            assemblyGenerator.genLogicalAndInstruction(
                    AssemblySymbolProcessor.createAssemblySymbol(leftExpRef),
                    AssemblySymbolProcessor.createAssemblySymbol(rightExpRef)
            );
        else
            assemblyGenerator.genLogicalOrInstruction(
                    AssemblySymbolProcessor.createAssemblySymbol(leftExpRef),
                    AssemblySymbolProcessor.createAssemblySymbol(rightExpRef)
            );

    }

}
