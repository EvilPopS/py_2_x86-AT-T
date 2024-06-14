package main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors;

import main.java.evilpops.pyathome_2_x86.assembly_generator.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.assembly_generator.IAssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.compilation_info_tracker.CompilationInfoTracker;
import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86.grammar_listener.utils.AssemblySymbolProcessor;
import main.java.evilpops.pyathome_2_x86.log_handler.exceptions.CompilationError;
import main.java.evilpops.pyathome_2_x86.symbol_table.ISymTabController;
import main.java.evilpops.pyathome_2_x86.symbol_table.SymTabController;

public class FunctionCallCtxProcessor {
    private static final IAssemblyGenerator assemblyGenerator = AssemblyGenerator.getInstance();
    private static final ISymTabController symTabController = SymTabController.getInstance();
    private static final CompilationInfoTracker compilationInfoTracker = CompilationInfoTracker.getInstance();

    public static int processOnExit(PyAtHomeParser.FunctionCallContext ctx) {
        int calledFuncRef = symTabController.getFuncRefByName(ctx.ID().getText());

        if (ctx.arguments() != null) {
            processNonIdArgs(ctx.arguments().nonIdArgs(), calledFuncRef);
            processIdArgs(ctx.arguments().idArgs());
        }

        compilationInfoTracker.resetFuncCallArgsCounter();

        assemblyGenerator.genFuncCall(
                symTabController.getFuncName(calledFuncRef),
                symTabController.getAllGenPurposeRegsInUse()
        );

        int countOfFuncParams = symTabController.getNumOfFuncParams(calledFuncRef);
        assemblyGenerator.genStackPointerInc(countOfFuncParams);
        compilationInfoTracker.decCurrVarCounter(countOfFuncParams);

        int resRegRef = symTabController.takeRegister(symTabController.getDataType(calledFuncRef));
        assemblyGenerator.genMoveFuncRetRegToSymbol(
                AssemblySymbolProcessor.createAssemblySymbol(resRegRef),
                !symTabController.checkIfDataTypeIsFloat(calledFuncRef)
        );
        return resRegRef;
    }

    private static void processNonIdArgs(PyAtHomeParser.NonIdArgsContext ctx, int calledFuncRef) {
        if (ctx == null) return;

        if (ctx.COMMA() != null) {
            processNonIdArgs(ctx.nonIdArgs(0), calledFuncRef);
            processNonIdArgs(ctx.nonIdArgs(1), calledFuncRef);
            return;
        }
        compilationInfoTracker.incFuncCallArgsCounter();

        int numExpRef = ctx.argNumExpression().getRefToSymTab();
        int paramRef = symTabController.getFuncParamRefByArgCountNum(
                calledFuncRef,
                compilationInfoTracker.getFuncCallArgsCounter()
        );

        if (!symTabController.getDataType(numExpRef).equals(symTabController.getDataType(paramRef)))
            throw new CompilationError("Parameter and its corresponding value are not of the same data type!");

        assemblyGenerator.genFuncArg(
                AssemblySymbolProcessor.createAssemblySymbol(numExpRef),
                symTabController.getTotalParamOrdinality(paramRef),
                !symTabController.checkIfDataTypeIsFloat(paramRef)
        );
    }
    private static void processIdArgs(PyAtHomeParser.IdArgsContext ctx) {
        if (ctx == null) return;

        if (ctx.COMMA() != null) {
            processIdArgs(ctx.idArgs(0));
            processIdArgs(ctx.idArgs(0));
        }

        int numExpRef = ctx.argNumExpression().getRefToSymTab();

        //TODO all
    }


}
