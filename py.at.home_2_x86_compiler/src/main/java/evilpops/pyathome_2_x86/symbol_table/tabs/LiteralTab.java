package main.java.evilpops.pyathome_2_x86.symbol_table.tabs;

import main.java.evilpops.pyathome_2_x86.symbol_table.enums.DataType;
import main.java.evilpops.pyathome_2_x86.symbol_table.tabs.row_struct.LiteralTabRow;

public class LiteralTab extends ScopeTableArchetype<LiteralTabRow> {
    public void add(int mainTabFK, DataType dataType, int funcScope, int blockScope, String value) {
        this.table.add(new LiteralTabRow(mainTabFK, dataType, funcScope, blockScope, value));
    }

    public void addFloat(int mainTabFK, int funcScope, int blockScope, String value, int dataLabelCounter) {
        addStrOrFloat(mainTabFK, DataType.FLOAT, funcScope, blockScope, value, dataLabelCounter);
    }

    public void addString(int mainTabFK, int funcScope, int blockScope, String value, int dataLabelCounter) {
        addStrOrFloat(mainTabFK, DataType.STRING, funcScope, blockScope, value, dataLabelCounter);
    }

    public String getValue(int ind) {
        return this.table.get(ind).getValue();
    }

    public int getDataLabelCounter(int ind) {
        return this.table.get(ind).getDataLabelNum();
    }

    private void addStrOrFloat(
            int mainTabFK,
            DataType dataType,
            int funcScope,
            int blockScope,
            String value,
            int dataLabelCounter
    ) {
        this.table.add(new LiteralTabRow(mainTabFK, dataType, funcScope, blockScope, value, dataLabelCounter));
    }

}
