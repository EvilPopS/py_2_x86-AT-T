package main.java.evilpops.pyathome_2_x86.assembly_gen;

import main.java.evilpops.pyathome_2_x86.assembly_gen.enums.ConditionalJump;
import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;

import java.util.List;

public interface IAssemblyGenerator {
    /* Singular instructions */
    void genMoveInst(int dest, int src);
    void genArgMoveInst(int dest, int src);
    void genRetValMoveInst(int dest, boolean isFloat);
    void genAddInst(int dest, int src);
    void genSubInst(int dest, int src);
    void genMulInst(int dest, int src);
    void genDivInst(int dest, int src);
    void genAndInst(int dest, int src);
    void genOrInst(int dest, int src);
    void genCmpInst(int dest, int src);
    void genCmpToZeroInst(int dest);
    int genVarOutOfScopeGetter(int src);

    /* Complex set of instructions */
    void genFuncCall(String funcName, List<Integer> args);
    void genNonDefParam(int paramOrdinality, int funcVarCounter);
    void genReturnStatement(int funcRef, int numExpRef, int currVarCount);

    /* Expressions set */
    int genAdditionExpr(int leftExpRef, int rightExpRef, DataType resultType);
    int genSubtractionExpr(int leftExpRef, int rightExpRef, DataType resultType);
    int genMultiplicationExpr(int leftExpRef, int rightExpRef, DataType resultType);
    int genDivisionExpr(int leftExpRef, int rightExpRef, DataType resultType);
    int genComparisonExpr(int leftExpRef, int rightExpRef, ConditionalJump jumpType);
    int genLogicalAndOpExpr(int leftExpRef, int rightExpRef);
    int genLogicalOrOpExpr(int leftExpRef, int rightExpRef);


    /* Other */
    void genFloatLiteral(int src);
    void genStringLiteral(int src);
    void genStackPointerDec(int times);
    void genStackPointerInc(int times);
    void genStackPointerAlignment(boolean isInc);
    void genCodeEnd();
    int genToDataTypeConversion(int src, DataType resDataType);
    void genJump(String jumpInst, String lblName);
    void genLabel(String lblName);

    void printToConsole();
    void onFuncStart(int funcRef);
    void onFuncEnd(String funcName, int currVarCount);
}
