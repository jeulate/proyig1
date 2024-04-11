package MVC.vista;

import MVC.controlador.ActividadesController;
import MVC.modelo.entity.EventosIglesia;
import MVC.modelo.entity.Relaciones;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FActividades {

    private ActividadesController actividadesController;
    private JPanel PPActividades;
    private JTextField txtNombreEvento;
    private JTextField txtDescripcion;
    private JDateChooser txtFecEvent;
    private JPanel panelFecEvent;
    private JComboBox<String> comboTipoEvento;
    private JPanel panelCampos;
    private JButton btnRegistrarEvento;
    private JPanel ppdatos;
    private JButton btnMostrar;
    private JTable tablaDatos;

    private DefaultTableModel modeloTabla;

    public FActividades() {
        actividadesController = new ActividadesController();

        txtFecEvent = new JDateChooser();
        panelFecEvent.add(txtFecEvent);

        String[] columnas = {"Nombre Evento", "Descripcion","Fecha Evento","Tipo Evento"};
        modeloTabla = new DefaultTableModel(columnas,0);
        tablaDatos = new JTable(modeloTabla);

        JScrollPane scrollPane =new JScrollPane(tablaDatos);
        ppdatos.add(scrollPane);


        btnRegistrarEvento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
                formato.setLenient(false);
                Date fechaEvento = txtFecEvent.getDate();

                String nombreevento = txtNombreEvento.getText();
                String descripcion = txtDescripcion.getText();
                Date fechaEv = fechaEvento;
                String tipoEvento = (String) comboTipoEvento.getSelectedItem();

                EventosIglesia eventosIglesia = new EventosIglesia(
                  nombreevento,
                  descripcion,
                  fechaEv,
                  tipoEvento
                );
                actividadesController.crearActividad(eventosIglesia);

            }
        });
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<EventosIglesia> eventosIglesias = actividadesController.obtenerActividad();
                limpiarTabla(modeloTabla);
                for (EventosIglesia eventosIglesia : eventosIglesias) {

                    modeloTabla.addRow(new Object[]{
                            eventosIglesia.getNombre_evento(),
                            eventosIglesia.getDescripcion(),
                            eventosIglesia.getFecha_evento(),
                            eventosIglesia.getTipo_evento()
                    });
                }

                modeloTabla.fireTableDataChanged();
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
            JFrame frame = new JFrame("Registro de Eventos y Actividades");
            frame.setContentPane(new FActividades().PPActividades);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(700,600);
            frame.setVisible(true);
        });
    }
}
