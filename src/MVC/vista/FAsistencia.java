package MVC.vista;

import MVC.controlador.ActividadesController;
import MVC.controlador.MiembrosController;
import MVC.controlador.ParticipacionEventosController;
import MVC.modelo.entity.AsistenciaEventos;
import MVC.modelo.entity.EventosIglesia;
import MVC.modelo.entity.Miembros;
import MVC.modelo.entity.Relaciones;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

public class FAsistencia {

    private MiembrosController miembrosController;
    private ActividadesController actividadesController;
    private ParticipacionEventosController asistenciaController;

    private JPanel PPAsistencia;
    private JPanel ppdatos;
    private JComboBox comboMiembros;
    private JComboBox comboActividades;
    private JRadioButton asistioRadioButton;
    private JRadioButton noAsistioRadioButton;
    private JButton btnGuardar;
    private JButton btnMostrar;
    private JTable tablaDatos;
    private ButtonGroup buttonGroupAsistencia;

    List<Miembros> miembros;
    List<EventosIglesia> actividades;
    DefaultComboBoxModel<Miembros> modeloComboMiembros;
    DefaultComboBoxModel<EventosIglesia> modeloComboActividades;

    private DefaultTableModel modeloTabla;

    public FAsistencia() {
        miembrosController = new MiembrosController();
        actividadesController = new ActividadesController();
        asistenciaController = new ParticipacionEventosController();

        cargarMiembros();
        cargarActividades();

        String[] columnas = {"Miembro", "Actividad", "Tipo Actividad", "Fecha Actividad", "Asistio"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaDatos = new JTable(modeloTabla);

        JScrollPane scrollPane = new JScrollPane(tablaDatos);
        ppdatos.add(scrollPane);


        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indexMiembro = comboMiembros.getSelectedIndex();
                Miembros miembro = modeloComboMiembros.getElementAt(indexMiembro);
                int indexActividad = comboActividades.getSelectedIndex();
                EventosIglesia actividad = modeloComboActividades.getElementAt(indexActividad);
                boolean asistio = asistioRadioButton.isSelected();

                AsistenciaEventos asistencia = new AsistenciaEventos(
                        miembro.getId(),
                        actividad.getId(),
                        asistio
                );

                asistenciaController.registrarAsistencia(asistencia);

            }
        });
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<AsistenciaEventos> asistencias = asistenciaController.obtenerAsistencias();
                    List<Miembros> miembros = miembrosController.obtenerMiembros();
                    List<EventosIglesia> actividades = actividadesController.obtenerActividad();

                    limpiarTabla(modeloTabla);

                    EventosIglesia actividad;
                    String nombreEvento;
                    String fechaEvento;
                    String tipoEvento;
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

                    for (AsistenciaEventos asistencia : asistencias) {
                        actividad = getActividad(actividades, asistencia.getEvento_id());
                        if(actividad == null) {
                            nombreEvento = "";
                            fechaEvento = "";
                            tipoEvento = "";
                        } else {
                            nombreEvento = actividad.getNombre_evento();
                            fechaEvento = formato.format(actividad.getFecha_evento());
                            tipoEvento = actividad.getTipo_evento();
                        }

                        modeloTabla.addRow(new Object[]{
                                getNombreMiembro(miembros, asistencia.getMiembro_id()),
                                nombreEvento,
                                tipoEvento,
                                fechaEvento,
                                asistencia.getAsistio() ? "Si": "No"
                        });
                    }

                    modeloTabla.fireTableDataChanged();

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al mostrar las asistencias: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void cargarMiembros() {
        miembros = miembrosController.obtenerMiembros();

        // Crear el modelo y agregar los datos al modelo
        modeloComboMiembros = new DefaultComboBoxModel<>();
        for (Miembros miembro : miembros) {
            modeloComboMiembros.addElement(miembro);
        }

        comboMiembros.setModel(modeloComboMiembros);
    }

    private void cargarActividades() {
        actividades = actividadesController.obtenerActividad();

        // Crear el modelo y agregar los datos al modelo
        modeloComboActividades = new DefaultComboBoxModel<>();
        for (EventosIglesia actividad : actividades) {
            modeloComboActividades.addElement(actividad);
        }

        comboActividades.setModel(modeloComboActividades);
    }

    private String getNombreMiembro(List<Miembros> miembros, int idMiembro) {
        Miembros miembro = null;
        for (int iMiembro = 0; iMiembro < miembros.size(); iMiembro++) {
            if (miembros.get(iMiembro).getId() == idMiembro) {
                miembro = miembros.get(iMiembro);
                break;
            }
        }
        if (miembro == null) {
            return "";
        }

        return miembro.toString();
    }

    private EventosIglesia getActividad(List<EventosIglesia> actividades, int idActividad) {
        for (int iActividad = 0; iActividad < actividades.size(); iActividad++) {
            if (actividades.get(iActividad).getId() == idActividad) {
                return actividades.get(iActividad);
            }
        }

        return null;
    }


    private void limpiarTabla(DefaultTableModel modelo) {
        // Se elimina el contenido de la tabla fila por fila desde arriba
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            JFrame frame = new JFrame("Gestion de Asistencia y Participación");
            frame.setContentPane(new FAsistencia().PPAsistencia);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(700,600);
            frame.setVisible(true);
        });
    }
}
