package cr.ac.ucenfotec.bl.entities;

import java.util.ArrayList;

public class Cliente extends Persona implements Imprimible {

    private String correo;
    private ArrayList<Reserva> listaReservas;

    public Cliente(String nombreCompleto, String identificacion, String telefono, String correo) {
        super(nombreCompleto, identificacion, telefono);
        this.correo = correo;
        this.listaReservas = new ArrayList<>();
    }

    public String getCorreo() {
        return correo;
    }

    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void agregarReserva(Reserva reserva) {
        listaReservas.add(reserva);
    }

    public String mostrarInformacion() {
        return "Cliente: " + getNombreCompleto() +
                " | ID: " + getIdentificacion() +
                " | Teléfono: " + getTelefono() +
                " | Correo: " + correo;
    }

    public String generarResumen() {
        return "Cliente " + getNombreCompleto() + " con " + listaReservas.size() + " reserva(s).";
    }

    public String toString() {
        return mostrarInformacion();
    }
}