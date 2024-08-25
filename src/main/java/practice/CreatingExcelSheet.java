package practice;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class CreatingExcelSheet {

    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet sheet = workbook.createSheet("SampleSheet");

        String[][] data = {
                {"Name","Age","City"},
                {"A","20","CityA"},
                {"B","30","CityB"},
                {"C","40","CityC"},
                {"D","50","CityD"}
        };

        for(int rowIndex=0; rowIndex<data.length;rowIndex++){
            Row row = sheet.createRow(rowIndex);

            for(int colIndex=0; colIndex<data[rowIndex].length;colIndex++){
                Cell cell = row.createCell(colIndex);
                cell.setCellValue(data[rowIndex][colIndex]);
            }
        }

        FileOutputStream out = new FileOutputStream("DemoExcel.xlsx");
        workbook.write(out);
        out.close();
    }
}
