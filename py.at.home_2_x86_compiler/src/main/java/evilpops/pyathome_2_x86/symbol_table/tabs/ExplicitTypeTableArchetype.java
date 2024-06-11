package main.java.evilpops.pyathome_2_x86.symbol_table.tabs;

import main.java.evilpops.pyathome_2_x86.symbol_table.enums.DataType;
import main.java.evilpops.pyathome_2_x86.symbol_table.tabs.row_struct.ExplicitTypeRowArchetype;

public abstract class ExplicitTypeTableArchetype<RowType extends ExplicitTypeRowArchetype> extends ScopeTableArchetype<RowType> {
    public DataType getExplicitType(int ind) {
        return this.table.get(ind).getExplicitType();
    }

    public void setExplicitType(int ind, DataType dt) {
        this.table.get(ind).setExplicitType(dt);
    }
}
