package pe.com.distriluz.data.exception;


import pe.com.distriluz.data.utiles.Constantes;

public class NetworkConnectionException extends Exception {

    public NetworkConnectionException() {
        super(Constantes.ERROR_CONEXION_INTERNET);
    }

    public NetworkConnectionException(final String message) {
        super(message);
    }

    public NetworkConnectionException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public NetworkConnectionException(final Throwable cause) {
        super(cause);
    }
}