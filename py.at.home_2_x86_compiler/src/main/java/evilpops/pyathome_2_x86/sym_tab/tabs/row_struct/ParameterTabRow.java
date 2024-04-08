package main.java.evilpops.pyathome_2_x86.sym_tab.tabs.row_struct;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;


@Getter
@Setter
@Accessors(chain = true)
public class ParameterTabRow extends ExplicitTypeRowArchetype {
    protected String name;
    protected boolean isDefault;

    public ParameterTabRow(int foreignId, DataType dataType, int scope, DataType explicitType, String name, boolean isDefault) {
        super(foreignId, dataType, scope, explicitType);
        this.name = name;
        this.isDefault = isDefault;
    }
}
