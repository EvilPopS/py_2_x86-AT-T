package main.java.evilpops.pyathome_2_x86.sym_tab.tabs;

import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;
import main.java.evilpops.pyathome_2_x86.sym_tab.tabs.row_struct.LiteralTabRow;

public class LiteralTab extends DataTypeTableArchetype<LiteralTabRow> {
    public void add(int mainTabFK, DataType dataType, String value) {
        this.table.add(new LiteralTabRow(mainTabFK, dataType, value));
    }

    public void addFloat(int mainTabFK, String value, int dataLabelCounter) {
        addStrOrFloat(mainTabFK, DataType.FLOAT, value, dataLabelCounter);
    }

    public void addString(int mainTabFK, String value, int dataLabelCounter) {
        addStrOrFloat(mainTabFK, DataType.STRING, value, dataLabelCounter);
    }

    public String getValue(int ind) {
        return this.table.get(ind).getValue();
    }

    public void setValue(int ind, String value) {
        this.table.get(ind).setValue(value);
    }

    public int getDataLabelCounter(int ind) {
        return this.table.get(ind).getDataLabelNum();
    }

    private void addStrOrFloat(int mainTabFK, DataType dataType, String value, int dataLabelCounter) {
        this.table.add(new LiteralTabRow(mainTabFK, dataType, value, dataLabelCounter));
    }

}
