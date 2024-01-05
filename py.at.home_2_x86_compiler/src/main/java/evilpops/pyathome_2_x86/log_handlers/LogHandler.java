package main.java.evilpops.pyathome_2_x86.log_handlers;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class LogHandler {
    private static final LogHandler LOG_HANDLER = new LogHandler();

    @Getter @Setter
    protected boolean syntaxErrDetected;

    protected final List<String> warningMessages;
    protected int line;
    protected final String CLR_RESET = "\u001B[0m";
    protected final String CLR_RED = "\u001B[31m";
    protected final String CLR_YELLOW = "\u001B[33m";


    private LogHandler() {
        this.warningMessages = new ArrayList<>();
        this.line = 0;
        this.syntaxErrDetected = false;
    }

    public static LogHandler getInstance() {
        return LOG_HANDLER;
    }

    public void updateLine(int line) {
        this.line = line;
    }

    public void addWarning(String warn) {
        this.warningMessages.add(makeMessToPrint("WARNING", warn));
    }

    public void printErrorMessage(String message) {
        System.out.print(redClrMessage(makeMessToPrint("ERROR", message)));
    }

    public void printWarningMessagesIfAny() {
        for (String warn : this.warningMessages)
            System.out.println(yellowClrMessage(warn));
    }

    private String makeMessToPrint(String messType, String message) {
        return String.format("\n%s at line %d: %s\n", messType, line, message);
    }

    private String redClrMessage(String message) {
        return clrMessage(message, CLR_RED);
    }

    private String yellowClrMessage(String message) {
        return clrMessage(message, CLR_YELLOW);
    }

    private String clrMessage(String mess, String clrCode) {
        return String.format("\n%s%s%s\n", clrCode, mess, CLR_RESET);
    }

}
