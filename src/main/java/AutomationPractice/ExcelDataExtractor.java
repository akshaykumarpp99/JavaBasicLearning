package AutomationPractice;//package AutomationPractice;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelDataExtractor {
    public static void main(String[] args) {




        String policyExcelFilePath = "C:\\Users\\JE385EF\\OneDrive - EY\\Desktop\\DTCC Automation\\XML\\Inputs\\XMLDataExtract.xlsx";
        String ActualExcelFilePath = "C:\\Users\\JE385EF\\OneDrive - EY\\Desktop\\DTCC Automation\\XML\\Updated Strategy codes.xlsx";
        List<Map<String, Object>> policyExtractedData = new ArrayList<>();
        List<Map<String, Object>> actualExtractedData = new ArrayList<>();

//      Actual StrategyCode Data Extraction
        try (FileInputStream fis = new FileInputStream(ActualExcelFilePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(4); // Read the first sheet

            // Assuming the first row contains headers, data starts from the second row
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                if (row == null) continue; // Skip empty rows

                // Extract data from columns
                String prodModeID = getCellValue(row.getCell(0)); // Column 1
                String firmCode = getCellValue(row.getCell(1));   // Column 2
                String firmName = getCellValue(row.getCell(2));    // Column 3
                String strategyCodes = getCellValue(row.getCell(3)); // Column 4

                // Split strategy codes by comma
                List<String> strategyCodeList = new ArrayList<>();
                if (strategyCodes != null && !strategyCodes.isEmpty()) {
                    String[] strategies = strategyCodes.split(",");
                    for (String strategy : strategies) {
                        strategyCodeList.add(strategy.trim());
                    }
                }

                // Store the data in a Map
                Map<String, Object> record = new HashMap<>();
                record.put("prodModeID", prodModeID);
                record.put("firmCode", firmCode);
                record.put("firmName", firmName);
                record.put("strategyCodes", strategyCodeList);

                // Add the record to the list
                actualExtractedData.add(record);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        //         Print the Actual strategycodes extracted data
//        System.out.println("Extracted Data:");
//        for (Map<String, Object> record : actualExtractedData) {
//            System.out.println("ProdModeID: " + record.get("prodModeID"));
//            System.out.println("FirmCode: " + record.get("firmCode"));
//            System.out.println("FirmName: " + record.get("firmName"));
//            System.out.println("Strategy Codes: " + record.get("strategyCodes"));
//            System.out.println("-----------------------------------");
//        }


        //      Policy Data Extraction
        try (FileInputStream fis = new FileInputStream(policyExcelFilePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // Read the first sheet

            // Assuming the first row contains headers, data starts from the second row
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                if (row == null) continue; // Skip empty rows

                // Extract data from columns
                String policyNumber = getCellValue(row.getCell(0)); // Column 1
                String prodModeID = getCellValue(row.getCell(4));   // Column 2
                String firmCode = getCellValue(row.getCell(3));    // Column 3
                String strategyCodes = getCellValue(row.getCell(5)); // Column 4

                // Split strategy codes by comma
                List<String> strategyCodeList = new ArrayList<>();
                if (strategyCodes != null && !strategyCodes.isEmpty()) {
                    String[] strategies = strategyCodes.split(",");
                    for (String strategy : strategies) {
                        strategyCodeList.add(strategy.trim());
                    }
                }

                // Store the data in a Map
                Map<String, Object> record = new HashMap<>();
                record.put("policyNumber", policyNumber);
                record.put("productId", prodModeID);
                record.put("firmCode", firmCode);
                record.put("strategyCodes", strategyCodeList);

                // Add the record to the list
                policyExtractedData.add(record);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print the policy extracted data
//        System.out.println("Extracted Data:");
//        for (Map<String, Object> record : policyExtractedData) {
//            System.out.println("Policy Number: " + record.get("policyNumber"));
//            System.out.println("Product ID: " + record.get("productId"));
//            System.out.println("Firm Code: " + record.get("firmCode"));
//            System.out.println("Strategy Codes: " + record.get("strategyCodes"));
//            System.out.println("-----------------------------------");
//        }

    }

    // Utility method to handle null cell values
    private static String getCellValue(Cell cell) {
        if (cell == null) return "";
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf((int) cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return "";
        }
    }



}
