package main.java.evilpops.pyathome_2_x86.symbol_table;

import main.java.evilpops.pyathome_2_x86.assembly_generator.enums.AssemblyRegister;
import main.java.evilpops.pyathome_2_x86.symbol_table.enums.DataType;

import java.util.List;

public interface ISymTabController {
    /* 'Add' methods */
    int addVariable(DataType dataType, int funcScope, int blockScope, String name, int ordinality);
    int addParameter(DataType dataType, int funcScope, int blockScope, String name, int functionRef, boolean isDefault, int totalOrdinality, int perDataTypeOrdinality);
    int addLiteral(DataType dataType, int funcScope, int blockScope, String value);
    int addFunction(int funcScope, int blockScope, String name);
    int addLiteralFloat(int funcScope, int blockScope, String value, int dataLabelCounter);
    int addLiteralString(int funcScope, int blockScope, String value, int dataLabelCounter);
    int addLiteralNone(int funcScope, int blockScope);
    int takeRegister(DataType dataType);
    int takeParamReg(int paramOrdinality, DataType dataType);
    int transferParamToVar(int paramRef, int ordinality, int funcScope, int blockScope);

    /* 'Get reference' methods */
    int getVarRefByNameInAnyScope(String name);
    int getVarRefByNameInCurrentFuncScope(String name, int currScope);
    int takeReturnReg(DataType dataType);
    int getFuncRefByName(String funcName);
    int getFuncParamRefByArgCountNum(int funcRef, int argCountNum);
    int getFuncParamRefByParamName(int funcRef, String paramName);

    /* 'Get data' methods */
    DataType getDataType(int ind);
    DataType getParamDataType(int paramRef);
    String getLiteralValue(int ind);
    AssemblyRegister getRegName(int ind);
    AssemblyRegister[] getAllGenPurposeRegsInUse();
    int getVarOrdinality(int ind);
    int getTotalParamOrdinality(int ind);
    int getPerDataTypeParamOrdinality(int ind);
    int getDataLabelCounter(int ind);
    int getFuncScope(int ind);
    int getBlockScope(int ind);
    int getParamScope(int paramRef);
    String getParamName(int paramRef);
    String getFuncName(int ind);
    List<Integer> getFuncsParamRefs(int ind);
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
    boolean checkIfParamDataTypeIsFloat(int paramRef);
    boolean checkIfDataTypeIsString(int ind);
    boolean checkIfDataTypeIsBoolean(int ind);
    boolean checkIfDataTypeIsNone(int ind);
    boolean checkIfIsDefParam(int paramRef);

    /* Delete methods */
    void deleteCurrentFuncScope(int targetScope);
    void deleteCurrentBlockScope(int targetScope);
    void freeIfIsRegister(int ind);
}
