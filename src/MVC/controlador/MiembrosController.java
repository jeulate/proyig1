package MVC.controlador;

import MVC.modelo.MiembrosDAO;
import MVC.modelo.entity.Miembros;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MiembrosController {

  private MiembrosDAO miembrosDAO;

  public MiembrosController() {
    this.miembrosDAO = new MiembrosDAO();
  }

  public void registrarNuevoMiembro(Miembros miembro) {
    if (esPersonaValida(miembro)) {
      this.miembrosDAO.agregarMiembro(miembro);
      System.out.println("Registro Exitoso");
    } else {
      System.out.println("Los campos no pueden estar vacios");
      JOptionPane.showMessageDialog(null, "Llena los campos");
    }
  }

  public List<Miembros> obtenerMiembros() {
    try {
      return this.miembrosDAO.obtenerMiembros();
    } catch (SQLException e) {
      System.out.println("Error al obtener los miembros");
      return new ArrayList<Miembros>();
    }
  }

  private boolean esPersonaValida(Miembros miembros) {
    return !miembros.getNombre().isEmpty()
        && !miembros.getApellido().isEmpty()
        && miembros.getFecha_nacimiento() != null
        && miembros.getGenero() != null
        && !miembros.getDireccion().isEmpty()
        && !miembros.getCorreo_electronico().isEmpty()
        && !miembros.getTelefono().isEmpty();
  }
}
