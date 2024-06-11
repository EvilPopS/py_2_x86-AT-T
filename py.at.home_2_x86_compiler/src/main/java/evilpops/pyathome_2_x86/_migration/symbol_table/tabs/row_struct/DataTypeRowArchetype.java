package main.java.evilpops.pyathome_2_x86._migration.symbol_table.tabs.row_struct;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import main.java.evilpops.pyathome_2_x86._migration.symbol_table.enums.DataType;

@Getter
@Setter
@Accessors(chain = true)
public abstract class DataTypeRowArchetype extends RowArchetype {
    protected DataType dataType;

    public DataTypeRowArchetype(int foreignId, DataType dataType) {
        super(foreignId);
        this.dataType = dataType;
    }
}
