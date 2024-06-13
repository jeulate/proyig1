package MVC.controlador;

import MVC.modelo.MinisteriosDAO;
import MVC.modelo.entity.Ministerios;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class MinisteriosTemplate {
    protected MinisteriosDAO ministeriosDAO;

    public MinisteriosTemplate() {
        this.ministeriosDAO = new MinisteriosDAO();
    }
    public void procesarMinisterio(Ministerios ministerio){
        try {
            guardarMinisterio(ministerio);
            mostrarMensajeExito();
        }catch (Exception e){
            mostrarMensajeError(e);
        }
    }
    protected abstract void guardarMinisterio(Ministerios ministerio) throws SQLException;

    protected abstract void mostrarMensajeExito();

    protected void mostrarMensajeError(Exception e){
        JOptionPane.showMessageDialog(null, "Error al procesar el ministerio: " + e.getMessage());
        System.out.println("Error al procesar el ministerio: " + e.getMessage());
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
