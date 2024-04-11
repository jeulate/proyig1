package MVC.vista;

import javax.swing.*;

public class FRelacionMiembros {
    private JButton btnGuardar;
    private JComboBox comboMiembro1;
    private JComboBox comboRelacion;
    private JComboBox comboMiembro2;
    private JPanel PPRelacion;
    private JButton btnMostrar;
    private JTable table1;

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
