package main.java.evilpops.pyathome_2_x86.grammar_listener.utils;

import main.java.evilpops.pyathome_2_x86.assembly_generator.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.assembly_generator.IAssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.exceptions.other.BadImplementationException;
import main.java.evilpops.pyathome_2_x86.symbol_table.ISymTabController;
import main.java.evilpops.pyathome_2_x86.symbol_table.SymTabController;

public class AssemblySymbolProcessor {
    private static final IAssemblyGenerator assemblyGenerator = AssemblyGenerator.getInstance();
    private static final ISymTabController symTabController = SymTabController.getInstance();

    public static String createAssemblySymbol(int src) {
        if (symTabController.checkIfIsLiteral(src)) {
            if (symTabController.checkIfDataTypeIsFloat(src))
                return assemblyGenerator.makeFloatLiteralSymbol(symTabController.getDataLabelCounter(src));
            else if (symTabController.checkIfDataTypeIsString(src))
                return assemblyGenerator.makeStringLiteralSymbol(symTabController.getDataLabelCounter(src));
            else if (symTabController.checkIfDataTypeIsNone(src))
                return assemblyGenerator.makeNoneSymbol();
            else
                return assemblyGenerator.makeIntOrBoolSymbol(symTabController.getLiteralValue(src));
        } else if (symTabController.checkIfIsVar(src))
            return assemblyGenerator.makeVarAccessSymbol(symTabController.getVarOrdinality(src));
        else if (symTabController.checkIfIsReg(src))
            return assemblyGenerator.makeRegisterAccessSymbol(symTabController.getRegName(src));
        else throw new BadImplementationException();
    }
}
