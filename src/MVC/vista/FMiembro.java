package MVC.vista;

import MVC.controlador.MiembrosController;
import MVC.modelo.entity.Miembros;
import com.toedter.calendar.JDateChooser;

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
    private MiembrosController miembrosController;


    private JPanel PPMiembro;

    private JTextField txtNombre;
    private JTextField txtApellido;
    private JDateChooser txtFecNac;
    private JRadioButton rdFemale;
    private JRadioButton rdMale;
    private JTextField txtDireccion;
    private JTextField txtEmail;
    private JTextField txtTelef;
    private JButton btnRegistrarMiembro;

    private JTable tablaDatos;
    private JButton btnMostrar;
    private JPanel paneFecNac;
    private JPanel ppdatos;

    private DefaultTableModel modeloTabla;

    private JDateChooser fechaVueltaChosser;
    private List<Miembros> datosCargados = new ArrayList<>();

    public FMiembro(){
        miembrosController = new MiembrosController();

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rdFemale);
        buttonGroup.add(rdMale);

        rdFemale.setText("F");
        rdMale.setText("M");

        txtFecNac =  new JDateChooser();
        paneFecNac.add(txtFecNac);


        String[] columnas = {"ID", "Nombre", "Apellido","Fecha Nac.", "Sexo", "Direccion","Email","Telefono"};
        modeloTabla = new DefaultTableModel(columnas,0);
        tablaDatos = new JTable(modeloTabla);

        JScrollPane scrollPane =new JScrollPane(tablaDatos);
        ppdatos.add(scrollPane);

        btnRegistrarMiembro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                try {
                    SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
                    formato.setLenient(false);
                    Date Fechanac = txtFecNac.getDate();

                    // Verificar si hay un botón seleccionado antes de obtener el comando de acción
                    String genero = "";
                    if (rdFemale.isSelected()) {
                        genero = rdFemale.getText();
                    }else if (rdMale.isSelected()){
                        genero = rdMale.getText();
                    }

                    System.out.println("el campo devuelve "+ genero);

                    String nombre = txtNombre.getText();
                    String apellido = txtApellido.getText();
                    Date fecha_nacimiento = Fechanac ;
//                    String genero = "";
                    String direccion = txtDireccion.getText();
                    String email=txtEmail.getText();
                    String telefono=txtTelef.getText();
                    Date fecha_bautismo=fecha_nacimiento;
                    Boolean asistio_culto=false;
;
                    Miembros miembro = new Miembros(
                            nombre,
                            apellido,
                            fecha_nacimiento,
                            genero,
                            direccion,
                            email,
                            telefono,
                            fecha_bautismo,
                            asistio_culto
                    );

                    miembrosController.registrarNuevoMiembro(miembro);

//                    controlador.registrarMiembro(miembros);
//                }catch (ParseException ex){
//                        ex.printStackTrace();
//                }
            }
        });
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Miembros> miembros =  miembrosController.obtenerMiembros();

                    limpiarTabla(modeloTabla);
//                    modeloTabla = new DefaultTableModel(columnas,0);

                    for (Miembros miembro : miembros) {
                        modeloTabla.addRow(new Object[]{
                                miembro.getId(),
                                miembro.getNombre(),
                                miembro.getApellido(),
                                miembro.getFecha_nacimiento(),
                                miembro.getGenero(),
                                miembro.getDireccion(),
                                miembro.getCorreo_electronico(),
                                miembro.getTelefono()
                        });
                    }

                    modeloTabla.fireTableDataChanged();

                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }

    private void limpiarTabla(DefaultTableModel modelo) {
        // Se elimina el contenido de la tabla fila por fila desde arriba
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            JFrame frame = new JFrame("Registro de Miembros");
            frame.setContentPane(new FMiembro().PPMiembro);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(700,600);
            frame.setVisible(true);
        });
    }

}
