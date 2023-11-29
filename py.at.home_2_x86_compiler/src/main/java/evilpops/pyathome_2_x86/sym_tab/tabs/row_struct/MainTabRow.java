package main.java.evilpops.pyathome_2_x86.sym_tab.tabs.row_struct;

import lombok.Getter;
import lombok.Setter;
import main.java.evilpops.pyathome_2_x86.sym_tab.enums.TabType;

@Getter
@Setter
public class MainTabRow extends RowArchetype {
    protected TabType refTabType;

    public MainTabRow(TabType refTabType, int foreignId) {
        super(foreignId);
        this.refTabType = refTabType;
    }
}
