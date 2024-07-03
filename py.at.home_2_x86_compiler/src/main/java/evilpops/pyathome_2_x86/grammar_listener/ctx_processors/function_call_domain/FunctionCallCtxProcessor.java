package main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.function_call_domain;

import main.java.evilpops.pyathome_2_x86.assembly_generator.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.assembly_generator.IAssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.compilation_info_tracker.CompilationInfoTracker;
import main.java.evilpops.pyathome_2_x86.exceptions.compilation.errors.MissingParameterInFunctionCallException;
import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86.grammar_listener.utils.AssemblySymbolProcessor;
import main.java.evilpops.pyathome_2_x86.log_handler.exceptions.CompilationError;
import main.java.evilpops.pyathome_2_x86.symbol_table.ISymTabController;
import main.java.evilpops.pyathome_2_x86.symbol_table.SymTabController;
import main.java.evilpops.pyathome_2_x86.symbol_table.enums.DataType;

import java.util.List;

public class FunctionCallCtxProcessor {
    private static final IAssemblyGenerator assemblyGenerator = AssemblyGenerator.getInstance();
    private static final ISymTabController symTabController = SymTabController.getInstance();
    private static final CompilationInfoTracker compilationInfoTracker = CompilationInfoTracker.getInstance();

    public static void processOnExit(PyAtHomeParser.FunctionCallContext ctx) {
        int calledFuncRef = symTabController.getFuncRefByName(ctx.ID().getText());

        if (ctx.arguments() != null) {
            List<Integer> paramRefs = symTabController.getFuncsParamRefs(calledFuncRef);
            processNonIdArgs(ctx.arguments().nonIdArgs(), calledFuncRef, paramRefs);
            processIdArgs(ctx.arguments().idArgs(), calledFuncRef, paramRefs);
            processMissingArgs(paramRefs);
        }

        compilationInfoTracker.getNonIdArgCountTracker().resetCounter();

        assemblyGenerator.genFuncCall(
                symTabController.getFuncName(calledFuncRef),
                symTabController.getAllGenPurposeRegsInUse()
        );

        int countOfFuncParams = symTabController.getNumOfFuncParams(calledFuncRef);
        if (countOfFuncParams != 0) {
            assemblyGenerator.genStackPointerInc(countOfFuncParams);
            compilationInfoTracker.getCurrFuncTracker().decVarCounterByAmount(countOfFuncParams);
        }
    }

    private static void processNonIdArgs(
            PyAtHomeParser.NonIdArgsContext ctx,
            int calledFuncRef,
            List<Integer> paramRefs
    ) {
        if (ctx == null) return;

        if (ctx.COMMA() != null) {
            processNonIdArgs(ctx.nonIdArgs(0), calledFuncRef, paramRefs);
            processNonIdArgs(ctx.nonIdArgs(1), calledFuncRef, paramRefs);
            return;
        }

        compilationInfoTracker.getNonIdArgCountTracker().incCounter();

        int numExpRef = ctx.argNumExpression().getRefToSymTab();
        int paramRef = symTabController.getFuncParamRefByArgCountNum(
                calledFuncRef,
                compilationInfoTracker.getNonIdArgCountTracker().getFuncCallArgsCounter()
        );

        if (!symTabController.getDataType(numExpRef).equals(symTabController.getParamDataType(paramRef)))
            throw new CompilationError("Parameter and its corresponding value are not of the same data type!");

        assemblyGenerator.genFuncArg(
                AssemblySymbolProcessor.createAssemblySymbol(numExpRef),
                symTabController.getPerDataTypeParamOrdinality(paramRef),
                !symTabController.checkIfParamDataTypeIsFloat(paramRef)
        );

        symTabController.freeIfIsRegister(numExpRef);
        paramRefs.removeIf(elem -> elem == paramRef);
    }

    private static void processIdArgs(
            PyAtHomeParser.IdArgsContext ctx,
            int calledFuncRef,
            List<Integer> paramRefs
    ) {
        if (ctx == null) return;

        if (ctx.COMMA() != null) {
            processIdArgs(ctx.idArgs(0), calledFuncRef, paramRefs);
            processIdArgs(ctx.idArgs(1), calledFuncRef, paramRefs);
            return;
        }

        int numExpRef = ctx.argNumExpression().getRefToSymTab();

        int paramRef = symTabController.getFuncParamRefByParamName(calledFuncRef, ctx.ID().getText());

        if (!symTabController.getDataType(numExpRef).equals(symTabController.getParamDataType(paramRef)))
            throw new CompilationError("Parameter and its corresponding value are not of the same data type!");

        assemblyGenerator.genFuncArg(
                AssemblySymbolProcessor.createAssemblySymbol(numExpRef),
                symTabController.getPerDataTypeParamOrdinality(paramRef),
                !symTabController.checkIfParamDataTypeIsFloat(paramRef)
        );

        symTabController.freeIfIsRegister(numExpRef);
        paramRefs.removeIf(elem -> elem == paramRef);
    }

    private static void processMissingArgs(List<Integer> paramRefs) {
        for (int paramRef : paramRefs) {
            if (!symTabController.checkIfIsDefParam(paramRef))
                throw new MissingParameterInFunctionCallException(symTabController.getParamName(paramRef));

            if (symTabController.checkIfParamDataTypeIsFloat(paramRef)) {
                int undefinedAddressRegRef = symTabController.takeRegister(DataType.INTEGER);
                int undefinedAddressRefRefAs128bit = symTabController.takeRegister(DataType.FLOAT);

                assemblyGenerator.genMovUndefinedToReg(symTabController.getRegName(undefinedAddressRegRef));
                assemblyGenerator.genIntToFloatConversion(
                        AssemblySymbolProcessor.createAssemblySymbol(undefinedAddressRegRef),
                        AssemblySymbolProcessor.createAssemblySymbol(undefinedAddressRefRefAs128bit)
                );

                symTabController.freeIfIsRegister(undefinedAddressRegRef);

                assemblyGenerator.genFuncArg(
                        assemblyGenerator.makeRegisterAccessSymbol(
                                symTabController.getRegName(undefinedAddressRefRefAs128bit)
                        ),
                        symTabController.getPerDataTypeParamOrdinality(paramRef),
                        false
                );

                symTabController.freeIfIsRegister(undefinedAddressRefRefAs128bit);
            } else {
                assemblyGenerator.genFuncArg(
                        assemblyGenerator.makeUndefinedSymbol(),
                        symTabController.getPerDataTypeParamOrdinality(paramRef),
                        true
                );
            }
        }
    }

}
