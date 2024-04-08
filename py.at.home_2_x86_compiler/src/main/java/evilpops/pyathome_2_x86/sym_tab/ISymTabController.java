package main.java.evilpops.pyathome_2_x86.sym_tab;

import main.java.evilpops.pyathome_2_x86.assembly_gen.enums.AssemblyRegister;
import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;

public interface ISymTabController {
    /* 'Add' methods */
    int addVariable(DataType dataType, int scope, DataType explicitType, String name, int ordinality);
    int addParameter(DataType dataType, int scope, DataType explicitType, String name, int functionRef, boolean isDefault);
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
    int getRegRefByName(AssemblyRegister regName);
    int getNoneLiteralRef();

    /* 'Get data' methods */
    DataType getDataType(int ind);
    DataType getExplicitType(int ind);
    String getLiteralValue(int ind);
    AssemblyRegister getRegName(int ind);
    int getVarOrdinality(int ind);
    int getDataLabelCounter(int ind);
    int getScope(int ind);
    int getCurrentScope();
    String getFuncName(int ind);

    /* 'Set field' methods */
    void setDataType(int ind, DataType dataType);
    void setExplicitType(int ind, DataType explicitType);

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
