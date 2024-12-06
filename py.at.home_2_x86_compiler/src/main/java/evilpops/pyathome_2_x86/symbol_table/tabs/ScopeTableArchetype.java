package main.java.evilpops.pyathome_2_x86.symbol_table.tabs;

import main.java.evilpops.pyathome_2_x86.symbol_table.tabs.row_struct.ScopeRowArchetype;

public abstract class ScopeTableArchetype<RowType extends ScopeRowArchetype> extends DataTypeTableArchetype<RowType> {
    public int getFuncScope(int ind) {
        return this.table.get(ind).getFuncScope();
    }

    public int getBlockScope(int ind) {
        return this.table.get(ind).getBlockScope();
    }
}
