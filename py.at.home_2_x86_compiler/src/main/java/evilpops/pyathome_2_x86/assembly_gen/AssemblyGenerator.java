package main.java.evilpops.pyathome_2_x86.assembly_gen;

import main.java.evilpops.pyathome_2_x86.assembly_gen.enums.AssemblyRegister;
import main.java.evilpops.pyathome_2_x86.sym_tab.ISymTabController;
import main.java.evilpops.pyathome_2_x86.sym_tab.SymTabController;

import static main.java.evilpops.pyathome_2_x86.assembly_gen.constants.AssemblyCodeFormats.*;

public class AssemblyGenerator implements IAssemblyGenerator {
    public static IAssemblyGenerator assemblyGen;
    private final ISymTabController symTabController;
    private final StringBuilder dataSection;
    private final StringBuilder txtSection;

    private AssemblyGenerator() {
        this.symTabController = SymTabController.getInstance();
        this.dataSection = new StringBuilder();
        this.txtSection = new StringBuilder();
        this.dataSection.append(String.format(SECTION, "data"));
        this.txtSection.append(String.format(SECTION, "text"))
                .append(GLOBAL_MAIN).append(MAIN_LBL)
                .append(String.format(PUSH_INST, INST_SUFFIX, this.getRegAccess(AssemblyRegister.RBP)))
                .append(String.format(
                        MOVE_INST, INST_SUFFIX,
                        this.getRegAccess(AssemblyRegister.RSP),
                        this.getRegAccess(AssemblyRegister.RBP)
                ));
    }

    public static IAssemblyGenerator getInstance() {
        if (assemblyGen == null)
            assemblyGen = new AssemblyGenerator();
        return assemblyGen;
    }

    @Override
    public void genMove(int dest, int src) {
        this.txtSection.append(String.format(
                MOVE_INST,
                symTabController.checkIfDataTypeIsFloat(src) ? FLOAT_INST_SUFFIX : INST_SUFFIX,
                this.genSymbolByTabInd(src),
                this.genSymbolByTabInd(dest)
        ));
    }

    @Override
    public void genAdd(int dest, int src) {

    }

    @Override
    public void genSub(int dest, int src) {

    }

    @Override
    public void genStackPointerDec(boolean isForFloat) {
        String instSuffix = isForFloat ? FLOAT_INST_SUFFIX : INST_SUFFIX;
        String offset = isForFloat ? FLOAT_SIZE : QUAD_SIZE;
        this.txtSection.append(String.format(
                SUB_INST,
                instSuffix,
                this.getLiteral(offset),
                this.getRegAccess(AssemblyRegister.RSP)
        ));
    }

    @Override
    public void printToConsole() {
        System.out.println(this.dataSection.toString() + this.txtSection.toString());
    }

    private String getRegAccess(AssemblyRegister register) {
        return String.format(REG_ACCESS, register);
    }

    private String getLiteral(String val) {
        return String.format(LITERAL_F, val);
    }

    private String genSymbolByTabInd(int ind) {
        if (symTabController.checkIfIsLiteralByInd(ind))
            return String.format(LITERAL_F, symTabController.getLiteralValueByInd(ind));
        else if (symTabController.checkIfIsVarByInd(ind)) {
            return String.format(
                    MEM_ACCESS,
                    calculateOffset(symTabController.getVarOrdinalityByInd(ind), NEG_QUAD_SIZE),
                    getRegAccess(AssemblyRegister.RBP));
        } else if (symTabController.checkIfIsRegByInd(ind)) {
            return getRegAccess(symTabController.getRegNameByInd(ind));
        }
        return null;
    }

    private String calculateOffset(int varOrdinality, String offsetBlockSize) {
        return Integer.toString(Integer.parseInt(offsetBlockSize)*varOrdinality);
    }
}
