package MVC.modelo;

import MVC.modelo.conector.ConexionBD;
import MVC.modelo.entity.Miembros;
import utils.Tablas;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MiembrosDAO extends BaseDAO<Miembros> {

  public void agregarMiembro(Miembros miembros) {
    Map<String, Object> campos = new HashMap<>();
    campos.put("nombre", miembros.getNombre());
    campos.put("apellido", miembros.getApellido());
    campos.put("fecha_nacimiento", miembros.getFecha_nacimiento());
    campos.put("genero", miembros.getGenero());
    campos.put("direccion", miembros.getDireccion());
    campos.put("correo_electronico", miembros.getCorreo_electronico());
    campos.put("telefono", miembros.getTelefono());
    campos.put("fecha_bautismo", miembros.getFecha_bautismo());
    campos.put("asistio_culto", miembros.getAsistio_culto());

    this.insertar(Tablas.MIEMBROS.getTableName(), campos);
  }

  //    public void agregarMiembro(Miembros miembros){
  //        try(Connection conexion  = ConexionBD.establecerConexion()) {
  //            String query = "INSERT INTO miembros
  // (nombre,apellido,fecha_nacimiento,genero,direccion,correo_electronico,telefono) VALUES
  // (?,?,?,?,?,?,?)";
  //            try(PreparedStatement statement = conexion.prepareStatement(query)){
  //                statement.setString(1, miembros.getNombre());
  //                statement.setString(2, miembros.getApellido());
  //                statement.setDate(3, new java.sql.Date(miembros.getFnaci().getTime()));
  //                statement.setString(4, miembros.getGenero());
  //                statement.setString(5, miembros.getDireccion());
  //                statement.setString(6, miembros.getEmail());
  //                statement.setString(7, miembros.getTelefono());
  //
  //                statement.execute();
  //                System.out.println("Datos registrados correctamente en la base de datos.");
  //            }
  //        }catch (SQLException e){
  //            e.printStackTrace();
  //        }
  //    }
  public void cargarDatosenTabla(DefaultTableModel modeloTabla) {
    // Obtener la conexión desde la clase ConexionBD
    try (Connection conexion = ConexionBD.establecerConexion()) {
      String query =
          "SELECT id,nombre,apellido,fecha_nacimiento,genero,direccion,correo_electronico,telefono FROM miembros";
      try (PreparedStatement statement = conexion.prepareStatement(query);
          ResultSet resultSet = statement.executeQuery()) {
        while (resultSet.next()) {
          String id = resultSet.getString("id");
          String nombre = resultSet.getString("nombre");
          String apellido = resultSet.getString("apellido");
          String fecha_nacimiento = resultSet.getString("fecha_nacimiento");
          String genero = resultSet.getString("genero");
          String direccion = resultSet.getString("direccion");
          String email = resultSet.getString("correo_electronico");
          String telefono = resultSet.getString("telefono");

          modeloTabla.addRow(
              new Object[] {
                id, nombre, apellido, fecha_nacimiento, genero, direccion, email, telefono
              });
        }
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public List<Miembros> obtenerMiembros() throws SQLException {
    List<Miembros> miembros =
        obtenerTodos(
            Tablas.MIEMBROS.getTableName(),
            rs ->
                new Miembros(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getDate("fecha_nacimiento"),
                    rs.getString("genero"),
                    rs.getString("direccion"),
                    rs.getString("correo_electronico"),
                    rs.getString("telefono"),
                    rs.getDate("fecha_bautismo"),
                    rs.getBoolean("asistio_culto")));

    return miembros;
  }
}
