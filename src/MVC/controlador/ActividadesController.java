package MVC.controlador;

import MVC.modelo.AsistenciaEventosDAO;
import MVC.modelo.EventosIglesiaDAO;
import MVC.modelo.ExportadorExcel;
import MVC.modelo.ExportadorPDF;
import MVC.modelo.entity.AsistenciaEventos;
import MVC.modelo.entity.EventosIglesia;
import MVC.modelo.entity.Exportador;
import MVC.modelo.entity.Ministerios;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActividadesController {

    private AsistenciaEventosDAO asistenciaEventosDAO;
    private EventosIglesiaDAO eventosIglesiaDAO;

    public ActividadesController() {
        this.asistenciaEventosDAO = new AsistenciaEventosDAO();
        this.eventosIglesiaDAO = new EventosIglesiaDAO();
    }

    public void crearActividad(EventosIglesia eventosIglesia) {
        this.eventosIglesiaDAO.crearEventoIglesia(eventosIglesia);
        JOptionPane.showMessageDialog(null,"Actividada Creada con Éxito");
        System.out.println("Actividad Creada con exito");
    }

    public List<EventosIglesia> obtenerActividad() {
        try {
            return this.eventosIglesiaDAO.obtenerEventosIglesia();
        } catch (SQLException e) {
            System.out.println("Error al obtener los Eventos de la Iglesia");
            return new ArrayList<EventosIglesia>();
        }
    }

    public void exportarActividades(String formato, String filePath,JTable table){
        Exportador exportador = null;

        if ("PDF".equalsIgnoreCase(formato)) {
            exportador = new ExportadorPDF(filePath);
        } else if ("Excel".equalsIgnoreCase(formato)) {
            exportador = new ExportadorExcel(filePath);
        } else {
            throw new IllegalArgumentException("Formato de exportación no soportado: " + formato);
        }

        exportador.exportar(table);
    }
}
