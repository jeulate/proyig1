package MVC.modelo.conector;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexionBD {
    //    private static final String URL = "jdbc:mysql://localhost:3306/IglesiaDB";

    private static final String CONFIG_FILE = "configuracion.properties";

    public static Connection establecerConexion() {
        Connection conexion = null;
        Properties propiedades = new Properties();
        try (FileInputStream entrada = new FileInputStream(CONFIG_FILE)) {
            propiedades.load(entrada);
            String url = propiedades.getProperty("url");
            String usuario = propiedades.getProperty("usuario");
            String contrasena = propiedades.getProperty("contrasena");

            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, contrasena);
//            System.out.println("Conexión establecida con éxito");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al establecer la conexión con la Base de Datos: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo de configuración: " + e.getMessage());
        }
        return conexion;
    }
}
