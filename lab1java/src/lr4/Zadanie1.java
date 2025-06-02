package lr4;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Zadanie1 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            Scanner id = new Scanner(System.in);
            System.out.println("Введите длину массива");
            int arraySize = id.nextInt();
            int sum = 0;
            int count = 0;
            int[] arr = new int[arraySize];
            System.out.println("Введите массив поэлементно");
            for (int i = 0; i < arraySize; i++)
                arr[i] = id.nextInt();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > 0) {
                    sum += arr[i];
                    count = 0;
                }
            }
            System.out.println("Среднее положительных элементов: " + (double)sum/count);

        } catch (NegativeArraySizeException negativeArraySizeException ){
            System.out.println("Отрицательная длина массива!");
        } catch (InputMismatchException inputMismatchException ) {
            System.out.println("Неверный формат введеных данных!");
        } catch (ArithmeticException arithmeticException) {
            System.out.println("В массиве отсутствуют положительные элементы!");
        } catch (Exception e) {
            System.out.println("Неизвестная ошибка: " + e.getMessage());
        }
    }
}