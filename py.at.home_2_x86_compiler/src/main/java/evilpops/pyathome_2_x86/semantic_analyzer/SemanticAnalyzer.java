package main.java.evilpops.pyathome_2_x86.semantic_analyzer;

import main.java.evilpops.pyathome_2_x86.semantic_analyzer.exceptions.DataTypesNotCompatibleException;
import main.java.evilpops.pyathome_2_x86.semantic_analyzer.maps.operands_comp_maps.OperandsTypesCompWArithmeticOps;
import main.java.evilpops.pyathome_2_x86.sym_tab.ISymTabController;
import main.java.evilpops.pyathome_2_x86.sym_tab.SymTabController;
import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;

public class SemanticAnalyzer {
    private static final ISymTabController symTabController = SymTabController.getInstance();

    public static void areTypesCompatibleForAddition(int leftRefToVal, int rightRefToVal) {
        DataType lType = symTabController.getDataTypeByInd(leftRefToVal);
        DataType rType = symTabController.getDataTypeByInd(rightRefToVal);
        if (!OperandsTypesCompWArithmeticOps.additionOperandsTypesComp.get(lType).get(rType))
            throw new DataTypesNotCompatibleException("+", lType.toString(), rType.toString());
    }
}
