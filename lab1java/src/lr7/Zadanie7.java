package lr7;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Zadanie7 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя файла: ");
        String fileName = in.nextLine();

        System.out.println("Введите текст: ");
        String text = in.nextLine();

        try (FileOutputStream outputStream = new FileOutputStream("src/lr7/"+fileName)) {
            outputStream.write(text.getBytes());
            System.out.println("Данные записаны в файл:" + fileName);
            System.out.println("Количество символов:" + text.length());
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}