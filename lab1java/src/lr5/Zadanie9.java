package lr5;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Zadanie9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер массива");
        int size = in.nextInt();
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(1000);
        }
        System.out.println("Введите порог");
        int threshold = in.nextInt();
        System.out.println("Исходный массив: ");
        System.out.println(Arrays.toString(arr));
        int[] arrResult = filterSmallNumbers(arr,threshold);
        System.out.printf("Массив чисел, которые больше %d : \n", threshold);
        System.out.println(Arrays.toString(arrResult));
    }

    public static int[] filterSmallNumbers(int[] arr, int threshold) {
        return Arrays.stream(arr).filter(x -> x > threshold).toArray();
    }
}