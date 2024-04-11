package MVC.vista;

import MVC.controlador.MiembrosController;
import MVC.controlador.RelacionesMiembrosController;
import MVC.modelo.entity.Miembros;
import MVC.modelo.entity.Relaciones;

import javax.swing.*;
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
    private JTable table1;

    List<Miembros> miembros1;
    List<Miembros> miembros2;
    DefaultComboBoxModel<Miembros> modeloComboMiembro1;
    DefaultComboBoxModel<Miembros> modeloComboMiembro2;

    public FRelacionMiembros() {
        miembrosController = new MiembrosController();
        relacionesMiembrosController = new RelacionesMiembrosController();

        cargarMiembro1();
        cargarMiembro2();

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
