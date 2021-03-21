package main.ymanilow.exceptions;

public class AvajException extends Throwable{
    private long numberOfString;
    public AvajException() {
        super();
    }

    public AvajException(String message) {
        super(message);
    }

    public AvajException(String message, long numberOfString) {
        super(message);
        this.numberOfString = numberOfString;
    }

    public AvajException(String message, Throwable cause) {
        super(message, cause);
    }

    public AvajException(String message, Throwable cause, long numberOfString) {
        super(message, cause);
        this.numberOfString = numberOfString;
    }

    public AvajException(Throwable cause) {
        super(cause);
    }

    protected AvajException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public String toString() {
        return super.toString() + (numberOfString == 0 ? "" : ", number of incorrect string: " + numberOfString);
    }
}
