package main.java.evilpops.pyathome_2_x86.symbol_table;

import main.java.evilpops.pyathome_2_x86.assembly_generator.enums.AssemblyRegister;
import main.java.evilpops.pyathome_2_x86.symbol_table.enums.DataType;

public interface ISymTabController {
    /* 'Add' methods */
    int addVariable(DataType dataType, int scope, String name, int ordinality);
    int addParameter(DataType dataType, int scope, String name, int functionRef, boolean isDefault, int totalOrdinality, int perDataTypeOrdinality);
    int addLiteral(String value, DataType dataType);
    int addFunction(int scope, String name);
    int addLiteralFloat(String value, DataType dataType, int dataLabelCounter);
    int addLiteralString(String value, DataType dataType, int dataLabelCounter);
    int takeRegister(DataType dataType);
    int takeParamReg(int paramOrdinality, DataType dataType);
    int transferParamToVar(int paramRef, int ordinality);

    /* 'Get reference' methods */
    int getVarRefByName(String name);
    Integer getVarRefByNameInCurrentScope(String name, int currScope);
    int takeReturnReg(DataType dataType);
    int getNoneLiteralRef();
    int getFuncRefByName(String funcName);
    int getFuncParamRefByArgCountNum(int funcRef, int argCountNum);

    /* 'Get data' methods */
    DataType getDataType(int ind);
    String getLiteralValue(int ind);
    AssemblyRegister getRegName(int ind);
    AssemblyRegister[] getAllGenPurposeRegsInUse();
    int getVarOrdinality(int ind);
    int getTotalParamOrdinality(int ind);
    int getPerDataTypeParamOrdinality(int ind);
    int getDataLabelCounter(int ind);
    int getScope(int ind);
    int getCurrentScope();
    String getFuncName(int ind);
    int getNumOfFuncParams(int ind);
    int[] getAndFreeAllTakenGenPurposeRegs();

    /* 'Set field' methods */
    void setDataType(int ind, DataType dataType);
    void restoreTakenStateOfGivenGenPurposeRegs(int[] genPurposeRegsRefs);

    /* Check if ... */
    boolean checkIfIsReg(int ind);
    boolean checkIfIsLiteral(int ind);
    boolean checkIfIsVar(int ind);
    boolean checkIfDataTypeIsFloat(int ind);
    boolean checkIfDataTypeIsString(int ind);
    boolean checkIfDataTypeIsBoolean(int ind);
    boolean checkIfDataTypeIsNone(int ind);

    /* Delete methods */
    void freeIfIsRegister(int ind);
}
