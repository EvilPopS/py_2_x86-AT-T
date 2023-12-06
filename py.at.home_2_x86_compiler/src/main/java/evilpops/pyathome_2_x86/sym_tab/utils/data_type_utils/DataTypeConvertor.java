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

    private static final Map<DataType, Map<DataType, DataType>> multiplicationDataTypeMap = new HashMap<>() {{
        put(
                DataType.INTEGER,
                new HashMap<>() {{
                    put(DataType.INTEGER, DataType.INTEGER);
                    put(DataType.FLOAT, DataType.FLOAT);
                    put(DataType.BOOLEAN, DataType.INTEGER);
                    put(DataType.STRING, DataType.STRING);
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
                    put(DataType.STRING, DataType.STRING);
                }}
        );
        put(
                DataType.STRING,
                new HashMap<>() {{
                    put(DataType.INTEGER, DataType.STRING);
                    put(DataType.BOOLEAN, DataType.STRING);
                }}
        );
    }};


    public static DataType getAdditionResultDataType(DataType lExpType, DataType rExpType) {
        return extractResDataTypeFromMap(lExpType, rExpType, additionDataTypeMap);
    }

    public static DataType getSubtractionResultDataType(DataType lExpType, DataType rExpType) {
        return extractResDataTypeFromMap(lExpType, rExpType, subtractionDataTypeMap);
    }
    public static DataType getMultiplicationResultDataType(DataType lExpType, DataType rExpType) {
        return extractResDataTypeFromMap(lExpType, rExpType, multiplicationDataTypeMap);
    }

    public static DataType getDivisionResultDataType() {
        return DataType.FLOAT;
    }

    private static DataType extractResDataTypeFromMap(DataType lt, DataType rt, Map<DataType, Map<DataType, DataType>> map) {
        if (map.containsKey(lt))
            if (map.get(lt).containsKey(rt))
                return map.get(lt).get(rt);
        throw new InvalidOperandsTypesForGivenOperatorException();
    }
}
