package main.java.evilpops.pyathome_2_x86.assembly_generator;


import main.java.evilpops.pyathome_2_x86.assembly_generator.constants.AssemblyCodeFormats;
import main.java.evilpops.pyathome_2_x86.assembly_generator.enums.AssemblyRegister;
import main.java.evilpops.pyathome_2_x86.assembly_generator.enums.ConditionalJump;
import main.java.evilpops.pyathome_2_x86.assembly_generator.utils.StackAlignmentTracker;

import java.util.*;

import static main.java.evilpops.pyathome_2_x86.assembly_generator.constants.AssemblyCodeFormats.*;
import static main.java.evilpops.pyathome_2_x86.assembly_generator.constants.AssemblyRegisterGroups.*;


public class AssemblyGenerator implements IAssemblyGenerator {
    public static IAssemblyGenerator assemblyGenerator;

    private final StringBuilder dataSection;
    private final StringBuilder builtInFuncs;
    private StringBuilder currentFunc;

    private final List<StringBuilder> funcDefs;
    private final Stack<Integer> funcIndStack;

    private final StackAlignmentTracker stackAlignmentTracker;
    private int labelCounter;

    private AssemblyGenerator() {
        this.stackAlignmentTracker = new StackAlignmentTracker();
        this.labelCounter = 0;
        this.funcDefs = new ArrayList<>() {{
            add(new StringBuilder());
        }};
        this.funcIndStack = new Stack<>();
        this.funcIndStack.push(0);
        this.currentFunc = this.funcDefs.get(0)
                .append(String.format(SECTION, "text"))
                .append(GLOBAL_MAIN).append(MAIN_LBL)
                .append(MAIN_START_CODE);
        this.dataSection = new StringBuilder()
                .append(String.format(SECTION, "data"))
                .append(DATA_SECTION_INIT);
        this.builtInFuncs = new StringBuilder()
                .append(CONCAT_STRINGS_BUILTIN)
                .append(STRINGS_MUL_BUILTIN)
                .append(STRINGS_CMP_BUILTIN)
                .append(STRING_TO_BOOL_BUILTIN);
    }

    public static IAssemblyGenerator getInstance() {
        if (assemblyGenerator == null)
            assemblyGenerator = new AssemblyGenerator();
        return assemblyGenerator;
    }

    @Override
    public void genFloatLiteral(String value, int lblCounter) {
        this.dataSection.append(String.format(FLOAT_LIT_DATA_SEC, lblCounter, value));
    }

    @Override
    public void genStringLiteral(String value, int lblCounter) {
        this.dataSection.append(String.format(STRING_LIT_DATA_SEC, lblCounter, value));
    }

    @Override
    public void genMoveSymbolToSymbol(String srcSymbol, String desSymbol, boolean is64bit) {
        this.currentFunc.append(String.format(
                MOVE_INST,
                is64bit ? INST_SUFFIX : FLOAT_INST_SUFFIX,
                srcSymbol,
                desSymbol
        ));
    }

    @Override
    public void genMoveSymbolToReg(String srcSymbol, AssemblyRegister destReg, boolean is64bit) {
        this.genMoveSymbolToSymbol(
                srcSymbol,
                this.makeRegisterAccessSymbol(destReg),
                is64bit
        );
    }

    @Override
    public void genMoveMemOfBasePointerToReg64bit(AssemblyRegister destReg) {
        this.genMoveSymbolToSymbol(
                String.format(MEM_ACCESS, "", this.makeRegisterAccessSymbol(BASE_POINTER)),
                this.makeRegisterAccessSymbol(destReg),
                true
        );
    }

    @Override
    public void genMoveMemOfRegToReg64bit(AssemblyRegister srcReg, AssemblyRegister destReg) {
        this.genMoveSymbolToSymbol(
                String.format(MEM_ACCESS, "", this.makeRegisterAccessSymbol(srcReg)),
                this.makeRegisterAccessSymbol(destReg),
                true
        );
    }

    @Override
    public void genMoveRegToPointerRegMem(AssemblyRegister srcReg, boolean is64bit) {
        this.genMoveSymbolToSymbol(
                this.makeRegisterAccessSymbol(srcReg),
                String.format(MEM_ACCESS, "", this.makeRegisterAccessSymbol(STACK_POINTER)),
                is64bit
        );
    }

