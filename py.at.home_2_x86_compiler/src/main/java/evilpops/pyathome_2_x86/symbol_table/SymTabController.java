package main.java.evilpops.pyathome_2_x86.symbol_table;

import main.java.evilpops.pyathome_2_x86.assembly_generator.enums.AssemblyRegister;
import main.java.evilpops.pyathome_2_x86.symbol_table.enums.DataType;
import main.java.evilpops.pyathome_2_x86.symbol_table.enums.TabType;
import main.java.evilpops.pyathome_2_x86.symbol_table.exceptions.ParameterNotFoundException;
import main.java.evilpops.pyathome_2_x86.symbol_table.exceptions.TabTypeEnumNotInSyncWithTabClassesException;
import main.java.evilpops.pyathome_2_x86.symbol_table.tabs.*;
import main.java.evilpops.pyathome_2_x86.symbol_table.tabs.row_struct.DataTypeRowArchetype;
import main.java.evilpops.pyathome_2_x86.symbol_table.tabs.row_struct.MainTabRow;
import main.java.evilpops.pyathome_2_x86.symbol_table.tabs.row_struct.ScopeRowArchetype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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
    }

    public static ISymTabController getInstance() {
        if (symTabBean == null)
            symTabBean = new SymTabController();
        return symTabBean;
    }

    @Override
    public int addVariable(DataType dataType, int funcScope, int blockScope, String name, int ordinality) {
        int rowRef = this.mainTab.getTableSize();
        this.variableTab.add(rowRef, dataType, funcScope, blockScope, name, ordinality);
        this.mainTab.addVariable(this.variableTab.getLastRowInd());
        return rowRef;
    }

    @Override
    public int addParameter(
            DataType dataType,
            int funcScope,
            int blockScope,
            String name,
            int functionRef,
            boolean isDefault,
            int totalOrdinality,
            int perDataTypeOrdinality
    ) {
        int paramRef = this.parameterTab.add(
                dataType,
                funcScope,
                blockScope,
                name,
                isDefault,
                totalOrdinality,
                perDataTypeOrdinality);
        this.functionTab.addParam(
                this.mainTab.get(functionRef).getForeignId(),
                paramRef
        );
        return paramRef;
    }

    @Override
    public int addLiteral(DataType dataType, int funcScope, int blockScope, String value) {
        int rowRef = this.mainTab.getTableSize();
        this.literalTab.add(rowRef, dataType, funcScope, blockScope, value);
        this.mainTab.addLiteral(this.literalTab.getLastRowInd());
        return rowRef;
    }

    @Override
    public int addFunction(int funcScope, int blockScope, String name) {
        int rowRef = this.mainTab.getTableSize();
        this.functionTab.add(rowRef, funcScope, blockScope, name);
        this.mainTab.addFunction(this.functionTab.getLastRowInd());
        return rowRef;
    }

    @Override
    public int addLiteralFloat(int funcScope, int blockScope, String value, int dataLabelCounter) {
        int rowRef = this.mainTab.getTableSize();
        this.literalTab.addFloat(rowRef, funcScope, blockScope, value, dataLabelCounter);
        this.mainTab.addLiteral(this.literalTab.getLastRowInd());
        return rowRef;
    }

    @Override
    public int addLiteralString(int funcScope, int blockScope, String value, int dataLabelCounter) {
        int rowRef = this.mainTab.getTableSize();
        this.literalTab.addString(rowRef, funcScope, blockScope, value, dataLabelCounter);
        this.mainTab.addLiteral(this.literalTab.getLastRowInd());
        return rowRef;
    }

    @Override
    public int addLiteralNone(int funcScope, int blockScope) {
        return this.addLiteral(DataType.NONE, funcScope, blockScope, null);
    }

    @Override
    public int takeRegister(DataType dataType) {
        int rowRef = this.mainTab.getTableSize();
        this.mainTab.addRegister(this.registerTab.takeGenPurposeReg(rowRef, dataType));
        return rowRef;
    }

    @Override
    public int takeParamReg(int paramOrdinality, DataType dataType) {
        int rowRef = this.mainTab.getTableSize();
        this.mainTab.addRegister(this.registerTab.takeParamReg(rowRef, paramOrdinality, dataType));
        return rowRef;
    }

    @Override
    public int transferParamToVar(int paramRef, int ordinality, int funcScope, int blockScope) {
        return this.addVariable(
                this.parameterTab.getDataType(paramRef),
                funcScope,
                blockScope,
                this.parameterTab.getName(paramRef),
                ordinality);
    }

    @Override
    public int getVarRefByNameInAnyScope(String name) {
        return this.variableTab.getByNameInAnyScope(name).getForeignId();
    }

    @Override
    public int getVarRefByNameInCurrentFuncScope(String name, int currScope) {
        return this.variableTab.getByNameInCurrentFuncScope(name, currScope).getForeignId();
    }

    @Override
    public int takeReturnReg(DataType dataType) {
        int rowRef = this.mainTab.getTableSize();
        this.mainTab.addRegister(this.registerTab.takeReturnReg(rowRef, dataType));
        return rowRef;
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
    public int getFuncParamRefByParamName(int funcRef, String paramName) {
        for (int paramRef : this.getFuncsParamRefs(funcRef)) {
            if (this.parameterTab.getName(paramRef).equals(paramName))
                return paramRef;
        }
        throw new ParameterNotFoundException();
    }

    @Override
    public DataType getDataType(int ind) {
        return getDataTypeTableByTabType(this.mainTab.get(ind).getRefTabType())
                .getDataType(getForeignId(ind));
    }

    @Override
    public DataType getParamDataType(int paramRef) {
        return this.parameterTab.getDataType(paramRef);
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
    public int getTotalParamOrdinality(int ind) {
        return this.parameterTab.getTotalOrdinality(getForeignId(ind));
    }

    @Override
    public int getPerDataTypeParamOrdinality(int ind) {
        return this.parameterTab.getDataTypeParamOrdinality(ind);
    }

    @Override
    public int getDataLabelCounter(int ind) {
        return this.literalTab.getDataLabelCounter(getForeignId(ind));
    }

    @Override
    public int getFuncScope(int ind) {
        MainTabRow rowData = this.mainTab.get(ind);
        return getScopeTableByTabType(rowData.getRefTabType())
                .getFuncScope(rowData.getForeignId());
    }

    @Override
    public int getBlockScope(int ind) {
        MainTabRow rowData = this.mainTab.get(ind);
        return getScopeTableByTabType(rowData.getRefTabType())
                .getBlockScope(rowData.getForeignId());
    }

    @Override
    public int getParamScope(int paramRef) {
        return this.parameterTab.getFuncScope(paramRef);
    }


    @Override
    public String getParamName(int paramRef) {
        return this.parameterTab.getName(getForeignId(paramRef));
    }

    @Override
    public String getFuncName(int ind) {
        return this.functionTab.getFuncName(getForeignId(ind));
    }

    @Override
    public List<Integer> getFuncsParamRefs(int ind) {
        return new ArrayList<>(this.functionTab.getFuncsParamRefs(getForeignId(ind)));
    }

    @Override
    public int getNumOfFuncParams(int ind) {
        return this.functionTab.countFuncParams(getForeignId(ind));
    }

    @Override
    public int[] getAndFreeAllTakenGenPurposeRegs() {
        return this.registerTab.getAndFreeAllTakenGenPurposeRegs();
    }

    @Override
    public void setDataType(int ind, DataType dataType) {
        MainTabRow rowData = this.mainTab.get(ind);
        this.getDataTypeTableByTabType(rowData.getRefTabType())
                .setDataType(rowData.getForeignId(), dataType);
    }

    @Override
    public void restoreTakenStateOfGivenGenPurposeRegs(int[] genPurposeRegsRefs) {
        this.registerTab.restoreTakenStateOfGivenGenPurposeRegs(
                Arrays.stream(genPurposeRegsRefs).boxed().toArray(Integer[]::new)
        );
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
    public boolean checkIfParamDataTypeIsFloat(int paramRef) {
        return this.getParamDataType(paramRef).equals(DataType.FLOAT);
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
    public boolean checkIfIsDefParam(int paramRef) {
        return this.parameterTab.isDefault(paramRef);
    }

    @Override
    public void deleteCurrentFuncScope(int targetScope) {
        for (int ind = this.mainTab.getTableSize() - 1; ind >= 0; ind--) {
            try {
                if (this.getFuncScope(ind) < targetScope)
                    return;
            } catch (Exception ignored) {
            }

            if (!this.checkIfIsReg(ind))
                this.getDataTypeTableByTabType(this.mainTab.get(ind).getRefTabType())
                        .removeRowByInd(getForeignId(ind));

            this.mainTab.removeRowByInd(ind);
        }
    }

    @Override
    public void deleteCurrentBlockScope(int targetScope) {
        for (int ind = this.mainTab.getTableSize() - 1; ind >= 0; ind--) {
            try {
                if (this.getBlockScope(ind) < targetScope)
                    return;
            } catch (Exception ignored) {
            }

            if (!this.checkIfIsReg(ind))
                this.getDataTypeTableByTabType(this.mainTab.get(ind).getRefTabType())
                        .removeRowByInd(getForeignId(ind));
            else
                this.freeIfIsRegister(ind);

            this.mainTab.removeRowByInd(ind);
        }
    }

    @Override
    public void freeIfIsRegister(int ind) {
        if (this.checkIfIsReg(ind))
            this.registerTab.freeRegister(getForeignId(ind));
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

    private ScopeTableArchetype<? extends ScopeRowArchetype> getScopeTableByTabType(TabType tabType) {
        return switch (tabType) {
            case VARIABLE -> this.variableTab;
            case PARAMETER -> this.parameterTab;
            case FUNCTION -> this.functionTab;
            case LITERAL -> this.literalTab;
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
