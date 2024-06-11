package main.java.evilpops.pyathome_2_x86.symbol_table.tabs;

import main.java.evilpops.pyathome_2_x86.symbol_table.enums.DataType;
import main.java.evilpops.pyathome_2_x86.symbol_table.exceptions.VariableNotFoundException;
import main.java.evilpops.pyathome_2_x86.symbol_table.tabs.row_struct.VariableTabRow;

public class VariableTab extends ExplicitTypeTableArchetype<VariableTabRow> {
    public void add(int mainTabFK, DataType dataType, int scope, DataType explicitType, String name, int ordinality) {
        this.table.add(new VariableTabRow(mainTabFK, dataType, scope, explicitType, name, ordinality));
    }

    public VariableTabRow getByName(String name) {
        return this.table.stream()
                .filter(row -> row.getName().equals(name))
                .reduce((first, second)-> second)
                .orElseThrow(VariableNotFoundException::new);
    }

    public VariableTabRow getByNameInCurrentScope(String name, int currScope) {
        return this.table.stream()
                .filter(row -> row.getName().equals(name) && row.getScope() == currScope)
                .reduce((first, second)-> second)
                .orElseThrow(VariableNotFoundException::new);
    }
    public int getOrdinality(int ind) {
        return this.table.get(ind).getOrdinality();
    }
}