    @Override
    public void genMovePointerRegMemToReg(AssemblyRegister destReg, boolean is64bit) {
        this.genMoveSymbolToSymbol(
                String.format(MEM_ACCESS, "", this.makeRegisterAccessSymbol(STACK_POINTER)),
                this.makeRegisterAccessSymbol(destReg),
                is64bit
        );
    }

    @Override
    public void genMoveVarFromCustomBasePointerToReg(
            AssemblyRegister customBasePointer,
            AssemblyRegister destReg,
            int varOrdinality,
            boolean is64bit
    ) {
        this.genMoveSymbolToSymbol(
                String.format(
                        MEM_ACCESS,
                        this.getMemAccessOffset(varOrdinality, NEG_16_BYTES),
                        this.makeRegisterAccessSymbol(customBasePointer)
                ),
                this.makeRegisterAccessSymbol(destReg),
                is64bit
        );
    }

    @Override
    public void genMoveBoolToSymbol(boolean boolVal, String destSymbol) {
        this.genMoveSymbolToSymbol(
                this.makeDollarSymbol(boolVal ? "1" : "0"),
                destSymbol,
                true
        );
    }

    @Override
    public void genMoveFuncRetRegToSymbol(String destSymbol, boolean is64bit) {
        this.genMoveSymbolToSymbol(
                this.makeRegisterAccessSymbol(is64bit ? RET_REG : FLOAT_RET_REG),
                destSymbol,
                is64bit
        );
    }

    @Override
    public void genMovUndefinedToReg(AssemblyRegister descReg) {
        this.genMoveSymbolToReg(
                this.makeUndefinedSymbol(),
                descReg,
                true
        );
    }

    @Override
    public void genAdditionSymbolToReg(String srcSymbol, AssemblyRegister destRegister, boolean is64bit) {
        this.currentFunc.append(String.format(
                ADD_INST,
                is64bit ? INST_SUFFIX : FLOAT_INST_SUFFIX,
                srcSymbol,
                this.makeRegisterAccessSymbol(destRegister)
        ));
    }

    @Override
    public void genSubtractionSymbolToReg(String srcSymbol, AssemblyRegister destRegister, boolean is64bit) {
        this.currentFunc.append(String.format(
                SUB_INST,
                is64bit ? INST_SUFFIX : FLOAT_INST_SUFFIX,
                srcSymbol,
                this.makeRegisterAccessSymbol(destRegister)
        ));
    }

    @Override
    public void genMultiplicationSymbolToReg(String srcSymbol, AssemblyRegister destRegister, boolean is64bit) {
        this.currentFunc.append(String.format(
                MUL_INST,
                is64bit ? INST_PREFIX : "",
                is64bit ? INST_SUFFIX : FLOAT_INST_SUFFIX,
                srcSymbol,
                this.makeRegisterAccessSymbol(destRegister)
        ));
    }

    @Override
    public void genDivisionSymbolToReg(String srcSymbol, AssemblyRegister destRegister) {
        this.currentFunc.append(String.format(
                DIV_INST,
                srcSymbol,
                this.makeRegisterAccessSymbol(destRegister)
        ));
    }

    @Override
    public void genLogicalAndInstruction(String symbol1, String symbol2) {
        this.currentFunc.append(String.format(
                AND_INST,
                symbol1,
                symbol2
        ));
    }

    @Override
    public void genLogicalOrInstruction(String symbol1, String symbol2) {
        this.currentFunc.append(String.format(
                OR_INST,
                symbol1,
                symbol2
        ));
    }

    @Override
    public void genCmpToZero(String srcSymbol, boolean is64bit) {
        this.currentFunc.append(String.format(
                is64bit ? CMP_INT : CMP_FLOAT,
                is64bit ? this.makeIntOrBoolSymbol("0") : FLOAT_ZERO,
                srcSymbol
        ));
    }

    @Override
    public void genCmpToOne(String srcSymbol) {
        this.currentFunc.append(String.format(
                CMP_INT,
                this.makeIntOrBoolSymbol("1"),
                srcSymbol
        ));
    }

    @Override
    public void genCmpToUndefined64bit(String srcSymbol) {
        this.currentFunc.append(String.format(
                CMP_INT,
                this.makeUndefinedSymbol(),
                srcSymbol
        ));
    }

