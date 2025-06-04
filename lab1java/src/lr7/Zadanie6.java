package lr7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Zadanie6 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя файла: ");
        String fileName = in.nextLine();
        System.out.println("Введите слово для поиска: ");
        String searchWord = in.nextLine();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/lr7/"+fileName))) {
            String line;
            int lineNumber = 1;
            boolean wordFound = false;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains(searchWord.toLowerCase())) {
                    System.out.printf("Строка %d: %s%n", lineNumber, line);
                    wordFound = true;
                }
                lineNumber++;
            }
            if (!wordFound) {
                System.out.println("Слово '" + searchWord + "' не найдено в файле.");
            }

        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}