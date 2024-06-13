package main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors;

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
        return symTabController.addLiteral(value, DataType.INTEGER);

    }

    private static int processIfFloat(PyAtHomeParser.FloatLiteralContext ctx) {
        String value;
        if (ctx.MINUS().size() % 2 == 1)
            value = "-" + ctx.FLOAT().getText();
        else
            value = ctx.FLOAT().getText();

        int literalRef = symTabController.addLiteralFloat(
                value,
                DataType.FLOAT,
                compilationInfoTracker.getAndIncLitLblCounter()
        );
        assemblyGenerator.genFloatLiteral(
                symTabController.getLiteralValue(literalRef),
                symTabController.getDataLabelCounter(literalRef)
        );
        return literalRef;
    }

    private static int processIfBoolean(PyAtHomeParser.LiteralContext ctx) {
        return symTabController.addLiteral(
                ctx.BOOLEAN().getText().equals("True") ? "1" : "0",
                DataType.BOOLEAN
        );
    }

    private static int processIfString(PyAtHomeParser.LiteralContext ctx) {
        String strVal = ctx.STRING().getText();
        int literalRef = symTabController.addLiteralString(
                strVal.substring(1, strVal.length() - 1),
                DataType.STRING,
                compilationInfoTracker.getAndIncLitLblCounter()
        );
        assemblyGenerator.genStringLiteral(
                symTabController.getLiteralValue(literalRef),
                symTabController.getDataLabelCounter(literalRef)
        );
        return literalRef;
    }

    private static int processIfNone() {
        return symTabController.getNoneLiteralRef();
    }

}
