package main.java.evilpops.pyathome_2_x86.sym_tab;

import main.java.evilpops.pyathome_2_x86.assembly_gen.enums.AssemblyRegister;
import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;

public interface ISymTabController {
    /* 'Add' methods */
    int addVariable(DataType dataType, String name, int ordinality);
    int addLiteral(String value, DataType dataType);
    int addRegister(DataType dataType);

    /* 'Get reference' methods */
    int getVarRefByName(String name);

    /* 'Get data' methods */
    DataType getDataTypeByInd(int ind);
    String getLiteralValueByInd(int ind);
    AssemblyRegister getRegNameByInd(int ind);
    int getVarOrdinalityByInd(int ind);

    /* 'Set field' methods */
    void setDataTypeByInd(int ind, DataType dataType);

    /* Check if ... */
    boolean checkIfIsRegByInd(int ind);
    boolean checkIfIsLiteralByInd(int ind);
    boolean checkIfIsVarByInd(int ind);
    boolean checkIfDataTypeIsFloat(int ind);
}
