package MVC.controlador;

import MVC.modelo.entity.Ministerios;

import javax.swing.*;
import java.sql.SQLException;

public class ActualizarMinisterio extends MinisteriosTemplate {

    @Override
    protected void guardarMinisterio(Ministerios ministerio) throws SQLException {
        this.ministeriosDAO.actualizarMinisterios(ministerio);
    }

    @Override
    protected void mostrarMensajeExito() {
        JOptionPane.showMessageDialog(null, "Datos del Ministerio Actualizados");
        System.out.println("Ministerio Actualizado Exitosamente");
    }
}
