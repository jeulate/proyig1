package Negocio;

import datos.Miembros;
import datos.MiembrosDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class RegistroMiembros {
    private MiembrosDAO miembrosDAO;
    public void setMiembrosDAO(MiembrosDAO miembrosDAO){
        this.miembrosDAO = miembrosDAO;
    }
    public void registrarMiembro(Miembros miembros){
        if (esPersonaValida(miembros)){
            miembrosDAO.agregarMiembro(miembros);
            System.out.println("Registro Exitoso");
        }else {
            System.out.println("Los Campos no pueden estar vacios");
            JOptionPane.showMessageDialog(null,"Llena los campos");
        }
    }
    public void cargarDatosenTabla(DefaultTableModel modeloTabla){
        miembrosDAO.cargarDatosenTabla(modeloTabla);
    }
    private boolean esPersonaValida(Miembros miembros){
        return !miembros.getNombre().isEmpty() &&
                !miembros.getApellido().isEmpty() &&
                !miembros.getFnaci().toString().isEmpty() &&
                !miembros.getGenero().isEmpty() &&
                !miembros.getDireccion().isEmpty() &&
                !miembros.getEmail().isEmpty() &&
                !miembros.getTelefono().isEmpty();
    }
}
