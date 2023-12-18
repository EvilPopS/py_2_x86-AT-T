package main.java.evilpops.pyathome_2_x86.assembly_gen;

import main.java.evilpops.pyathome_2_x86.assembly_gen.enums.AssemblyRegister;
import main.java.evilpops.pyathome_2_x86.assembly_gen.enums.ConditionalJump;
import main.java.evilpops.pyathome_2_x86.assembly_gen.exceptions.CannotConvertGivenDataTypeToFloatException;
import main.java.evilpops.pyathome_2_x86.assembly_gen.exceptions.ImplementationInconsistencyException;
import main.java.evilpops.pyathome_2_x86.assembly_gen.utils.LabelCounter;
import main.java.evilpops.pyathome_2_x86.assembly_gen.utils.StackAlignmentTracker;
import main.java.evilpops.pyathome_2_x86.sym_tab.ISymTabController;
import main.java.evilpops.pyathome_2_x86.sym_tab.SymTabController;
import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;

import java.util.ArrayList;
import java.util.List;

import static main.java.evilpops.pyathome_2_x86.assembly_gen.constants.AssemblyCodeFormats.*;
import static main.java.evilpops.pyathome_2_x86.assembly_gen.constants.AssemblyRegisterGroups.*;

public class AssemblyGenerator implements IAssemblyGenerator {
    public static IAssemblyGenerator assemblyGen;
    private final ISymTabController symTabController;

    private final LabelCounter lblCounter;
    private final StackAlignmentTracker stackAlignTracker;

    private final StringBuilder dataSection;
    private final StringBuilder builtInTxtSection;
    private final StringBuilder txtSection;

