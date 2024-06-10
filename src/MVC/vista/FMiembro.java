package MVC.vista;

import MVC.controlador.MiembrosController;
import MVC.modelo.entity.Miembros;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JButton btnActualizar;
    private JButton btnEliminar;

    private DefaultTableModel modeloTabla;

    private List<Miembros> datosCargados = new ArrayList<>();

    public FMiembro() {
        miembrosController = new MiembrosController();

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rdFemale);
        buttonGroup.add(rdMale);

        rdFemale.setText("F");
        rdMale.setText("M");

        txtFecNac = new JDateChooser();
        paneFecNac.add(txtFecNac);


        String[] columnas = {"ID", "Nombre", "Apellido", "Fecha Nac.", "Sexo", "Direccion", "Email", "Telefono"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaDatos = new JTable(modeloTabla);

        JScrollPane scrollPane = new JScrollPane(tablaDatos);
        ppdatos.add(scrollPane);

        btnRegistrarMiembro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
                    formato.setLenient(false);
                    Date Fechanac = txtFecNac.getDate();

                    // Verificar si hay un botón seleccionado antes de obtener el comando de acción
                    String genero = "";
                    if (rdFemale.isSelected()) {
                        genero = rdFemale.getText();
                    } else if (rdMale.isSelected()) {
                        genero = rdMale.getText();
                    }


                    String nombre = txtNombre.getText();
                    String apellido = txtApellido.getText();
                    Date fecha_nacimiento = Fechanac;
                    String direccion = txtDireccion.getText();
                    String email = txtEmail.getText();
                    String telefono = txtTelef.getText();
                    Date fecha_bautismo = fecha_nacimiento;
                    Boolean asistio_culto = false;
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
                    ActualizarTabla();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al registrar miembro: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }


            }
        });
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ActualizarTabla();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al obtener miembros: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        tablaDatos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Verifica si la selección ha cambiado y si hay alguna fila seleccionada
                if (!e.getValueIsAdjusting() && tablaDatos.getSelectedRow() != -1) {
                    // Obtiene los datos del miembro seleccionado
                    int filaSeleccionada = tablaDatos.getSelectedRow();
                    int id = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
                    String nombre = (String) modeloTabla.getValueAt(filaSeleccionada, 1);
                    String apellido = (String) modeloTabla.getValueAt(filaSeleccionada, 2);
                    Date fechaNacimiento = (Date) modeloTabla.getValueAt(filaSeleccionada, 3);
                    String genero = (String) modeloTabla.getValueAt(filaSeleccionada, 4);
                    String direccion = (String) modeloTabla.getValueAt(filaSeleccionada, 5);
                    String email = (String) modeloTabla.getValueAt(filaSeleccionada, 6);
                    String telefono = (String) modeloTabla.getValueAt(filaSeleccionada, 7);

                    // Muestra los datos del miembro seleccionado en los campos correspondientes
                    txtNombre.setText(nombre);
                    txtApellido.setText(apellido);
                    txtFecNac.setDate(fechaNacimiento);
                    if (genero.equals("F")) {
                        rdFemale.setSelected(true);
                    } else {
                        rdMale.setSelected(true);
                    }
                    txtDireccion.setText(direccion);
                    txtEmail.setText(email);
                    txtTelef.setText(telefono);
                }
            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
                    formato.setLenient(false);
                    Date Fechanac = txtFecNac.getDate();

                    int filaSeleccionada = tablaDatos.getSelectedRow();
                    int id = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
                    String nombre = (String) modeloTabla.getValueAt(filaSeleccionada, 1);
                    String apellido = (String) modeloTabla.getValueAt(filaSeleccionada, 2);
                    Date fechaNacimiento = (Date) modeloTabla.getValueAt(filaSeleccionada, 3);
                    String genero = (String) modeloTabla.getValueAt(filaSeleccionada, 4);
                    String direccion = (String) modeloTabla.getValueAt(filaSeleccionada, 5);
                    String email = (String) modeloTabla.getValueAt(filaSeleccionada, 6);
                    String telefono = (String) modeloTabla.getValueAt(filaSeleccionada, 7);
                    Date fecha_bautismo = fechaNacimiento;
                    boolean asistio_culto = false;

                    fechaNacimiento = Fechanac;

                    ;
                    Miembros miembro = new Miembros(
                            id,
                            nombre,
                            apellido,
                            fechaNacimiento,
                            genero,
                            direccion,
                            email,
                            telefono,
                            fecha_bautismo,
                            asistio_culto
                    );

                    miembrosController.actualizarMiembro(miembro);
                    ActualizarTabla();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al actualizar miembro: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }


            }
        });
    }

    private void ActualizarTabla(){
        try {
            List<Miembros> miembros = miembrosController.obtenerMiembros();

            limpiarTabla(modeloTabla);

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
            JOptionPane.showMessageDialog(null, "Error al mostrar miembros: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void limpiarTabla(DefaultTableModel modelo) {
        // Se elimina el contenido de la tabla fila por fila desde arriba
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    public JPanel getPanel() {
        return PPMiembro;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Registro de Miembros");
            frame.setContentPane(new FMiembro().PPMiembro);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(700, 600);
            frame.setVisible(true);
        });
    }

}
