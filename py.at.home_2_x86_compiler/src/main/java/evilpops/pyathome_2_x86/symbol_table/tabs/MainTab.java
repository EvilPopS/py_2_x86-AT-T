package main.java.evilpops.pyathome_2_x86.symbol_table.tabs;


import main.java.evilpops.pyathome_2_x86.symbol_table.enums.TabType;
import main.java.evilpops.pyathome_2_x86.symbol_table.tabs.row_struct.MainTabRow;

public class MainTab extends TableArchetype<MainTabRow> {
    public MainTabRow get(int ind) {
        return this.table.get(ind);
    }

    public void addVariable(int foreignId) {
        this.add(TabType.VARIABLE, foreignId);
    }
    public void addLiteral(int foreignId) {
        this.add(TabType.LITERAL, foreignId);
    }
    public void addRegister(int foreignId) {
        this.add(TabType.REGISTER, foreignId);
    }
    public void addFunction(int foreignId) {
        this.add(TabType.FUNCTION, foreignId);
    }

    private void add(TabType tabType, int foreignId) {
        this.table.add(new MainTabRow(tabType, foreignId));

    }
}


