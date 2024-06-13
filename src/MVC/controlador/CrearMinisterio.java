package MVC.controlador;

import MVC.modelo.entity.Ministerios;

import javax.swing.*;
import java.sql.SQLException;

public class CrearMinisterio extends MinisteriosTemplate{

    @Override
    protected void guardarMinisterio(Ministerios ministerio) throws SQLException {
        this.ministeriosDAO.agregarMinisterio(ministerio);
    }

    @Override
    protected void mostrarMensajeExito() {
        JOptionPane.showMessageDialog(null,"Ministerio Creado exitosamente");
    }
}

