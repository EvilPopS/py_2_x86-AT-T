package main.java.evilpops.pyathome_2_x86.symbol_table.tabs.row_struct;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import main.java.evilpops.pyathome_2_x86.symbol_table.enums.DataType;

@Getter
@Setter
@Accessors(chain = true)
public class VariableTabRow extends ScopeRowArchetype {
    protected String name;
    protected int ordinality;

    public VariableTabRow(int foreignId, DataType dataType, int funcScope, int blockScope, String name, int ordinality) {
        super(foreignId, dataType, funcScope, blockScope);
        this.name = name;
        this.ordinality = ordinality;
    }

}
