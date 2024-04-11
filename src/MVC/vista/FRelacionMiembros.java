package MVC.vista;

import MVC.controlador.MiembrosController;
import MVC.controlador.RelacionesMiembrosController;
import MVC.modelo.entity.Miembros;

import javax.swing.*;
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


    public FRelacionMiembros() {
        miembrosController = new MiembrosController();

        cargarMiembro1();
        cargarMiembro2();

    }



    private void cargarMiembro1() {
        miembros1 =  miembrosController.obtenerMiembros();

        // Crear el modelo y agregar los datos al modelo
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
        for (Miembros miembro : miembros1) {
            modelo.addElement(miembro.getNombre() + " " + miembro.getApellido());
        }

        comboMiembro1.setModel(modelo);
    }

    private void cargarMiembro2() {
        miembros2 =  miembrosController.obtenerMiembros();

        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
        for (Miembros miembro : miembros2) {
            modelo.addElement(miembro.getNombre() + " " + miembro.getApellido());
        }

        comboMiembro2.setModel(modelo);
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
