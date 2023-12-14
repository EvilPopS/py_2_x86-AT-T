package main.java.evilpops.pyathome_2_x86.assembly_gen.constants;

import main.java.evilpops.pyathome_2_x86.assembly_gen.enums.AssemblyRegister;

public class AssemblyRegisterGroups {
    public static final AssemblyRegister STACK_POINTER = AssemblyRegister.RSP;

    public static final AssemblyRegister BASE_POINTER = AssemblyRegister.RSP;

    public static final AssemblyRegister[] RET_REGS = new AssemblyRegister[]{
            AssemblyRegister.RAX
    };

    public static final AssemblyRegister[] FLOAT_RET_REGS = new AssemblyRegister[]{
            AssemblyRegister.XMM0, AssemblyRegister.XMM1
    };

    public static final AssemblyRegister[] ARGS_REGS = new AssemblyRegister[]{
            AssemblyRegister.RDI, AssemblyRegister.RSI, AssemblyRegister.RDX,
            AssemblyRegister.RCX, AssemblyRegister.R8, AssemblyRegister.R9
    };

    public static final AssemblyRegister[] FLOAT_ARGS_REGS = new AssemblyRegister[]{
            AssemblyRegister.XMM2, AssemblyRegister.XMM3, AssemblyRegister.XMM4,
            AssemblyRegister.XMM5, AssemblyRegister.XMM6, AssemblyRegister.XMM7
    };

    public static final AssemblyRegister[] CALLEE_SAVED_REGS = new AssemblyRegister[]{
            AssemblyRegister.RBX, AssemblyRegister.R12, AssemblyRegister.R13,
            AssemblyRegister.R14, AssemblyRegister.R15
    };

    public static final AssemblyRegister[] TEMP_REGS = new AssemblyRegister[]{
            AssemblyRegister.R10, AssemblyRegister.R11
    };


    public static final AssemblyRegister[] FLOAT_TEMP_REGS = new AssemblyRegister[]{
            AssemblyRegister.XMM8, AssemblyRegister.XMM9, AssemblyRegister.XMM10,
            AssemblyRegister.XMM11, AssemblyRegister.XMM12, AssemblyRegister.XMM13,
            AssemblyRegister.XMM14, AssemblyRegister.XMM15
    };

}
