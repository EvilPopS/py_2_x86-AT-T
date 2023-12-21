package main.java.evilpops.pyathome_2_x86.sym_tab.tabs.row_struct;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;

@Getter
@Setter
@Accessors(chain = true)
public abstract class ExplicitTypeRowArchetype extends DataTypeRowArchetype {
    protected DataType explicitType;

    public ExplicitTypeRowArchetype(int foreignId, DataType dataType, DataType explicitType) {
        super(foreignId, dataType);
        this.explicitType = explicitType;
    }

}
