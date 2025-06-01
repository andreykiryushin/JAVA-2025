package lr3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество элементов:");
        int n = scanner.nextInt();

        Task6_1.doTask(n);
       Task6_2.doTask(n);

        scanner.close();
    }
}