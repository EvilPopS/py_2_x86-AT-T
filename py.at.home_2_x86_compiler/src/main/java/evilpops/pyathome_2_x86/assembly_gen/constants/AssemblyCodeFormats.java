package main.java.evilpops.pyathome_2_x86.assembly_gen.constants;

public class AssemblyCodeFormats {
    public static final String SECTION = ".section .%s\n";
    public static final String GLOBAL_MAIN = ".globl main\n";
    public static final String MAIN_LBL = "main:\n";
    public static final String MAIN_START_CODE = "\tpushq %rbp\n\tsubq $8, %rsp\n\tmovq %rsp, %rbp\n";
    public static final String DATA_SECTION_INIT = "\tFLOAT_ZERO: .double 0.0\n";
    public static final String PROGRAM_END_CODE = "main_end:\n\tmovq $60, %rax\n\txorq %rdi, %rdi\n\tsyscall\n";

    public static final String PUSH_INST = "\tpush%s %s\n";
    public static final String MOVE_INST = "\tmov%s %s, %s\n";
    public static final String ADD_INST = "\tadd%s %s, %s\n";
    public static final String SUB_INST = "\tsub%s %s, %s\n";
    public static final String MUL_INST = "\t%smul%s %s, %s\n";
    public static final String DIV_INST = "\tdivsd %s, %s\n";
    public static final String AND_INST = "\tandq %s, %s\n";
    public static final String OR_INST = "\torq %s, %s\n";
    public static final String BOOLINT_2_FLOAT_INST = "\tcvtsi2sd %s, %s\n";
    public static final String CMP_INT = "\tcmpq %s, %s\n";
    public static final String CMP_FLOAT = "\tcomisd %s, %s\n";

    public static final String JMP_INST = "\t%s %s\n";
    public static final String JMP_NON_COND = "jmp";

    public static final String INST_PREFIX = "i";
    public static final String INST_SUFFIX = "q";
    public static final String FLOAT_INST_SUFFIX = "sd";

    public static final String QUAD_SIZE = "8";
    public static final String NEG_QUAD_SIZE = "-8";
    public static final String FLOAT_SIZE = "16";
    public static final String NEG_FLOAT_SIZE = "-16";

    public static final String REG_ACCESS = "%%%s";
    public static final String MEM_ACCESS = "%s(%s)";
    public static final String LITERAL_W_DOLLAR = "$%s";
    public static final String DATA_SEC_FLOAT_REF = "FLOAT_VAL%s";
    public static final String FLOAT_LIT_DATA_SEC = "\tFLOAT_VAL%s: .double %s\n";

    public static final String LBL_FORMAT = "%s:\n";
    public static final String LBL_CMP_TRUE = "L_CMP_TRUE_%s";
    public static final String LBL_CMP_END = "L_CMP_END_%s";

    public static final String FLOAT_ZERO = "FLOAT_ZERO";

    public static final String CONCAT_STRINGS_BUILTIN =
            "STRING_CONCAT:" +
            "\t%rbp\n" +
            "\tmovq %rsp, %rbp\n\n" +
            "\tsubq $32, %rsp\n" +
            "\tmovq %rdi, -16(%rbp)\n" +
            "\tmovq %rsi, -24(%rbp)\n\n" +
            "\tmovq -16(%rbp), %rdi\t\n" +
            "\tcall strlen@plt\n" +
            "\tmovq %rax, %r10\n\n" +
            "\tmovq -24(%rbp), %rdi\t\n" +
            "\tcall strlen@plt\n" +
            "\taddq %rax, %r10\n\n" +
            "\tmovq %r10, %rdi\n" +
            "\tcall malloc@plt\n" +
            "\tmovq %rax, -32(%rbp)\t\n\n" +
            "\tmovq -32(%rbp), %rdi\n" +
            "\tmovq -16(%rbp), %rsi\n" +
            "\tcall strcpy@plt\n\n" +
            "\tmovq -32(%rbp), %rdi\n" +
            "\tmovq -24(%rbp), %rsi\n" +
            "\tcall strcat@plt\n\n" +
            "\tmovq -32(%rbp), %rax\n\n" +
            "\taddq $32, %rsp\n" +
            "\tpopq %rbp\n\n" +
            "\tret\n\n";
}
