package main.java.evilpops.pyathome_2_x86.semantic_analyzer;

import main.java.evilpops.pyathome_2_x86.semantic_analyzer.exceptions.DataTypesNotCompatibleException;
import main.java.evilpops.pyathome_2_x86.sym_tab.utils.data_type_utils.ArithOpsOperandsTypesComp;
import main.java.evilpops.pyathome_2_x86.sym_tab.ISymTabController;
import main.java.evilpops.pyathome_2_x86.sym_tab.SymTabController;
import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;
import main.java.evilpops.pyathome_2_x86.sym_tab.utils.data_type_utils.RelOpsOperandsTypesComp;

import java.util.Map;

public class SemanticAnalyzer {
    private static final ISymTabController symTabController = SymTabController.getInstance();

    public static void areTypesCompatibleForAddition(int leftRefToVal, int rightRefToVal) {
        checkTypesCompatibility(
                ArithOpsOperandsTypesComp.additionOperandsTypesComp, leftRefToVal, rightRefToVal, "+"
        );
    }

    public static void areTypesCompatibleForSubtraction(int leftRefToVal, int rightRefToVal) {
        checkTypesCompatibility(
                ArithOpsOperandsTypesComp.subtractionOperandsTypesComp, leftRefToVal, rightRefToVal, "-"
        );
    }

    public static void areTypesCompatibleForMultiplication(int leftRefToVal, int rightRefToVal) {
        checkTypesCompatibility(
                ArithOpsOperandsTypesComp.multiplicationOperandsTypesComp, leftRefToVal, rightRefToVal, "*"
        );
    }

    public static void areTypesCompatibleForDivision(int leftRefToVal, int rightRefToVal) {
        checkTypesCompatibility(
                ArithOpsOperandsTypesComp.divisionOperandsTypesComp, leftRefToVal, rightRefToVal, "*"
        );
    }

    public static void areTypesCompatibleForEqualityRelOp(int leftRefToVal, int rightRefToVal) {
        checkTypesCompatibility(
                RelOpsOperandsTypesComp.equalityRelOpsOperandsTypesComp, leftRefToVal, rightRefToVal, "(== or !=)"
        );
    }

    public static void areTypesCompatibleForNonEqualityRelOp(int leftRefToVal, int rightRefToVal) {
        checkTypesCompatibility(
                RelOpsOperandsTypesComp.nonEqualityRelOpsOperandsTypesComp, leftRefToVal, rightRefToVal, "(< or <= or > or >=)"
        );
    }


    private static void checkTypesCompatibility(Map<DataType, Map<DataType, Boolean>> map, int leftRef, int rightRef, String operator) {
        DataType lType = symTabController.getDataTypeByInd(leftRef);
        DataType rType = symTabController.getDataTypeByInd(rightRef);
        if (!map.get(lType).get(rType))
            throw new DataTypesNotCompatibleException(operator, lType.toString(), rType.toString());
    }
}
