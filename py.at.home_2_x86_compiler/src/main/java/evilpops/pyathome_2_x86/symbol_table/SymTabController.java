package main.java.evilpops.pyathome_2_x86.symbol_table;

import main.java.evilpops.pyathome_2_x86.assembly_generator.enums.AssemblyRegister;
import main.java.evilpops.pyathome_2_x86.symbol_table.enums.DataType;
import main.java.evilpops.pyathome_2_x86.symbol_table.enums.TabType;
import main.java.evilpops.pyathome_2_x86.symbol_table.exceptions.TabTypeEnumNotInSyncWithTabClassesException;
import main.java.evilpops.pyathome_2_x86.symbol_table.tabs.*;
import main.java.evilpops.pyathome_2_x86.symbol_table.tabs.row_struct.DataTypeRowArchetype;
import main.java.evilpops.pyathome_2_x86.symbol_table.tabs.row_struct.ExplicitTypeRowArchetype;
import main.java.evilpops.pyathome_2_x86.symbol_table.tabs.row_struct.MainTabRow;
import main.java.evilpops.pyathome_2_x86.symbol_table.tabs.row_struct.ScopeRowArchetype;


public class SymTabController implements ISymTabController {
    protected static ISymTabController symTabBean = null;
    protected final MainTab mainTab;
    protected final VariableTab variableTab;
    protected final ParameterTab parameterTab;
    protected final LiteralTab literalTab;
    protected final FunctionTab functionTab;
    protected final RegisterTab registerTab;


    private SymTabController() {
        this.mainTab = new MainTab();
        this.variableTab = new VariableTab();
        this.literalTab = new LiteralTab();
        this.registerTab = new RegisterTab();
        this.functionTab = new FunctionTab();
        this.parameterTab = new ParameterTab();
        this.addLiteral(null, DataType.NONE);
    }

    public static ISymTabController getInstance() {
        if (symTabBean == null)
            symTabBean = new SymTabController();
        return symTabBean;
    }

    @Override
    public int addVariable(DataType dataType, int scope, DataType explicitType, String name, int ordinality) {
        int rowRef = this.mainTab.getNextFreeRowInd();
        this.variableTab.add(rowRef, dataType, scope, explicitType, name, ordinality);
        this.mainTab.addVariable(this.variableTab.getLastRowInd());
        return rowRef;
    }

    @Override
    public int addParameter(
            DataType dataType,
            int scope,
            DataType explicitType,
            String name,
            int functionRef,
            boolean isDefault,
            int ordinality
    ) {
        int rowRef = this.mainTab.getNextFreeRowInd();
        this.parameterTab.add(rowRef, dataType, scope, explicitType, name, isDefault, ordinality);
        this.mainTab.addParameter(this.parameterTab.getLastRowInd());
        this.functionTab.addParam(
                this.mainTab.get(functionRef).getForeignId(),
                rowRef
        );
        return rowRef;
    }

    @Override
    public int addLiteral(String value, DataType dataType) {
        int rowRef = this.mainTab.getNextFreeRowInd();
        this.literalTab.add(rowRef, dataType, value);
        this.mainTab.addLiteral(this.literalTab.getLastRowInd());
        return rowRef;
    }

    @Override
    public int addFunction(int scope, String name) {
        int rowRef = this.mainTab.getNextFreeRowInd();
        this.functionTab.add(rowRef, scope, name);
        this.mainTab.addFunction(this.functionTab.getLastRowInd());
        return rowRef;
    }

    @Override
    public int addLiteralFloat(String value, DataType dataType, int dataLabelCounter) {
        int rowRef = this.mainTab.getNextFreeRowInd();
        this.literalTab.addFloat(rowRef, value, dataLabelCounter);
        this.mainTab.addLiteral(this.literalTab.getLastRowInd());
        return rowRef;
    }

    @Override
    public int addLiteralString(String value, DataType dataType, int dataLabelCounter) {
        int rowRef = this.mainTab.getNextFreeRowInd();
        this.literalTab.addString(rowRef, value, dataLabelCounter);
        this.mainTab.addLiteral(this.literalTab.getLastRowInd());
        return rowRef;
    }


    @Override
    public int takeRegister(DataType dataType) {
        int rowRef = this.mainTab.getNextFreeRowInd();
        this.mainTab.addRegister(this.registerTab.takeGenPurposeReg(rowRef, dataType));
        return rowRef;
    }

    @Override
    public int takeParamReg(int paramOrdinality, DataType dataType) {
        int rowRef = this.mainTab.getNextFreeRowInd();
        this.mainTab.addRegister(this.registerTab.takeParamReg(rowRef, paramOrdinality, dataType));
        return rowRef;
    }

    @Override
    public int transferParamToVar(int paramRef, int ordinality) {
        paramRef = this.mainTab.get(paramRef).getForeignId();
        return this.addVariable(
                this.parameterTab.getDataType(paramRef),
                this.parameterTab.getScope(paramRef),
                this.parameterTab.getExplicitType(paramRef),
                this.parameterTab.getName(paramRef),
                ordinality);
    }

    @Override
    public int getVarRefByName(String name) {
        return this.variableTab.getByName(name).getForeignId();
    }

    @Override
    public Integer getVarRefByNameInCurrentScope(String name, int currScope) {
        return this.variableTab.getByNameInCurrentScope(name, currScope).getForeignId();
    }

    @Override
    public int takeReturnReg(DataType dataType) {
        int rowRef = this.mainTab.getNextFreeRowInd();
        this.mainTab.addRegister(this.registerTab.takeReturnReg(rowRef, dataType));
        return rowRef;
    }

