package MVC.controlador;

import MVC.modelo.*;
import MVC.modelo.entity.AsistenciaEventos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParticipacionEventosController {
  private AsistenciaEventosDAO asistenciaEventosDAO;
  private MiembrosDAO miembrosDAO;
  private EventosIglesiaDAO eventosIglesiaDAO;

  public ParticipacionEventosController() {
    this.asistenciaEventosDAO = new AsistenciaEventosDAO();
    this.miembrosDAO = new MiembrosDAO();
    this.eventosIglesiaDAO = new EventosIglesiaDAO();
  }

  public void registrarAsistencia(AsistenciaEventos asistenciaEventos){
    this.asistenciaEventosDAO.registrarAsistencia(asistenciaEventos);
    System.out.println("Asistencia registrada al servicio "+ asistenciaEventos.getEvento_id());
  }

  public List<AsistenciaEventos> obtenerAsistencias() {
    try {
      return this.asistenciaEventosDAO.obtenerAsistencias();
    } catch (SQLException e) {
      System.out.println("Error al obtener los Eventos de la Iglesia");
      return new ArrayList<AsistenciaEventos>();
    }
  }
}
