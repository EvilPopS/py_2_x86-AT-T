package main.java.evilpops.pyathome_2_x86.grammar_listener.ctx_processors;


import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeParser;

public class ParamDefValCtxProcessor {

    public static void processOnExit(PyAtHomeParser.ParamDefValContext ctx) {
        if (ctx.ID() == null)
            return; // TODO default params
    }
}
