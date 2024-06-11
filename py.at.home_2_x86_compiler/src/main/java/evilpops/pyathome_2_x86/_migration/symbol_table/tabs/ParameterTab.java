package main.java.evilpops.pyathome_2_x86._migration.symbol_table.tabs;

import main.java.evilpops.pyathome_2_x86._migration.symbol_table.enums.DataType;
import main.java.evilpops.pyathome_2_x86._migration.symbol_table.tabs.row_struct.ParameterTabRow;

public class ParameterTab extends ExplicitTypeTableArchetype<ParameterTabRow> {
    public void add(
            int mainTabFK,
            DataType dataType,
            int scope,
            DataType explicitType,
            String name,
            boolean isDefault,
            int ordinality
    ) {
        this.table.add(
                new ParameterTabRow(
                        mainTabFK,
                        dataType,
                        scope,
                        explicitType,
                        name,
                        isDefault,
                        ordinality
                )
        );
    }

    public String getName(int ref) {
        return this.table.get(ref).getName();
    }

    public int getOrdinality(int ref) {
        return this.table.get(ref).getOrdinality();
    }
}
