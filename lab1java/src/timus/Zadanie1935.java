package timus;

import java.util.Arrays;
import java.util.Scanner;

public class Zadanie1935 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int[] part = Arrays.stream(in.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sum = 0;
        int max = 0;
        for (int i =0; i<n; i++) {
            sum += part[i];
            if(max < part[i])
                max = part[i];
        }
        System.out.println(sum + max);
    }
}