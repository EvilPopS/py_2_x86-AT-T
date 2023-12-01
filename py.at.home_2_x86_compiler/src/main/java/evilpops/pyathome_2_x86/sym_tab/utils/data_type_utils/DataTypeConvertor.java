package main.java.evilpops.pyathome_2_x86.sym_tab.utils.data_type_utils;

import main.java.evilpops.pyathome_2_x86.grammar_listener.exceptions.InvalidOperandsTypesForGivenOperatorException;
import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;

import java.util.HashMap;
import java.util.Map;

public class DataTypeConvertor {
    private static final Map<DataType, Map<DataType, DataType>> additionDataTypeMap = new HashMap<>() {{
        put(
                DataType.INTEGER,
                new HashMap<>() {{
                    put(DataType.INTEGER, DataType.INTEGER);
                    put(DataType.FLOAT, DataType.FLOAT);
                    put(DataType.BOOLEAN, DataType.INTEGER);
                }}
        );
        put(
                DataType.FLOAT,
                new HashMap<>() {{
                    put(DataType.INTEGER, DataType.FLOAT);
                    put(DataType.FLOAT, DataType.FLOAT);
                    put(DataType.BOOLEAN, DataType.FLOAT);
                }}
        );
        put(
                DataType.BOOLEAN,
                new HashMap<>() {{
                    put(DataType.INTEGER, DataType.INTEGER);
                    put(DataType.FLOAT, DataType.FLOAT);
                    put(DataType.BOOLEAN, DataType.INTEGER);
                }}
        );
        put(
                DataType.STRING,
                new HashMap<>() {{
                    put(DataType.STRING, DataType.STRING);
                }}
        );
    }};

    private static final Map<DataType, Map<DataType, DataType>> subtractionDataTypeMap = new HashMap<>() {{
        put(
                DataType.INTEGER,
                new HashMap<>() {{
                    put(DataType.INTEGER, DataType.INTEGER);
                    put(DataType.FLOAT, DataType.FLOAT);
                    put(DataType.BOOLEAN, DataType.INTEGER);
                }}
        );
        put(
                DataType.FLOAT,
                new HashMap<>() {{
                    put(DataType.INTEGER, DataType.FLOAT);
                    put(DataType.FLOAT, DataType.FLOAT);
                    put(DataType.BOOLEAN, DataType.FLOAT);
                }}
        );
        put(
                DataType.BOOLEAN,
                new HashMap<>() {{
                    put(DataType.INTEGER, DataType.INTEGER);
                    put(DataType.FLOAT, DataType.FLOAT);
                    put(DataType.BOOLEAN, DataType.INTEGER);
                }}
        );
    }};

    public static DataType getAdditionResultDataType(DataType lExpType, DataType rExpType) {
        if (additionDataTypeMap.containsKey(lExpType))
            if (additionDataTypeMap.get(lExpType).containsKey(rExpType))
                return additionDataTypeMap.get(lExpType).get(rExpType);
        throw new InvalidOperandsTypesForGivenOperatorException();
    }

    public static DataType getSubtractionResultDataType(DataType lExpType, DataType rExpType) {
        if (subtractionDataTypeMap.containsKey(lExpType))
            if (subtractionDataTypeMap.get(lExpType).containsKey(rExpType))
                return subtractionDataTypeMap.get(lExpType).get(rExpType);
        throw new InvalidOperandsTypesForGivenOperatorException();
    }

}
