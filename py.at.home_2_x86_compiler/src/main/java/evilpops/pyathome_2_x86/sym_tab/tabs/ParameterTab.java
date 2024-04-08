package main.java.evilpops.pyathome_2_x86.sym_tab.tabs;

import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;
import main.java.evilpops.pyathome_2_x86.sym_tab.tabs.row_struct.ParameterTabRow;

public class ParameterTab extends ExplicitTypeTableArchetype<ParameterTabRow> {
    public void add(int mainTabFK, DataType dataType, int scope, DataType explicitType, String name, boolean isDefault) {
        this.table.add(new ParameterTabRow(mainTabFK, dataType, scope, explicitType, name, isDefault));
    }

    public String getName(int ref) {
        return this.table.get(ref).getName();
    }

}
