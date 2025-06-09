package timus;

import java.util.Scanner;

public class Zadanie2100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // Переход на следующую строку

        int guests = 2; // Маршалл и Лили

        for (int i = 0; i < n; i++) {
            String response = scanner.nextLine();
            if (response.contains("+one")) {
                guests += 2;
            } else {
                guests += 1;
            }
        }

        if (guests == 13) {
            guests += 1; // Добавляем манекен
        }

        int cost = guests * 100;
        System.out.println(cost);
    }
}