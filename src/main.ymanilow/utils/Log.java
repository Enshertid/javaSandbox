package main.ymanilow.utils;

import main.ymanilow.exceptions.AvajException;

import java.io.PrintStream;

public class Log {
    private PrintStream exceptionsStream;
    private PrintStream logStream;
    public Log(PrintStream exceptionsStream, PrintStream logStream) {
        this.exceptionsStream = exceptionsStream;
        this.logStream = logStream;
    }

    public PrintStream getExceptionsStream() {
        return exceptionsStream;
    }

    public void printMessage(String message) {
        logStream.println(message);
    }

    public void printException(AvajException ex) {
        exceptionsStream.println(ex);
        for (StackTraceElement string : ex.getStackTrace()) {
            exceptionsStream.println(string);
        }
    }
    public void printExceptionWithoutStacktrace(AvajException ex){
        exceptionsStream.println(ex);
    }
}
