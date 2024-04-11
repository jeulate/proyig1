package MVC.controlador;

import MVC.modelo.*;
import MVC.modelo.entity.AsistenciaEventos;

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
}
