package timus;

import java.util.Scanner;

public class Zadanie2031 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char[] arr = {'1', '0', '6', '8'};

        if (n > 4) {
            System.out.println("Glupenky Pierre");
        } else {
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i]);
                if (i != n - 1) {
                    System.out.print(" ");
                }
            }
        }
        in.close();
    }
}