package timus;

import java.util.Scanner;

public class Zadanie2025 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int base = n / k;
            int remainder = n % k;
            int totalFights = (n * n - (remainder * (base + 1) * (base + 1) + (k - remainder) * base * base)) / 2;
            System.out.println(totalFights);
        }
        scanner.close();
    }
}