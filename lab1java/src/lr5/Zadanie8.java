package lr5;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Zadanie8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер массива");
        int size = in.nextInt();
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(1000);
        }
        System.out.println("Введите длину");
        int length = in.nextInt();
        System.out.println("Исходный массив: ");
        System.out.println(Arrays.toString(arr));
        int[] arrResult = filterShortNumbers(arr,length);
        System.out.printf("Массив чисел, которые длиннее %d : \n", length);
        System.out.println(Arrays.toString(arrResult));
    }

    public static int[] filterShortNumbers(int[] arr, int length) {
        return Arrays.stream(arr)
                .filter(x -> String.valueOf(Math.abs(x)).length() > length)
                .toArray();
    }
}