    @Override
    public void genCmpSymbolToSymbol(String symbol1, String symbol2, boolean is64bit) {
        this.currentFunc.append(String.format(
                is64bit ? CMP_INT : CMP_FLOAT,
                symbol1,
                symbol2
        ));
    }

    @Override
    public void genCmpAfterFlow(AssemblyRegister destReg, ConditionalJump jumpType, boolean is64bit) {
        this.labelCounter++;
        String cmpTrueLbl = String.format(LBL_CMP_TRUE, labelCounter);
        String cmpEndLbl = String.format(LBL_CMP_END, labelCounter);
        this.genJmp(this.makeJmpInst(jumpType, is64bit), cmpTrueLbl);
        this.genMoveBoolToSymbol(false, this.makeRegisterAccessSymbol(destReg));
        this.genJmp(JMP_NON_COND, cmpEndLbl);
        this.genLabel(cmpTrueLbl);
        this.genMoveBoolToSymbol(true, this.makeRegisterAccessSymbol(destReg));
        this.genLabel(cmpEndLbl);
    }

    @Override
    public void genCall(String lblName) {
        this.currentFunc.append(String.format(CALL_INST, lblName));
    }

    @Override
    public void genFuncStart(String funcName) {
        this.funcDefs.add(new StringBuilder());
        this.funcIndStack.push(this.funcDefs.size() - 1);
        this.currentFunc = this.funcDefs.get(this.funcIndStack.peek());
        this.stackAlignmentTracker.increaseBlock();
        this.genLabel(String.format(LBL_FUNC_NAME, funcName));
        this.currentFunc.append(FUNC_START);
    }

    @Override
    public void genFuncEnd(String funcName) {
        this.genLabel(String.format(LBL_FUNC_END, funcName));
        this.currentFunc.append(FUNC_END);
        this.funcIndStack.pop();
        this.currentFunc = this.funcDefs.get(this.funcIndStack.peek());
        this.stackAlignmentTracker.decreaseBlock();
    }

    @Override
    public void genFuncArg(String srcSymbol, int argOrdinality, boolean is64bit) {
        this.genMoveSymbolToSymbol(
                srcSymbol,
                this.makeRegisterAccessSymbol(
                        is64bit ? PARAM_REGS[argOrdinality - 1] : FLOAT_PARAM_REGS[argOrdinality - 1]
                ),
                is64bit
        );
    }

    @Override
    public void genPrintBuiltInFuncFloatArg(String srcSymbol) {
        this.genMoveSymbolToSymbol(
                srcSymbol,
                this.makeRegisterAccessSymbol(FLOAT_RET_REG),
                false
        );
    }

    @Override
    public void genFuncCall(String funcName, AssemblyRegister[] regsToSave) {
        for (AssemblyRegister reg : regsToSave)
            this.genPushReg(reg, Arrays.asList(GEN_PURPOSE_REGS).contains(reg));

        if (!stackAlignmentTracker.isCurrentBlockStackAligned())
            this.genStackPointerAlignmentCorrection(false);

        this.genCall(String.format(LBL_FUNC_NAME, funcName));

        if (!stackAlignmentTracker.isCurrentBlockStackAligned())
            this.genStackPointerAlignmentCorrection(true);

        Collections.reverse(Arrays.asList(regsToSave));
        for (AssemblyRegister reg : regsToSave)
            this.genPopReg(reg, Arrays.asList(GEN_PURPOSE_REGS).contains(reg));
    }

    @Override
    public void genStringToBoolConversionBuiltInFuncCall(String argSymbol, AssemblyRegister[] regsToSave) {
        this.genFuncArg(argSymbol, 1, true);
        this.genFuncCall(BUILT_IN_STRING_TO_BOOL_LBL, regsToSave);
    }

    @Override
    public void genStringAdditionBuiltInFuncCall(String argSymbol1, String argSymbol2, AssemblyRegister[] regsToSave) {
        this.genFuncArg(argSymbol1, 1, true);
        this.genFuncArg(argSymbol2, 2, true);
        this.genFuncCall(BUILT_IN_CONCAT_STRINGS_LBL, regsToSave);
    }

    @Override
    public void genStringMultiplicationBuiltInFuncCall(String argStr, String argInt, AssemblyRegister[] regsToSave) {
        this.genFuncArg(argStr, 1, true);
        this.genFuncArg(argInt, 2, true);
        this.genFuncCall(BUILT_IN_STRINGS_MUL_LBL, regsToSave);
    }

