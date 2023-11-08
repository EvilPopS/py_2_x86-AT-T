package main.java.evilpops.pyathome_2_x86.listener;

import main.java.evilpops.pyathome_2_x86.grammar.grammar_classes.PyAtHomeBaseListener;
import org.antlr.v4.runtime.ParserRuleContext;

public class PyAtHomeListener extends PyAtHomeBaseListener {
    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        System.out.println(ctx.getText());
    }
}
