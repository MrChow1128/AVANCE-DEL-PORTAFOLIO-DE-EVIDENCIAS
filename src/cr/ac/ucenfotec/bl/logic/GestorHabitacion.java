package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.dao.DAOHabitacion;
import cr.ac.ucenfotec.bl.entities.Habitacion;
import cr.ac.ucenfotec.bl.exceptions.DatoInvalidoException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestorHabitacion {

    public static String registrarHabitacion(int numero, String tipo, double precioPorNoche)
            throws SQLException, IOException, ClassNotFoundException {

        if (numero <= 0) {
            throw new DatoInvalidoException("El número de habitación debe ser mayor que 0.");
        }

        if (tipo == null || tipo.isEmpty()) {
            throw new DatoInvalidoException("El tipo de habitación no puede estar vacío.");
        }

        if (precioPorNoche <= 0) {
            throw new DatoInvalidoException("El precio por noche debe ser mayor que 0.");
        }

        Habitacion habitacionExistente = DAOHabitacion.buscarHabitacionPorNumero(numero);

        if (habitacionExistente != null) {
            throw new DatoInvalidoException("Ya existe una habitación con ese número.");
        }

        Habitacion habitacion = new Habitacion(numero, tipo, precioPorNoche);
        return DAOHabitacion.registrarHabitacion(habitacion);
    }

    public static ArrayList<Habitacion> listarHabitaciones()
            throws SQLException, IOException, ClassNotFoundException {
        return DAOHabitacion.listarHabitaciones();
    }

    public static Habitacion buscarHabitacionPorNumero(int numero)
            throws SQLException, IOException, ClassNotFoundException {
        return DAOHabitacion.buscarHabitacionPorNumero(numero);
    }
}