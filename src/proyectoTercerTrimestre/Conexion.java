package proyectoTercerTrimestre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion{
    private static final String URL = "jdbc:mysql://localhost/proyecto";
    private static final String USER = "root";
    private static final String PASSWORD = "123456789";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}