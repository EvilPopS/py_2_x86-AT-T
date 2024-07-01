package main.java.evilpops.pyathome_2_x86.symbol_table.tabs.row_struct;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import main.java.evilpops.pyathome_2_x86.symbol_table.enums.DataType;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class FunctionTabRow extends ScopeRowArchetype {
    protected String name;
    protected int funcNumId;
    protected List<Integer> parameters;

    public FunctionTabRow(int foreignId, DataType dataType, int scope, int funcNumId, String name) {
        super(foreignId, dataType, scope);
        this.name = name;
        this.funcNumId = funcNumId;
        this.parameters = new ArrayList<>();
    }
}