    @Override
    public void genStringComparisonBuiltInFuncCall(String argSymbol1, String argSymbol2, AssemblyRegister[] regsToSave) {
        this.genFuncArg(argSymbol1, 1, true);
        this.genFuncArg(argSymbol2, 2, true);
        this.genFuncCall(BUILT_IN_STRING_CMP_LBL, regsToSave);
    }

    @Override
    public void genPrintBuiltInFuncCall(AssemblyRegister[] regsToSave) {
        for (AssemblyRegister reg : regsToSave)
            this.genPushReg(reg, Arrays.asList(GEN_PURPOSE_REGS).contains(reg));

        if (!stackAlignmentTracker.isCurrentBlockStackAligned())
            this.genStackPointerAlignmentCorrection(false);

        this.genCall(String.format(BUILT_IN_PRINT_LBL));

        if (!stackAlignmentTracker.isCurrentBlockStackAligned())
            this.genStackPointerAlignmentCorrection(true);

        Collections.reverse(Arrays.asList(regsToSave));
        for (AssemblyRegister reg : regsToSave)
            this.genPopReg(reg, Arrays.asList(GEN_PURPOSE_REGS).contains(reg));
    }

    @Override
    public void genJmp(String jmpInst, String lblName) {
        this.currentFunc.append(String.format(JMP_INST, jmpInst, lblName));
    }

    @Override
    public void genNonCondJmp(String lblName) {
        this.currentFunc.append(String.format(JMP_INST, JMP_NON_COND, lblName));
    }

    @Override
    public void genJmpIfEqual(String lblName) {
        this.currentFunc.append(String.format(JMP_INST, JMP_EQ, lblName));
    }

    @Override
    public void genNonCondJmpToFuncEnd(String funcName) {
        this.genNonCondJmp(String.format(LBL_FUNC_END, funcName));
    }

    @Override
    public void genNonCondJmpToDefParamCondStart(int lblNum) {
        this.genNonCondJmp(String.format(LBL_DEF_PARAM_COND, lblNum));
    }

    @Override
    public void genNonCondJmpToDefParamCondEnd(int lblNum) {
        this.genNonCondJmp(String.format(LBL_DEF_PARAM_COND_END, lblNum));
    }

    @Override
    public void genJmpWhileElseStatEnd(int lblNum) {
        this.genNonCondJmp(String.format(LBL_WHILE_ELSE_STAT_END, lblNum));
    }

    @Override
    public void genJmpWhileStatPartEnd(int lblNum) {
        this.genNonCondJmp(String.format(LBL_WHILE_STAT_PART_END, lblNum));
    }

    @Override
    public void genJmpWhileConditionStartLbl(int lblNum) {
        this.genNonCondJmp(String.format(LBL_WHILE_CONDITION_START, lblNum));
    }

    @Override
    public void genJmpIfEqToWhileOnFirstTimeEnterLbl(int lblNum) {
        this.genJmpIfEqual(String.format(LBL_WHILE_ON_FIRST_TIME_ENTER, lblNum));
    }

    @Override
    public void genJmpIfEqToWhileBlockStart(int lblNum) {
        this.genJmpIfEqual(String.format(LBL_WHILE_BLOCK_START, lblNum));
    }

    @Override
    public void genJmpWhileBlockEnd(int lblNum) {
        this.genNonCondJmp(String.format(LBL_WHILE_BLOCK_END, lblNum));
    }

    @Override
    public void genJmpWhileLoopStart(int lblNum) {
        this.genNonCondJmp(String.format(LBL_WHILE_LOOP_START, lblNum));
    }

    @Override
    public void genJmpIfEqToWhileLoopEnd(int lblNum) {
        this.genJmpIfEqual(String.format(LBL_WHILE_LOOP_END, lblNum));
    }

    @Override
    public void genJmpIfEqToDefParamNumExpStart(int lblNum) {
        this.genJmpIfEqual(String.format(LBL_DEF_PARAM_NUM_EXP, lblNum));
    }

    @Override
    public void genJmpIfElifElseEnd(int lblNum) {
        this.genNonCondJmp(String.format(LBL_IF_ELIF_ELSE_STAT_END, lblNum));
    }

