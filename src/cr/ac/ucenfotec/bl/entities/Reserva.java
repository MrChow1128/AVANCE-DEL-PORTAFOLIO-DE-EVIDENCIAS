package cr.ac.ucenfotec.bl.entities;

public class Reserva implements Imprimible {

    private String codigoReserva;
    private String fechaEntrada;
    private String fechaSalida;
    private Cliente cliente;
    private Habitacion habitacion;
    private String estado;

    public Reserva(String codigoReserva, String fechaEntrada, String fechaSalida, Cliente cliente, Habitacion habitacion) {
        this.codigoReserva = codigoReserva;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.estado = "Activa";
    }

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public void cancelarReserva() {
        this.estado = "Cancelada";
        this.habitacion.liberar();
    }

    public String generarResumen() {
        return "Reserva: " + codigoReserva +
                " | Cliente: " + cliente.getNombreCompleto() +
                " | Habitación: " + habitacion.getNumero() +
                " | Entrada: " + fechaEntrada +
                " | Salida: " + fechaSalida +
                " | Estado: " + estado;
    }

    public String toString() {
        return generarResumen();
    }
}