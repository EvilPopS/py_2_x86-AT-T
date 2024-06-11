package main.java.evilpops.pyathome_2_x86._migration.symbol_table.tabs;

import main.java.evilpops.pyathome_2_x86._migration.symbol_table.enums.DataType;
import main.java.evilpops.pyathome_2_x86._migration.symbol_table.tabs.row_struct.LiteralTabRow;

public class LiteralTab extends DataTypeTableArchetype<LiteralTabRow> {
    public void add(int mainTabFK, DataType dataType, String value) {
        this.table.add(new LiteralTabRow(mainTabFK, dataType, 0, value));
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

    public int getNoneRowRef() {
        for (LiteralTabRow row : this.table) {
            if (row.getDataType().equals(DataType.NONE))
                return this.table.indexOf(row);
        }
        return -1;
    }

    public void setValue(int ind, String value) {
        this.table.get(ind).setValue(value);
    }

    public int getDataLabelCounter(int ind) {
        return this.table.get(ind).getDataLabelNum();
    }

    private void addStrOrFloat(int mainTabFK, DataType dataType, String value, int dataLabelCounter) {
        this.table.add(new LiteralTabRow(mainTabFK, dataType, 0, value, dataLabelCounter));
    }

}
