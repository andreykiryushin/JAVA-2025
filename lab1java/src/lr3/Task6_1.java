package lr3;

import java.util.ArrayList;

public class Task6_1 {
    public static void doTask(int w) {
        ArrayList<Integer> circle = new ArrayList<>();

        // Заполнение списка числами от 1 до w
        for (int i = 1; i <= w; i++) {
            circle.add(i);
        }

        long startTime = System.nanoTime();
        int index = 0;

        // Алгоритм "Иосифа" - удаление каждого второго элемента
        while (circle.size() > 1) {
            index = (index + 1) % circle.size();
            circle.remove(index);
            index = index % circle.size();
        }

        long endTime = System.nanoTime();

        System.out.println("ArrayList: Остался один человек: " + circle.get(0));
        System.out.println("ArrayList: Время выполнения " + (endTime - startTime) + " наносекунд");
    }
}