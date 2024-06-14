package main.java.evilpops.pyathome_2_x86.semantics;


import main.java.evilpops.pyathome_2_x86.exceptions.compilation.errors.DataTypesNotCompatibleException;
import main.java.evilpops.pyathome_2_x86.exceptions.compilation.warnings.ImplicitAndExplicitTypesNotCompatibleWarning;
import main.java.evilpops.pyathome_2_x86.symbol_table.data_type_utils.ArithOpsOperandsTypesComp;
import main.java.evilpops.pyathome_2_x86.symbol_table.data_type_utils.RelOpsOperandsTypesComp;
import main.java.evilpops.pyathome_2_x86.symbol_table.enums.DataType;

import java.util.Map;

public class SemanticAnalyzer {
    public static void areTypesCompatibleForAddition(DataType leftExpDataType, DataType rightExpDataType) {
        checkTypesCompatibility(
                ArithOpsOperandsTypesComp.additionOperandsTypesComp,
                leftExpDataType,
                rightExpDataType,
                "+"
        );
    }

    public static void areTypesCompatibleForSubtraction(DataType leftExpDataType, DataType rightExpDataType) {
        checkTypesCompatibility(
                ArithOpsOperandsTypesComp.subtractionOperandsTypesComp,
                leftExpDataType,
                rightExpDataType,
                "-"
        );
    }

    public static void areTypesCompatibleForMultiplication(DataType leftExpDataType, DataType rightExpDataType) {
        checkTypesCompatibility(
                ArithOpsOperandsTypesComp.multiplicationOperandsTypesComp,
                leftExpDataType,
                rightExpDataType,
                "*"
        );
    }

    public static void areTypesCompatibleForDivision(DataType leftExpDataType, DataType rightExpDataType) {
        checkTypesCompatibility(
                ArithOpsOperandsTypesComp.divisionOperandsTypesComp,
                leftExpDataType,
                rightExpDataType,
                "*"
        );
    }

    public static void areTypesCompatibleForEqualityRelOp(DataType leftExpDataType, DataType rightExpDataType) {
        checkTypesCompatibility(
                RelOpsOperandsTypesComp.equalityRelOpsOperandsTypesComp,
                leftExpDataType,
                rightExpDataType,
                "(== or !=)"
        );
    }

    public static void areTypesCompatibleForNonEqualityRelOp(DataType leftExpDataType, DataType rightExpDataType) {
        checkTypesCompatibility(
                RelOpsOperandsTypesComp.nonEqualityRelOpsOperandsTypesComp,
                leftExpDataType,
                rightExpDataType,
                "(< or <= or > or >=)"
        );
    }

    public static void areImplicitAndExplicitDataTypesTheSame(DataType implicit, DataType explicit) {
        if (!implicit.equals(explicit) && !explicit.equals(DataType.UNKNOWN))
            throw new ImplicitAndExplicitTypesNotCompatibleWarning(implicit.toString(), explicit.toString());
    }

    private static void checkTypesCompatibility(
            Map<DataType, Map<DataType, Boolean>> map,
            DataType leftExpDataType,
            DataType rightExpDataType,
            String operator
    ) {
        if (!map.get(leftExpDataType).get(rightExpDataType))
            throw new DataTypesNotCompatibleException(
                    operator, leftExpDataType.toString(), rightExpDataType.toString()
            );
    }
}
