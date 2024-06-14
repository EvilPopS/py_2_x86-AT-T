package main.java.evilpops.pyathome_2_x86.symbol_table.tabs;

import main.java.evilpops.pyathome_2_x86.symbol_table.enums.DataType;
import main.java.evilpops.pyathome_2_x86.symbol_table.tabs.row_struct.ParameterTabRow;

public class ParameterTab extends ScopeTableArchetype<ParameterTabRow> {
    public void add(
            int mainTabFK,
            DataType dataType,
            int scope,
            String name,
            boolean isDefault,
            int totalOrdinality,
            int perDataTypeOrdinality
    ) {
        this.table.add(
                new ParameterTabRow(
                        mainTabFK,
                        dataType,
                        scope,
                        name,
                        isDefault,
                        totalOrdinality,
                        perDataTypeOrdinality
                )
        );
    }

    public String getName(int ref) {
        return this.table.get(ref).getName();
    }

    public int getTotalOrdinality(int ref) {
        return this.table.get(ref).getTotalOrdinality();
    }

    public int getDataTypeParamOrdinality(int ref) {
        return this.table.get(ref).getPerDataTypeOrdinality();
    }

}
