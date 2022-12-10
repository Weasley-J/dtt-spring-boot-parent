package cn.alphahub.dtt.plus.exception;

/**
 * Parse exception
 */
@SuppressWarnings("serial")
public class ParseException extends RuntimeException {

    public ParseException() {
        super();
    }

    public ParseException(String message) {
        super(message);
    }

    public ParseException(String message, Throwable cause) {
        super(message, cause);
    }
}
