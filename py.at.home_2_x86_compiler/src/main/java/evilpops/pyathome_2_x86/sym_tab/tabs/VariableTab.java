package main.java.evilpops.pyathome_2_x86.sym_tab.tabs;

import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;
import main.java.evilpops.pyathome_2_x86.sym_tab.exceptions.VariableNotFoundException;
import main.java.evilpops.pyathome_2_x86.sym_tab.tabs.row_struct.VariableTabRow;

import java.util.ArrayList;
import java.util.List;

public class VariableTab extends ConcreteTableArchetype<VariableTabRow> {
    public void add(String name, DataType dataType, int mainTabFK) {
        this.table.add(new VariableTabRow(name, dataType, mainTabFK));
    }

    public VariableTabRow getByName(String name) {
        return this.table.stream()
                .filter(row -> row.getName().equals(name))
                .findFirst()
                .orElseThrow(VariableNotFoundException::new);
    }
}
