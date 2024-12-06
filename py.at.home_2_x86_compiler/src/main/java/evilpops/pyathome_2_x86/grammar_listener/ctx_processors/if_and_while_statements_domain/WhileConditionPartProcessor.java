package main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.if_and_while_statements_domain;

import main.java.evilpops.pyathome_2_x86.assembly_generator.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.assembly_generator.IAssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.compilation_info_tracker.CompilationInfoTracker;
import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86.grammar_listener.utils.AssemblySymbolProcessor;
import main.java.evilpops.pyathome_2_x86.grammar_listener.utils.ConversionProcessor;
import main.java.evilpops.pyathome_2_x86.symbol_table.enums.DataType;

public class WhileConditionPartProcessor {
    private static final IAssemblyGenerator assemblyGenerator = AssemblyGenerator.getInstance();
    private static final CompilationInfoTracker compilationInfoTracker = CompilationInfoTracker.getInstance();

    public static void processOnEnter() {
        assemblyGenerator.genStackPointerDec(1);
        assemblyGenerator.genMoveBoolToSymbol(
                true,
                assemblyGenerator.makeVarAccessSymbol(
                        compilationInfoTracker.getCurrFuncTracker().incAndGetVarCounter()
                )
        );

        assemblyGenerator.genWhileConditionStartLbl(
                compilationInfoTracker.getWhileStatementInfoTracker().getCurrLblNum()
        );
    }

    public static void processOnExit(PyAtHomeParser.WhileConditionPartContext ctx) {
        int conditionRef = processConditionPart(ctx);
        processCheckIfIsFirstTimeEnterBranches(conditionRef);
        assemblyGenerator.genWhileBlockStartLbl(
                compilationInfoTracker.getWhileStatementInfoTracker().getCurrLblNum()
        );
    }

    private static int processConditionPart(PyAtHomeParser.WhileConditionPartContext ctx) {
        return ConversionProcessor.processTypeConversion(
                ctx.complexExpression().getRefToSymTab(),
                DataType.BOOLEAN
        );
    }

    private static void processCheckIfIsFirstTimeEnterBranches(int conditionRef) {
        assemblyGenerator.genCmpToOne(
                assemblyGenerator.makeVarAccessSymbol(
                        compilationInfoTracker.getCurrFuncTracker().getVarCounter()
                )
        );

        assemblyGenerator.genJmpIfEqToWhileOnFirstTimeEnterLbl(
                compilationInfoTracker.getWhileStatementInfoTracker().getCurrLblNum()
        );

        processOnNewIterationEnter(conditionRef);
        processOnFirstTimeEnter(conditionRef);
    }

    private static void processOnNewIterationEnter(int conditionRef) {
        int lblNum = compilationInfoTracker.getWhileStatementInfoTracker().getCurrLblNum();

        assemblyGenerator.genCmpToOne(
                AssemblySymbolProcessor.createAssemblySymbol(conditionRef)
        );

        assemblyGenerator.genJmpIfEqToWhileBlockStart(lblNum);
        assemblyGenerator.genJmpWhileBlockEnd(lblNum);
    }

    private static void processOnFirstTimeEnter(int conditionRef) {
        int lblNum = compilationInfoTracker.getWhileStatementInfoTracker().getCurrLblNum();
        assemblyGenerator.genWhileOnFirstTimeEnterLbl(lblNum);

        assemblyGenerator.genMoveBoolToSymbol(
                false,
                assemblyGenerator.makeVarAccessSymbol(
                        compilationInfoTracker.getCurrFuncTracker().getVarCounter()
                )
        );

        assemblyGenerator.genCmpToOne(
                AssemblySymbolProcessor.createAssemblySymbol(conditionRef)
        );

        assemblyGenerator.genJmpIfEqToWhileBlockStart(lblNum);

        assemblyGenerator.genJmpWhileStatPartEnd(lblNum);
    }

}
