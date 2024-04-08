package main.java.evilpops.pyathome_2_x86.sym_tab.tabs.row_struct;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;

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
