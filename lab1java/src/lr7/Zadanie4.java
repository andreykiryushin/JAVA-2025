package lr7;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Zadanie4 {
    public static void main(String[] args) {
        File inputFile = new File("src/lr7/input.txt");
        File outputFile = new File("src/lr7/output.txt");
        if (!inputFile.exists()) {
            System.err.println("Ошибка: Файл input.txt не найден!");
            return;
        }
        try (FileReader reader = new FileReader(inputFile);
             FileWriter writer = new FileWriter(outputFile)) {
            int c;
            while ((c = reader.read()) != -1) {
                writer.write(c);
            }
            System.out.println("Файл успешно скопирован в output.txt!");
        } catch (IOException e) {
            System.err.println("Ошибка при копировании: " + e.getMessage());
            e.printStackTrace();
        }
    }
}