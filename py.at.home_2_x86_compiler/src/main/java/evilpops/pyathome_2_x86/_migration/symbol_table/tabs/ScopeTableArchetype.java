package main.java.evilpops.pyathome_2_x86._migration.symbol_table.tabs;

import main.java.evilpops.pyathome_2_x86._migration.symbol_table.tabs.row_struct.ScopeRowArchetype;

public class ScopeTableArchetype<RowType extends ScopeRowArchetype> extends DataTypeTableArchetype<RowType> {
    public int getScope(int ind) {
        return this.table.get(ind).getScope();
    }
}
