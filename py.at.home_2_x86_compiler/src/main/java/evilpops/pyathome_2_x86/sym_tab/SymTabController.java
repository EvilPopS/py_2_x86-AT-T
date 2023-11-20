package main.java.evilpops.pyathome_2_x86.sym_tab;

import main.java.evilpops.pyathome_2_x86.assembly_gen.enums.AssemblyRegister;
import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;
import main.java.evilpops.pyathome_2_x86.sym_tab.enums.TabType;
import main.java.evilpops.pyathome_2_x86.sym_tab.exceptions.TabTypeEnumNotInSyncWithTabClassesException;
import main.java.evilpops.pyathome_2_x86.sym_tab.tabs.*;
import main.java.evilpops.pyathome_2_x86.sym_tab.tabs.row_struct.ConcreteRowArchetype;
import main.java.evilpops.pyathome_2_x86.sym_tab.tabs.row_struct.MainTabRow;

public class SymTabController implements ISymTabController {
    protected static ISymTabController symTabBean = null;
    protected final MainTab mainTab;
    protected final VariableTab variableTab;
    protected final LiteralTab literalTab;
    protected final RegisterTab registerTab;


    private SymTabController() {
        this.mainTab = new MainTab();
        this.variableTab = new VariableTab();
        this.literalTab = new LiteralTab();
        this.registerTab = new RegisterTab();
    }

    public static ISymTabController getInstance() {
        if (symTabBean == null)
            symTabBean = new SymTabController();
        return symTabBean;
    }

    @Override
    public int addVariable(DataType dataType, String name, int ordinality) {
        int rowRef = this.mainTab.getNextFreeRowInd();
        this.variableTab.add(rowRef, dataType, name, ordinality);
        this.mainTab.addVariable(this.variableTab.getLastRowInd());
        return rowRef;
    }

    @Override
    public int addLiteral(String value, DataType dataType) {
        int rowRef = this.mainTab.getNextFreeRowInd();
        this.literalTab.add(value, dataType, rowRef);
        this.mainTab.addLiteral(this.literalTab.getLastRowInd());
        return rowRef;
    }

    @Override
    public int addRegister(DataType dataType) {
        int rowRef = this.mainTab.getNextFreeRowInd();
        this.registerTab.add(dataType, rowRef);
        this.mainTab.addRegister(this.registerTab.getLastRowInd());
        return rowRef;
    }

    @Override
    public int getVarRefByName(String name) {
        return this.variableTab.getByName(name).getForeignId();
    }

    @Override
    public DataType getDataTypeByInd(int ind) {
        MainTabRow rowData = this.mainTab.getByInd(ind);
        return getConcreteTableByTabType(rowData.getRefTabType())
                .getDataType(rowData.getForeignId());
    }

    @Override
    public String getLiteralValueByInd(int ind) {
        return this.literalTab.getValueByInd(getForeignId(ind));
    }

    @Override
    public AssemblyRegister getRegNameByInd(int ind) {
        return this.registerTab.getRegisterNameByInd(getForeignId(ind));
    }

    @Override
    public int getVarOrdinalityByInd(int ind) {
        return this.variableTab.getOrdinalityByInd(getForeignId(ind));
    }

    @Override
    public void setDataTypeByInd(int ind, DataType dataType) {
        MainTabRow rowData = this.mainTab.getByInd(ind);
        getConcreteTableByTabType(rowData.getRefTabType())
                .setDataType(rowData.getForeignId(), dataType);
    }

    @Override
    public boolean checkIfIsRegByInd(int ind) {
        return this.checkIfIsOfGivenTabType(ind, TabType.REGISTER);
    }

    @Override
    public boolean checkIfIsLiteralByInd(int ind) {
        return this.checkIfIsOfGivenTabType(ind, TabType.LITERAL);
    }

    @Override
    public boolean checkIfIsVarByInd(int ind) {
        return this.checkIfIsOfGivenTabType(ind, TabType.VARIABLE);
    }

    @Override
    public boolean checkIfDataTypeIsFloat(int ind) {
        return this.getDataTypeByInd(ind) == DataType.FLOAT;
    }

    private ConcreteTableArchetype<? extends ConcreteRowArchetype> getConcreteTableByTabType(TabType tabType) {
        return switch (tabType) {
            case VARIABLE -> this.variableTab;
            case LITERAL -> this.literalTab;
            case REGISTER -> this.registerTab;
            default -> throw new TabTypeEnumNotInSyncWithTabClassesException();
        };
    }

    private boolean checkIfIsOfGivenTabType(int ind, TabType tabType) {
        return this.mainTab.getByInd(ind).getRefTabType().equals(tabType);
    }

    private int getForeignId(int ind) {
        return this.mainTab.getByInd(ind).getForeignId();
    }
}
