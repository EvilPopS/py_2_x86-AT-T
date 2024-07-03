package main.java.evilpops.pyathome_2_x86.symbol_table.tabs.row_struct;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import main.java.evilpops.pyathome_2_x86.symbol_table.enums.DataType;

@Getter
@Setter
@Accessors(chain = true)
public class ScopeRowArchetype extends DataTypeRowArchetype {
    protected int funcScope;
    protected int blockScope;

    public ScopeRowArchetype(int foreignId, DataType dataType, int funcScope, int blockScope) {
        super(foreignId, dataType);
        this.funcScope = funcScope;
        this.blockScope = blockScope;
    }
}
