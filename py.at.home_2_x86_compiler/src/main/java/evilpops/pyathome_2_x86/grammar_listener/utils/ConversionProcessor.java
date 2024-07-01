package main.java.evilpops.pyathome_2_x86.grammar_listener.utils;

import main.java.evilpops.pyathome_2_x86.assembly_generator.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.assembly_generator.IAssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.assembly_generator.enums.ConditionalJump;
import main.java.evilpops.pyathome_2_x86.exceptions.other.BadImplementationException;
import main.java.evilpops.pyathome_2_x86.symbol_table.ISymTabController;
import main.java.evilpops.pyathome_2_x86.symbol_table.SymTabController;
import main.java.evilpops.pyathome_2_x86.symbol_table.enums.DataType;

public class ConversionProcessor {
    private static final IAssemblyGenerator assemblyGenerator = AssemblyGenerator.getInstance();
    private static final ISymTabController symTabController = SymTabController.getInstance();

    public static int processTypeConversion(int src, DataType convertTo) {
        if (symTabController.getDataType(src).equals(convertTo))
            return src;

        return switch (convertTo) {
            case INTEGER -> toIntegerConversion(src);
            case FLOAT -> toFloatConversion(src);
            case BOOLEAN -> toBooleanConversion(src);
            default -> throw new BadImplementationException();
        };
    }

    private static int toIntegerConversion(int src) {
        DataType srcDataType = symTabController.getDataType(src);
        if (!srcDataType.equals(DataType.BOOLEAN))
            throw new BadImplementationException();

        int destRegRef = symTabController.takeRegister(DataType.INTEGER);
        assemblyGenerator.genMoveSymbolToSymbol(
                AssemblySymbolProcessor.createAssemblySymbol(src),
                AssemblySymbolProcessor.createAssemblySymbol(destRegRef),
                true
        );
        symTabController.freeIfIsRegister(src);
        return destRegRef;
    }

    private static int toFloatConversion(int src) {
        return switch (symTabController.getDataType(src)) {
            case INTEGER, BOOLEAN -> {
                if (symTabController.checkIfIsLiteral(src)) {
                    int transferRegRef = symTabController.takeRegister(DataType.INTEGER);
                    assemblyGenerator.genMoveSymbolToSymbol(
                            AssemblySymbolProcessor.createAssemblySymbol(src),
                            AssemblySymbolProcessor.createAssemblySymbol(transferRegRef),
                            true
                    );
                    src = transferRegRef;
                }
                int destRegRef = symTabController.takeRegister(DataType.FLOAT);
                assemblyGenerator.genIntToFloatConversion(
                        AssemblySymbolProcessor.createAssemblySymbol(src),
                        AssemblySymbolProcessor.createAssemblySymbol(destRegRef)
                );
                symTabController.freeIfIsRegister(src);
                yield destRegRef;
            }
            default -> throw new BadImplementationException();
        };
    }

    private static int toBooleanConversion(int src) {
        if (!symTabController.checkIfIsReg(src)) {
            int regRef = symTabController.takeRegister(symTabController.getDataType(src));
            assemblyGenerator.genMoveSymbolToSymbol(
                    AssemblySymbolProcessor.createAssemblySymbol(src),
                    AssemblySymbolProcessor.createAssemblySymbol(regRef),
                    true
            );
            src = regRef;
        }

        return switch (symTabController.getDataType(src)) {
            case INTEGER -> integerToBooleanConversion(src);
            case FLOAT -> floatToBooleanConversion(src);
            case STRING -> stringToBooleanConversion(src);
            case NONE -> noneToBooleanConversion(src);
            default -> throw new BadImplementationException();
        };
    }

    private static int integerToBooleanConversion(int src) {
        assemblyGenerator.genCmpToZero(
                AssemblySymbolProcessor.createAssemblySymbol(src),
                true
        );
        symTabController.freeIfIsRegister(src);
        int resRegRef = symTabController.takeRegister(DataType.BOOLEAN);
        assemblyGenerator.genCmpAfterFlow(
                symTabController.getRegName(resRegRef),
                ConditionalJump.JNE,
                true
        );
        return resRegRef;
    }

    private static  int floatToBooleanConversion(int src) {
        assemblyGenerator.genCmpToZero(
                AssemblySymbolProcessor.createAssemblySymbol(src),
                false
        );
        symTabController.freeIfIsRegister(src);
        int resRegRef = symTabController.takeRegister(DataType.BOOLEAN);
        assemblyGenerator.genCmpAfterFlow(
                symTabController.getRegName(resRegRef),
                ConditionalJump.JNE,
                false
        );
        return resRegRef;
    }

    private static int stringToBooleanConversion(int src) {
        assemblyGenerator.genStringToBoolConversionBuiltInFuncCall(
                assemblyGenerator.makeRegisterAccessSymbol(symTabController.getRegName(src)),
                symTabController.getAllGenPurposeRegsInUse()
        );
        symTabController.freeIfIsRegister(src);
        int resRegRef = symTabController.takeRegister(DataType.BOOLEAN);
        assemblyGenerator.genMoveFuncRetRegToSymbol(
                AssemblySymbolProcessor.createAssemblySymbol(resRegRef),
                true
        );
        return resRegRef;
    }

    private  static  int noneToBooleanConversion(int src) {
        symTabController.freeIfIsRegister(src);
        int resRegRef = symTabController.takeRegister(DataType.BOOLEAN);
        assemblyGenerator.genMoveBoolToSymbol(
                false,
                assemblyGenerator.makeRegisterAccessSymbol(symTabController.getRegName(resRegRef))
        );
        return resRegRef;
    }

}
