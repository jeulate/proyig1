package MVC.controlador;

import MVC.modelo.Miembro;
import MVC.modelo.RegistroMiembros;

import javax.swing.table.DefaultTableModel;

public class CRegistroMiembros {
    private RegistroMiembros registroMiembros;

    public CRegistroMiembros(RegistroMiembros registroMiembros) {
        this.registroMiembros = registroMiembros;
    }
    public void registrarMiembro(Miembro miembro){
        registroMiembros.registrarMiembro(miembro);
    }
    public void cargarDatosenTabla(DefaultTableModel modeloTabla){
        registroMiembros.cargarDatosenTabla(modeloTabla);
    }
}
