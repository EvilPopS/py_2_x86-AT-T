package main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.function_call_domain;

import main.java.evilpops.pyathome_2_x86.assembly_generator.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.assembly_generator.IAssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86.grammar_listener.utils.AssemblySymbolProcessor;
import main.java.evilpops.pyathome_2_x86.symbol_table.ISymTabController;
import main.java.evilpops.pyathome_2_x86.symbol_table.SymTabController;

public class FuncCallExpressionCtxProcessor {
    private static final IAssemblyGenerator assemblyGenerator = AssemblyGenerator.getInstance();
    private static final ISymTabController symTabController = SymTabController.getInstance();

    public static int processOnExit(PyAtHomeParser.FuncCallExpressionContext ctx) {
        int calledFuncRef = symTabController.getFuncRefByName(ctx.functionCall().ID().getText());

        int resRegRef = symTabController.takeRegister(symTabController.getDataType(calledFuncRef));
        assemblyGenerator.genMoveFuncRetRegToSymbol(
                AssemblySymbolProcessor.createAssemblySymbol(resRegRef),
                !symTabController.checkIfDataTypeIsFloat(calledFuncRef)
        );
        return resRegRef;
    }
}
