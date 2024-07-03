package main.java.evilpops.pyathome_2_x86.assembly_generator;

import main.java.evilpops.pyathome_2_x86.assembly_generator.enums.AssemblyRegister;
import main.java.evilpops.pyathome_2_x86.assembly_generator.enums.ConditionalJump;

public interface IAssemblyGenerator {
    // Data section (Singular)
    void genFloatLiteral(String value, int lblCounter);
    void genStringLiteral(String value, int lblCounter);

    // Move - Instructions (Singular)
    void genMoveSymbolToSymbol(String srcSymbol, String destSymbol, boolean is64bit);
    void genMoveSymbolToReg(String srcSymbol, AssemblyRegister destReg, boolean is64bit);
    void genMoveMemOfBasePointerToReg64bit(AssemblyRegister destReg);
    void genMoveMemOfRegToReg64bit(AssemblyRegister srcReg, AssemblyRegister destReg);
    void genMoveRegToPointerRegMem(AssemblyRegister srcReg, boolean is64bit);
    void genMovePointerRegMemToReg(AssemblyRegister destReg, boolean is64bit);
    void genMoveVarFromCustomBasePointerToReg(AssemblyRegister customBasePointer, AssemblyRegister destReg, int varOrdinality, boolean is64bit);
    void genMoveBoolToSymbol(boolean boolVal, String destSymbol);
    void genMoveFuncRetRegToSymbol(String destSymbol, boolean is64bit);
    void genMovUndefinedToReg(AssemblyRegister descReg);

    // Operations - Instructions (Singular)
    void genAdditionSymbolToReg(String srcSymbol, AssemblyRegister destRegister, boolean is64bit);
    void genSubtractionSymbolToReg(String srcSymbol, AssemblyRegister destRegister, boolean is64bit);
    void genMultiplicationSymbolToReg(String srcSymbol, AssemblyRegister destRegister, boolean is64bit);
    void genDivisionSymbolToReg(String srcSymbol, AssemblyRegister destRegister);
    void genLogicalAndInstruction(String symbol1, String symbol2);
    void genLogicalOrInstruction(String symbol1, String symbol2);

    // Compare - Instructions (Singular)
    void genCmpToZero(String srcSymbol, boolean is64bit);
    void genCmpToUndefined64bit(String srcSymbol);
    void genCmpSymbolToSymbol(String symbol1, String symbol2, boolean is64bit);

    // Compare - Instructions (Multiple)
    void genCmpAfterFlow(AssemblyRegister destReg, ConditionalJump jumpType, boolean is64bit);

    // Function related - Instructions
    void genCall(String lblName);
    void genFuncStart(String funcName);
    void genFuncEnd(String funcName);
    void genFuncArg(String srcSymbol, int argOrdinality, boolean is64bit);
    void genFuncCall(String funcName, AssemblyRegister[] regsToSave);
    void genStringToBoolConversionBuiltInFuncCall(String argSymbol, AssemblyRegister[] regsToSave);
    void genStringAdditionBuiltInFuncCall(String argSymbol1, String argSymbol2, AssemblyRegister[] regsToSave);
    void genStringMultiplicationBuiltInFuncCall(String argStr, String argInt, AssemblyRegister[] regsToSave);
    void genStringComparisonBuiltInFuncCall(String argSymbol1, String argSymbol2, AssemblyRegister[] regsToSave);

    // Jump - Instructions
    void genJmp(String jmpInst, String lblName);
    void genNonCondJmp(String lblName);
    void genJmpIfEqual(String lblName);
    void genNonCondJmpToFuncEnd(String funcName);
    void genNonCondJmpToDefParamCondStart(int lblNum);
    void genNonCondJmpToDefParamCondEnd(int lblNum);
    void genJmpIfEqToDefParamNumExpStart(int lblNum);
    void genJmpAfterIfStatCondition(int lblNum);
    void genJmpAfterElifStatCondition(int lblNum1, int lblNum2);


    // Labels
    void genLabel(String lblName);
    void genDefParamNumExpLabel(int lblNum);
    void genDefParamCondStartLabel(int lblNum);
    void genDefParamCondEndLabel(int lblNum);
    void genIfStatStartLabel(int lblNum);
    void genIfStatEndLabel(int lblNum);
    void genElifStatStartLabel(int lblNum1, int lblNum2);
    void genElifStatEndLabel(int lblNum1, int lblNum2);
    void genElseStatStartLabel(int lblNum);

    // Other - Instructions (Singular)
    void genIntToFloatConversion(String srcSymbol, String destSymbol);
    void genPushReg(AssemblyRegister register, boolean is64bit);
    void genPopReg(AssemblyRegister register, boolean is64bit);
    void genStackPointerAlignmentCorrection(boolean isStackIncreasing);
    void genStackPointerDec(int times);
    void genStackPointerInc(int times);

    // Compound
    void genFunctionEnd(String funcName, int funcVarsCount);

    void genCodeEnd();

    // Non-gen
    String makeFloatLiteralSymbol(int srcLabelCounter);
    String makeStringLiteralSymbol(int srcLabelCounter);
    String makeNoneSymbol();
    String makeUndefinedSymbol();
    String makeIntOrBoolSymbol(String srcValue);
    String makeVarAccessSymbol(int varOrdinality);
    String makeRegisterAccessSymbol(AssemblyRegister register);

    String makeJmpInst(ConditionalJump conditionalJump, boolean is64bit);

    void printToConsole();
}
