package cr.ac.ucenfotec.bl.exceptions;

public class ClienteNoEncontradoException extends RuntimeException {

    public ClienteNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}