package MVC.modelo;

import MVC.modelo.entity.Asignaciones;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import utils.Tablas;

public class AsignacionesDAO extends BaseDAO<Asignaciones> {

  public void agregarAsignacion(Asignaciones asignacion) {
//    Map<String, Object> campos = new HashMap<>();
//    campos.put("nombre", asignacion.getNombre());
//    campos.put("apellido", asignacion.getApellido());
//    campos.put("fecha_nacimiento", asignacion.getFecha_nacimiento());
//    campos.put("genero", asignacion.getGenero());
//    campos.put("direccion", asignacion.getDireccion());
//    campos.put("correo_electronico", asignacion.getCorreo_electronico());
//    campos.put("telefono", asignacion.getTelefono());
//    campos.put("fecha_bautismo", asignacion.getFecha_bautismo());
//    campos.put("asistio_culto", asignacion.getAsistio_culto());
//
//    this.insertar(Tablas.ASIGNACIONES.getTableName(), campos);
  }

  public List<Asignaciones> obtenerAsignaciones() throws SQLException {
    List<Asignaciones> asignaciones = new ArrayList<Asignaciones>();
//        obtenerTodos(
//            Tablas.ASIGNACIONES.getTableName(),
//            rs ->
//                new Asignaciones(
//                    rs.getInt("id"),
//                    rs.getString("nombre"),
//                    rs.getString("apellido"),
//                    rs.getDate("fecha_nacimiento"),
//                    rs.getString("genero"),
//                    rs.getString("direccion"),
//                    rs.getString("correo_electronico"),
//                    rs.getString("telefono"),
//                    rs.getDate("fecha_bautismo"),
//                    rs.getBoolean("asistio_culto")));

    return asignaciones;
  }
}
