package MVC.modelo;

import java.sql.*;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/IglesiaDB";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";
    private static Connection conexion = null;

    public static Connection establecerConexion() {
        if (conexion == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
                System.out.println("Conexion establecida con exito");
            } catch (ClassNotFoundException e) {
                System.out.println("Error al cargar el driver JDBC: " + e.getMessage());
            } catch (SQLException e) {
                System.out.println("Error al establecer la conexion con la Base de Datos: " + e.getMessage());
            }
        }
        return conexion;
    }
}
