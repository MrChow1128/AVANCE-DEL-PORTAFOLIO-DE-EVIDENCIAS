package cr.ac.ucenfotec.bl.entities;

public abstract class Persona {

    private String nombreCompleto;
    private String identificacion;
    private String telefono;

    public Persona(String nombreCompleto, String identificacion, String telefono) {
        this.nombreCompleto = nombreCompleto;
        this.identificacion = identificacion;
        this.telefono = telefono;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public abstract String mostrarInformacion();
}