package MVC.modelo;

import MVC.modelo.entity.EventosIglesia;
import MVC.modelo.entity.Exportador;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.JTable;
import javax.swing.table.TableModel;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;  // Asegúrate de importar java.util.Date

public class ExportadorExcel implements Exportador {
    private String filePath;
    public ExportadorExcel(String filePath) {
        this.filePath = filePath;
    }
    @Override
    public void exportar(JTable table) {
//        JOptionPane.showMessageDialog(null,"Exportando a Excel...");
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Eventos Iglesia");

        TableModel model = table.getModel();

        // Crear encabezados
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < model.getColumnCount(); i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(model.getColumnName(i));
        }

        // Crear filas de datos
        for (int rowIndex = 0; rowIndex < model.getRowCount(); rowIndex++) {
            Row row = sheet.createRow(rowIndex + 1);
            for (int colIndex = 0; colIndex < model.getColumnCount(); colIndex++) {
                Cell cell = row.createCell(colIndex);
                Object value = model.getValueAt(rowIndex, colIndex);
                if (value instanceof Date) {
                    CellStyle cellStyle = workbook.createCellStyle();
                    CreationHelper createHelper = workbook.getCreationHelper();
                    cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
                    cell.setCellValue((Date) value);
                    cell.setCellStyle(cellStyle);
                } else {
                    cell.setCellValue(value.toString());
                }
            }
        }

        // Autoajustar el ancho de las columnas
        for (int i = 0; i < model.getColumnCount(); i++) {
            sheet.autoSizeColumn(i);
        }

        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
            System.out.println("Exportado a Excel con éxito: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
