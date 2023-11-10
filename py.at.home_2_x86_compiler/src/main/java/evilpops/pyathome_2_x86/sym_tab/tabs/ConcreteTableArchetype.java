package main.java.evilpops.pyathome_2_x86.sym_tab.tabs;

import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;
import main.java.evilpops.pyathome_2_x86.sym_tab.tabs.row_struct.ConcreteRowArchetype;

public abstract class ConcreteTableArchetype<RowType extends ConcreteRowArchetype> extends TableArchetype<RowType>{
    public DataType getDataType(int ind) {
        return this.table.get(ind).getDataType();
    }
}
