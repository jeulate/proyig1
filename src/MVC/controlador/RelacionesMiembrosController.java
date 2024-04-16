package MVC.controlador;

import MVC.modelo.RelacionesDAO;
import MVC.modelo.entity.Miembros;
import MVC.modelo.entity.Relaciones;

import javax.swing.*;
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
    JOptionPane.showMessageDialog(null,"Relacion Creada Exitosamente");
  }

  public List<Relaciones> obtenerRelaciones() {
    try {
      return this.relacionesDAO.obtenerRelaciones();
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null,"Error al obtener las relaciones");
      return new ArrayList<Relaciones>();
    }
  }
}
