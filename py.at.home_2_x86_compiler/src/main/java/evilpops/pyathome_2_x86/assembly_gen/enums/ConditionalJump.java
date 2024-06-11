package main.java.evilpops.pyathome_2_x86.assembly_gen.enums;


public enum ConditionalJump {
    JE,
    JNE,
    JG,
    JL,
    JGE,
    JLE,
    JA,
    JB,
    JAE,
    JBE;

    public static String getJump(ConditionalJump jump, boolean isFloat) {
        return (switch (jump) {
            case JE, JNE -> jump;
            case JG, JA -> isFloat ? JA : JG;
            case JGE, JAE -> isFloat ? JAE : JGE;
            case JL, JB -> isFloat ? JB : JL;
            case JLE, JBE -> isFloat ? JBE : JLE;
        }).toString().toLowerCase();
    }
}
