package main.java.evilpops.pyathome_2_x86.assembly_gen;

public interface IAssemblyGenerator {
    void genMove(int dest, int src);
    void genAdd(int dest, int src);
    void genSub(int dest, int src);
    void genStackPointerDec(boolean isForFloat);

    void printToConsole();
}
