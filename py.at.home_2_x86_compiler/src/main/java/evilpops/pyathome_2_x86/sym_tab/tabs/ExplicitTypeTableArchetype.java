package main.java.evilpops.pyathome_2_x86.sym_tab.tabs;

import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;
import main.java.evilpops.pyathome_2_x86.sym_tab.tabs.row_struct.DataTypeRowArchetype;
import main.java.evilpops.pyathome_2_x86.sym_tab.tabs.row_struct.ExplicitTypeRowArchetype;

public abstract class ExplicitTypeTableArchetype<RowType extends ExplicitTypeRowArchetype> extends DataTypeTableArchetype<RowType>{
    public DataType getExplicitType(int ind) {
        return this.table.get(ind).getExplicitType();
    }

    public void setExplicitType(int ind, DataType dt) {
        this.table.get(ind).setExplicitType(dt);
    }
}
