package cn.alphahub.dtt.plus.exception;

/**
 * class解析异常
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
