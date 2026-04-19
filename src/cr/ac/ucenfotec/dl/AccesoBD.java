package cr.ac.ucenfotec.dl;

import java.sql.*;

public class AccesoBD {

    private Connection conexion;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public AccesoBD(String direccion, String usuario, String contrasenia) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexion = DriverManager.getConnection(direccion, usuario, contrasenia);
    }


    public void ejecutarStatement(String statement) throws SQLException {
        this.statement = conexion.createStatement();
        this.statement.executeUpdate(statement);
    }

    public void ejecutarStatement(String statement, String s1, String s2) throws SQLException {
        preparedStatement = conexion.prepareStatement(statement);
        preparedStatement.setString(1, s1);
        preparedStatement.setString(2, s2);
        preparedStatement.executeUpdate();
    }


    public void ejecutarStatement(String statement, String s1, String s2, String s3, String s4, int i, String s5) throws SQLException {
        preparedStatement = conexion.prepareStatement(statement);
        preparedStatement.setString(1, s1);
        preparedStatement.setString(2, s2);
        preparedStatement.setString(3, s3);
        preparedStatement.setString(4, s4);
        preparedStatement.setInt(5, i);
        preparedStatement.setString(6, s5);
        preparedStatement.executeUpdate();
    }

    public void ejecutarStatement(String statement, String s1, String s2, String s3, String s4) throws SQLException {
        preparedStatement = conexion.prepareStatement(statement);
        preparedStatement.setString(1, s1);
        preparedStatement.setString(2, s2);
        preparedStatement.setString(3, s3);
        preparedStatement.setString(4, s4);
        preparedStatement.executeUpdate();
    }

    public void ejecutarStatement(String statement, int i, String s, double d, boolean b) throws SQLException {
        preparedStatement = conexion.prepareStatement(statement);
        preparedStatement.setInt(1, i);
        preparedStatement.setString(2, s);
        preparedStatement.setDouble(3, d);
        preparedStatement.setBoolean(4, b);
        preparedStatement.executeUpdate();
    }

    public void ejecutarStatement(String statement, String s1, String s2, String s3, int i, String s4) throws SQLException {
        preparedStatement = conexion.prepareStatement(statement);
        preparedStatement.setString(1, s1);
        preparedStatement.setString(2, s2);
        preparedStatement.setString(3, s3);
        preparedStatement.setInt(4, i);
        preparedStatement.setString(5, s4);
        preparedStatement.executeUpdate();
    }

    public void ejecutarStatement(String statement, boolean b, int i) throws SQLException {
        preparedStatement = conexion.prepareStatement(statement);
        preparedStatement.setBoolean(1, b);
        preparedStatement.setInt(2, i);
        preparedStatement.executeUpdate();
    }

    public void ejecutarStatement(String statement, String s) throws SQLException {
        preparedStatement = conexion.prepareStatement(statement);
        preparedStatement.setString(1, s);
        preparedStatement.executeUpdate();
    }

    public ResultSet ejecutarQuery(String query) throws SQLException {
        preparedStatement = conexion.prepareStatement(query);
        return preparedStatement.executeQuery();
    }

    public ResultSet ejecutarQuery(String query, String s) throws SQLException {
        preparedStatement = conexion.prepareStatement(query);
        preparedStatement.setString(1, s);
        return preparedStatement.executeQuery();
    }

    public ResultSet ejecutarQuery(String query, int i) throws SQLException {
        preparedStatement = conexion.prepareStatement(query);
        preparedStatement.setInt(1, i);
        return preparedStatement.executeQuery();
    }
}