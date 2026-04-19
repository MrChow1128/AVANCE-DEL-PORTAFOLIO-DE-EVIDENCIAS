package cr.ac.ucenfotec.bl.dao;

import cr.ac.ucenfotec.bl.entities.Cliente;
import cr.ac.ucenfotec.bl.entities.Habitacion;
import cr.ac.ucenfotec.bl.entities.Reserva;
import cr.ac.ucenfotec.dl.Conector;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOReserva {

    private static String statement;
    private static String query;

    public static String registrarReserva(Reserva reserva) throws SQLException, IOException, ClassNotFoundException {
        statement = "INSERT INTO t_reservas (codigo_reserva, fecha_entrada, fecha_salida, identificacion_cliente, numero_habitacion, estado) VALUES (?, ?, ?, ?, ?, ?)";
        Conector.getConexion().ejecutarStatement(statement,
                reserva.getCodigoReserva(),
                reserva.getFechaEntrada(),
                reserva.getFechaSalida(),
                reserva.getCliente().getIdentificacion(),
                reserva.getHabitacion().getNumero(),
                reserva.getEstado());

        return "Reserva registrada correctamente.";
    }

    public static ArrayList<Reserva> listarReservas() throws SQLException, IOException, ClassNotFoundException {
        query = "SELECT * FROM t_reservas";
        ResultSet resultado = Conector.getConexion().ejecutarQuery(query);
        ArrayList<Reserva> reservas = new ArrayList<>();

        while (resultado.next()) {
            Cliente cliente = DAOCliente.buscarClientePorIdentificacion(resultado.getString("identificacion_cliente"));
            Habitacion habitacion = DAOHabitacion.buscarHabitacionPorNumero(resultado.getInt("numero_habitacion"));

            if (cliente != null && habitacion != null) {
                Reserva reserva = new Reserva(
                        resultado.getString("codigo_reserva"),
                        resultado.getString("fecha_entrada"),
                        resultado.getString("fecha_salida"),
                        cliente,
                        habitacion
                );

                if (resultado.getString("estado").equals("Cancelada")) {
                    reserva.cancelarReserva();
                }

                reservas.add(reserva);
            }
        }

        return reservas;
    }

    public static Reserva buscarReservaPorCodigo(String codigoReserva) throws SQLException, IOException, ClassNotFoundException {
        query = "SELECT * FROM t_reservas WHERE codigo_reserva = ?";
        ResultSet resultado = Conector.getConexion().ejecutarQuery(query, codigoReserva);

        if (!resultado.next()) {
            return null;
        }

        Cliente cliente = DAOCliente.buscarClientePorIdentificacion(resultado.getString("identificacion_cliente"));
        Habitacion habitacion = DAOHabitacion.buscarHabitacionPorNumero(resultado.getInt("numero_habitacion"));

        if (cliente == null || habitacion == null) {
            return null;
        }

        Reserva reserva = new Reserva(
                resultado.getString("codigo_reserva"),
                resultado.getString("fecha_entrada"),
                resultado.getString("fecha_salida"),
                cliente,
                habitacion
        );

        if (resultado.getString("estado").equals("Cancelada")) {
            reserva.cancelarReserva();
        }

        return reserva;
    }

    public static void actualizarEstadoReserva(String estado, String codigoReserva) throws SQLException, IOException, ClassNotFoundException {
        statement = "UPDATE t_reservas SET estado = ? WHERE codigo_reserva = ?";
        Conector.getConexion().ejecutarStatement(statement, estado, codigoReserva);
    }
}