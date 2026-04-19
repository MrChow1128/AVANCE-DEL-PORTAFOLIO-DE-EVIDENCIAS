package cr.ac.ucenfotec.bl.dao;

import cr.ac.ucenfotec.bl.entities.Cliente;
import cr.ac.ucenfotec.dl.Conector;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOCliente {

    private static String statement;
    private static String query;

    public static String registrarCliente(Cliente cliente) throws SQLException, IOException, ClassNotFoundException {
        statement = "INSERT INTO t_clientes (identificacion, nombre_completo, telefono, correo) VALUES (?, ?, ?, ?)";
        Conector.getConexion().ejecutarStatement(statement,
                cliente.getIdentificacion(),
                cliente.getNombreCompleto(),
                cliente.getTelefono(),
                cliente.getCorreo());

        return "Cliente registrado correctamente.";
    }

    public static ArrayList<Cliente> listarClientes() throws SQLException, IOException, ClassNotFoundException {
        query = "SELECT * FROM t_clientes";
        ResultSet resultado = Conector.getConexion().ejecutarQuery(query);
        ArrayList<Cliente> clientes = new ArrayList<>();

        while (resultado.next()) {
            Cliente cliente = new Cliente(
                    resultado.getString("nombre_completo"),
                    resultado.getString("identificacion"),
                    resultado.getString("telefono"),
                    resultado.getString("correo")
            );
            clientes.add(cliente);
        }

        return clientes;
    }

    public static Cliente buscarClientePorIdentificacion(String identificacion) throws SQLException, IOException, ClassNotFoundException {
        query = "SELECT * FROM t_clientes WHERE identificacion = ?";
        ResultSet resultado = Conector.getConexion().ejecutarQuery(query, identificacion);

        if (!resultado.next()) {
            return null;
        }

        return new Cliente(
                resultado.getString("nombre_completo"),
                resultado.getString("identificacion"),
                resultado.getString("telefono"),
                resultado.getString("correo")
        );
    }
}