    private AssemblyGenerator() {
        this.symTabController = SymTabController.getInstance();
        this.lblCounter = new LabelCounter();
        this.stackAlignTracker = new StackAlignmentTracker();
        this.dataSection = new StringBuilder();
        this.builtInTxtSection = new StringBuilder();
        this.txtSection = new StringBuilder();
        this.dataSection.append(String.format(SECTION, "data"))
                .append(DATA_SECTION_INIT);
        this.builtInTxtSection.append(CONCAT_STRINGS_BUILTIN)
                .append(STRINGS_MUL_BUILTIN).append(STRINGS_CMP_BUILTIN)
                .append(STRING_TO_BOOL_BUILTIN);
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
    public void genArgMoveInst(int dest, int src) {
        AssemblyRegister destReg = symTabController.checkIfDataTypeIsFloat(src) ? FLOAT_ARGS_REGS[dest] : ARGS_REGS[dest];
        this.txtSection.append(String.format(
                MOVE_INST,
                this.calcInstructionSuffix(src),
                this.genSymbolByTabInd(src),
                this.getRegAccess(destReg)
        ));
        this.symTabController.freeIfIsRegister(src);
    }

    @Override
    public void genRetValMoveInst(int dest, boolean isFloat) {
        this.txtSection.append(String.format(
                MOVE_INST,
                isFloat ? FLOAT_INST_SUFFIX : INST_SUFFIX,
                this.getRegAccess(isFloat ? FLOAT_RET_REGS[0] : RET_REGS[0]),
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
    public void genAndInst(int dest, int src) {
        this.txtSection.append(String.format(
                AND_INST,
                this.genSymbolByTabInd(src),
                this.genSymbolByTabInd(dest)
        ));
    }

    @Override
    public void genOrInst(int dest, int src) {
        this.txtSection.append(String.format(
                OR_INST,
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
    public void genCmpToZeroInst(int dest) {
        boolean isFloat = this.symTabController.checkIfDataTypeIsFloat(dest);
        this.txtSection.append(String.format(
                isFloat ? CMP_FLOAT : CMP_INT,
                this.makeLiteralSymbol(isFloat ? FLOAT_ZERO : "0", isFloat),
                this.genSymbolByTabInd(dest)
        ));
    }

    @Override
    public void genFuncCall(String funcName, List<Integer> args) {
        //TODO push temp regs that are taken and pop them after return
        boolean isStackAligned = this.stackAlignTracker.isCurrentBlockStackAligned();
        if (!isStackAligned)
            this.genStackPointerAlignment(false);

        int nonFloatArgNum = 0;
        int floatArgNum = 0;
        for (int src : args)
            this.genArgMoveInst(
                    this.symTabController.checkIfDataTypeIsFloat(src) ?
                            floatArgNum++ : nonFloatArgNum++,
                    src
            );

        this.txtSection.append(String.format(CALL_INST, funcName));

        if (!isStackAligned)
            this.genStackPointerAlignment(true);
    }

    @Override
    public int genAdditionExpr(int leftExpRef, int rightExpRef, DataType resultType) {
        leftExpRef = assemblyGen.genToDataTypeConversion(leftExpRef, resultType);
        rightExpRef = assemblyGen.genToDataTypeConversion(rightExpRef, resultType);
        return switch (resultType) {
            case INTEGER, FLOAT -> genNumberAddition(leftExpRef, rightExpRef, resultType);
            case STRING -> genStringAddition(leftExpRef, rightExpRef);
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
            case STRING -> genStringMultiplication(leftExpRef, rightExpRef);
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
        int resultRef;
        DataType leftExpDT = symTabController.getDataType(leftExpRef);
        DataType rightExpDT = symTabController.getDataType(rightExpRef);

        if (leftExpDT.equals(DataType.NONE) || rightExpDT.equals(DataType.NONE)) {
            resultRef = this.symTabController.takeRegister(DataType.BOOLEAN);
            genImmediateComparisonResult(
                    resultRef,
                    leftExpDT.equals(DataType.NONE) && rightExpDT.equals(DataType.NONE)
            );
        }
        else {
            if (leftExpDT.equals(DataType.STRING)) {
                this.genStringComparison(leftExpRef, rightExpRef);
                resultRef = this.genComparisonBranchCode(jumpType, false);
            } else { // it is a bool/number
                boolean isFloat = leftExpDT.equals(DataType.FLOAT) || rightExpDT.equals(DataType.FLOAT);
                this.genNumComparison(leftExpRef, rightExpRef, isFloat);
                resultRef = this.genComparisonBranchCode(jumpType, isFloat);
            }
        }

        symTabController.freeIfIsRegister(leftExpRef);
        symTabController.freeIfIsRegister(rightExpRef);
        return resultRef;
    }

    @Override
    public int genLogicalAndOpExpr(int leftExpRef, int rightExpRef) {
        return this.genLogicalOpExpr(leftExpRef, rightExpRef, true);
    }

    @Override
    public int genLogicalOrOpExpr(int leftExpRef, int rightExpRef) {
        return this.genLogicalOpExpr(leftExpRef, rightExpRef, false);
    }

    @Override
    public void genFloatLiteral(int src) {
        this.dataSection.append(String.format(
                FLOAT_LIT_DATA_SEC,
                this.symTabController.getDataLabelCounter(src),
                this.symTabController.getLiteralValue(src)
        ));
    }

    @Override
    public void genStringLiteral(int src) {
        this.dataSection.append(String.format(
                STRING_LIT_DATA_SEC,
                this.symTabController.getDataLabelCounter(src),
                this.symTabController.getLiteralValue(src)
        ));
    }

    @Override
    public void genStackPointerDec(boolean isForFloat) {
        this.txtSection.append(String.format(
                SUB_INST,
                INST_SUFFIX,
                this.makeLiteralSymbol(POS_16_BYTES, false),
                this.getRegAccess(AssemblyRegister.RSP)
        ));
    }

    @Override
        public void genStackPointerAlignment(boolean isInc) {
        this.txtSection.append(String.format(
                isInc ? ADD_INST : SUB_INST,
                INST_SUFFIX,
                this.makeLiteralSymbol(POS_8_BYTES, false),
                this.getRegAccess(AssemblyRegister.RSP)
        ));

    }

    @Override
    public void genCodeEnd() {
        this.txtSection.append(PROGRAM_END_CODE);
    }

    @Override
    public int genToDataTypeConversion(int src, DataType resDataType) {
        if (symTabController.getDataType(src).equals(resDataType))
            return src;

        return switch (resDataType) {
            case INTEGER -> genToIntegerConversion(src);
            case FLOAT -> genToFloatConversion(src);
            case BOOLEAN -> genToBooleanConversion(src);
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
        System.out.println(this.dataSection.toString() + this.txtSection.toString() + this.builtInTxtSection.toString());
    }

    private String getRegAccess(AssemblyRegister register) {
        return String.format(REG_ACCESS, register);
    }

    private String makeLiteralSymbol(String val, boolean isFloat) {
        return isFloat ? val : String.format(LITERAL_W_DOLLAR, val);
    }

    private String genSymbolByTabInd(int ind) {
        if (symTabController.checkIfIsLiteral(ind)) {
            if (symTabController.checkIfDataTypeIsFloat(ind))
                return makeLiteralSymbol(
                        String.format(DATA_SEC_FLOAT_REF, symTabController.getDataLabelCounter(ind)),true
                );
            else if (symTabController.checkIfDataTypeIsString(ind))
                return makeLiteralSymbol(
                        String.format(DATA_SEC_STRING_REF, symTabController.getDataLabelCounter(ind)),false
                );
            else
                return makeLiteralSymbol(symTabController.getLiteralValue(ind), false);
        } else if (symTabController.checkIfIsVar(ind))
            return String.format(
                    MEM_ACCESS,
                    calculateOffset(symTabController.getVarOrdinality(ind), NEG_16_BYTES),
                    getRegAccess(AssemblyRegister.RBP)
            );
        else if (symTabController.checkIfIsReg(ind))
            return getRegAccess(symTabController.getRegName(ind));

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
        DataType srcDataType = symTabController.getDataType(src);
        if (!srcDataType.equals(DataType.BOOLEAN))
            throw new CannotConvertGivenDataTypeToFloatException(srcDataType.toString());

        int destRegRef = symTabController.takeRegister(DataType.INTEGER);
        this.genMoveInst(destRegRef, src);
        this.symTabController.freeIfIsRegister(src);
        return destRegRef;
    }

    private int genToFloatConversion(int src) {
        DataType srcDataType = symTabController.getDataType(src);
        switch (srcDataType) {
            case INTEGER:
            case BOOLEAN:
                if (symTabController.checkIfIsLiteral(src)) {
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
                this.symTabController.freeIfIsRegister(src);
                return destRegRef;
            default:
                throw new CannotConvertGivenDataTypeToFloatException(srcDataType.toString());
        }
    }

    private int genToBooleanConversion(int src) {
        if (!this.symTabController.checkIfIsReg(src)) {
            int regRef = this.symTabController.takeRegister(this.symTabController.getDataType(src));
            this.genMoveInst(regRef, src);
            src = regRef;
        }

        return switch (this.symTabController.getDataType(src)) {
            case INTEGER -> {
                this.genCmpToZeroInst(src);
                this.symTabController.freeIfIsRegister(src);
                yield this.genComparisonBranchCode(ConditionalJump.JNE, false);
            }
            case FLOAT -> {
                this.genCmpToZeroInst(src);
                this.symTabController.freeIfIsRegister(src);
                yield this.genComparisonBranchCode(ConditionalJump.JNE, true);
            }
            case STRING -> this.genStringToBooleanConversion(src);
            case NONE -> {
                this.genImmediateComparisonResult(src, false);
                yield src;
            }
            default -> throw new CannotConvertGivenDataTypeToFloatException("");
        };
    }

    private int genNumberAddition(int leftExpRef, int rightExpRef, DataType resType) {
        if (symTabController.checkIfIsReg(leftExpRef)) {
            this.genAddInst(leftExpRef, rightExpRef);
            symTabController.freeIfIsRegister(rightExpRef);
            return leftExpRef;
        } else if (symTabController.checkIfIsReg(rightExpRef)) {
            this.genAddInst(rightExpRef, leftExpRef);
            symTabController.freeIfIsRegister(leftExpRef);
            return rightExpRef;
        } else {
            int destRegRef = symTabController.takeRegister(resType);
            this.genMoveInst(destRegRef, leftExpRef);
            this.genAddInst(destRegRef, rightExpRef);
            return destRegRef;
        }
    }

    private int genStringAddition(int leftExpRef, int rightExpRef) {
        this.genFuncCall(
                CONCAT_STRINGS_LBL,
                new ArrayList<>() {{
                    add(leftExpRef);
                    add(rightExpRef);
                }}
        );
        int regRef = this.symTabController.takeRegister(DataType.STRING);
        genRetValMoveInst(regRef, false);
        return regRef;
    }

    private int genNumberSubtraction(int leftExpRef, int rightExpRef, DataType resType) {
        int destRegRef;
        if (symTabController.checkIfIsReg(leftExpRef)) {
            this.genSubInst(leftExpRef, rightExpRef);
            destRegRef = leftExpRef;
        } else {
            destRegRef = symTabController.takeRegister(resType);
            this.genMoveInst(destRegRef, leftExpRef);
            this.genSubInst(destRegRef, rightExpRef);
        }
        symTabController.freeIfIsRegister(rightExpRef);
        return destRegRef;
    }

    private int genNumberMultiplication(int leftExpRef, int rightExpRef, DataType resType) {
        if (symTabController.checkIfIsReg(leftExpRef)) {
            this.genMulInst(leftExpRef, rightExpRef);
            symTabController.freeIfIsRegister(rightExpRef);
            return leftExpRef;
        } else if (symTabController.checkIfIsReg(rightExpRef)) {
            this.genMulInst(rightExpRef, leftExpRef);
            symTabController.freeIfIsRegister(leftExpRef);
            return rightExpRef;
        } else {
            int destRegRef = symTabController.takeRegister(resType);
            this.genMoveInst(destRegRef, leftExpRef);
            this.genMulInst(destRegRef, rightExpRef);
            return destRegRef;
        }
    }

    private int genStringMultiplication(int leftExpRef, int rightExpRef) {
        boolean isLeftExpStr = this.symTabController.checkIfDataTypeIsString(leftExpRef);
        int strVal = isLeftExpStr ? leftExpRef : rightExpRef;
        int mulVal = isLeftExpStr ? rightExpRef : leftExpRef;
        this.genFuncCall(
                STRINGS_MUL_LBL,
                new ArrayList<>() {{
                    add(strVal);
                    add(mulVal);
                }}
        );
        int regRef = this.symTabController.takeRegister(DataType.STRING);
        genRetValMoveInst(regRef, false);
        return regRef;
    }

    private int genNumberDivision(int leftExpRef, int rightExpRef, DataType resType) {
        int destRegRef;
        if (symTabController.checkIfIsReg(leftExpRef)) {
            this.genDivInst(leftExpRef, rightExpRef);
            destRegRef = leftExpRef;
        } else {
            destRegRef = symTabController.takeRegister(resType);
            this.genMoveInst(destRegRef, leftExpRef);
            this.genDivInst(destRegRef, rightExpRef);
        }
        symTabController.freeIfIsRegister(rightExpRef);
        return destRegRef;
    }

    private void genImmediateComparisonResult(int dest, boolean isTrue) {
        this.txtSection.append(String.format(
                MOVE_INST,
                INST_SUFFIX,
                isTrue ? this.makeLiteralSymbol("1", false) : this.makeLiteralSymbol("0", false),
                this.genSymbolByTabInd(dest)
        ));
    }

    private void genNumComparison(int leftExpRef, int rightExpRef, boolean isFloat) {
        DataType resDT = isFloat ? DataType.FLOAT : DataType.INTEGER;
        leftExpRef = this.genToDataTypeConversion(leftExpRef, resDT);
        rightExpRef = this.genToDataTypeConversion(rightExpRef, resDT);
        if (!this.symTabController.checkIfIsReg(leftExpRef)) {
            int regRef = this.symTabController.takeRegister(resDT);
            this.genMoveInst(regRef, leftExpRef);
            leftExpRef = regRef;
        }
        this.genCmpInst(leftExpRef, rightExpRef);
        this.symTabController.freeIfIsRegister(leftExpRef);
        this.symTabController.freeIfIsRegister(rightExpRef);
    }

    private void genStringComparison(int leftExpRef, int rightExpRef) {
        this.genFuncCall(
            STRING_CMP_LBL,
                new ArrayList<>(){{
                    add(leftExpRef);
                    add(rightExpRef);
                }}
        );
        int dest = this.symTabController.takeRegister(DataType.BOOLEAN);
        this.genRetValMoveInst(dest, false);
        this.genCmpToZeroInst(dest);
        this.symTabController.freeIfIsRegister(dest);
    }


    private int genComparisonBranchCode(ConditionalJump jumpType, boolean isFloat) {
        int dest = this.symTabController.takeRegister(DataType.BOOLEAN);
        this.lblCounter.incrementComparisonLblCount();
        String cmpLblCount = this.lblCounter.getComparisonLblCount();
        String cmpTrueLbl = String.format(LBL_CMP_TRUE, cmpLblCount);
        String cmpEndLbl = String.format(LBL_CMP_END, cmpLblCount);
        this.genJump(ConditionalJump.getJump(jumpType, isFloat), cmpTrueLbl);
        this.genImmediateComparisonResult(dest, false);
        this.genJump(JMP_NON_COND, cmpEndLbl);
        this.genLabel(cmpTrueLbl);
        this.genImmediateComparisonResult(dest, true);
        this.genLabel(cmpEndLbl);
        return dest;
    }

    private int genStringToBooleanConversion(int src) {
        this.genFuncCall(STRING_TO_BOOL_LBL, new ArrayList<>(){{ add(src); }});
        int regRef = this.symTabController.takeRegister(DataType.BOOLEAN);
        this.genRetValMoveInst(regRef, false);
        return regRef;
    }

    private int genLogicalOpExpr(int leftExpRef, int rightExpRef, boolean isAnd) {
        int resRef;
        leftExpRef = this.genToDataTypeConversion(leftExpRef, DataType.BOOLEAN);
        rightExpRef = this.genToDataTypeConversion(rightExpRef, DataType.BOOLEAN);

        if (this.symTabController.checkIfIsReg(leftExpRef)) {
            this.genLogicalOpInst(leftExpRef, rightExpRef, isAnd);
            this.symTabController.freeIfIsRegister(rightExpRef);
            resRef = leftExpRef;
        } else if (this.symTabController.checkIfIsReg(rightExpRef)) {
            this.genLogicalOpInst(rightExpRef, leftExpRef, isAnd);
            this.symTabController.freeIfIsRegister(leftExpRef);
            resRef = rightExpRef;
        } else {
            resRef = this.symTabController.takeRegister(DataType.BOOLEAN);
            this.genMoveInst(resRef, leftExpRef);
            this.genLogicalOpInst(resRef, rightExpRef, isAnd);
        }
        return resRef;
    }

    private void genLogicalOpInst(int dest, int src, boolean isAnd) {
        if (isAnd)
            this.genAndInst(dest, src);
        else
            this.genOrInst(dest, src);
    }
}
