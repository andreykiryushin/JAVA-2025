package lr5;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Zadanie3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите размер массивов:");
        int size = scanner.nextInt();

        int[] arr1 = new int[size];
        int[] arr2 = new int[size];
        Random random = new Random();

        // Заполнение массивов случайными числами от 0 до 199
        for (int i = 0; i < size; i++) {
            arr1[i] = random.nextInt(200);
            arr2[i] = random.nextInt(200);
        }

        System.out.println("Элементы первого массива:");
        System.out.println(Arrays.toString(arr1));
        System.out.println("Элементы второго массива:");
        System.out.println(Arrays.toString(arr2));

        int[] commonElements = findCommonElements(arr1, arr2);

        System.out.println("Совпадающие элементы:");
        System.out.println(Arrays.toString(commonElements));

        scanner.close();
    }

    public static int[] findCommonElements(int[] arr1, int[] arr2) {
        return Arrays.stream(arr1)
                .distinct()  // Убираем дубликаты
                .filter(x -> Arrays.stream(arr2).anyMatch(y -> y == x))
                .toArray();
    }
}