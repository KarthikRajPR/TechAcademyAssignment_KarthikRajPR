package utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {
    private static final String EXCEL_PATH = "src/test/resources/TestData.xlsx";

    public static String getCellData(String sheetName, int row, int col) throws IOException {
        FileInputStream fis = new FileInputStream(EXCEL_PATH);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet(sheetName);
        Row r = sheet.getRow(row);
        Cell c = r.getCell(col);
        String value = c.getStringCellValue();
        workbook.close();
        return value;
    }
}
