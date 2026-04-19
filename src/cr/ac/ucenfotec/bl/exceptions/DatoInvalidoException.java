package cr.ac.ucenfotec.bl.exceptions;

public class DatoInvalidoException extends RuntimeException {

    public DatoInvalidoException(String mensaje) {
        super(mensaje);
    }
}