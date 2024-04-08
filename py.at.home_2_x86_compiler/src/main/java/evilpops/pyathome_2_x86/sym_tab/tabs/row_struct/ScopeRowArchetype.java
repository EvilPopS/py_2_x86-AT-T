package main.java.evilpops.pyathome_2_x86.sym_tab.tabs.row_struct;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;

@Getter
@Setter
@Accessors(chain = true)
public class ScopeRowArchetype extends DataTypeRowArchetype {
    protected int scope;

    public ScopeRowArchetype(int foreignId, DataType dataType, int scope) {
        super(foreignId, dataType);
        this.scope = scope;
    }
}
