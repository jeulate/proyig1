package MVC.controlador;

import MVC.modelo.ConexionBD;
import MVC.modelo.Miembro;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CMiembrosDAO {
    public void agregarMiembro(Miembro miembro){
        try(Connection conexion  = ConexionBD.establecerConexion()) {
            String query = "INSERT INTO miembros (nombre,apellido,fecha_nacimiento,genero,direccion,correo_electronico,telefono) VALUES (?,?,?,?,?,?,?)";
            try(PreparedStatement statement = conexion.prepareStatement(query)){
                statement.setString(1, miembro.getNombre());
                statement.setString(2, miembro.getApellido());
                statement.setDate(3, new java.sql.Date(miembro.getFnaci().getTime()));
                statement.setString(4,miembro.getGenero());
                statement.setString(5,miembro.getDireccion());
                statement.setString(6,miembro.getEmail());
                statement.setString(7, miembro.getTelefono());

                statement.execute();
                System.out.println("Datos registrados correctamente en la base de datos.");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void cargarDatosenTabla(DefaultTableModel modeloTabla){
        // Obtener la conexión desde la clase ConexionBD
        try (Connection conexion = ConexionBD.establecerConexion()){
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
