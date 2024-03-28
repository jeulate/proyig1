package datos;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class MiembrosDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/iglesiadb";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";

    public void agregarMiembro(Miembros miembros){
        try (Connection conexion = DriverManager.getConnection(URL,USUARIO,CONTRASENA)) {
            String query = "INSERT INTO miembros (nombre,apellido,fecha_nacimiento,genero,direccion,correo_electronico,telefono) VALUES (?,?,?,?,?,?,?)";

            try(PreparedStatement statement = conexion.prepareStatement(query)){
                statement.setString(1, miembros.getNombre());
                statement.setString(2, miembros.getApellido());
                statement.setDate(3, new java.sql.Date(miembros.getFnaci().getTime()));
                statement.setString(4,miembros.getGenero());
                statement.setString(5,miembros.getDireccion());
                statement.setString(6,miembros.getEmail());
                statement.setString(7, miembros.getTelefono());

                statement.execute();
                System.out.println("Datos registrados correctamente en " + URL);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void cargarDatosenTabla(DefaultTableModel modeloTabla){
        try (Connection conexion = DriverManager.getConnection(URL,USUARIO,CONTRASENA)){
            String query = "SELECT id,nombre,apellido,fecha_nacimiento,genero,direccion,correo_electronico,telefono FROM miembros";
            try(PreparedStatement statement = conexion.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()){
                while (resultSet.next()){
                    String id = resultSet.getString("id");
                    String nombre = resultSet.getString("nombre");
                    String apellido = resultSet.getString("apellido");
                    String fecha_nacimiento = resultSet.getString("fecha_nacimiento");
                    String genero = resultSet.getString("genero");
                    String direccion = resultSet.getString("direccion");
                    String email = resultSet.getString("correo_electronico");
                    String telefono = resultSet.getString("telefono");

                    modeloTabla.addRow(new Object[]{
                            id,nombre,apellido,fecha_nacimiento,genero,direccion,email,telefono
                    });
                }
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
