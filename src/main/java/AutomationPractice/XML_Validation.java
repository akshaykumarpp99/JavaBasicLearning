package AutomationPractice;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class XML_Validation {

            public static void main(String[] args) throws IOException {
                // Read source and target lists from Excel
                List<Map<String, Object>> sourceList = readExcel("C:\\Users\\JE385EF\\OneDrive - EY\\Desktop\\DTCC Automation\\XML\\Inputs\\XMLDataExtract.xlsx");
                List<Map<String, Object>> targetList = readExcel("C:\\Users\\JE385EF\\OneDrive - EY\\Desktop\\DTCC Automation\\XML\\Updated Strategy codes.xlsx");

                // List to store the updated results
                List<Map<String, Object>> resultList = new ArrayList<>();

                // Compare and update counts for each strategy code
                for (Map<String, Object> source : sourceList) {
                    String sourceProductId = (String) source.get("productId");
                    String sourceFirmCode = (String) source.get("firmCode");
                    String sourcePolicyNumber = (String) source.get("policyNumber");
                    List<String> sourceStrategyCodes = (List<String>) source.get("strategyCodes");

                    // Find matching target record for productId and firmCode
                    Optional<Map<String, Object>> targetRecordOpt = targetList.stream()
                            .filter(target -> sourceProductId.equals(target.get("productId")) &&
                                    sourceFirmCode.equals(target.get("firmCode")))
                            .findFirst();

                    if (targetRecordOpt.isPresent()) {
                        Map<String, Object> targetRecord = targetRecordOpt.get();
                        List<String> targetStrategyCodes = (List<String>) targetRecord.get("strategyCodes");

                        // Count occurrences for each strategy code
                        for (String strategy : sourceStrategyCodes) {
                            int count = targetStrategyCodes.contains(strategy) ? 1 : 0;

                            // Add results to the result list
                            Map<String, Object> result = new HashMap<>();
                            result.put("policyNumber", sourcePolicyNumber);
                            result.put("productId", sourceProductId);
                            result.put("firmCode", sourceFirmCode);
                            result.put("strategyCode", strategy);
                            result.put("count", count);
                            resultList.add(result);
                        }
                    }
                }

                // Write the results to an Excel sheet
                writeExcel("output.xlsx", resultList);
            }

            // Method to read Excel and return a list of maps
            public static List<Map<String, Object>> readExcel(String filePath) throws IOException {
                List<Map<String, Object>> list = new ArrayList<>();
                FileInputStream fis = new FileInputStream(filePath);
                Workbook workbook = new XSSFWorkbook(fis);
                Sheet sheet = workbook.getSheetAt(0);

                // Read headers
                Row headerRow = sheet.getRow(0);
                List<String> headers = new ArrayList<>();
                for (Cell cell : headerRow) {
                    headers.add(cell.getStringCellValue());
                }

                // Read data rows
                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    Row row = sheet.getRow(i);
                    Map<String, Object> map = new HashMap<>();
                    for (int j = 0; j < headers.size(); j++) {
                        Cell cell = row.getCell(j);
                        if (cell != null) {
                            if (headers.get(j).equals("strategyCodes")) {
                                map.put(headers.get(j), Arrays.asList(cell.getStringCellValue().split(",")));
                            } else {
                                map.put(headers.get(j), cell.getStringCellValue());
                            }
                        }
                    }
                    list.add(map);
                }
                workbook.close();
                fis.close();
                return list;
            }

            // Method to write a list of maps to an Excel file
            public static void writeExcel(String filePath, List<Map<String, Object>> data) throws IOException {
                Workbook workbook = new XSSFWorkbook();
                Sheet sheet = workbook.createSheet("Results");

                // Write headers
                Row headerRow = sheet.createRow(0);
                if (!data.isEmpty()) {
                    Map<String, Object> firstRecord = data.get(0);
                    int colIndex = 0;
                    for (String key : firstRecord.keySet()) {
                        Cell cell = headerRow.createCell(colIndex++);
                        cell.setCellValue(key);
                    }
                }

                // Write data rows
                int rowIndex = 1;
                for (Map<String, Object> record : data) {
                    Row row = sheet.createRow(rowIndex++);
                    int colIndex = 0;
                    for (Object value : record.values()) {
                        Cell cell = row.createCell(colIndex++);
                        if (value instanceof List) {
                            cell.setCellValue(String.join(",", (List<String>) value));
                        } else {
                            cell.setCellValue(value.toString());
                        }
                    }
                }

                // Save to file
                FileOutputStream fos = new FileOutputStream(filePath);
                workbook.write(fos);
                fos.close();
                workbook.close();
            }


}




