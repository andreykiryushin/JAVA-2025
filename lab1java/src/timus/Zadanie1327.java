package timus;

import java.util.Scanner;

public class Zadanie1327 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите начальный день");
        int startingDay = scanner.nextInt();

        System.out.println("Введите конечный день");
        int finalDay = scanner.nextInt();
        scanner.close();

        int countFuse = 0;
        for (int day = startingDay; day <= finalDay; day++) {
            if (day % 2 == 1) {
                countFuse++;
            }
        }

        System.out.println("Янус спалит предохранитель " + countFuse + " раз(-а)");
    }
}