    @Override
    public void genJmpAfterIfStatCondition(int lblNum) {
        this.genJmpIfEqual(String.format(LBL_IF_STAT_END, lblNum));
    }

    @Override
    public void genJmpAfterElifStatCondition(int lblNum1, int lblNum2) {
        this.genJmpIfEqual(String.format(LBL_ELIF_STAT_END, lblNum1, lblNum2));
    }

    @Override
    public void genLabel(String lblName) {
        this.currentFunc.append(String.format(LBL_FORMAT, lblName));
    }

    @Override
    public void genDefParamNumExpLabel(int lblNum) {
        this.genLabel(String.format(LBL_DEF_PARAM_NUM_EXP, lblNum));
    }

    @Override
    public void genDefParamCondStartLabel(int lblNum) {
        this.genLabel(String.format(LBL_DEF_PARAM_COND, lblNum));
    }

    @Override
    public void genDefParamCondEndLabel(int lblNum) {
        this.genLabel(String.format(LBL_DEF_PARAM_COND_END, lblNum));
    }

    @Override
    public void genWhileElseEndLabel(int lblNum) {
        this.genLabel(String.format(LBL_WHILE_ELSE_STAT_END, lblNum));
    }

    @Override
    public void genWhileConditionStartLbl(int lblNum) {
        this.genLabel(String.format(LBL_WHILE_CONDITION_START, lblNum));
    }

    @Override
    public void genWhileOnFirstTimeEnterLbl(int lblNum) {
        this.genLabel(String.format(LBL_WHILE_ON_FIRST_TIME_ENTER, lblNum));
    }

    @Override
    public void genWhileStatPartEndLbl(int lblNum) {
        this.genLabel(String.format(LBL_WHILE_STAT_PART_END, lblNum));
    }

    @Override
    public void genWhileBlockStartLbl(int lblNum) {
        this.genLabel(String.format(LBL_WHILE_BLOCK_START, lblNum));
    }

    @Override
    public void genWhileBlockEndLbl(int lblNum) {
        this.genLabel(String.format(LBL_WHILE_BLOCK_END, lblNum));
    }

    @Override
    public void genWhileLoopStartLbl(int lblNum) {
        this.genLabel(String.format(LBL_WHILE_LOOP_START, lblNum));
    }

    @Override
    public void genIfElifElseEndLabel(int lblNum) {
        this.genLabel(String.format(LBL_IF_ELIF_ELSE_STAT_END, lblNum));
    }

    @Override
    public void genIfStatStartLabel(int lblNum) {
        this.genLabel(String.format(LBL_IF_STAT_START, lblNum));
    }

    @Override
    public void genIfStatEndLabel(int lblNum) {
        this.genLabel(String.format(LBL_IF_STAT_END, lblNum));
    }

    @Override
    public void genElifStatStartLabel(int lblNum1, int lblNum2) {
        this.genLabel(String.format(LBL_ELIF_STAT_START, lblNum1, lblNum2));
    }

    @Override
    public void genElifStatEndLabel(int lblNum1, int lblNum2) {
        this.genLabel(String.format(LBL_ELIF_STAT_END, lblNum1, lblNum2));
    }

    @Override
    public void genElseStatStartLabel(int lblNum) {
        this.genLabel(String.format(LBL_ELSE_STAT_START, lblNum));
    }

    @Override
    public void genIntToFloatConversion(String srcSymbol, String destSymbol) {
        this.currentFunc.append(String.format(BOOLINT_2_FLOAT_INST, srcSymbol, destSymbol));
    }


    @Override
    public void genPushReg(AssemblyRegister register, boolean is64bit) {
        if (is64bit) {
            this.stackAlignmentTracker.invCurrStackAlignment();
            this.currentFunc.append(String.format(
                    PUSH_INST,
                    "",
                    this.makeRegisterAccessSymbol(register)
            ));
        } else {
            this.genStackPointerDec(1);
            this.genMoveRegToPointerRegMem(register, false);
        }
    }

    @Override
    public void genPopReg(AssemblyRegister register, boolean is64bit) {
        if (is64bit) {
            this.stackAlignmentTracker.invCurrStackAlignment();
            this.currentFunc.append(String.format(
                    POP_INST,
                    "",
                    this.makeRegisterAccessSymbol(register)
            ));
        } else {
            this.genMovePointerRegMemToReg(register, false);
            this.genStackPointerInc(1);
        }

    }

