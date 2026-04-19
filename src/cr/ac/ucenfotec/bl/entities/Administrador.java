package cr.ac.ucenfotec.bl.entities;

public class Administrador extends Persona {

    private String codigoAcceso;

    public Administrador(String nombreCompleto, String identificacion, String telefono, String codigoAcceso) {
        super(nombreCompleto, identificacion, telefono);
        this.codigoAcceso = codigoAcceso;
    }

    public String getCodigoAcceso() {
        return codigoAcceso;
    }

    public void setCodigoAcceso(String codigoAcceso) {
        this.codigoAcceso = codigoAcceso;
    }

    public boolean validarAcceso(String codigoIngresado) {
        return codigoAcceso.equals(codigoIngresado);
    }

    public String mostrarInformacion() {
        return "Administrador: " + getNombreCompleto() +
                " | ID: " + getIdentificacion() +
                " | Teléfono: " + getTelefono();
    }

    public String toString() {
        return mostrarInformacion();
    }
}