package main.java.evilpops.pyathome_2_x86.assembly_gen;

import main.java.evilpops.pyathome_2_x86.assembly_gen.enums.AssemblyRegister;
import main.java.evilpops.pyathome_2_x86.assembly_gen.enums.ConditionalJump;
import main.java.evilpops.pyathome_2_x86.assembly_gen.exceptions.CannotConvertGivenDataTypeToFloatException;
import main.java.evilpops.pyathome_2_x86.assembly_gen.exceptions.ImplementationInconsistencyException;
import main.java.evilpops.pyathome_2_x86.assembly_gen.utils.LabelCounter;
import main.java.evilpops.pyathome_2_x86.sym_tab.ISymTabController;
import main.java.evilpops.pyathome_2_x86.sym_tab.SymTabController;
import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;

import static main.java.evilpops.pyathome_2_x86.assembly_gen.constants.AssemblyCodeFormats.*;

public class AssemblyGenerator implements IAssemblyGenerator {
    public static IAssemblyGenerator assemblyGen;
    private final ISymTabController symTabController;

    private final LabelCounter lblCounter;
    private final StringBuilder dataSection;
    private final StringBuilder txtSection;

    private AssemblyGenerator() {
        this.symTabController = SymTabController.getInstance();
        this.lblCounter = new LabelCounter();
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
    public void genMulInst(int dest, int src) {
        this.txtSection.append(String.format(
                MUL_INST,
                this.calcInstructionPrefix(dest),
                this.calcInstructionSuffix(dest),
                this.genSymbolByTabInd(src),
                this.genSymbolByTabInd(dest)
        ));
    }

    @Override
    public void genDivInst(int dest, int src) {
        this.txtSection.append(String.format(
                DIV_INST,
                this.genSymbolByTabInd(src),
                this.genSymbolByTabInd(dest)
        ));
    }

    @Override
    public void genCmpInst(int dest, int src) {
        this.txtSection.append(String.format(
                this.symTabController.checkIfDataTypeIsFloat(dest) ? CMP_FLOAT : CMP_INT,
                this.genSymbolByTabInd(src),
                this.genSymbolByTabInd(dest)
        ));
    }

    @Override
    public int genAdditionExpr(int leftExpRef, int rightExpRef, DataType resultType) {
        leftExpRef = assemblyGen.genToDataTypeConversion(leftExpRef, resultType);
        rightExpRef = assemblyGen.genToDataTypeConversion(rightExpRef, resultType);
        return switch (resultType) {
            case INTEGER, FLOAT -> genNumberAddition(leftExpRef, rightExpRef, resultType);
            case STRING -> -1; // TODO
            default -> throw new ImplementationInconsistencyException("genAdditionExpr");
        };
    }

    @Override
    public int genSubtractionExpr(int leftExpRef, int rightExpRef, DataType resultType) {
        leftExpRef = assemblyGen.genToDataTypeConversion(leftExpRef, resultType);
        rightExpRef = assemblyGen.genToDataTypeConversion(rightExpRef, resultType);
        return switch (resultType) {
            case INTEGER, FLOAT -> genNumberSubtraction(leftExpRef, rightExpRef, resultType);
            default -> throw new ImplementationInconsistencyException("genSubtractionExpr");
        };
    }

    @Override
    public int genMultiplicationExpr(int leftExpRef, int rightExpRef, DataType resultType) {
        if (!resultType.equals(DataType.STRING)) {
            leftExpRef = assemblyGen.genToDataTypeConversion(leftExpRef, resultType);
            rightExpRef = assemblyGen.genToDataTypeConversion(rightExpRef, resultType);
        }

        return switch (resultType) {
            case INTEGER, FLOAT -> genNumberMultiplication(leftExpRef, rightExpRef, resultType);
            case STRING -> -1; // TODO
            default -> throw new ImplementationInconsistencyException("genMultiplicationExpr");
        };
    }

    @Override
    public int genDivisionExpr(int leftExpRef, int rightExpRef, DataType resultType) {
        leftExpRef = assemblyGen.genToDataTypeConversion(leftExpRef, resultType);
        rightExpRef = assemblyGen.genToDataTypeConversion(rightExpRef, resultType);
        return switch (resultType) {
            case INTEGER, FLOAT -> genNumberDivision(leftExpRef, rightExpRef, resultType);
            default -> throw new ImplementationInconsistencyException("genDivisionExpr");
        };
    }

    @Override
    public int genComparisonExpr(int leftExpRef, int rightExpRef, ConditionalJump jumpType) {
        int resultRef = symTabController.takeRegister(DataType.BOOLEAN);
        DataType leftExpDT = symTabController.getDataTypeByInd(leftExpRef);
        DataType rightExpDT = symTabController.getDataTypeByInd(rightExpRef);

        if (leftExpDT.equals(DataType.NONE) || rightExpDT.equals(DataType.NONE))
            genImmediateComparisonResult(
                    resultRef, leftExpDT.equals(DataType.NONE) && rightExpDT.equals(DataType.NONE)
            );
        else {
            this.lblCounter.incrementComparisonLblCount();
            if (leftExpDT.equals(DataType.STRING)) {
                //TODO - generate string comparison
            } else if (leftExpDT.equals(DataType.FLOAT) || rightExpDT.equals(DataType.FLOAT)) {
                this.genNumComparison(leftExpRef, rightExpRef, true);
                this.genComparisonBranchCode(resultRef, jumpType, true);
            } else {
                this.genNumComparison(leftExpRef, rightExpRef, false);
                this.genComparisonBranchCode(resultRef, jumpType, false);
            }
        }

        symTabController.freeIfIsRegisterByInd(leftExpRef);
        symTabController.freeIfIsRegisterByInd(rightExpRef);
        return resultRef;
    }

    @Override
    public int genIsNotEqualExpr(int leftExpRef, int rightExpRef) {
        DataType leftExpDT = symTabController.getDataTypeByInd(leftExpRef);
        DataType rightExpDT = symTabController.getDataTypeByInd(rightExpRef);
        if (leftExpDT.equals(DataType.NONE) || rightExpDT.equals(DataType.NONE)) {
        } else if (leftExpDT.equals(DataType.STRING)) {
        } else if (leftExpDT.equals(DataType.FLOAT) || rightExpDT.equals(DataType.FLOAT)) {
        } else {
        }
        return 0;
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
        if (symTabController.getDataTypeByInd(src).equals(resDataType))
            return src;

        return switch (resDataType) {
            case INTEGER -> genToIntegerConversion(src);
            case FLOAT -> genToFloatConversion(src);
//            case BOOLEAN -> genToFloatConversion(src);
            default -> -1;
        };
    }

    @Override
    public void genJump(String jumpInst, String lblName) {
        this.txtSection.append(String.format(JMP_INST, jumpInst, lblName));
    }

    @Override
    public void genLabel(String lblName) {
        this.txtSection.append(String.format(LBL_FORMAT, lblName));
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

    private String calcInstructionPrefix(int ind) {
        return symTabController.checkIfDataTypeIsFloat(ind) ? "" : INST_PREFIX;
    }

    private String calcInstructionSuffix(int ind) {
        return symTabController.checkIfDataTypeIsFloat(ind) ? FLOAT_INST_SUFFIX : INST_SUFFIX;
    }

    private int genToIntegerConversion(int src) {
        DataType srcDataType = symTabController.getDataTypeByInd(src);
        if (srcDataType.equals(DataType.BOOLEAN)) {
            int destRegRef = symTabController.takeRegister(DataType.INTEGER);
            this.genMoveInst(destRegRef, src);
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
                    this.genMoveInst(transferRegRef, src);
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
            this.genAddInst(leftExpRef, rightExpRef);
            symTabController.freeIfIsRegisterByInd(rightExpRef);
            return leftExpRef;
        } else if (symTabController.checkIfIsRegByInd(rightExpRef)) {
            this.genAddInst(rightExpRef, leftExpRef);
            symTabController.freeIfIsRegisterByInd(leftExpRef);
            return rightExpRef;
        } else {
            int destRegRef = symTabController.takeRegister(resType);
            this.genMoveInst(destRegRef, leftExpRef);
            this.genAddInst(destRegRef, rightExpRef);
            return destRegRef;
        }
    }

    private int genNumberSubtraction(int leftExpRef, int rightExpRef, DataType resType) {
        int destRegRef;
        if (symTabController.checkIfIsRegByInd(leftExpRef)) {
            this.genSubInst(leftExpRef, rightExpRef);
            destRegRef = leftExpRef;
        } else {
            destRegRef = symTabController.takeRegister(resType);
            this.genMoveInst(destRegRef, leftExpRef);
            this.genSubInst(destRegRef, rightExpRef);
        }
        symTabController.freeIfIsRegisterByInd(rightExpRef);
        return destRegRef;
    }

    private int genNumberMultiplication(int leftExpRef, int rightExpRef, DataType resType) {
        if (symTabController.checkIfIsRegByInd(leftExpRef)) {
            this.genMulInst(leftExpRef, rightExpRef);
            symTabController.freeIfIsRegisterByInd(rightExpRef);
            return leftExpRef;
        } else if (symTabController.checkIfIsRegByInd(rightExpRef)) {
            this.genMulInst(rightExpRef, leftExpRef);
            symTabController.freeIfIsRegisterByInd(leftExpRef);
            return rightExpRef;
        } else {
            int destRegRef = symTabController.takeRegister(resType);
            this.genMoveInst(destRegRef, leftExpRef);
            this.genMulInst(destRegRef, rightExpRef);
            return destRegRef;
        }
    }

    private int genNumberDivision(int leftExpRef, int rightExpRef, DataType resType) {
        int destRegRef;
        if (symTabController.checkIfIsRegByInd(leftExpRef)) {
            this.genDivInst(leftExpRef, rightExpRef);
            destRegRef = leftExpRef;
        } else {
            destRegRef = symTabController.takeRegister(resType);
            this.genMoveInst(destRegRef, leftExpRef);
            this.genDivInst(destRegRef, rightExpRef);
        }
        symTabController.freeIfIsRegisterByInd(rightExpRef);
        return destRegRef;
    }

    private void genImmediateComparisonResult(int dest, boolean isTrue) {
        this.txtSection.append(String.format(
                MOVE_INST,
                INST_SUFFIX,
                isTrue ? this.makeLiteralSymbol("1") : this.makeLiteralSymbol("0"),
                this.genSymbolByTabInd(dest)
        ));
    }

    private void genNumComparison(int leftExpRef, int rightExpRef, boolean isFloat) {
        DataType resDT = isFloat ? DataType.FLOAT : DataType.INTEGER;
        leftExpRef = this.genToDataTypeConversion(leftExpRef, resDT);
        rightExpRef = this.genToDataTypeConversion(rightExpRef, resDT);
        if (!this.symTabController.checkIfIsRegByInd(leftExpRef)) {
            int regRef = this.symTabController.takeRegister(resDT);
            this.genMoveInst(regRef, leftExpRef);
            leftExpRef = regRef;
        }
        genCmpInst(leftExpRef, rightExpRef);
    }


    private void genComparisonBranchCode(int dest, ConditionalJump jumpType, boolean isFloat) {
        String cmpLblCount = this.lblCounter.getComparisonLblCount();
        String cmpTrueLbl = String.format(LBL_CMP_TRUE, cmpLblCount);
        String cmpEndLbl = String.format(LBL_CMP_END, cmpLblCount);
        this.genJump(ConditionalJump.getJump(jumpType, isFloat), cmpTrueLbl);
        this.genImmediateComparisonResult(dest, false);
        this.genJump(JMP_NON_COND, cmpEndLbl);
        this.genLabel(cmpTrueLbl);
        this.genImmediateComparisonResult(dest, true);
        this.genLabel(cmpEndLbl);
    }


}
