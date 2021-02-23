package pe.com.distriluz.data.exception;


import pe.com.distriluz.data.utiles.Constantes;

public class TokenException extends Exception {

    public TokenException() {
        super(Constantes.ERROR_CONEXION_INTERNET);
    }

    public TokenException(final String message) {
        super(message);
    }

    public TokenException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public TokenException(final Throwable cause) {
        super(cause);
    }
}