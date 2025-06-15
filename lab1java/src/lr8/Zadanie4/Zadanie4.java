package lr8.Zadanie4;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class Zadanie4 {
    public static void main(String[] args) {
        System.setProperty("org.apache.poi.util.POILogger", "org.apache.poi.util.NullLogger");

        Scanner in = new Scanner(System.in);
        System.out.println("Введите полный путь к файлу (например: C:/data/zadanie4.xlsx):");
        String filePath = in.nextLine();

        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // Берём первый лист

            System.out.println("\nДанные из файла:");
            for (Row row : sheet) {
                for (Cell cell : row) {
                    System.out.print(getCellValue(cell) + "\t");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        } finally {
            in.close();
        }
    }

    private static String getCellValue(Cell cell) {
        if (cell == null) return "";
        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue();
            case NUMERIC -> String.valueOf(cell.getNumericCellValue());
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            default -> "";
        };
    }
}