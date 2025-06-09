package timus;

import java.util.Scanner;

public class Zadanie1209 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] K = new int[N];
        for (int i = 0; i < N; i++) {
            K[i] = scanner.nextInt();
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int k = K[i];
            int m = (int) Math.sqrt(2 * (k - 1));
            if (m * (m + 1) / 2 + 1 == k) {
                result.append("1 ");
            } else {
                result.append("0 ");
            }
        }
        System.out.println(result.toString().trim());
    }
}