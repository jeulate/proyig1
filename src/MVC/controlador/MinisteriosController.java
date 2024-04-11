package MVC.controlador;

import MVC.modelo.MinisteriosDAO;
import MVC.modelo.entity.Ministerios;
import MVC.modelo.entity.Relaciones;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MinisteriosController {

  private MinisteriosDAO ministeriosDAO;

  public MinisteriosController() {
    this.ministeriosDAO = new MinisteriosDAO();
  }

  public void crearMinisterio(Ministerios ministerio) {
    this.ministeriosDAO.agregarMinisterio(ministerio);
    JOptionPane.showMessageDialog(null,"Ministerio creado exitosamente");
    System.out.printf("Registro de Ministerio Exitoso");
  }

  public List<Ministerios> obtenerMinisterios() {
    try {
      return this.ministeriosDAO.obtenerMinisterios();
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null,"Error al obtener los Ministerios");
      System.out.println("Error al obtener los Ministerios");
      return new ArrayList<Ministerios>();
    }
  }
}
