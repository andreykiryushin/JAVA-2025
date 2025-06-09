package timus;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Zadanie1293 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Чтение входных данных
        System.out.println("Введите N, A, B через пробел:");
        String input = scanner.nextLine();

        // Парсинг чисел
        List<Integer> dimensions = Arrays.stream(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // Проверка количества параметров
        if (dimensions.size() != 3) {
            System.out.println("Ошибка: требуется 3 числа (N, A, B)");
            return;
        }

        int N = dimensions.get(0); // Количество панелей
        int A = dimensions.get(1); // Длина панели
        int B = dimensions.get(2); // Ширина панели

        // Вычисление общего количества нанокраски (2 стороны у каждой панели)
        int totalPaint = N * A * B * 2;

        System.out.println("Общее количество нанокраски: " + totalPaint);

        scanner.close();
    }
}