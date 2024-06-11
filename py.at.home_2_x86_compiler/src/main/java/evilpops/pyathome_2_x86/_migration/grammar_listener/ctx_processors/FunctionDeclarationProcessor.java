package main.java.evilpops.pyathome_2_x86._migration.grammar_listener.ctx_processors;

import main.java.evilpops.pyathome_2_x86._migration.compilation_info_tracker.CompilationInfoTracker;
import main.java.evilpops.pyathome_2_x86._migration.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86._migration.symbol_table.ISymTabController;
import main.java.evilpops.pyathome_2_x86._migration.symbol_table.SymTabController;
import main.java.evilpops.pyathome_2_x86._migration.symbol_table.enums.DataType;

public class FunctionDeclarationProcessor {
    private static final ISymTabController symTabController = SymTabController.getInstance();
    private static final CompilationInfoTracker compilationInfoTracker = CompilationInfoTracker.getInstance();

    public static void processOnExit(PyAtHomeParser.FunctionDeclarationContext ctx) {
        DataType funcRetType = DataType.NONE;
        if (ctx.retType() != null) {
            if (ctx.retType().types().T_BOOLEAN() != null)
                funcRetType = DataType.BOOLEAN;
            else if (ctx.retType().types().T_INT() != null)
                funcRetType = DataType.INTEGER;
            else if (ctx.retType().types().T_FLOAT() != null)
                funcRetType = DataType.FLOAT;
            else if (ctx.retType().types().T_STRING() != null)
                funcRetType = DataType.STRING;
        }
        symTabController.setDataType(compilationInfoTracker.getCurrFuncRef(), funcRetType);
    }
}
