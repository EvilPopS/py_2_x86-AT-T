package main.java.evilpops.pyathome_2_x86._migration.grammar_listener.utils;

import main.java.evilpops.pyathome_2_x86._migration.exceptions.other.BadImplementationException;
import main.java.evilpops.pyathome_2_x86._migration.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86._migration.symbol_table.enums.DataType;

public class TypesContextProcessor {
    public static DataType convertTypingCtxToDataType(PyAtHomeParser.TypesContext ctx) {
        if (ctx.T_INT() != null)
            return DataType.INTEGER;
        else if (ctx.T_FLOAT() != null)
            return DataType.FLOAT;
        else if (ctx.T_BOOLEAN() != null)
            return DataType.BOOLEAN;
        else if (ctx.T_STRING() != null)
            return DataType.STRING;
        else if (ctx.T_NONE() != null)
            return DataType.NONE;
        throw new BadImplementationException();
    }
}
