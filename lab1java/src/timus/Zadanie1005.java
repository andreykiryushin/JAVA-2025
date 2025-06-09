package timus;

import java.util.*;

public class Zadanie1005 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] weights = new int[n];
        int total = 0;

        for (int i = 0; i < n; i++) {
            weights[i] = in.nextInt();
            total += weights[i];
        }

        int minDiff = Integer.MAX_VALUE;

        for (int mask = 0; mask < (1 << n); mask++) {
            int sum1 = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum1 += weights[i];
                }
            }
            int sum2 = total - sum1;
            minDiff = Math.min(minDiff, Math.abs(sum1 - sum2));
        }

        System.out.println(minDiff);
    }
}
