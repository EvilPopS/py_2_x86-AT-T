package main.java.evilpops.pyathome_2_x86.sym_tab.tabs.row_struct;

import lombok.Getter;
import lombok.Setter;
import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;

@Getter
@Setter
public class VariableTabRow extends ExplicitTypeRowArchetype {
    protected String name;
    protected int ordinality;

    public VariableTabRow(int foreignId, DataType dataType, DataType explicitType, String name, int ordinality) {
        super(foreignId, dataType, explicitType);
        this.name = name;
        this.ordinality = ordinality;
    }

}
