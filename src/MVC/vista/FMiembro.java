package MVC.vista;

import MVC.controlador.CMiembrosDAO;
import MVC.controlador.CRegistroMiembros;
import MVC.modelo.Miembros;
import MVC.modelo.RegistroMiembros;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FMiembro {
    private JPanel PPMiembro;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtFecNac;
    private JRadioButton rdFemale;
    private JRadioButton rdMale;
    private JTextField txtDireccion;
    private JTextField txtEmail;
    private JTextField txtTelef;
    private JButton btnRegistrarMiembro;
    private JTable tablaDatos;
    private JButton btnMostrar;
    private DefaultTableModel modeloTabla;
    private List<Miembros> datosCargados = new ArrayList<>();
    public FMiembro(){
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rdFemale);
        buttonGroup.add(rdMale);

        rdFemale.setText("F");
        rdMale.setText("M");

        String[] columnas = {"ID", "Nombre", "Apellido","Fecha Nac.", "Sexo", "Direccion","Email","Telefono"};
        modeloTabla = new DefaultTableModel(columnas,0);
        tablaDatos = new JTable(modeloTabla);

        JScrollPane scrollPane =new JScrollPane(tablaDatos);
        PPMiembro.add(scrollPane);


        btnRegistrarMiembro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
                    formato.setLenient(false);
                    Date Fechanac = formato.parse(txtFecNac.getText());

                    // Verificar si hay un botón seleccionado antes de obtener el comando de acción
                    String genero = "";
                    if (rdFemale.isSelected()) {
                        genero = rdFemale.getText();
                    }else if (rdMale.isSelected()){
                        genero = rdMale.getText();
                    }

//                    Miembros miembros = new Miembros(
//                            txtNombre.getText(),
//                            txtApellido.getText(),
//                            Fechanac,
//                            genero,
//                            txtDireccion.getText(),
//                            txtEmail.getText(),
//                            txtTelef.getText()
//                    );
                    System.out.println("el campo devuelve "+ genero);
                    CMiembrosDAO cMiembrosDAO = new CMiembrosDAO();
                    RegistroMiembros registroMiembros = new RegistroMiembros(cMiembrosDAO);

                    CRegistroMiembros controlador = new CRegistroMiembros(registroMiembros);
//                    controlador.registrarMiembro(miembros);
                }catch (ParseException ex){
                        ex.printStackTrace();
                }
            }
        });
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    CMiembrosDAO cMiembrosDAO = new CMiembrosDAO();
                    RegistroMiembros servicio = new RegistroMiembros(cMiembrosDAO);
                    servicio.cargarDatosenTabla(modeloTabla);
                    modeloTabla.fireTableDataChanged();

                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            JFrame frame = new JFrame("Registro de Miembros");
            frame.setContentPane(new FMiembro().PPMiembro);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(900,400);
            frame.setVisible(true);
        });
    }

}
