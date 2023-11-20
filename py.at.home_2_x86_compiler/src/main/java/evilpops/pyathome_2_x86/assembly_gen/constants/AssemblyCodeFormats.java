package main.java.evilpops.pyathome_2_x86.assembly_gen.constants;

public class AssemblyCodeFormats {
    public static final String SECTION = ".section .%s\n";
    public static final String GLOBAL_MAIN = ".globl main\n";
    public static final String MAIN_LBL = "main:\n";
    public static final String MAIN_END_LBL = "main_end:\n";
    public static final String PROGRAM_END_CODE = "\tmovq $60, %rax\n\tmovq $0, %rbx\n\tsyscall\n";
    public static final String PUSH_INST = "\tpush%s %s\n";
    public static final String MOVE_INST = "\tmov%s %s, %s\n";
    public static final String ADD_INST = "\tadd%s %s, %s\n";
    public static final String SUB_INST = "\tsub%s %s, %s\n";

    public static final String INST_SUFFIX = "q";
    public static final String FLOAT_INST_SUFFIX = "sd";

    public static final String QUAD_SIZE = "8";
    public static final String NEG_QUAD_SIZE = "-8";
    public static final String FLOAT_SIZE = "16";
    public static final String NEG_FLOAT_SIZE = "-16";

    public static final String REG_ACCESS = "%%%s";
    public static final String MEM_ACCESS = "%s(%s)";
    public static final String LITERAL_F = "$%s";

}
