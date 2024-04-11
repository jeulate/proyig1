package MVC.modelo;

import MVC.modelo.entity.AsistenciaEventos;
import utils.Tablas;

import java.util.HashMap;
import java.util.Map;

public class AsistenciaEventosDAO extends BaseDAO<AsistenciaEventos>{
    public void registrarAsistencia(AsistenciaEventos asistenciaEventos){
        Map<String, Object> campos = new HashMap<>();
        campos.put("miembro_id", asistenciaEventos.getMiembro_id());
        campos.put("evento_id", asistenciaEventos.getEvento_id());
        campos.put("asistio", asistenciaEventos.getAsistio());


        this.insertar(Tablas.ASISTENCIA_EVENTOS.getTableName(), campos);
    }
}
