package main.java.evilpops.pyathome_2_x86.grammar_listener.utils;

import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeParser;
import main.java.evilpops.pyathome_2_x86.grammar_listener.exceptions.MethodNotInSyncWithGrammarException;
import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;

public class Convertors {
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
        throw getException("convertTypingCtxToDataType");
    }

    public static MethodNotInSyncWithGrammarException getException(String methodName) {
        return new MethodNotInSyncWithGrammarException(methodName);
    }
}
