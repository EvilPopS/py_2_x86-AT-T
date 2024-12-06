package main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.function_call_domain;

import main.java.evilpops.pyathome_2_x86.assembly_generator.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.assembly_generator.IAssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.exceptions.other.BadImplementationException;
import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86.grammar_listener.utils.AssemblySymbolProcessor;
import main.java.evilpops.pyathome_2_x86.symbol_table.ISymTabController;
import main.java.evilpops.pyathome_2_x86.symbol_table.SymTabController;

public class PrintFunctionCallCtxProcessor {
    private static final IAssemblyGenerator assemblyGenerator = AssemblyGenerator.getInstance();
    private static final ISymTabController symTabController = SymTabController.getInstance();


    public static void processOnExit(PyAtHomeParser.PrintFunctionCallContext ctx) {
        if (ctx.complexExpression() == null) {
            processPrintWhenEmpty();
        } else {
            int numExpRef = ctx.complexExpression().getRefToSymTab();
            switch (symTabController.getDataType(numExpRef)) {
                case INTEGER, BOOLEAN -> processPrintWhenIntOrBool(numExpRef);
                case FLOAT -> processPrintWhenFloat(numExpRef);
                case STRING -> processPrintWhenString(numExpRef);
                case NONE -> processPrintWhenNone();
                default -> throw new BadImplementationException();
            }
        }
    }

    private static void processPrintWhenEmpty() {

    }

    private static void processPrintWhenIntOrBool(int numExpRef) {
        assemblyGenerator.genFuncArg(
                assemblyGenerator.makePrintIntOrBoolFormatSymbol(),
                1,
                true
        );
        assemblyGenerator.genFuncArg(
                AssemblySymbolProcessor.createAssemblySymbol(numExpRef),
                2,
                true
        );
        symTabController.freeIfIsRegister(numExpRef);
        assemblyGenerator.genPrintBuiltInFuncCall(symTabController.getAllGenPurposeRegsInUse());
    }

    private static void processPrintWhenFloat(int numExpRef) {
        assemblyGenerator.genFuncArg(
                assemblyGenerator.makePrintFloatFormatSymbol(),
                1,
                true
        );
        assemblyGenerator.genPrintBuiltInFuncFloatArg(AssemblySymbolProcessor.createAssemblySymbol(numExpRef));
        symTabController.freeIfIsRegister(numExpRef);
        assemblyGenerator.genPrintBuiltInFuncCall(symTabController.getAllGenPurposeRegsInUse());
    }

    private static void processPrintWhenString(int numExpRef) {
        assemblyGenerator.genFuncArg(
                assemblyGenerator.makePrintStringFormatSymbol(),
                1,
                true
        );
        assemblyGenerator.genFuncArg(
                AssemblySymbolProcessor.createAssemblySymbol(numExpRef),
                2,
                true
        );
        symTabController.freeIfIsRegister(numExpRef);
        assemblyGenerator.genPrintBuiltInFuncCall(symTabController.getAllGenPurposeRegsInUse());
    }

    private static void processPrintWhenNone() {
        assemblyGenerator.genFuncArg(
                assemblyGenerator.makePrintStringFormatSymbol(),
                1,
                true
        );
        assemblyGenerator.genFuncArg(
                assemblyGenerator.makeNoneSymbol(),
                2,
                true
        );
        assemblyGenerator.genPrintBuiltInFuncCall(symTabController.getAllGenPurposeRegsInUse());
    }

}
