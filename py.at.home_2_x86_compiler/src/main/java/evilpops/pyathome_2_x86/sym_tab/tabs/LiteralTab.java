package main.java.evilpops.pyathome_2_x86.sym_tab.tabs;

import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;
import main.java.evilpops.pyathome_2_x86.sym_tab.tabs.row_struct.LiteralTabRow;

public class LiteralTab extends ConcreteTableArchetype<LiteralTabRow> {
    public void add(int mainTabFK, DataType dataType, String value) {
        this.table.add(new LiteralTabRow(mainTabFK, dataType, value));
    }

    public void addFloat(int mainTabFK, DataType dataType, String value, int dataLabelCounter) {
        this.table.add(new LiteralTabRow(mainTabFK, dataType, value, dataLabelCounter));
    }

    public String getValueByInd(int ind) {
        return this.table.get(ind).getValue();
    }

    public void setValueByInd(int ind, String value) {
        this.table.get(ind).setValue(value);
    }

    public int getDataLabelCounter(int ind) {
        return this.table.get(ind).getDataLabelNum();
    }

}
