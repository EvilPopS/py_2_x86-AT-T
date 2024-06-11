package main.java.evilpops.pyathome_2_x86._migration.grammar_listener.ctx_processors;

import main.java.evilpops.pyathome_2_x86._migration.assembly_generator.AssemblyGenerator;
import main.java.evilpops.pyathome_2_x86._migration.assembly_generator.IAssemblyGenerator;
import main.java.evilpops.pyathome_2_x86._migration.compilation_info_tracker.CompilationInfoTracker;
import main.java.evilpops.pyathome_2_x86._migration.exceptions.other.BadImplementationException;
import main.java.evilpops.pyathome_2_x86._migration.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86._migration.symbol_table.ISymTabController;
import main.java.evilpops.pyathome_2_x86._migration.symbol_table.SymTabController;
import main.java.evilpops.pyathome_2_x86._migration.symbol_table.enums.DataType;

public class LiteralCtxProcessor {
    private static final IAssemblyGenerator assemblyGenerator = AssemblyGenerator.getInstance();
    private static final ISymTabController symTabController = SymTabController.getInstance();
    private static final CompilationInfoTracker compilationInfoTracker = CompilationInfoTracker.getInstance();

    public static int processOnExit(PyAtHomeParser.LiteralContext ctx) {
        if (ctx.INTEGER() != null)
            return processIfInteger(ctx);
        else if (ctx.FLOAT() != null)
            return processIfFloat(ctx);
        else if (ctx.BOOLEAN() != null)
            return processIfBoolean(ctx);
        else if (ctx.STRING() != null)
            return processIfString(ctx);
        else if (ctx.NONE() != null)
            return processIfNone();
        else throw new BadImplementationException();

    }

    private static int processIfInteger(PyAtHomeParser.LiteralContext ctx) {
        return symTabController.addLiteral(ctx.INTEGER().getText(), DataType.INTEGER);
    }

    private static int processIfFloat(PyAtHomeParser.LiteralContext ctx) {
        int literalRef = symTabController.addLiteralFloat(
                ctx.FLOAT().getText(),
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
