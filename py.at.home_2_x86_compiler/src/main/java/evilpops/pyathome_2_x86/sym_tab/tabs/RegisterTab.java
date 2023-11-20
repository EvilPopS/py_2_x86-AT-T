package main.java.evilpops.pyathome_2_x86.sym_tab.tabs;

import main.java.evilpops.pyathome_2_x86.assembly_gen.constants.AssemblyRegisterGroups;
import main.java.evilpops.pyathome_2_x86.assembly_gen.enums.AssemblyRegister;
import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;
import main.java.evilpops.pyathome_2_x86.sym_tab.tabs.row_struct.RegisterTabRow;

import java.util.HashMap;
import java.util.Map;

public class RegisterTab extends ConcreteTableArchetype<RegisterTabRow> {
    public static final Map<AssemblyRegister, Boolean> registerAvailability = new HashMap<>() {{
        for (AssemblyRegister ar : AssemblyRegister.values())
            put(ar, false);
    }};

    public void add(DataType dataType, int mainTabFK) {
        this.table.add(new RegisterTabRow(getNextFreeRegister(dataType), dataType, mainTabFK));
    }

    private AssemblyRegister getNextFreeRegister(DataType dataType) {
        if (dataType != DataType.FLOAT) {
            for (AssemblyRegister ar : AssemblyRegisterGroups.FREE_REGS)
                if (registerAvailability.get(ar)) {
                    registerAvailability.put(ar, true);
                    return ar;
                }
        } else {
            for (AssemblyRegister ar : AssemblyRegisterGroups.FLOAT_FREE_REGS)
                if (registerAvailability.get(ar)) {
                    registerAvailability.put(ar, true);
                    return ar;
                }
        }
        // What if there are no free registers?
        return null;
    }

}
