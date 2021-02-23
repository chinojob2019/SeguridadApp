package pe.com.distriluz.data.exception;


public class ErrorException extends Exception {

    public ErrorException() {
        super();
    }

    public ErrorException(final String message) {
        super(message);
    }

    public ErrorException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ErrorException(final Throwable cause) {
        super(cause);
    }
}