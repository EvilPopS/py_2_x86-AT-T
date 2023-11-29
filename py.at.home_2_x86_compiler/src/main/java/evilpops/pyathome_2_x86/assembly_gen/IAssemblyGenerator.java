package main.java.evilpops.pyathome_2_x86.assembly_gen;

import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;

public interface IAssemblyGenerator {
    void genMove(int dest, int src);
    void genAdd(int dest, int src);
    void genSub(int dest, int src);
    void genFloatLiteral(int src);
    void genStackPointerDec(boolean isForFloat);
    void genCodeEnd();
    int genToDataTypeConversion(int src, DataType resDataType);

    void printToConsole();
}
