package main.java.evilpops.pyathome_2_x86.grammar.grammar_classes;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IndentationTracker {
    protected final List<Integer> indentationLevels;

    private int spaceCounter;
    private int indentCounter;
    private int dedentCounter;


    public IndentationTracker() {
        this.indentationLevels = new ArrayList<>() {{
            add(0);
        }};
        this.spaceCounter = 0;
    }

    public void processToken(Token tk) {
        if (tk.getType() == PyAtHomeLexer.NEWLINE) {
            this.spaceCounter = countSpacesFromTxt(tk.getText());
            calculateNextDent();
        }
    }

    public Token sendDentTokenIfNeeded() {
        if (this.indentCounter > 0) {
            this.indentCounter--;
            return new CommonToken(PyAtHomeParser.INDENT, "INDENT");
        } else if (this.dedentCounter > 0) {
            this.dedentCounter--;
            return new CommonToken(PyAtHomeParser.DEDENT, "DEDENT");
        }

        return null;
    }

    private int countSpacesFromTxt(String txt) {
        String[] splits = txt.split("\n");
        if (splits.length < 2)
            return 0;
        txt = splits[splits.length - 1];
        return (int) (txt.chars().filter(ch -> ch == ' ').count() + txt.chars().filter(ch -> ch == '\t').count() * 4);
    }

    private void calculateNextDent() {
        if (this.spaceCounter > this.getCurrIndentLevel()) {
            this.indentationLevels.add(this.spaceCounter);
            this.indentCounter++;
        } else if (this.spaceCounter < this.getCurrIndentLevel())
            for (int indentLvl : this.indentationLevels.stream().sorted(Collections.reverseOrder()).toList()) {
                if (this.spaceCounter == indentLvl)
                    break;
                if (this.spaceCounter > indentLvl)
                    throw new RuntimeException("Invalid indentation");
                this.dedentCounter++;
                this.removeLastIndentLevel();
            }
    }

    private int getCurrIndentLevel() {
        return this.indentationLevels.get(this.indentationLevels.size() - 1);
    }

    private void removeLastIndentLevel() {
        this.indentationLevels.remove(this.indentationLevels.size()-1);
    }

}
