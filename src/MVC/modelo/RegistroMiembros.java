package MVC.modelo;

import MVC.controlador.CMiembrosDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class RegistroMiembros {
    private CMiembrosDAO cMiembrosDAO;

    public RegistroMiembros(CMiembrosDAO cMiembrosDAO) {
        this.cMiembrosDAO = cMiembrosDAO;
    }
    public void registrarMiembro(Miembros miembros){
        if (esPersonaValida(miembros)) {
            cMiembrosDAO.agregarMiembro(miembros);
            System.out.println("Registro Exitoso");
        } else{
            System.out.println("Los campos no pueden estar vacios");
            JOptionPane.showMessageDialog(null,"Llena los campos");
        }
    }

    public void cargarDatosenTabla(DefaultTableModel modeloTabla){
        cMiembrosDAO.cargarDatosenTabla(modeloTabla);
    }
    private boolean esPersonaValida(Miembros miembros) {
        return !miembros.getNombre().isEmpty() &&
                !miembros.getApellido().isEmpty() &&
                miembros.getFnaci() != null &&
                miembros.getGenero() != null  &&
                !miembros.getDireccion().isEmpty() &&
                !miembros.getEmail().isEmpty() &&
                !miembros.getTelefono().isEmpty();
    }

}
