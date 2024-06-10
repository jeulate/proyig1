package MVC.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FInterfaz extends JFrame {
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public FInterfaz(){
        setTitle("Finterfaz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        mainPanel = new JPanel();
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);

        // Crear paneles de las diferentes vistas
        JPanel actividadesPanel = new FActividades().getPanel();
        JPanel miembroPanel = new FMiembro().getPanel();
        JPanel ministerioPanel = new FMinisterio().getPanel();
        JPanel asistenciaPanel = new FAsistencia().getPanel();
        JPanel relacionPanel = new FRelacionMiembros().getPanel();


        // Añadir los paneles al CardLayout
        mainPanel.add(actividadesPanel, "Actividades");
        mainPanel.add(miembroPanel, "Miembro");
        mainPanel.add(ministerioPanel,"Ministerios");
        mainPanel.add(asistenciaPanel,"Registro de Asistencia");
        mainPanel.add(relacionPanel,"Asignar Relación");



        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");

        JMenuItem actividadesMenuItem = new JMenuItem("Actividades");
        actividadesMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Actividades");
            }
        });
        JMenuItem miembroMenuItem = new JMenuItem("Miembro");
        miembroMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Miembro");
            }
        });
        JMenuItem ministerioMenuItem = new JMenuItem("Ministerios");
        ministerioMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel,"Ministerios");
            }
        });

        JMenuItem asistenciaMenuItem = new JMenuItem("Registro de Asistencia");
        asistenciaMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel,"Registro de Asistencia");
            }
        });

        JMenuItem relacionMenuItem = new JMenuItem("Asignar Relación");
        relacionMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel,"Asignar Relación");
            }
        });

        menu.add(actividadesMenuItem);
        menu.add(miembroMenuItem);
        menu.add(ministerioMenuItem);
        menu.add(asistenciaMenuItem);
        menu.add(relacionMenuItem);

        menuBar.add(menu);
        setJMenuBar(menuBar);
        add(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FInterfaz());
    }
}
