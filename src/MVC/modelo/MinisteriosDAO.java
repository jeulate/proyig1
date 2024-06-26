package MVC.modelo;

import MVC.modelo.entity.Ministerios;
import MVC.modelo.entity.Relaciones;
import utils.Tablas;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinisteriosDAO extends BaseDAO<Ministerios> {
    public void agregarMinisterio(Ministerios ministerios) {
        Map<String, Object> campos = new HashMap<>();
        campos.put("nombre", ministerios.getNombre());
        campos.put("descripcion", ministerios.getDescripcion());

        try {
            this.insertar(Tablas.MINISTERIOS.getTableName(), campos);
        } catch (Exception e) {
            System.err.println("Error al agregar ministerios: " + e.getMessage());
        }
    }

    public List<Ministerios> obtenerMinisterios() throws SQLException {
        List<Ministerios> ministerios =
                obtenerTodos(
                        Tablas.MINISTERIOS.getTableName(),
                        rs ->
                                new Ministerios(
                                        rs.getInt("ID"),
                                        rs.getString("nombre"),
                                        rs.getString("descripcion")));

        return ministerios;
    }
    public void actualizarMinisterios(Ministerios ministerios){
        Map<String, Object> campos = new HashMap<>();
        campos.put("nombre",ministerios.getNombre());
        campos.put("descripcion",ministerios.getDescripcion());
        try {
            this.actualizar(Tablas.MINISTERIOS.getTableName(),campos,"id = " + ministerios.getId());
        }catch (Exception e){
            System.err.println("Error al actualizar ministerios: " + e.getMessage());
        }
    }
}
