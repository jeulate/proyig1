package MVC.controlador;

import MVC.modelo.*;
import MVC.modelo.entity.AsistenciaEventos;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParticipacionEventosController {
    private AsistenciaEventosDAO asistenciaEventosDAO;
    private MiembrosDAO miembrosDAO;
    private EventosIglesiaDAO eventosIglesiaDAO;

    public ParticipacionEventosController() {
        this.asistenciaEventosDAO = new AsistenciaEventosDAO();
        this.miembrosDAO = new MiembrosDAO();
        this.eventosIglesiaDAO = new EventosIglesiaDAO();
    }

    public void registrarAsistencia(AsistenciaEventos asistenciaEventos) {
        try {
            this.asistenciaEventosDAO.registrarAsistencia(asistenciaEventos);
            JOptionPane.showMessageDialog(null, "Asistencia Asignada al Evento Correspondiente");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al registrar asistencia: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<AsistenciaEventos> obtenerAsistencias() {
        try {
            return this.asistenciaEventosDAO.obtenerAsistencias();
        } catch (SQLException e) {
            System.out.println("Error al obtener los Eventos de la Iglesia");
            return new ArrayList<AsistenciaEventos>();
        }
    }
}
