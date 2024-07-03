package main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors.expressions_domain;

import main.java.evilpops.pyathome_2_x86.assembly_generator.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.assembly_generator.IAssemblyGenerator;
import main.java.evilpops.pyathome_2_x86.compilation_info_tracker.CompilationInfoTracker;
import main.java.evilpops.pyathome_2_x86.exceptions.other.BadImplementationException;
import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86.symbol_table.ISymTabController;
import main.java.evilpops.pyathome_2_x86.symbol_table.SymTabController;
import main.java.evilpops.pyathome_2_x86.symbol_table.enums.DataType;

public class LiteralCtxProcessor {
    private static final IAssemblyGenerator assemblyGenerator = AssemblyGenerator.getInstance();
    private static final ISymTabController symTabController = SymTabController.getInstance();
    private static final CompilationInfoTracker compilationInfoTracker = CompilationInfoTracker.getInstance();

    public static int processOnExit(PyAtHomeParser.LiteralContext ctx) {
        if (ctx.integerLiteral() != null)
            return processIfInteger(ctx.integerLiteral());
        else if (ctx.floatLiteral() != null)
            return processIfFloat(ctx.floatLiteral());
        else if (ctx.BOOLEAN() != null)
            return processIfBoolean(ctx);
        else if (ctx.STRING() != null)
            return processIfString(ctx);
        else if (ctx.NONE() != null)
            return processIfNone();
        else throw new BadImplementationException();

    }

    private static int processIfInteger(PyAtHomeParser.IntegerLiteralContext ctx) {
        String value;
        if (ctx.MINUS().size() % 2 == 1)
            value = "-" + ctx.INTEGER().getText();
        else
            value = ctx.INTEGER().getText();
        return symTabController.addLiteral(
                DataType.INTEGER,
                compilationInfoTracker.getFunctionScopeTracker().getScope(),
                compilationInfoTracker.getBlockScopeTracker().getScope(),
                value
        );

    }

    private static int processIfFloat(PyAtHomeParser.FloatLiteralContext ctx) {
        String value;
        if (ctx.MINUS().size() % 2 == 1)
            value = "-" + ctx.FLOAT().getText();
        else
            value = ctx.FLOAT().getText();

        compilationInfoTracker.getLiteralsLblTracker().incLblCounter();

        int literalRef = symTabController.addLiteralFloat(
                compilationInfoTracker.getFunctionScopeTracker().getScope(),
                compilationInfoTracker.getBlockScopeTracker().getScope(),
                value,
                compilationInfoTracker.getLiteralsLblTracker().getLblCounter()
        );

        assemblyGenerator.genFloatLiteral(
                symTabController.getLiteralValue(literalRef),
                symTabController.getDataLabelCounter(literalRef)
        );
        return literalRef;
    }

    private static int processIfBoolean(PyAtHomeParser.LiteralContext ctx) {
        return symTabController.addLiteral(
                DataType.BOOLEAN,
                compilationInfoTracker.getFunctionScopeTracker().getScope(),
                compilationInfoTracker.getBlockScopeTracker().getScope(),
                ctx.BOOLEAN().getText().equals("True") ? "1" : "0"
        );
    }

    private static int processIfString(PyAtHomeParser.LiteralContext ctx) {
        String strVal = ctx.STRING().getText();

        compilationInfoTracker.getLiteralsLblTracker().incLblCounter();

        int literalRef = symTabController.addLiteralString(
                compilationInfoTracker.getFunctionScopeTracker().getScope(),
                compilationInfoTracker.getBlockScopeTracker().getScope(),
                strVal.substring(1, strVal.length() - 1),
                compilationInfoTracker.getLiteralsLblTracker().getLblCounter()
        );

        assemblyGenerator.genStringLiteral(
                symTabController.getLiteralValue(literalRef),
                symTabController.getDataLabelCounter(literalRef)
        );
        return literalRef;
    }

    private static int processIfNone() {
        return symTabController.addLiteralNone(
                compilationInfoTracker.getFunctionScopeTracker().getScope(),
                compilationInfoTracker.getBlockScopeTracker().getScope()
        );
    }

}
