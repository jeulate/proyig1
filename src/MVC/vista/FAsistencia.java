package MVC.vista;

import javax.swing.*;

public class FAsistencia {
    private JPanel PPAsistencia;
    private JPanel pAsistencia;

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
