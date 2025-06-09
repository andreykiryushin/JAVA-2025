package timus;

import java.util.Scanner;

public class Zadanie1068 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int result = 0;

        if (n > 0) {
            for (int i = 1; i <= n; i++){
                result += i;
            }
        } else {
            for (int i = 1; i >= n; i--) {
                result += i;
            }
        }

        System.out.println(result);
    }
}