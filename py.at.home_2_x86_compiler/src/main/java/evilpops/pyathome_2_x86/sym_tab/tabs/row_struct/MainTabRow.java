package main.java.evilpops.pyathome_2_x86.sym_tab.tabs.row_struct;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import main.java.evilpops.pyathome_2_x86.sym_tab.enums.TabType;

@Getter
@Setter
@AllArgsConstructor
public class MainTabRow {
    protected int id;
    protected TabType refTabType;
    protected int foreignId;
}
