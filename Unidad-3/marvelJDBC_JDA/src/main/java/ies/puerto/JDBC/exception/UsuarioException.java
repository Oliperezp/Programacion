package ies.puerto.JDBC.exception;

public class UsuarioException extends Exception{

    public UsuarioException(String message) {
        super(message);
    }

    public UsuarioException(String message, Throwable tipo) {
        super(message,tipo);
    }


}
