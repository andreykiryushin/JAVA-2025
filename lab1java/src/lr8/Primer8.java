package lr8;

import java.io. FileInputStream;
import java.io. IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class Primer8 {
    public static void main(String[] args)  throws IOException{
        String filePath = "src/lr8/example3.xlsx";
        FileInputStream inputStream = new FileInputStream(filePath);

        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

        XSSFSheet sheet = workbook. getSheet( "Товары");

        for (Row row : sheet){
            for (Cell cell : row){
                System.out.print(cell.toString() + "\t");
            }
            System.out.println();
        }

        workbook.close();
        inputStream.close();
    }
}