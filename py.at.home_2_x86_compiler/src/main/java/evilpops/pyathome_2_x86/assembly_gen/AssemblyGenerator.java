package main.java.evilpops.pyathome_2_x86.assembly_gen;

import static main.java.evilpops.pyathome_2_x86.assembly_gen.code_formats.AssemblyCodeFormats.GLOBAL_MAIN;
import static main.java.evilpops.pyathome_2_x86.assembly_gen.code_formats.AssemblyCodeFormats.SECTION_F;

public class AssemblyGenerator implements IAssemblyGenerator{
    public static final IAssemblyGenerator assemblyGen = new AssemblyGenerator();

    private String dataSection;
    private String txtSection;

    private AssemblyGenerator() {
        this.dataSection = String.format(SECTION_F, "data");
        this.txtSection = String.format(SECTION_F, "text") + GLOBAL_MAIN;
    }


}
