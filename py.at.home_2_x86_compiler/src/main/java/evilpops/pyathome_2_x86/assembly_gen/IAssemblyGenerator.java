package main.java.evilpops.pyathome_2_x86.assembly_gen;

import main.java.evilpops.pyathome_2_x86.assembly_gen.enums.ConditionalJump;
import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;

public interface IAssemblyGenerator {
    /* Singular instructions */
    void genMoveInst(int dest, int src);
    void genAddInst(int dest, int src);
    void genSubInst(int dest, int src);
    void genMulInst(int dest, int src);
    void genDivInst(int dest, int src);
    void genCmpInst(int dest, int src);

    /* Instructions set */
    int genAdditionExpr(int leftExpRef, int rightExpRef, DataType resultType);
    int genSubtractionExpr(int leftExpRef, int rightExpRef, DataType resultType);
    int genMultiplicationExpr(int leftExpRef, int rightExpRef, DataType resultType);
    int genDivisionExpr(int leftExpRef, int rightExpRef, DataType resultType);
    int genComparisonExpr(int leftExpRef, int rightExpRef, ConditionalJump jumpType);
    int genIsNotEqualExpr(int leftExpRef, int rightExpRef);

    /* Other */
    void genFloatLiteral(int src);
    void genStackPointerDec(boolean isForFloat);
    void genCodeEnd();
    int genToDataTypeConversion(int src, DataType resDataType);
    void genJump(String jumpInst, String lblName);
    void genLabel(String lblName);

    void printToConsole();
}
