package main.java.evilpops.pyathome_2_x86.sym_tab.tabs;

import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;
import main.java.evilpops.pyathome_2_x86.sym_tab.tabs.row_struct.DataTypeRowArchetype;

public abstract class DataTypeTableArchetype<RowType extends DataTypeRowArchetype> extends TableArchetype<RowType>{
    public DataType getDataType(int ind) {
        return this.table.get(ind).getDataType();
    }

    public void setDataType(int ind, DataType dt) {
        this.table.get(ind).setDataType(dt);
    }
}
