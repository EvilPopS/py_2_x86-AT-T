package main.java.evilpops.pyathome_2_x86.symbol_table.tabs;

import main.java.evilpops.pyathome_2_x86.symbol_table.tabs.row_struct.RowArchetype;

import java.util.ArrayList;
import java.util.List;

public abstract class TableArchetype<RowType extends RowArchetype> {
    protected List<RowType> table;

    public TableArchetype() {
        this.table = new ArrayList<>();
    }

    public int getLastRowInd() {
        return this.table.size()-1;
    }

    public int getTableSize() {
        return this.table.size();
    }

    public void removeRowByInd(int ind) {
        this.table.remove(ind);
    }
}
