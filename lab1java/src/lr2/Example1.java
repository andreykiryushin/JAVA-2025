package lr2;

import java.util.Arrays;
import java.util.Random;

public class Example1 {
    public static void main(String[] args) {
        // Создаем массив из 15 элементов
        int[] array = new int[15];
        Random random = new Random();

        // Заполняем массив случайными числами от 0 до 99
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        // Выводим массив в консоль
        System.out.println("Сгенерированный массив: " + Arrays.toString(array));

        // Находим минимальный элемент
        int min = array[0];
        for (int num : array) {
            if (num < min) {
                min = num;
            }
        }

        // Выводим минимальное значение
        System.out.println("Минимальное значение в массиве: " + min);

        // Находим и выводим все индексы минимального элемента
        System.out.print("Индексы минимального элемента: ");
        for (int i = 0; i < array.length; i++) {
            if (array[i] == min) {
                System.out.print(i + " ");
            }
        }
    }
}