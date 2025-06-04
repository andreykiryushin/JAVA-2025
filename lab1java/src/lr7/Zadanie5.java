package lr7;

import java.io.File;
import java.util.Scanner;

public class Zadanie5 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя файла");
        String name = in.nextLine();
        File file = new File("src/lr7/"+name);
        if (file.exists()) {
            long fileSize = file.length();
            System.out.println("Размер файла '" + name + ":" + fileSize + " байт");
        } else {
            System.out.println("Файл не существует");
        }

        in.close();
    }
}