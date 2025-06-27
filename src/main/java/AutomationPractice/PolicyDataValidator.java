package AutomationPractice;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

public class PolicyDataValidator {

    public static void main(String[] args) {
        String standardSetFile = "C:\\Java\\collections\\src\\main\\java\\Data\\StandardSet.xlsx";
        String policyDataFile = "C:\\Java\\collections\\src\\main\\java\\Data\\PolicyData.xlsx";
        String resultFile = "C:\\Java\\collections\\src\\main\\java\\Data\\ValidationResults.xlsx";

        try {
            // Step 1: Load Standard Set data
            Map<String, String> standardSet = loadStandardSet(standardSetFile);

            // Step 2: Load Policy Data and validate
            List<Map<String, String>> validationResults = validatePolicyData(policyDataFile, standardSet);

            // Step 3: Write results to Excel
            writeResultsToExcel(validationResults, resultFile);

            System.out.println("Validation completed. Results saved to: " + resultFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getCellValue(Cell cell) {
        if (cell == null) {
            return ""; // Return empty string for null cells
        }

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    // Handle date format
                    return cell.getDateCellValue().toString();
                } else {
                    // Convert numeric to string
                    return String.valueOf(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return "";
            default:
                return "";
        }
    }


    private static Map<String, String> loadStandardSet(String filePath) throws Exception {
        Map<String, String> standardSet = new HashMap<>();
        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // Skip header row

                String productModel = getCellValue(row.getCell(0));
                String firmCode = getCellValue(row.getCell(1));
                String strategyCode = getCellValue(row.getCell(2));

                // Use a composite key for lookup
                String key = productModel + "|" + firmCode;
                standardSet.put(key, strategyCode);
            }
        }
        return standardSet;
    }


    private static List<Map<String, String>> validatePolicyData(String filePath, Map<String, String> standardSet) throws Exception {
        List<Map<String, String>> results = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // Skip header row

                String policyNumber = getCellValue(row.getCell(0));
                String productModel = getCellValue(row.getCell(4));
                String firmCode = getCellValue(row.getCell(3));
                String strategyCode = getCellValue(row.getCell(5));

                String key = productModel + "|" + firmCode;
                String expectedStrategyCode = standardSet.get(key);

                Map<String, String> result = new HashMap<>();
                result.put("Policy Number", policyNumber);
                result.put("ProductModel", productModel);
                result.put("FirmCode", firmCode);

                if (expectedStrategyCode == null) {
                    result.put("Status", "Missing in Standard Set");
                } else if (!expectedStrategyCode.equals(strategyCode)) {
                    result.put("Status", "Mismatch");
                    result.put("Expected Strategy Code", expectedStrategyCode);
                } else {
                    result.put("Status", "Valid");
                }

                results.add(result);
            }
        }
        return results;
    }


    private static void writeResultsToExcel(List<Map<String, String>> results, String filePath) throws Exception {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Validation Results");

            // Create header row
            Row headerRow = sheet.createRow(0);
            String[] headers = {"Policy Number", "ProductModel", "FirmCode", "Status", "Expected Strategy Code"};
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
            }

            // Write data rows
            int rowNum = 1;
            for (Map<String, String> result : results) {
                Row row = sheet.createRow(rowNum++);

                row.createCell(0).setCellValue(result.get("Policy Number"));
                row.createCell(1).setCellValue(result.get("ProductModel"));
                row.createCell(2).setCellValue(result.get("FirmCode"));
                row.createCell(3).setCellValue(result.get("Status"));
                row.createCell(4).setCellValue(result.getOrDefault("Expected Strategy Code", ""));
            }

            // Write to file
            try (FileOutputStream fos = new FileOutputStream(new File(filePath))) {
                workbook.write(fos);
            }
        }
    }
}
