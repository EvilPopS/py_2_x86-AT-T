package main.java.evilpops.pyathome_2_x86.sym_tab.tabs.row_struct;

import lombok.Getter;
import lombok.Setter;
import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;

@Getter
@Setter
public class LiteralTabRow extends ConcreteRowArchetype {
    protected String value;
    protected int dataLabelNum;

    public LiteralTabRow(int foreignId, DataType dataType, String value) {
        super(dataType, foreignId);
        this.value = value;
        this.dataLabelNum = -1;
    }

    public LiteralTabRow(int foreignId, DataType dataType, String value, int dataLabelNum) {
        super(dataType, foreignId);
        this.value = value;
        this.dataLabelNum = dataLabelNum;
    }
}
