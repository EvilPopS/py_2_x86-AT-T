package main.java.evilpops.pyathome_2_x86.sym_tab;

import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;
import main.java.evilpops.pyathome_2_x86.sym_tab.enums.TabType;
import main.java.evilpops.pyathome_2_x86.sym_tab.exceptions.TabTypeEnumNotInSyncWithTabClassesException;
import main.java.evilpops.pyathome_2_x86.sym_tab.tabs.ConcreteTableArchetype;
import main.java.evilpops.pyathome_2_x86.sym_tab.tabs.LiteralTab;
import main.java.evilpops.pyathome_2_x86.sym_tab.tabs.MainTab;
import main.java.evilpops.pyathome_2_x86.sym_tab.tabs.VariableTab;
import main.java.evilpops.pyathome_2_x86.sym_tab.tabs.row_struct.ConcreteRowArchetype;
import main.java.evilpops.pyathome_2_x86.sym_tab.tabs.row_struct.MainTabRow;

public class SymTabController implements ISymTabController {
    protected static ISymTabController symTabBean = null;
    protected final MainTab mainTab;
    protected final VariableTab variableTab;
    protected final LiteralTab literalTab;


    private SymTabController() {
        this.mainTab = new MainTab();
        this.variableTab = new VariableTab();
        this.literalTab = new LiteralTab();
    }

    public static ISymTabController getInstance() {
        if (symTabBean == null)
            symTabBean = new SymTabController();
        return symTabBean;
    }

    @Override
    public int addVariable(String name, DataType dataType) {
        int varRef = this.mainTab.getNextFreeRowInd();
        this.variableTab.add(name, dataType, varRef);
        this.mainTab.addVariable(this.variableTab.getLastRowInd());
        return varRef;
    }

    @Override
    public int addLiteral(String value, DataType dataType) {
        int varRef = this.mainTab.getNextFreeRowInd();
        this.literalTab.add(value, dataType, varRef);
        this.mainTab.addLiteral(this.literalTab.getLastRowInd());
        return varRef;
    }

    @Override
    public int getVarRefByName(String name) {
        return this.variableTab.getByName(name).getForeignId();
    }

    @Override
    public DataType getDataTypeByInd(int ind) {
        MainTabRow rowData = this.mainTab.getByInd(ind);
        return getConcreteTableByTabType(rowData.getRefTabType())
                .getDataType(rowData.getForeignId());
    }

    private ConcreteTableArchetype<? extends ConcreteRowArchetype> getConcreteTableByTabType(TabType tabType) {
        return switch (tabType) {
            case VARIABLE -> this.variableTab;
            case LITERAL -> this.literalTab;
            default -> throw new TabTypeEnumNotInSyncWithTabClassesException();
        };
    }
}
