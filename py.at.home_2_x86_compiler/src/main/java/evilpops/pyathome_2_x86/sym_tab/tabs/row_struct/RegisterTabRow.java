package main.java.evilpops.pyathome_2_x86.sym_tab.tabs.row_struct;

import lombok.Getter;
import lombok.Setter;
import main.java.evilpops.pyathome_2_x86.assembly_gen.enums.AssemblyRegister;
import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;

@Getter
@Setter
public class RegisterTabRow extends ConcreteRowArchetype {
    protected AssemblyRegister registerName;
    public RegisterTabRow(AssemblyRegister registerName, DataType dataType, int foreignId) {
        super(dataType, foreignId);
        this.registerName = registerName;
    }
}
