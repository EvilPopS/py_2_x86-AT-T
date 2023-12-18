package main.java.evilpops.pyathome_2_x86.sym_tab.tabs;

import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;
import main.java.evilpops.pyathome_2_x86.sym_tab.exceptions.VariableNotFoundException;
import main.java.evilpops.pyathome_2_x86.sym_tab.tabs.row_struct.VariableTabRow;

public class VariableTab extends ConcreteTableArchetype<VariableTabRow> {
    public void add(int mainTabFK, DataType dataType, String name, int ordinality) {
        this.table.add(new VariableTabRow(mainTabFK, dataType, name, ordinality));
    }

    public VariableTabRow getByName(String name) {
        return this.table.stream()
                .filter(row -> row.getName().equals(name))
                .findFirst()
                .orElseThrow(VariableNotFoundException::new);
    }

    public int getOrdinality(int ind) {
        return this.table.get(ind).getOrdinality();
    }
}
