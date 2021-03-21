package main.ymanilow.utils;

import main.ymanilow.exceptions.AvajException;

import java.io.PrintStream;
import java.util.Arrays;

public class Log {
    private PrintStream stream;
    public Log(PrintStream stream) {
        this.stream = stream;
    }

    public PrintStream getStream() {
        return stream;
    }

    public void printMessage(String message) {
        stream.println(message);
    }

    public void printException(AvajException ex) {
        stream.println(ex);
        for (StackTraceElement string : ex.getStackTrace()) {
            stream.println(string);
        }
    }
    public void printExceptionWithoutStacktrace(AvajException ex){
        stream.println(ex);
    }
}
