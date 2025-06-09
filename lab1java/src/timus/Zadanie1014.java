package timus;

import java.util.Scanner;
public class Zadanie1014 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextLong();
        long Q = findSmallestQ(N);
        System.out.println(Q);
    }
    public static long findSmallestQ(long N) {
        if (N == 0) return 10;
        if (N == 1) return 1;
        StringBuilder result = new StringBuilder();

        for (int d = 9; d >= 2; d--) {
            while (N % d == 0) {
                N /= d;
                result.append(d);
            }
        }
        if (N > 1) return -1;
        if (result.length() == 0) return -1;

        result.reverse();

        try {
            return Long.parseLong(result.toString());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}