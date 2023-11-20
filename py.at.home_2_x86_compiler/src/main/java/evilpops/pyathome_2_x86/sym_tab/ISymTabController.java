package main.java.evilpops.pyathome_2_x86.sym_tab;

import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;

public interface ISymTabController {
    /* 'Add' methods */
    int addVariable(String name, DataType dataType);
    int addLiteral(String value, DataType dataType);
    int addRegister(DataType dataType);

    /* 'Get reference' methods */
    int getVarRefByName(String name);

    /* 'Get data' methods */
    DataType getDataTypeByInd(int ind);

    /* Check if ... */
    boolean checkIfIsRegByInd(int ind);
    boolean checkIfDataTypeIsFloat(int ind);
}
