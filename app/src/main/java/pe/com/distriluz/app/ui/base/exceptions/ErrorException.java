package pe.com.distriluz.app.ui.base.exceptions;


public class ErrorException extends Exception {
    private int code;

    public ErrorException() {
        super();
    }

    public ErrorException(final String message) {
        super(message);
    }
    public ErrorException(final int code , final String message) {
        super(message);
        this.code=code;
    }

    public int getCode() {
        return code;
    }

    public ErrorException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ErrorException(final Throwable cause) {
        super(cause);
    }

    public boolean isTokenValid(){
        return code !=83 && code !=84 && code!=85;
    }
}