package main.java.evilpops.pyathome_2_x86.symbol_table.tabs;

import main.java.evilpops.pyathome_2_x86.symbol_table.enums.DataType;
import main.java.evilpops.pyathome_2_x86.symbol_table.exceptions.FunctionNotFoundException;
import main.java.evilpops.pyathome_2_x86.symbol_table.tabs.row_struct.FunctionTabRow;

import java.util.List;

public class FunctionTab extends ScopeTableArchetype<FunctionTabRow> {
    protected int funcCount;

    public FunctionTab() {
        this.funcCount = 0;
    }

    public void add(int mainTabFK, int scope, String name) {
        this.table.add(new FunctionTabRow(mainTabFK, DataType.UNKNOWN, scope, ++this.funcCount, name));
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
        return funcRow.getName() + "_" + funcRow.getFuncNumId();
    }

    public List<Integer> getFuncsParamRefs(int funcInd) {
        return this.table.get(funcInd).getParameters();
    }

    public int countFuncParams(int funcInd) {
        return this.table.get(funcInd).getParameters().size();
    }

    public int getMainRefByName(String funcName) {
        return this.table.stream()
                .filter(row -> row.getName().equals(funcName))
                .reduce((first, second) -> second)
                .orElseThrow(FunctionNotFoundException::new)
                .getForeignId();
    }

    public int getParamRefByArgsCount(int funcRef, int argsCount) {
        return this.table.get(funcRef).getParameters().get(argsCount-1);
    }
}
