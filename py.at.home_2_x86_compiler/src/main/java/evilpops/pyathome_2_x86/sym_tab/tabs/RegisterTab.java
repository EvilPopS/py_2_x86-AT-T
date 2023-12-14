package main.java.evilpops.pyathome_2_x86.sym_tab.tabs;

import main.java.evilpops.pyathome_2_x86.assembly_gen.constants.AssemblyRegisterGroups;
import main.java.evilpops.pyathome_2_x86.assembly_gen.enums.AssemblyRegister;
import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;
import main.java.evilpops.pyathome_2_x86.sym_tab.tabs.row_struct.RegisterTabRow;

import java.util.HashMap;
import java.util.Map;

public class RegisterTab extends ConcreteTableArchetype<RegisterTabRow> {
    private final Map<AssemblyRegister, Integer> regInds;

    public RegisterTab() {
        super();
        this.regInds = new HashMap<>();
        for (AssemblyRegister ar : AssemblyRegister.values()) {
            this.regInds.put(ar, this.table.size());
            this.table.add(new RegisterTabRow(ar, DataType.UNKNOWN, -1));
        }
    }

    public int takeGenPurposeReg(DataType dataType, int mainTabFK) {
        int regInd = this.regInds.get(getNextFreeGenPurposeReg(dataType));
        this.table.get(regInd).setAvailable(false)
                .setDataType(dataType).setForeignId(mainTabFK);
        return regInd;
    }

    public AssemblyRegister getRegisterNameByInd(int ind) {
        return this.table.get(ind).getRegisterName();
    }

    public void freeRegister(int ind) {
        this.table.get(ind).setAvailable(true).setDataType(DataType.UNKNOWN).setForeignId(-1);
    }

    private AssemblyRegister getNextFreeGenPurposeReg(DataType dataType) {
        AssemblyRegister[] regGroup = dataType == DataType.FLOAT ?
                AssemblyRegisterGroups.FLOAT_TEMP_REGS :
                AssemblyRegisterGroups.CALLEE_SAVED_REGS;

        for (AssemblyRegister ar : regGroup)
            if (this.table.get(this.regInds.get(ar)).isAvailable())
                return ar;

        //What if there are no free registers left???????
        return null;
    }

}
