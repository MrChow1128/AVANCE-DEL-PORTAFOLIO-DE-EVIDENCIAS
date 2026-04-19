package cr.ac.ucenfotec.bl.dao;

import cr.ac.ucenfotec.bl.entities.Habitacion;
import cr.ac.ucenfotec.dl.Conector;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOHabitacion {

    private static String statement;
    private static String query;

    public static String registrarHabitacion(Habitacion habitacion) throws SQLException, IOException, ClassNotFoundException {
        statement = "INSERT INTO t_habitaciones (numero, tipo, precio_por_noche, disponible) VALUES (?, ?, ?, ?)";
        Conector.getConexion().ejecutarStatement(statement,
                habitacion.getNumero(),
                habitacion.getTipo(),
                habitacion.getPrecioPorNoche(),
                habitacion.isDisponible());

        return "Habitación registrada correctamente.";
    }

    public static ArrayList<Habitacion> listarHabitaciones() throws SQLException, IOException, ClassNotFoundException {
        query = "SELECT * FROM t_habitaciones";
        ResultSet resultado = Conector.getConexion().ejecutarQuery(query);
        ArrayList<Habitacion> habitaciones = new ArrayList<>();

        while (resultado.next()) {
            Habitacion habitacion = new Habitacion(
                    resultado.getInt("numero"),
                    resultado.getString("tipo"),
                    resultado.getDouble("precio_por_noche")
            );

            if (!resultado.getBoolean("disponible")) {
                habitacion.reservar();
            }

            habitaciones.add(habitacion);
        }

        return habitaciones;
    }

    public static Habitacion buscarHabitacionPorNumero(int numero) throws SQLException, IOException, ClassNotFoundException {
        query = "SELECT * FROM t_habitaciones WHERE numero = ?";
        ResultSet resultado = Conector.getConexion().ejecutarQuery(query, numero);

        if (!resultado.next()) {
            return null;
        }

        Habitacion habitacion = new Habitacion(
                resultado.getInt("numero"),
                resultado.getString("tipo"),
                resultado.getDouble("precio_por_noche")
        );

        if (!resultado.getBoolean("disponible")) {
            habitacion.reservar();
        }

        return habitacion;
    }

    public static void actualizarDisponibilidad(boolean disponible, int numero) throws SQLException, IOException, ClassNotFoundException {
        statement = "UPDATE t_habitaciones SET disponible = ? WHERE numero = ?";
        Conector.getConexion().ejecutarStatement(statement, disponible, numero);
    }
}