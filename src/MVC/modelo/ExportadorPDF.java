package MVC.modelo;

import MVC.modelo.entity.EventosIglesia;
import MVC.modelo.entity.Exportador;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExportadorPDF implements Exportador {

    private String filePath;

    public ExportadorPDF(String filePath){
        this.filePath = filePath;
    }
    @Override
    public void exportar(JTable table) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();
            document.add(new Paragraph("Lista de Eventos Iglesia"));
            document.add(new Paragraph(" ")); // Espacio en blanco

            PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
            pdfTable.setWidthPercentage(100);
            pdfTable.setSpacingBefore(10f);
            pdfTable.setSpacingAfter(10f);

            // Añadir encabezados
            for (int i = 0; i < table.getColumnCount(); i++) {
                PdfPCell cell = new PdfPCell(new Phrase(table.getColumnName(i)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                pdfTable.addCell(cell);
            }

            // Añadir datos
            for (int rows = 0; rows < table.getRowCount(); rows++) {
                for (int cols = 0; cols < table.getColumnCount(); cols++) {
                    pdfTable.addCell(table.getModel().getValueAt(rows, cols).toString());
                }
            }

            document.add(pdfTable);
            document.close();
            System.out.println("Exportado a PDF con éxito: " + filePath);
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }
}
