package main.java.evilpops.pyathome_2_x86._migration.symbol_table.tabs.row_struct;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import main.java.evilpops.pyathome_2_x86._migration.symbol_table.enums.DataType;

@Getter
@Setter
@Accessors(chain = true)
public abstract class ExplicitTypeRowArchetype extends ScopeRowArchetype {
    protected DataType explicitType;

    public ExplicitTypeRowArchetype(int foreignId, DataType dataType, int scope, DataType explicitType) {
        super(foreignId, dataType, scope);
        this.explicitType = explicitType;
    }

}
