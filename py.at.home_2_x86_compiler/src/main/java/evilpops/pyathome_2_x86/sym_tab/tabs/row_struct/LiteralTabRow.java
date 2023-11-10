package main.java.evilpops.pyathome_2_x86.sym_tab.tabs.row_struct;

import lombok.Getter;
import lombok.Setter;
import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;

@Getter
@Setter
public class LiteralTabRow extends ConcreteRowArchetype {
    protected String value;

    public LiteralTabRow(String value, DataType dataType, int foreignId) {
        super(dataType, foreignId);
        this.value = value;
    }
}
