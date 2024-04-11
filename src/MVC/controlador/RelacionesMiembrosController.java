package MVC.controlador;

import MVC.modelo.RelacionesDAO;
import MVC.modelo.entity.Miembros;
import MVC.modelo.entity.Relaciones;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RelacionesMiembrosController {

  private RelacionesDAO relacionesDAO;

  public RelacionesMiembrosController() {
    this.relacionesDAO = new RelacionesDAO();
  }

  public void registrarNuevaRelacionMiembro(Relaciones relaciones) {
    this.relacionesDAO.agregarRelacion(relaciones);
    System.out.println("Registro de Relacion Exitoso");
  }

  public List<Relaciones> obtenerRelaciones() {
    try {
      return this.relacionesDAO.obtenerRelaciones();
    } catch (SQLException e) {
      System.out.println("Error al obtener las relaciones");
      return new ArrayList<Relaciones>();
    }
  }
}
