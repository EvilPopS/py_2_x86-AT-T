package main.java.evilpops.pyathome_2_x86.sym_tab;

import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;

public interface ISymTabController {
    void addVariable(String name, DataType dataType);
    void addLiteral(String value, DataType dataType);
}
