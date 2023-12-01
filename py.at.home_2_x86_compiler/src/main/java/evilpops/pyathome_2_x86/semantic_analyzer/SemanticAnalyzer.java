package main.java.evilpops.pyathome_2_x86.semantic_analyzer;

import main.java.evilpops.pyathome_2_x86.semantic_analyzer.exceptions.DataTypesNotCompatibleException;
import main.java.evilpops.pyathome_2_x86.semantic_analyzer.maps.operands_comp_maps.AritOpsOperandsTypesComp;
import main.java.evilpops.pyathome_2_x86.sym_tab.ISymTabController;
import main.java.evilpops.pyathome_2_x86.sym_tab.SymTabController;
import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;

import java.util.Map;

public class SemanticAnalyzer {
    private static final ISymTabController symTabController = SymTabController.getInstance();

    public static void areTypesCompatibleForAddition(int leftRefToVal, int rightRefToVal) {
        checkTypesCompatibility(
                AritOpsOperandsTypesComp.additionOperandsTypesComp, leftRefToVal, rightRefToVal, "+"
        );

    }

    public static void areTypesCompatibleForSubtraction(int leftRefToVal, int rightRefToVal) {
        checkTypesCompatibility(
                AritOpsOperandsTypesComp.subtractionOperandsTypesComp, leftRefToVal, rightRefToVal, "-"
        );
    }

    private static void checkTypesCompatibility(Map<DataType, Map<DataType, Boolean>> map, int leftRef, int rightRef, String operator) {
        DataType lType = symTabController.getDataTypeByInd(leftRef);
        DataType rType = symTabController.getDataTypeByInd(rightRef);
        if (!map.get(lType).get(rType))
            throw new DataTypesNotCompatibleException(operator, lType.toString(), rType.toString());
    }
}
