package main.java.evilpops.pyathome_2_x86.sym_tab.tabs;


import main.java.evilpops.pyathome_2_x86.sym_tab.enums.TabType;
import main.java.evilpops.pyathome_2_x86.sym_tab.tabs.row_struct.MainTabRow;

import java.util.ArrayList;
import java.util.List;

public class MainTab {
    protected List<MainTabRow> table;

    public MainTab() {
        this.table = new ArrayList<>();
    }

    public void addVariable(int foreignId) {
        this.add(TabType.VARIABLE, foreignId);
    }

    public void addLiteral(int foreignId) {
        this.add(TabType.LITERAL, foreignId);
    }

    private void add(TabType tabType, int foreignId) {
        this.table.add(new MainTabRow(this.table.size(), tabType, foreignId));

    }
}


