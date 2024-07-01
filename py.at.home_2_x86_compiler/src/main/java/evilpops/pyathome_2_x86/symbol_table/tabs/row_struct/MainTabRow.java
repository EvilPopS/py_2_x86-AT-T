package main.java.evilpops.pyathome_2_x86.symbol_table.tabs.row_struct;

import lombok.Getter;
import lombok.Setter;
import main.java.evilpops.pyathome_2_x86.symbol_table.enums.TabType;

@Getter
@Setter
public class MainTabRow extends RowArchetype {
    protected TabType refTabType;

    public MainTabRow(TabType refTabType, int foreignId) {
        super(foreignId);
        this.refTabType = refTabType;
    }
}
