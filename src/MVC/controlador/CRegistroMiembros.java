package MVC.controlador;

import MVC.modelo.Miembros;
import MVC.modelo.RegistroMiembros;

import javax.swing.table.DefaultTableModel;

public class CRegistroMiembros {
    private RegistroMiembros registroMiembros;

    public CRegistroMiembros(RegistroMiembros registroMiembros) {
        this.registroMiembros = registroMiembros;
    }
    public void registrarMiembro(Miembros miembros){
        registroMiembros.registrarMiembro(miembros);
    }
    public void cargarDatosenTabla(DefaultTableModel modeloTabla){
        registroMiembros.cargarDatosenTabla(modeloTabla);
    }
}
