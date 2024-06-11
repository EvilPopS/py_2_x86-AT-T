package main.java.evilpops.pyathome_2_x86._migration.symbol_table.data_type_utils;

import main.java.evilpops.pyathome_2_x86._migration.symbol_table.enums.DataType;

import java.util.HashMap;
import java.util.Map;

public class RelOpsOperandsTypesComp {
    public static final Map<DataType, Map<DataType, Boolean>> equalityRelOpsOperandsTypesComp = new HashMap<>() {{
        put(
                DataType.INTEGER,
                new HashMap<>() {{
                    put(DataType.INTEGER, true);
                    put(DataType.FLOAT, true);
                    put(DataType.BOOLEAN, true);
                    put(DataType.NONE, true);
                    put(DataType.STRING, false);
                    put(DataType.UNKNOWN, false);
                }}
        );
        put(
                DataType.FLOAT,
                new HashMap<>() {{
                    put(DataType.INTEGER, true);
                    put(DataType.FLOAT, true);
                    put(DataType.BOOLEAN, true);
                    put(DataType.NONE, true);
                    put(DataType.STRING, false);
                    put(DataType.UNKNOWN, false);
                }}
        );
        put(
                DataType.BOOLEAN,
                new HashMap<>() {{
                    put(DataType.INTEGER, true);
                    put(DataType.FLOAT, true);
                    put(DataType.BOOLEAN, true);
                    put(DataType.NONE, true);
                    put(DataType.STRING, false);
                    put(DataType.UNKNOWN, false);
                }}
        );
        put(
                DataType.NONE,
                new HashMap<>() {{
                    put(DataType.INTEGER, false);
                    put(DataType.FLOAT, false);
                    put(DataType.BOOLEAN, true);
                    put(DataType.NONE, true);
                    put(DataType.STRING, true);
                    put(DataType.UNKNOWN, false);
                }}
        );
        put(
                DataType.STRING,
                new HashMap<>() {{
                    put(DataType.INTEGER, false);
                    put(DataType.FLOAT, false);
                    put(DataType.BOOLEAN, false);
                    put(DataType.NONE, true);
                    put(DataType.STRING, true);
                    put(DataType.UNKNOWN, false);
                }}
        );
        put(
                DataType.UNKNOWN,
                new HashMap<>() {{
                    put(DataType.INTEGER, false);
                    put(DataType.FLOAT, false);
                    put(DataType.BOOLEAN, false);
                    put(DataType.NONE, true);
                    put(DataType.STRING, false);
                    put(DataType.UNKNOWN, false);
                }}
        );
    }};

    public static final Map<DataType, Map<DataType, Boolean>> nonEqualityRelOpsOperandsTypesComp = new HashMap<>() {{
        put(
                DataType.INTEGER,
                new HashMap<>() {{
                    put(DataType.INTEGER, true);
                    put(DataType.FLOAT, true);
                    put(DataType.BOOLEAN, true);
                    put(DataType.NONE, false);
                    put(DataType.STRING, false);
                    put(DataType.UNKNOWN, false);
                }}
        );
        put(
                DataType.FLOAT,
                new HashMap<>() {{
                    put(DataType.INTEGER, true);
                    put(DataType.FLOAT, true);
                    put(DataType.BOOLEAN, true);
                    put(DataType.NONE, false);
                    put(DataType.STRING, false);
                    put(DataType.UNKNOWN, false);
                }}
        );
        put(
                DataType.BOOLEAN,
                new HashMap<>() {{
                    put(DataType.INTEGER, true);
                    put(DataType.FLOAT, true);
                    put(DataType.BOOLEAN, true);
                    put(DataType.NONE, false);
                    put(DataType.STRING, false);
                    put(DataType.UNKNOWN, false);
                }}
        );
        put(
                DataType.NONE,
                new HashMap<>() {{
                    put(DataType.INTEGER, false);
                    put(DataType.FLOAT, false);
                    put(DataType.BOOLEAN, false);
                    put(DataType.NONE, false);
                    put(DataType.STRING, false);
                    put(DataType.UNKNOWN, false);
                }}
        );
        put(
                DataType.STRING,
                new HashMap<>() {{
                    put(DataType.INTEGER, false);
                    put(DataType.FLOAT, false);
                    put(DataType.BOOLEAN, false);
                    put(DataType.NONE, false);
                    put(DataType.STRING, true);
                    put(DataType.UNKNOWN, false);
                }}
        );
        put(
                DataType.UNKNOWN,
                new HashMap<>() {{
                    put(DataType.INTEGER, false);
                    put(DataType.FLOAT, false);
                    put(DataType.BOOLEAN, false);
                    put(DataType.NONE, false);
                    put(DataType.STRING, false);
                    put(DataType.UNKNOWN, false);
                }}
        );
    }};
}
