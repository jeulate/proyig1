package MVC.vista;

import MVC.controlador.MinisteriosController;
import MVC.modelo.entity.Ministerios;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FMinisterio {

    private MinisteriosController ministeriosController;
    private JPanel PPMinisterio;
    private JTextField txtNombre;
    private JTextField txtDescripcion;
    private JButton btnRegistrarMinisterios;
    private JPanel ppdatos;
    private JButton btnMostrar;
    private JTable tablaDatos;
    private JButton btnClonaMinisterio;
    private JButton btnActualizar;

    private DefaultTableModel modeloTabla;

    public FMinisterio() {

        ministeriosController = new MinisteriosController();

        String[] columnas = {"id","Ministerios", "Descripcion"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaDatos = new JTable(modeloTabla);


        JScrollPane scrollPane = new JScrollPane(tablaDatos);
        ppdatos.add(scrollPane);
        btnRegistrarMinisterios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = txtNombre.getText();
                    String descripcion = txtDescripcion.getText();
                    // Clonar el prototipo desde el controlador
                    Ministerios ministerios = ministeriosController.clone();
                    ministerios.setNombre(nombre);
                    ministerios.setDescripcion(descripcion);

                    ministeriosController.crearMinisterio(ministerios);
                    actualizarTabla();

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al Registrar Ministerio: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    actualizarTabla();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al mostrar ministerios: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnClonaMinisterio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ministeriosController.clonaryCrearMinisterio();
                    actualizarTabla();
                }catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al clonar ministerio: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int filaSelecciona = tablaDatos.getSelectedRow();
                    int id = (int) modeloTabla.getValueAt(filaSelecciona,0);
                    String nombre = (String) modeloTabla.getValueAt(filaSelecciona,1);
                    String descripcion = (String) modeloTabla.getValueAt(filaSelecciona,2);
                    Ministerios ministerio = new Ministerios(id,nombre,descripcion);
                    ministeriosController.actualizarMinisterio(ministerio);
                    actualizarTabla();

                }catch (Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al actualizar ministerio: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    private void actualizarTabla() {
        try {
            List<Ministerios> ministerios = ministeriosController.obtenerMinisterios();
            limpiarTabla(modeloTabla);
            for (Ministerios ministerio : ministerios) {
                modeloTabla.addRow(new Object[]{
                        ministerio.getId(),
                        ministerio.getNombre(),
                        ministerio.getDescripcion()
                });
            }
            modeloTabla.fireTableDataChanged();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al mostrar ministerios: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void limpiarTabla(DefaultTableModel modelo) {
        // Se elimina el contenido de la tabla fila por fila desde arriba
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }
    public JPanel getPanel() {
        return PPMinisterio;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Registro de Ministerios");
            frame.setContentPane(new FMinisterio().PPMinisterio);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(700, 600);
            frame.setVisible(true);
        });
    }
}
