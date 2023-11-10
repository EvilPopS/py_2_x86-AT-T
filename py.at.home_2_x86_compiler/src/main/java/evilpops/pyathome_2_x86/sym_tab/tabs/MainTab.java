package main.java.evilpops.pyathome_2_x86.sym_tab.tabs;


import main.java.evilpops.pyathome_2_x86.sym_tab.enums.TabType;
import main.java.evilpops.pyathome_2_x86.sym_tab.tabs.row_struct.MainTabRow;

public class MainTab extends TableArchetype<MainTabRow> {
    public MainTabRow getByInd(int ind) {
        return this.table.get(ind);
    }

    public void addVariable(int foreignId) {
        this.add(TabType.VARIABLE, foreignId);
    }

    public void addLiteral(int foreignId) {
        this.add(TabType.LITERAL, foreignId);
    }

    private void add(TabType tabType, int foreignId) {
        this.table.add(new MainTabRow(tabType, foreignId));

    }
}


