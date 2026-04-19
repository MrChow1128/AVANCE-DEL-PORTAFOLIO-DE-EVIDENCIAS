package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.dao.DAOHabitacion;
import cr.ac.ucenfotec.bl.dao.DAOReserva;
import cr.ac.ucenfotec.bl.entities.Cliente;
import cr.ac.ucenfotec.bl.entities.Habitacion;
import cr.ac.ucenfotec.bl.entities.Reserva;
import cr.ac.ucenfotec.bl.exceptions.ClienteNoEncontradoException;
import cr.ac.ucenfotec.bl.exceptions.DatoInvalidoException;
import cr.ac.ucenfotec.bl.exceptions.HabitacionNoDisponibleException;
import cr.ac.ucenfotec.bl.exceptions.ReservaNoEncontradaException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestorReserva {

    public static String registrarReserva(String codigoReserva, String fechaEntrada, String fechaSalida,
                                          String identificacionCliente, int numeroHabitacion)
            throws SQLException, IOException, ClassNotFoundException {

        if (codigoReserva == null || codigoReserva.isEmpty()) {
            throw new DatoInvalidoException("El código de reserva no puede estar vacío.");
        }

        if (fechaEntrada == null || fechaEntrada.isEmpty()) {
            throw new DatoInvalidoException("La fecha de entrada no puede estar vacía.");
        }

        if (fechaSalida == null || fechaSalida.isEmpty()) {
            throw new DatoInvalidoException("La fecha de salida no puede estar vacía.");
        }

        Cliente cliente = GestorCliente.buscarClientePorIdentificacion(identificacionCliente);

        if (cliente == null) {
            throw new ClienteNoEncontradoException("No se encontró un cliente con esa identificación.");
        }

        Habitacion habitacion = GestorHabitacion.buscarHabitacionPorNumero(numeroHabitacion);

        if (habitacion == null) {
            throw new HabitacionNoDisponibleException("La habitación indicada no existe.");
        }

        if (!habitacion.isDisponible()) {
            throw new HabitacionNoDisponibleException("La habitación no está disponible.");
        }

        Reserva reservaExistente = DAOReserva.buscarReservaPorCodigo(codigoReserva);

        if (reservaExistente != null) {
            throw new DatoInvalidoException("Ya existe una reserva con ese código.");
        }

        habitacion.reservar();
        DAOHabitacion.actualizarDisponibilidad(false, numeroHabitacion);

        Reserva reserva = new Reserva(codigoReserva, fechaEntrada, fechaSalida, cliente, habitacion);
        cliente.agregarReserva(reserva);

        return DAOReserva.registrarReserva(reserva);
    }

    public static ArrayList<Reserva> listarReservas()
            throws SQLException, IOException, ClassNotFoundException {
        return DAOReserva.listarReservas();
    }

    public static String cancelarReserva(String codigoReserva)
            throws SQLException, IOException, ClassNotFoundException {

        Reserva reserva = DAOReserva.buscarReservaPorCodigo(codigoReserva);

        if (reserva == null) {
            throw new ReservaNoEncontradaException("No existe una reserva con ese código.");
        }

        reserva.cancelarReserva();

        DAOReserva.actualizarEstadoReserva("Cancelada", codigoReserva);
        DAOHabitacion.actualizarDisponibilidad(true, reserva.getHabitacion().getNumero());

        return "Reserva cancelada correctamente.";
    }
}