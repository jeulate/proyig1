package Presentacion;

import Negocio.RegistroMiembros;
import datos.Miembros;
import datos.MiembrosDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class FMiembros {
    private JPanel PPrincipal;
    private JTextField txtID;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtFecNac;
    private JTextField txtGenero;
    private JTextField txtDireccion;
    private JTextField txtEmail;
    private JTextField txtTelefono;
    private JButton btnRegistrar;

    public FMiembros() {

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MiembrosDAO miembrosDAO = new MiembrosDAO();
                RegistroMiembros registroMiembros = new RegistroMiembros();
                registroMiembros.setMiembrosDAO(miembrosDAO);
                try{
                    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                    Date fechanacimiento = formato.parse(txtFecNac.getText());
                    Miembros miembros = new Miembros(
                            txtID.getText(),
                            txtNombre.getText(),
                            txtApellido.getText(),
                            fechanacimiento,
                            txtGenero.getText(),
                            txtDireccion.getText(),
                            txtEmail.getText(),
                            txtTelefono.getText());
                    registroMiembros.registrarMiembro(miembros);
                }catch (ParseException ex){
                    ex.printStackTrace();
                }

            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            JFrame frame = new JFrame("Registro de Miembros");
            frame.setContentPane(new FMiembros().PPrincipal);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600,400);
            frame.setVisible(true);
        });
    }

}
