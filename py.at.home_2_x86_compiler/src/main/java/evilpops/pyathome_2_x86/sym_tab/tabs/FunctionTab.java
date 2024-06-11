package main.java.evilpops.pyathome_2_x86.sym_tab.tabs;

import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;
import main.java.evilpops.pyathome_2_x86.sym_tab.exceptions.FunctionNotFoundException;
import main.java.evilpops.pyathome_2_x86.sym_tab.tabs.row_struct.FunctionTabRow;

public class FunctionTab extends ScopeTableArchetype<FunctionTabRow> {
    private int funcNum;

    public FunctionTab() {
        funcNum = 0;
    }

    public void add(int mainTabFK, int scope,  String name) {
        this.table.add(new FunctionTabRow(mainTabFK, DataType.UNKNOWN, scope, name, this.funcNum++));
    }

    public int getCurrentFuncScope() {
        return this.getLastRowInd() >= 0
                ? this.table.get(this.getLastRowInd()).getScope() + 1
                : 0;
    }

    public void addParam(int funcInd, int paramId) {
        this.table.get(funcInd).getParameters().add(paramId);
    }

    public String getFuncName(int funcInd) {
        FunctionTabRow funcRow = this.table.get(funcInd);
        return funcRow.getName() + funcRow.getFuncNum();
    }

    public int getMainRefByName(String funcName) {
        return this.table.stream()
                .filter(row -> row.getName().equals(funcName))
                .reduce((first,second)-> second)
                .orElseThrow(FunctionNotFoundException::new)
                .getForeignId();
    }

    public int getParamRefByOrdinality(int funcRef, int paramOrdinality) {
        return this.table.get(funcRef).getParameters().get(paramOrdinality);
    }
}
