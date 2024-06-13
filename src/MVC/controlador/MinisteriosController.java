package MVC.controlador;

import MVC.modelo.MinisteriosDAO;
import MVC.modelo.entity.Ministerios;
import MVC.modelo.entity.Relaciones;
import MVC.modelo.entity.Cloneable;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MinisteriosController implements Cloneable<Ministerios> {

//    private MinisteriosDAO ministeriosDAO;
    private Ministerios ministerioPrototipo;

    public MinisteriosController() {
//        this.ministeriosDAO = new MinisteriosDAO();
        this.ministerioPrototipo = new Ministerios("Nombre por Defecto", "Descripcion por defecto");
    }
    @Override
    public Ministerios clone(){
        return ministerioPrototipo.clone();
    }
    public void crearMinisterio(Ministerios ministerio) {
        new CrearMinisterio().procesarMinisterio(ministerio);
//        this.ministeriosDAO.agregarMinisterio(ministerio);
//        JOptionPane.showMessageDialog(null, "Ministerio creado exitosamente");
//        System.out.printf("Registro de Ministerio Exitoso");
    }

    public void clonaryCrearMinisterio(){
        Ministerios ministerioclonado = this.clone();
        new CrearMinisterio().procesarMinisterio(ministerioclonado);
//        this.ministeriosDAO.agregarMinisterio(ministerioclonado);
//        JOptionPane.showMessageDialog(null,"Ministerio Clonado y creado Exitosamente");
//        System.out.println("Reistro de Ministerio Clonado Exitoso");
    }

    public void actualizarMinisterio(Ministerios ministerios){
        new ActualizarMinisterio().procesarMinisterio(ministerios);
//            this.ministeriosDAO.actualizarMinisterios(ministerios);
//            JOptionPane.showMessageDialog(null,"Datos del Ministerio Actualizado");
//            System.out.println("Ministerios Actualizado Exitosamente");
    }
    public List<Ministerios> obtenerMinisterios() {
        return new CrearMinisterio().obtenerMinisterios();
//        try {
//            return this.ministeriosDAO.obtenerMinisterios();
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error al obtener los Ministerios");
//            System.out.println("Error al obtener los Ministerios");
//            return new ArrayList<Ministerios>();
//        }
    }
}
