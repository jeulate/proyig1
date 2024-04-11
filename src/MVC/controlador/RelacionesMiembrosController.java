package MVC.controlador;

import MVC.modelo.RelacionesDAO;
import MVC.modelo.entity.Relaciones;

public class RelacionesMiembrosController {


  private RelacionesDAO relacionesDAO;

  public RelacionesMiembrosController() {
    this.relacionesDAO = new RelacionesDAO();
  }

  public void registrarNuevaRelacionMiembro(Relaciones relaciones) {
    this.relacionesDAO.agregarRelacion(relaciones);
    System.out.println("Registro Exitoso");
  }
}
