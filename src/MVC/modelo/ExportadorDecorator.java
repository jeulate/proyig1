package MVC.modelo;

import MVC.modelo.entity.EventosIglesia;
import MVC.modelo.entity.Exportador;

import javax.swing.*;
import java.util.List;

public abstract class ExportadorDecorator implements Exportador {
    protected Exportador decorador;
    public ExportadorDecorator(Exportador decorador){
        this.decorador = decorador;
    }
    @Override
    public void exportar(JTable table){
        decorador.exportar(table);
    }
}
