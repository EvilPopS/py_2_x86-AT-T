package main.java.evilpops.pyathome_2_x86.semantic_analyzer.maps.operands_comp_maps;

import main.java.evilpops.pyathome_2_x86.sym_tab.enums.DataType;

import java.util.HashMap;
import java.util.Map;

public class OperandsTypesCompWArithmeticOps {
    /* Addition */
    public static final Map<DataType, Map<DataType, Boolean>> additionOperandsTypesComp = new HashMap<>() {{
        put(
                DataType.NUMBER,
                new HashMap<>() {{
                    put(DataType.NUMBER, true);
                    put(DataType.BOOLEAN, true);
                    put(DataType.NONE, false);
                    put(DataType.STRING, false);
                    put(DataType.UNKNOWN, false);
                }}
        );
        put(
                DataType.BOOLEAN,
                new HashMap<>() {{
                    put(DataType.NUMBER, true);
                    put(DataType.BOOLEAN, true);
                    put(DataType.NONE, false);
                    put(DataType.STRING, false);
                    put(DataType.UNKNOWN, false);
                }}
        );
        put(
                DataType.NONE,
                new HashMap<>() {{
                    put(DataType.NUMBER, false);
                    put(DataType.BOOLEAN, false);
                    put(DataType.NONE, false);
                    put(DataType.STRING, false);
                    put(DataType.UNKNOWN, false);
                }}
        );
        put(
                DataType.STRING,
                new HashMap<>() {{
                    put(DataType.NUMBER, false);
                    put(DataType.BOOLEAN, false);
                    put(DataType.NONE, false);
                    put(DataType.STRING, true);
                    put(DataType.UNKNOWN, false);
                }}
        );
        put(
                DataType.UNKNOWN,
                new HashMap<>() {{
                    put(DataType.NUMBER, false);
                    put(DataType.BOOLEAN, false);
                    put(DataType.NONE, false);
                    put(DataType.STRING, false);
                    put(DataType.UNKNOWN, false);
                }}
        );
    }};

    /* Subtraction */
    public static final Map<DataType, Map<DataType, Boolean>> subtractionOperandsTypesComp = new HashMap<>() {{
        put(
                DataType.NUMBER,
                new HashMap<>() {{
                    put(DataType.NUMBER, true);
                    put(DataType.BOOLEAN, true);
                    put(DataType.NONE, false);
                    put(DataType.STRING, false);
                    put(DataType.UNKNOWN, false);
                }}
        );
        put(
                DataType.BOOLEAN,
                new HashMap<>() {{
                    put(DataType.NUMBER, true);
                    put(DataType.BOOLEAN, true);
                    put(DataType.NONE, false);
                    put(DataType.STRING, false);
                    put(DataType.UNKNOWN, false);
                }}
        );
        put(
                DataType.NONE,
                new HashMap<>() {{
                    put(DataType.NUMBER, false);
                    put(DataType.BOOLEAN, false);
                    put(DataType.NONE, false);
                    put(DataType.STRING, false);
                    put(DataType.UNKNOWN, false);
                }}
        );
        put(
                DataType.STRING,
                new HashMap<>() {{
                    put(DataType.NUMBER, false);
                    put(DataType.BOOLEAN, false);
                    put(DataType.NONE, false);
                    put(DataType.STRING, false);
                    put(DataType.UNKNOWN, false);
                }}
        );
        put(
                DataType.UNKNOWN,
                new HashMap<>() {{
                    put(DataType.NUMBER, false);
                    put(DataType.BOOLEAN, false);
                    put(DataType.NONE, false);
                    put(DataType.STRING, false);
                    put(DataType.UNKNOWN, false);
                }}
        );
    }};

    /* Multiplication */
    public static final Map<DataType, Map<DataType, Boolean>> multiplicationOperandsTypesComp = new HashMap<>() {{
        put(
                DataType.NUMBER,
                new HashMap<>() {{
                    put(DataType.NUMBER, true);
                    put(DataType.BOOLEAN, true);
                    put(DataType.NONE, false);
                    put(DataType.STRING, true);
                    put(DataType.UNKNOWN, false);
                }}
        );
        put(
                DataType.BOOLEAN,
                new HashMap<>() {{
                    put(DataType.NUMBER, true);
                    put(DataType.BOOLEAN, true);
                    put(DataType.NONE, false);
                    put(DataType.STRING, true);
                    put(DataType.UNKNOWN, false);
                }}
        );
        put(
                DataType.NONE,
                new HashMap<>() {{
                    put(DataType.NUMBER, false);
                    put(DataType.BOOLEAN, false);
                    put(DataType.NONE, false);
                    put(DataType.STRING, false);
                    put(DataType.UNKNOWN, false);
                }}
        );
        put(
                DataType.STRING,
                new HashMap<>() {{
                    put(DataType.NUMBER, true);
                    put(DataType.BOOLEAN, true);
                    put(DataType.NONE, false);
                    put(DataType.STRING, false);
                    put(DataType.UNKNOWN, false);
                }}
        );
        put(
                DataType.UNKNOWN,
                new HashMap<>() {{
                    put(DataType.NUMBER, false);
                    put(DataType.BOOLEAN, false);
                    put(DataType.NONE, false);
                    put(DataType.STRING, false);
                    put(DataType.UNKNOWN, false);
                }}
        );
    }};

    /* Division */
    public static final Map<DataType, Map<DataType, Boolean>> divisionOperandsTypesComp = new HashMap<>() {{
        put(
                DataType.NUMBER,
                new HashMap<>() {{
                    put(DataType.NUMBER, true);
                    put(DataType.BOOLEAN, true);
                    put(DataType.NONE, false);
                    put(DataType.STRING, false);
                    put(DataType.UNKNOWN, false);
                }}
        );
        put(
                DataType.BOOLEAN,
                new HashMap<>() {{
                    put(DataType.NUMBER, true);
                    put(DataType.BOOLEAN, true);
                    put(DataType.NONE, false);
                    put(DataType.STRING, false);
                    put(DataType.UNKNOWN, false);
                }}
        );
        put(
                DataType.NONE,
                new HashMap<>() {{
                    put(DataType.NUMBER, false);
                    put(DataType.BOOLEAN, false);
                    put(DataType.NONE, false);
                    put(DataType.STRING, false);
                    put(DataType.UNKNOWN, false);
                }}
        );
        put(
                DataType.STRING,
                new HashMap<>() {{
                    put(DataType.NUMBER, false);
                    put(DataType.BOOLEAN, false);
                    put(DataType.NONE, false);
                    put(DataType.STRING, false);
                    put(DataType.UNKNOWN, false);
                }}
        );
        put(
                DataType.UNKNOWN,
                new HashMap<>() {{
                    put(DataType.NUMBER, false);
                    put(DataType.BOOLEAN, false);
                    put(DataType.NONE, false);
                    put(DataType.STRING, false);
                    put(DataType.UNKNOWN, false);
                }}
        );
    }};
}
