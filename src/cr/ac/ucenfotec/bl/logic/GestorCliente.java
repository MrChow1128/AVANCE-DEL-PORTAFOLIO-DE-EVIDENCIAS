package cr.ac.ucenfotec.bl.logic;

import cr.ac.ucenfotec.bl.dao.DAOCliente;
import cr.ac.ucenfotec.bl.entities.Cliente;
import cr.ac.ucenfotec.bl.exceptions.DatoInvalidoException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestorCliente {

    public static String registrarCliente(String nombreCompleto, String identificacion, String telefono, String correo)
            throws SQLException, IOException, ClassNotFoundException {

        if (nombreCompleto == null || nombreCompleto.isEmpty()) {
            throw new DatoInvalidoException("El nombre completo no puede estar vacío.");
        }

        if (identificacion == null || identificacion.isEmpty()) {
            throw new DatoInvalidoException("La identificación no puede estar vacía.");
        }

        Cliente clienteExistente = DAOCliente.buscarClientePorIdentificacion(identificacion);

        if (clienteExistente != null) {
            throw new DatoInvalidoException("Ya existe un cliente con esa identificación.");
        }

        Cliente cliente = new Cliente(nombreCompleto, identificacion, telefono, correo);
        return DAOCliente.registrarCliente(cliente);
    }

    public static ArrayList<Cliente> listarClientes()
            throws SQLException, IOException, ClassNotFoundException {
        return DAOCliente.listarClientes();
    }

    public static Cliente buscarClientePorIdentificacion(String identificacion)
            throws SQLException, IOException, ClassNotFoundException {
        return DAOCliente.buscarClientePorIdentificacion(identificacion);
    }
}