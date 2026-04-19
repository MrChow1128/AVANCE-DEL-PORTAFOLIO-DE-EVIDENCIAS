package cr.ac.ucenfotec.tl;

import cr.ac.ucenfotec.bl.entities.Cliente;
import cr.ac.ucenfotec.bl.entities.Habitacion;
import cr.ac.ucenfotec.bl.entities.Reserva;
import cr.ac.ucenfotec.bl.logic.GestorCliente;
import cr.ac.ucenfotec.bl.logic.GestorHabitacion;
import cr.ac.ucenfotec.bl.logic.GestorReserva;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Controlador {

    public static String registrarCliente(String nombreCompleto, String identificacion, String telefono, String correo)
            throws SQLException, IOException, ClassNotFoundException {
        return GestorCliente.registrarCliente(nombreCompleto, identificacion, telefono, correo);
    }

    public static ArrayList<Cliente> listarClientes()
            throws SQLException, IOException, ClassNotFoundException {
        return GestorCliente.listarClientes();
    }

    public static String registrarHabitacion(int numero, String tipo, double precioPorNoche)
            throws SQLException, IOException, ClassNotFoundException {
        return GestorHabitacion.registrarHabitacion(numero, tipo, precioPorNoche);
    }

    public static ArrayList<Habitacion> listarHabitaciones()
            throws SQLException, IOException, ClassNotFoundException {
        return GestorHabitacion.listarHabitaciones();
    }

    public static String registrarReserva(String codigoReserva, String fechaEntrada, String fechaSalida,
                                          String identificacionCliente, int numeroHabitacion)
            throws SQLException, IOException, ClassNotFoundException {
        return GestorReserva.registrarReserva(codigoReserva, fechaEntrada, fechaSalida, identificacionCliente, numeroHabitacion);
    }

    public static ArrayList<Reserva> listarReservas()
            throws SQLException, IOException, ClassNotFoundException {
        return GestorReserva.listarReservas();
    }

    public static String cancelarReserva(String codigoReserva)
            throws SQLException, IOException, ClassNotFoundException {
        return GestorReserva.cancelarReserva(codigoReserva);
    }
}