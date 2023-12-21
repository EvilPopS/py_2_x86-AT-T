package main.java.evilpops.pyathome_2_x86.sym_tab.tabs.row_struct;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import main.java.evilpops.pyathome_2_x86.assembly_gen.enums.AssemblyRegister;
import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;

@Getter
@Setter
@Accessors(chain = true)
public class RegisterTabRow extends DataTypeRowArchetype {
    protected AssemblyRegister registerName;
    protected boolean available;

    public RegisterTabRow(int foreignId, DataType dataType, AssemblyRegister registerName) {
        super(foreignId, dataType);
        this.registerName = registerName;
        this.available = true;
    }
}
