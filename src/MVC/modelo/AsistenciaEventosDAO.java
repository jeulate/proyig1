package MVC.modelo;

import MVC.modelo.entity.AsistenciaEventos;
import utils.Tablas;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AsistenciaEventosDAO extends BaseDAO<AsistenciaEventos> {
    public void registrarAsistencia(AsistenciaEventos asistenciaEventos) {
        Map<String, Object> campos = new HashMap<>();
        campos.put("miembro_id", asistenciaEventos.getMiembro_id());
        campos.put("evento_id", asistenciaEventos.getEvento_id());
        campos.put("asistio", asistenciaEventos.getAsistio());
        try {
            this.insertar(Tablas.ASISTENCIA_EVENTOS.getTableName(), campos);
        } catch (Exception e) {
            System.err.println("Error al Registrar la asistencia: " + e.getMessage());
        }
    }

    public List<AsistenciaEventos> obtenerAsistencias() throws SQLException {
        List<AsistenciaEventos> asistencias =
                obtenerTodos(
                        Tablas.ASISTENCIA_EVENTOS.getTableName(),
                        rs ->
                                new AsistenciaEventos(
                                        rs.getInt("id"),
                                        rs.getInt("miembro_id"),
                                        rs.getInt("evento_id"),
                                        rs.getBoolean("asistio")
                                        ));

        return asistencias;
    }
}
