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
    private Ministerios ministerioPrototipo;

    public MinisteriosController() {
        this.ministeriosDAO = new MinisteriosDAO();
        this.ministerioPrototipo = new Ministerios("Musical", "Instrumentistas, Coro, Vocalistas");
    }
    public Ministerios getPrototipoMinisterio() {
        return ministerioPrototipo.clone();
    }
    public void crearMinisterio(Ministerios ministerio) {
//        Ministerios nuevoMinisterio = ministerioPrototipo.clone();
//        nuevoMinisterio.setNombre(ministerio.getNombre());
//        nuevoMinisterio.setDescripcion(ministerio.getDescripcion());

//        this.ministeriosDAO.agregarMinisterio(nuevoMinisterio);
        this.ministeriosDAO.agregarMinisterio(ministerio);
        JOptionPane.showMessageDialog(null, "Ministerio creado exitosamente");
        System.out.printf("Registro de Ministerio Exitoso");

//    this.ministeriosDAO.agregarMinisterio(ministerio);

    }

    public List<Ministerios> obtenerMinisterios() {
        try {
            return this.ministeriosDAO.obtenerMinisterios();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los Ministerios");
            System.out.println("Error al obtener los Ministerios");
            return new ArrayList<Ministerios>();
        }
    }
}
