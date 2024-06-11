package main.java.evilpops.pyathome_2_x86._migration.symbol_table.tabs;

import main.java.evilpops.pyathome_2_x86._migration.assembly_generator.constants.AssemblyRegisterGroups;
import main.java.evilpops.pyathome_2_x86._migration.assembly_generator.enums.AssemblyRegister;
import main.java.evilpops.pyathome_2_x86._migration.symbol_table.enums.DataType;
import main.java.evilpops.pyathome_2_x86._migration.symbol_table.tabs.row_struct.RegisterTabRow;

import java.util.*;


public class RegisterTab extends DataTypeTableArchetype<RegisterTabRow> {
    private final Map<AssemblyRegister, Integer> regInds;

    public RegisterTab() {
        super();
        this.regInds = new HashMap<>();
        for (AssemblyRegister ar : AssemblyRegister.values()) {
            this.regInds.put(ar, this.table.size());
            this.table.add(new RegisterTabRow(-1, DataType.UNKNOWN, ar));
        }
    }

    public int takeGenPurposeReg(int mainTabFK, DataType dataType) {
        int regInd = this.regInds.get(getNextFreeGenPurposeReg(dataType));
        this.table.get(regInd).setAvailable(false).setDataType(dataType).setForeignId(mainTabFK);
        return regInd;
    }

    public int takeParamReg(int mainTabFK, int ordinality, DataType dataType) {
        int regInd = this.regInds.get(getParamReg(ordinality, dataType));
        this.table.get(regInd).setDataType(dataType).setForeignId(mainTabFK);
        return regInd;
    }

    public int takeReturnReg(int mainTabFK, DataType dataType) {
        int regInd = this.regInds.get(
                dataType.equals(DataType.FLOAT) ?
                        AssemblyRegisterGroups.FLOAT_RET_REG :
                        AssemblyRegisterGroups.RET_REG
        );
        this.table.get(regInd).setDataType(dataType).setForeignId(mainTabFK);
        return regInd;
    }

    public AssemblyRegister getRegisterName(int ind) {
        return this.table.get(ind).getRegisterName();
    }

    public void freeRegister(int ind) {
        this.table.get(ind).setAvailable(true).setDataType(DataType.UNKNOWN).setForeignId(-1);
    }

    public AssemblyRegister[] getAllGenPurposeRegsInUse() {
        return this.table.stream().filter(row ->
                        !row.isAvailable() &&
                                (Arrays.asList(AssemblyRegisterGroups.GEN_PURPOSE_REGS).contains(row.getRegisterName()) ||
                                        Arrays.asList(AssemblyRegisterGroups.FLOAT_GEN_PURPOSE_REGS).contains(row.getRegisterName()))
                )
                .map(RegisterTabRow::getRegisterName)
                .toArray(AssemblyRegister[]::new);
    }

    private AssemblyRegister getNextFreeGenPurposeReg(DataType dataType) {
        AssemblyRegister[] regGroup = dataType == DataType.FLOAT ?
                AssemblyRegisterGroups.FLOAT_GEN_PURPOSE_REGS :
                AssemblyRegisterGroups.GEN_PURPOSE_REGS;

        for (AssemblyRegister ar : regGroup)
            if (this.table.get(this.regInds.get(ar)).isAvailable())
                return ar;

        //What if there are no free registers left??????? Ain't going to happen :D
        return null;
    }

    private AssemblyRegister getParamReg(int ordinality, DataType dataType) {
        AssemblyRegister[] regGroup = dataType == DataType.FLOAT ?
                AssemblyRegisterGroups.FLOAT_PARAM_REGS :
                AssemblyRegisterGroups.PARAM_REGS;
        if (ordinality < 5)
            return regGroup[ordinality];
        return null;
    }

}
