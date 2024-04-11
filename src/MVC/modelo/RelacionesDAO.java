package MVC.modelo;

import MVC.modelo.entity.Miembros;
import MVC.modelo.entity.Relaciones;
import utils.Tablas;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RelacionesDAO extends BaseDAO<Relaciones> {
    public void agregarRelacion(Relaciones relacion) {
        Map<String, Object> campos = new HashMap<>();
        campos.put("miembro1_id", relacion.getMiembro1_id());
        campos.put("miembro2_id", relacion.getMiembro2_id());
        campos.put("tipo_relacion",relacion.getTipo_relacion());



        this.insertar(Tablas.RELACIONES.getTableName(), campos);
    }
}
