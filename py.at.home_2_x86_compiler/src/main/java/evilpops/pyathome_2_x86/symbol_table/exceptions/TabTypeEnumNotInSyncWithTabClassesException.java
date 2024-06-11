package main.java.evilpops.pyathome_2_x86.symbol_table.exceptions;

public class TabTypeEnumNotInSyncWithTabClassesException extends RuntimeException {
    public TabTypeEnumNotInSyncWithTabClassesException() {
        super("Table type enum & implemented concrete table classes are not in sync!");
    }
}