    @Override
    public void genStackPointerAlignmentCorrection(boolean isStackIncreasing) {
        this.currentFunc.append(String.format(
                isStackIncreasing ? ADD_INST : SUB_INST,
                INST_SUFFIX,
                this.makeDollarSymbol(POS_8_BYTES),
                this.makeRegisterAccessSymbol(AssemblyRegister.RSP)
        ));
    }

    @Override
    public void genStackPointerDec(int times) {
        this.currentFunc.append(String.format(
                SUB_INST,
                INST_SUFFIX,
                this.makeDollarSymbol(
                        times == 1
                                ? POS_16_BYTES
                                : Integer.toString(Integer.parseInt(POS_16_BYTES) * times)
                ),
                this.makeRegisterAccessSymbol(AssemblyRegister.RSP)
        ));
    }

    @Override
    public void genStackPointerInc(int times) {
        this.currentFunc.append(String.format(
                ADD_INST,
                INST_SUFFIX,
                this.makeDollarSymbol(
                        times == 1
                                ? POS_16_BYTES
                                : Integer.toString(Integer.parseInt(POS_16_BYTES) * times)
                ),
                this.makeRegisterAccessSymbol(AssemblyRegister.RSP)
        ));
    }

    @Override
    public void genCodeEnd() {
        this.currentFunc.append(AssemblyCodeFormats.PROGRAM_END_CODE);
    }

    @Override
    public String makeFloatLiteralSymbol(int srcLabelCounter) {
        return String.format(DATA_SEC_FLOAT_REF, srcLabelCounter);
    }

    @Override
    public String makeStringLiteralSymbol(int srcLabelCounter) {
        return makeDollarSymbol(String.format(DATA_SEC_STRING_REF, srcLabelCounter));
    }

    @Override
    public String makeNoneSymbol() {
        return makeDollarSymbol(NONE_LIT);
    }

    @Override
    public String makeUndefinedSymbol() {
        return makeDollarSymbol(UNDEFINED_LIT);
    }

    @Override
    public String makeIntOrBoolSymbol(String srcValue) {
        return makeDollarSymbol(srcValue);
    }

    @Override
    public String makeVarAccessSymbol(int varOrdinality) {
        return String.format(
                MEM_ACCESS,
                this.getMemAccessOffset(varOrdinality, NEG_16_BYTES),
                this.makeRegisterAccessSymbol(BASE_POINTER)
        );
    }

    @Override
    public String makeRegisterAccessSymbol(AssemblyRegister register) {
        return String.format(REG_ACCESS, register);
    }

    @Override
    public String makePrintIntOrBoolFormatSymbol() {
        return this.makeDollarSymbol(PRINT_INT_OR_BOOL);
    }

    @Override
    public String makePrintFloatFormatSymbol() {
        return this.makeDollarSymbol(PRINT_FLOAT);
    }

    @Override
    public String makePrintStringFormatSymbol() {
        return this.makeDollarSymbol(PRINT_STRING);
    }

    @Override
    public String makeJmpInst(ConditionalJump conditionalJump, boolean is64bit) {
        return (switch (conditionalJump) {
            case JE -> JMP_EQ;
            case JNE -> JMP_NOT_EQ;
            case JG, JA -> is64bit ? JMP_GREATER : JMP_ABOVE;
            case JGE, JAE -> is64bit ? JMP_GREATER_EQ : JMP_ABOVE_EQ;
            case JL, JB -> is64bit ? JMP_LESSER : JMP_BELOW;
            case JLE, JBE -> is64bit ? JMP_LESSER_EQ : JMP_BELOW_EQ;
        });
    }

    @Override
    public void printToConsole() {
        System.out.println(this.dataSection.toString() + this.buildFuncDefs() + this.builtInFuncs.toString());
    }

    @SuppressWarnings("SameParameterValue")
    private String getMemAccessOffset(int offsetMultiplier, String offsetBlock) {
        return offsetMultiplier != 0 ?
                Integer.toString(Integer.parseInt(offsetBlock) * offsetMultiplier) :
                "";
    }

    private String makeDollarSymbol(String val) {
        return String.format(LITERAL_W_DOLLAR, val);
    }

    private String buildFuncDefs() {
        return String.join("", this.funcDefs.stream().map(StringBuilder::toString).toList());
    }
}
