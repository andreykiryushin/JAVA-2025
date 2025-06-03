package lr5;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Zadanie2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите размер массива:");
        int size = scanner.nextInt();

        int[] arr = new int[size];
        Random random = new Random();

        // Заполнение массива случайными числами
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100); // числа от 0 до 99
        }

        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(arr));

        int[] evenNumbers = filterEvenNumbers(arr);

        System.out.println("Массив четных чисел:");
        System.out.println(Arrays.toString(evenNumbers));

        scanner.close();
    }

    public static int[] filterEvenNumbers(int[] arr) {
        return Arrays.stream(arr)
                .filter(x -> x % 2 == 0)
                .toArray();
    }
}