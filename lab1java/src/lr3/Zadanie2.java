package lr3;

import java.util.Scanner;

public class Zadanie2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите число:");
        int n = in.nextInt();
        toBinary(n);
    }

    public static void toBinary(int n) {
        if (n >= 2) {
            toBinary(n / 2);
        }
        System.out.print(n % 2);
    }
}