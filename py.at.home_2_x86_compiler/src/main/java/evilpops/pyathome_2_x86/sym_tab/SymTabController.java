package main.java.evilpops.pyathome_2_x86.sym_tab;

import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;
import main.java.evilpops.pyathome_2_x86.sym_tab.tabs.LiteralTab;
import main.java.evilpops.pyathome_2_x86.sym_tab.tabs.MainTab;
import main.java.evilpops.pyathome_2_x86.sym_tab.tabs.VariableTab;

public class SymTabController implements ISymTabController {
    protected static SymTabController symTabBean = null;
    protected final MainTab mainTab;
    protected final VariableTab variableTab;
    protected final LiteralTab literalTab;


    private SymTabController() {
        this.mainTab = new MainTab();
        this.variableTab = new VariableTab();
        this.literalTab = new LiteralTab();
    }

    public static SymTabController getInstance() {
        if (symTabBean == null)
            symTabBean = new SymTabController();
        return symTabBean;
    }

    @Override
    public void addVariable(String name, DataType dataType) {
        this.variableTab.add(name, dataType);
        this.mainTab.addVariable(this.variableTab.lastRowInd());
    }

    @Override
    public void addLiteral(String value, DataType dataType) {
        this.literalTab.add(value, dataType);
        this.mainTab.addVariable(this.literalTab.lastRowInd());
    }
}
