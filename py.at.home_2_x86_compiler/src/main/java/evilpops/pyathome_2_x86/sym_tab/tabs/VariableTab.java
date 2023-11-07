package main.java.evilpops.pyathome_2_x86.sym_tab.tabs;

import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;
import main.java.evilpops.pyathome_2_x86.sym_tab.tabs.row_struct.VariableTabRow;

import java.util.ArrayList;
import java.util.List;

public class VariableTab {
    protected final List<VariableTabRow> table;

    public VariableTab() {
        this.table = new ArrayList<>();
    }

    public int lastRowInd() {
        return this.table.size()-1;
    }

    public void add(String name, DataType dataType) {
        this.table.add(new VariableTabRow(name, dataType));
    }
}
