package ymanilow.utils;

import java.io.PrintStream;

public class Log {
    private PrintStream stream = System.out;
    public Log() {
    }

    public PrintStream getStream() {
        return stream;
    }
}
