package main.java.evilpops.pyathome_2_x86.assembly_gen;

import main.java.evilpops.pyathome_2_x86.assembly_gen.enums.AssemblyRegister;
import main.java.evilpops.pyathome_2_x86.assembly_gen.exceptions.CannotConvertGivenDataTypeToFloatException;
import main.java.evilpops.pyathome_2_x86.assembly_gen.exceptions.ImplementationInconsistencyException;
import main.java.evilpops.pyathome_2_x86.sym_tab.ISymTabController;
import main.java.evilpops.pyathome_2_x86.sym_tab.SymTabController;
import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;

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
                .append(MAIN_START_CODE);
    }

    public static IAssemblyGenerator getInstance() {
        if (assemblyGen == null)
            assemblyGen = new AssemblyGenerator();
        return assemblyGen;
    }

    @Override
    public void genMoveInst(int dest, int src) {
        this.txtSection.append(String.format(
                MOVE_INST,
                this.calcInstructionSuffix(dest),
                this.genSymbolByTabInd(src),
                this.genSymbolByTabInd(dest)
        ));
    }

    @Override
    public void genAddInst(int dest, int src) {
        this.txtSection.append(String.format(
                ADD_INST,
                this.calcInstructionSuffix(dest),
                this.genSymbolByTabInd(src),
                this.genSymbolByTabInd(dest)
        ));
    }

    @Override
    public void genSubInst(int dest, int src) {
        this.txtSection.append(String.format(
                SUB_INST,
                this.calcInstructionSuffix(dest),
                this.genSymbolByTabInd(src),
                this.genSymbolByTabInd(dest)
        ));
    }

    @Override
    public int genAdditionExpr(int leftExpRef, int rightExpRef, DataType resultType) {
        return switch (resultType) {
            case INTEGER, FLOAT -> genNumberAddition(leftExpRef, rightExpRef, resultType);
            case STRING -> -1; // TODO
            default -> throw new ImplementationInconsistencyException("genAdditionExpr");
        };
    }

    @Override
    public int genSubtractionExpr(int leftExpRef, int rightExpRef, DataType resultType) {
        return switch (resultType) {
            case INTEGER, FLOAT -> genNumberSubtraction(leftExpRef, rightExpRef, resultType);
            default -> throw new ImplementationInconsistencyException("genSubtractionExpr");
        };
    }

    @Override
    public void genFloatLiteral(int src) {
        this.dataSection.append(String.format(
                FLOAT_LIT_DATA_SEC,
                this.symTabController.getDataLabelCounter(src),
                this.symTabController.getLiteralValueByInd(src)
        ));
    }

    @Override
    public void genStackPointerDec(boolean isForFloat) {
        this.txtSection.append(String.format(
                SUB_INST,
                INST_SUFFIX,
                this.makeLiteralSymbol(FLOAT_SIZE),
                this.getRegAccess(AssemblyRegister.RSP)
        ));
    }

    @Override
    public void genCodeEnd() {
        this.txtSection.append(PROGRAM_END_CODE);
    }

    @Override
    public int genToDataTypeConversion(int src, DataType resDataType) {
        switch (resDataType) {
            case INTEGER -> { return genToIntegerConversion(src); }
            case FLOAT -> { return genToFloatConversion(src); }
//            case BOOLEAN -> genToFloatConversion(src);
        }
        return -1;
    }

    @Override
    public void printToConsole() {
        System.out.println(this.dataSection.toString() + this.txtSection.toString());
    }

    private String getRegAccess(AssemblyRegister register) {
        return String.format(REG_ACCESS, register);
    }

    private String makeLiteralSymbol(String val) {
        return String.format(LITERAL_W_DOLLAR, val);
    }

    private String genSymbolByTabInd(int ind) {
        if (symTabController.checkIfIsLiteralByInd(ind)) {
            if (symTabController.checkIfDataTypeIsFloat(ind))
                return String.format(DATA_SEC_FLOAT_REF, symTabController.getDataLabelCounter(ind));
            return String.format(LITERAL_W_DOLLAR, symTabController.getLiteralValueByInd(ind));
        } else if (symTabController.checkIfIsVarByInd(ind)) {
            return String.format(
                    MEM_ACCESS,
                    calculateOffset(symTabController.getVarOrdinalityByInd(ind), NEG_FLOAT_SIZE),
                    getRegAccess(AssemblyRegister.RBP));
        } else if (symTabController.checkIfIsRegByInd(ind)) {
            return getRegAccess(symTabController.getRegNameByInd(ind));
        }
        return null;
    }

    private String calculateOffset(int varOrdinality, String offsetBlockSize) {
        return Integer.toString(Integer.parseInt(offsetBlockSize) * varOrdinality);
    }

    private String calcInstructionSuffix(int ind) {
        return symTabController.checkIfDataTypeIsFloat(ind) ? FLOAT_INST_SUFFIX : INST_SUFFIX;
    }

    private int genToIntegerConversion(int src) {
        DataType srcDataType = symTabController.getDataTypeByInd(src);
        if (srcDataType.equals(DataType.BOOLEAN)) {
            int destRegRef = symTabController.takeRegister(DataType.INTEGER);
            this.txtSection.append(String.format(
                    MOVE_INST,
                    INST_SUFFIX,
                    this.genSymbolByTabInd(src),
                    this.genSymbolByTabInd(destRegRef)
            ));
            return destRegRef;
        }
        throw new CannotConvertGivenDataTypeToFloatException(srcDataType.toString());
    }

    private int genToFloatConversion(int src) {
        DataType srcDataType = symTabController.getDataTypeByInd(src);
        switch (srcDataType) {
            case INTEGER:
            case BOOLEAN:
                if (symTabController.checkIfIsLiteralByInd(src)) {
                    int transferRegRef = symTabController.takeRegister(DataType.INTEGER);
                    this.txtSection.append(String.format(
                            MOVE_INST,
                            INST_SUFFIX,
                            this.genSymbolByTabInd(src),
                            this.genSymbolByTabInd(transferRegRef)
                    ));
                    src = transferRegRef;
                }

                int destRegRef = symTabController.takeRegister(DataType.FLOAT);
                this.txtSection.append(String.format(
                        BOOLINT_2_FLOAT_INST,
                        this.genSymbolByTabInd(src),
                        this.genSymbolByTabInd(destRegRef)
                ));
                return destRegRef;
        }
        throw new CannotConvertGivenDataTypeToFloatException(srcDataType.toString());
    }

    private int genNumberAddition(int leftExpRef, int rightExpRef, DataType resType) {
        if (symTabController.checkIfIsRegByInd(leftExpRef)) {
            assemblyGen.genAddInst(leftExpRef, rightExpRef);
            if (symTabController.checkIfIsRegByInd(rightExpRef))
                symTabController.freeRegisterByInd(rightExpRef);
            return leftExpRef;
        } else if (symTabController.checkIfIsRegByInd(rightExpRef)) {
            assemblyGen.genAddInst(rightExpRef, leftExpRef);
            if (symTabController.checkIfIsRegByInd(leftExpRef))
                symTabController.freeRegisterByInd(leftExpRef);
            return rightExpRef;
        } else {
            int destRegRef = symTabController.takeRegister(resType);
            assemblyGen.genMoveInst(destRegRef, leftExpRef);
            assemblyGen.genAddInst(destRegRef, rightExpRef);
            return destRegRef;
        }
    }

    private int genNumberSubtraction(int leftExpRef, int rightExpRef, DataType resType) {
        int destRegRef;
        if (symTabController.checkIfIsRegByInd(leftExpRef)) {
            assemblyGen.genSubInst(leftExpRef, rightExpRef);
            destRegRef = leftExpRef;
        }
        else {
            destRegRef = symTabController.takeRegister(resType);
            assemblyGen.genMoveInst(destRegRef, leftExpRef);
            assemblyGen.genSubInst(destRegRef, rightExpRef);
        }

        if (symTabController.checkIfIsRegByInd(rightExpRef))
            symTabController.freeRegisterByInd(rightExpRef);

        return destRegRef;
    }
}
