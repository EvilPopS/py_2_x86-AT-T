package main.java.evilpops.pyathome_2_x86._migration.symbol_table.tabs.row_struct;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import main.java.evilpops.pyathome_2_x86._migration.symbol_table.enums.DataType;

@Getter
@Setter
@Accessors(chain = true)
public class VariableTabRow extends ExplicitTypeRowArchetype {
    protected String name;
    protected int ordinality;

    public VariableTabRow(int foreignId, DataType dataType, int scope, DataType explicitType, String name, int ordinality) {
        super(foreignId, dataType, scope, explicitType);
        this.name = name;
        this.ordinality = ordinality;
    }

}
