package lr3;

import java.util.LinkedList;

public class Task6_2 {
    public static void doTask(int n) {
        LinkedList<Integer> circle = new LinkedList<>();

        // Заполнение списка числами от 1 до n
        for (int i = 1; i <= n; i++) {
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

        System.out.println("LinkedList: Остался один человек: " + circle.get(0));
        System.out.println("LinkedList: Время выполнения " + (endTime - startTime) + " наносекунд");
    }
}