package main.java.evilpops.pyathome_2_x86.sym_tab.tabs;

import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;
import main.java.evilpops.pyathome_2_x86.sym_tab.tabs.row_struct.LiteralTabRow;

import java.util.ArrayList;
import java.util.List;

public class LiteralTab {
    protected List<LiteralTabRow> table;

    public LiteralTab() {
        this.table = new ArrayList<>();
    }

    public int lastRowInd() {
        return this.table.size()-1;
    }

    public void add(String value, DataType dataType) {
        this.table.add(new LiteralTabRow(value, dataType));
    }
}
