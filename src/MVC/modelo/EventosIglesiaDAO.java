package MVC.modelo;

import MVC.modelo.entity.EventosIglesia;
import MVC.modelo.entity.Miembros;
import utils.Tablas;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventosIglesiaDAO extends BaseDAO<EventosIglesia> {
    public void crearEventoIglesia(EventosIglesia eventosIglesia) {
        Map<String, Object> campos = new HashMap<>();
        campos.put("nombre_evento", eventosIglesia.getNombre_evento());
        campos.put("descripcion", eventosIglesia.getDescripcion());
        campos.put("fecha_evento", eventosIglesia.getFecha_evento());
        campos.put("tipo_evento", eventosIglesia.getTipo_evento());

        try {
            this.insertar(Tablas.EVENTOS_IGLESIA.getTableName(), campos);

        } catch (Exception e) {
            System.err.println("Error al crear Evento: " + e.getMessage());
        }
    }

    public List<EventosIglesia> obtenerEventosIglesia() throws SQLException {
        List<EventosIglesia> eventosIglesia =
                obtenerTodos(
                        Tablas.EVENTOS_IGLESIA.getTableName(),
                        rs ->
                                new EventosIglesia(
                                        rs.getInt("id"),
                                        rs.getString("nombre_evento"),
                                        rs.getString("descripcion"),
                                        rs.getDate("fecha_evento"),
                                        rs.getString("tipo_evento")));

        return eventosIglesia;
    }
}
