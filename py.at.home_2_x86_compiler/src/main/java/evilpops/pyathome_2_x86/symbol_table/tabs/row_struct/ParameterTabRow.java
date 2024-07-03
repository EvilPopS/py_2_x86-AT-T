package main.java.evilpops.pyathome_2_x86.symbol_table.tabs.row_struct;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import main.java.evilpops.pyathome_2_x86.symbol_table.enums.DataType;


@Getter
@Setter
@Accessors(chain = true)
public class ParameterTabRow extends ScopeRowArchetype {
    protected String name;
    protected boolean isDefault;
    protected int totalOrdinality;
    protected int perDataTypeOrdinality;


    public ParameterTabRow(
            int foreignId,
            DataType dataType,
            int funcScope,
            int blockScope,
            String name,
            boolean isDefault,
            int totalOrdinality,
            int perDataTypeOrdinality
    ) {
        super(foreignId, dataType, funcScope, blockScope);
        this.name = name;
        this.isDefault = isDefault;
        this.totalOrdinality = totalOrdinality;
        this.perDataTypeOrdinality = perDataTypeOrdinality;
    }
}
