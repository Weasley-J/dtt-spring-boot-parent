package cn.alphahub.dtt.plus.util.exception;

/**
 * Util exception
 */
@SuppressWarnings("serial")
public class UtilException extends RuntimeException {

    public UtilException() {
        super();
    }

    public UtilException(String message) {
        super(message);
    }

    public UtilException(String message, Throwable cause) {
        super(message, cause);
    }
}
