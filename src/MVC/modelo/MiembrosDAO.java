package MVC.modelo;

import MVC.modelo.entity.Miembros;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import utils.Tablas;

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

  public Miembros obtenerMiembro(int id) throws SQLException {
    Miembros miembro =
        this.obtener(
            Tablas.MIEMBROS.getTableName(),
            "id = " + id,
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

    return miembro;
  }

  public void actualizarMiembro(Miembros miembros) {
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

    this.actualizar(Tablas.MIEMBROS.getTableName(), campos, "id = " + miembros.getId());
  }
}
