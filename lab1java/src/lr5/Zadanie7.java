package lr5;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Zadanie7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер массива");
        int size = in.nextInt();
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt();
        }
        System.out.println("Введите число");
        int number = in.nextInt();
        System.out.println("Исходный массив: ");
        System.out.println(Arrays.toString(arr));
        int[] arrResult = filterNonDivisibleNumbers(arr,number);
        System.out.printf("Массив чисел, делящихся на %d : \n", number);
        System.out.println(Arrays.toString(arrResult));
    }

    public static int[] filterNonDivisibleNumbers(int[] arr, int num) {
        return Arrays.stream(arr).filter(x -> x % num == 0).toArray();
    }
}