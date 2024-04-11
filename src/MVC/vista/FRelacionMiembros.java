package MVC.vista;

import MVC.controlador.MiembrosController;
import MVC.controlador.RelacionesMiembrosController;
import MVC.modelo.entity.Miembros;
import MVC.modelo.entity.Relaciones;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FRelacionMiembros {

    private MiembrosController miembrosController;
    private RelacionesMiembrosController relacionesMiembrosController;

    private JButton btnGuardar;
    private JComboBox comboMiembro1;
    private JComboBox comboRelacion;
    private JComboBox comboMiembro2;
    private JPanel PPRelacion;
    private JButton btnMostrar;
    private JTable tablaDatos;
    private JPanel ppdatos;

    List<Miembros> miembros1;
    List<Miembros> miembros2;
    DefaultComboBoxModel<Miembros> modeloComboMiembro1;
    DefaultComboBoxModel<Miembros> modeloComboMiembro2;

    private DefaultTableModel modeloTabla;

    public FRelacionMiembros() {
        miembrosController = new MiembrosController();
        relacionesMiembrosController = new RelacionesMiembrosController();

        cargarMiembro1();
        cargarMiembro2();

        String[] columnas = {"ID", "Miembro 1", "Miembro 2","Relacion"};
        modeloTabla = new DefaultTableModel(columnas,0);
        tablaDatos = new JTable(modeloTabla);

        JScrollPane scrollPane =new JScrollPane(tablaDatos);
        ppdatos.add(scrollPane);

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indexMiembro1 = comboMiembro1.getSelectedIndex();
                Miembros miembros1 = modeloComboMiembro1.getElementAt(indexMiembro1);
                String relacion = (String) comboRelacion.getSelectedItem();
                int indexMiembro2 = comboMiembro2.getSelectedIndex();
                Miembros miembros2 = modeloComboMiembro2.getElementAt(indexMiembro2);

                Relaciones relaciones = new Relaciones(
                        miembros1.getId(),
                        miembros2.getId(),
                        relacion
                );

                relacionesMiembrosController.registrarNuevaRelacionMiembro(relaciones);

            }
        });
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Relaciones> relaciones =  relacionesMiembrosController.obtenerRelaciones();
                List<Miembros> miembros = miembrosController.obtenerMiembros();

                limpiarTabla(modeloTabla);
//                    modeloTabla = new DefaultTableModel(columnas,0);

                for (Relaciones relacion : relaciones) {

                    modeloTabla.addRow(new Object[]{
                            getNombreMiembro(miembros, relacion.getMiembro1_id()),
                            getNombreMiembro(miembros, relacion.getMiembro2_id()),
                            relacion.getTipo_relacion()
                    });
                }

                modeloTabla.fireTableDataChanged();
            }
        });
    }



    private void cargarMiembro1() {
        miembros1 =  miembrosController.obtenerMiembros();

        // Crear el modelo y agregar los datos al modelo
        modeloComboMiembro1 = new DefaultComboBoxModel<>();
        for (Miembros miembro : miembros1) {
            modeloComboMiembro1.addElement(miembro);
        }

        comboMiembro1.setModel(modeloComboMiembro1);
    }

    private void cargarMiembro2() {
        miembros2 =  miembrosController.obtenerMiembros();

        modeloComboMiembro2 = new DefaultComboBoxModel<>();
        for (Miembros miembro : miembros2) {
            modeloComboMiembro2.addElement(miembro);
        }

        comboMiembro2.setModel(modeloComboMiembro2);
    }

    private void limpiarTabla(DefaultTableModel modelo) {
        // Se elimina el contenido de la tabla fila por fila desde arriba
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    private String getNombreMiembro(List<Miembros> miembros, int idMiembro) {
        // Se elimina el contenido de la tabla fila por fila desde arriba
        Miembros miembro = null;
        for (int iMiembro = 0; iMiembro < miembros.size(); iMiembro++) {
            if(miembros.get(iMiembro).getId() == idMiembro) {
                miembro = miembros.get(iMiembro);
                break;
            }
        }
        if( miembro == null) {
            return "";
        }

        return miembro.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            JFrame frame = new JFrame("Registro de Miembros");
            frame.setContentPane(new FRelacionMiembros().PPRelacion);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(700,600);
            frame.setVisible(true);
        });
    }
}
