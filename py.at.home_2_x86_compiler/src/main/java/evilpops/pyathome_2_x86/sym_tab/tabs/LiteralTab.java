package main.java.evilpops.pyathome_2_x86.sym_tab.tabs;

import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;
import main.java.evilpops.pyathome_2_x86.sym_tab.tabs.row_struct.LiteralTabRow;

public class LiteralTab extends ConcreteTableArchetype<LiteralTabRow> {
    public void add(String value, DataType dataType, int mainTabFK) {
        this.table.add(new LiteralTabRow(value, dataType, mainTabFK));
    }

    public String getValueByInd(int ind) {
        return this.table.get(ind).getValue();
    }
}
