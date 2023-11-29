package main.java.evilpops.pyathome_2_x86.sym_tab.tabs.row_struct;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@AllArgsConstructor
@Accessors(chain = true)
public abstract class RowArchetype {
    protected int foreignId;
}
