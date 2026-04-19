package cr.ac.ucenfotec.bl.entities;

import java.util.ArrayList;

public class SistemaReservas {

    private ArrayList<Cliente> listaClientes;
    private ArrayList<Habitacion> listaHabitaciones;
    private ArrayList<Reserva> listaReservas;

    public SistemaReservas() {
        this.listaClientes = new ArrayList<>();
        this.listaHabitaciones = new ArrayList<>();
        this.listaReservas = new ArrayList<>();
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public ArrayList<Habitacion> getListaHabitaciones() {
        return listaHabitaciones;
    }

    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void agregarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public void agregarHabitacion(Habitacion habitacion) {
        listaHabitaciones.add(habitacion);
    }

    public void agregarReserva(Reserva reserva) {
        listaReservas.add(reserva);
    }
}