    @Override
    public int getNoneLiteralRef() {
        return this.literalTab.getNoneRowRef();
    }

    @Override
    public int getFuncRefByName(String funcName) {
        return this.functionTab.getMainRefByName(funcName);
    }

    @Override
    public int getFuncParamRefByArgCountNum(int funcRef, int argCountNum) {
        return this.functionTab.getParamRefByArgsCount(this.mainTab.get(funcRef).getForeignId(), argCountNum);
    }

    @Override
    public DataType getDataType(int ind) {
        MainTabRow rowData = this.mainTab.get(ind);
        return getDataTypeTableByTabType(rowData.getRefTabType())
                .getDataType(rowData.getForeignId());
    }

    @Override
    public DataType getExplicitType(int ind) {
        MainTabRow rowData = this.mainTab.get(ind);
        return getExplicitTypeTableByTabType(rowData.getRefTabType())
                .getExplicitType(rowData.getForeignId());
    }

    @Override
    public String getLiteralValue(int ind) {
        return this.literalTab.getValue(getForeignId(ind));
    }

    @Override
    public AssemblyRegister getRegName(int ind) {
        return this.registerTab.getRegisterName(getForeignId(ind));
    }

    @Override
    public AssemblyRegister[] getAllGenPurposeRegsInUse() {
        return this.registerTab.getAllGenPurposeRegsInUse();
    }

    @Override
    public int getVarOrdinality(int ind) {
        return this.variableTab.getOrdinality(getForeignId(ind));
    }

    @Override
    public int getParamOrdinality(int ind) {
        return this.parameterTab.getOrdinality(getForeignId(ind));
    }

    @Override
    public int getDataLabelCounter(int ind) {
        return this.literalTab.getDataLabelCounter(getForeignId(ind));
    }

    @Override
    public int getScope(int ind) {
        MainTabRow rowData = this.mainTab.get(ind);
        return getScopeTableByTabType(rowData.getRefTabType())
                .getScope(rowData.getForeignId());
    }

    @Override
    public int getCurrentScope() {
        return this.functionTab.getCurrentFuncScope();
    }

    @Override
    public String getFuncName(int ind) {
        return this.functionTab.getFuncName(this.mainTab.get(ind).getForeignId());
    }

    @Override
    public void setDataType(int ind, DataType dataType) {
        MainTabRow rowData = this.mainTab.get(ind);
        this.getDataTypeTableByTabType(rowData.getRefTabType())
                .setDataType(rowData.getForeignId(), dataType);
    }

    @Override
    public void setExplicitType(int ind, DataType explicitType) {
        MainTabRow rowData = this.mainTab.get(ind);
        this.getExplicitTypeTableByTabType(rowData.getRefTabType())
                .setExplicitType(rowData.getForeignId(), explicitType);
    }

    @Override
    public boolean checkIfIsReg(int ind) {
        return this.checkIfIsOfGivenTabType(ind, TabType.REGISTER);
    }

    @Override
    public boolean checkIfIsLiteral(int ind) {
        return this.checkIfIsOfGivenTabType(ind, TabType.LITERAL);
    }

    @Override
    public boolean checkIfIsVar(int ind) {
        return this.checkIfIsOfGivenTabType(ind, TabType.VARIABLE);
    }

    @Override
    public boolean checkIfDataTypeIsFloat(int ind) {
        return this.getDataType(ind).equals(DataType.FLOAT);
    }

    @Override
    public boolean checkIfDataTypeIsString(int ind) {
        return this.getDataType(ind).equals(DataType.STRING);
    }

    @Override
    public boolean checkIfDataTypeIsBoolean(int ind) {
        return this.getDataType(ind) == DataType.BOOLEAN;
    }

    @Override
    public boolean checkIfDataTypeIsNone(int ind) {
        return this.getDataType(ind) == DataType.NONE;
    }

    @Override
    public void freeIfIsRegister(int ind) {
        if (this.checkIfIsReg(ind))
            this.registerTab.freeRegister(this.mainTab.get(ind).getForeignId());
    }

    private DataTypeTableArchetype<? extends DataTypeRowArchetype> getDataTypeTableByTabType(TabType tabType) {
        return switch (tabType) {
            case VARIABLE -> this.variableTab;
            case PARAMETER -> this.parameterTab;
            case LITERAL -> this.literalTab;
            case REGISTER -> this.registerTab;
            case FUNCTION -> this.functionTab;
        };
    }

    private ExplicitTypeTableArchetype<? extends ExplicitTypeRowArchetype> getExplicitTypeTableByTabType(TabType tabType) {
        return switch (tabType) {
            case VARIABLE -> this.variableTab;
            case PARAMETER -> this.parameterTab;
            default -> throw new TabTypeEnumNotInSyncWithTabClassesException();
        };
    }

    private ScopeTableArchetype<? extends ScopeRowArchetype> getScopeTableByTabType(TabType tabType) {
        return switch (tabType) {
            case VARIABLE -> this.variableTab;
            case PARAMETER -> this.parameterTab;
            case FUNCTION -> this.functionTab;
            default -> throw new TabTypeEnumNotInSyncWithTabClassesException();
        };
    }
    private boolean checkIfIsOfGivenTabType(int ind, TabType tabType) {
        return this.mainTab.get(ind).getRefTabType().equals(tabType);
    }

    private int getForeignId(int ind) {
        return this.mainTab.get(ind).getForeignId();
    }
}
