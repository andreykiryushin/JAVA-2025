package lr3;

import java.util.*;

public class CollectionBenchmark {
    private static final int M = 15_000_000;

    public static void main(String[] args) {
        System.out.println("\nТестирование для коллекций с 15 000 000 элементов");

        // Используем полные имена классов из java.util
        java.util.Deque<Integer> arrayDeque = new java.util.ArrayDeque<>();
        java.util.List<Integer> arrayList = new java.util.ArrayList<>();
        java.util.List<Integer> linkedList = new java.util.LinkedList<>();

        fillCollection(arrayDeque, M);
        fillCollection(arrayList, M);
        fillCollection(linkedList, M);

        System.out.println("\nДобавление в начало:");
        measureTime(() -> arrayList.add(0, 1000), "ArrayList");
        measureTime(() -> linkedList.add(0, 1000), "LinkedList");
        measureTime(() -> arrayDeque.addFirst(1000), "ArrayDeque");

        System.out.println("\nДобавление в конец:");
        measureTime(() -> arrayList.add(1000), "ArrayList");
        measureTime(() -> linkedList.add(1000), "LinkedList");
        measureTime(() -> arrayDeque.addLast(1000), "ArrayDeque");

        System.out.println("\nДобавление в середину:");
        measureTime(() -> arrayList.add(M/2, 1000), "ArrayList");
        measureTime(() -> linkedList.add(M/2, 1000), "LinkedList");
    }

    private static void fillCollection(Collection<Integer> collection, int count) {
        for (int i = 0; i < count; i++) {
            collection.add(i);
        }
    }

    private static void measureTime(Runnable action, String collectionName) {
        long start = System.nanoTime();
        action.run();
        long end = System.nanoTime();
        System.out.printf("%s: %,d нс\n", collectionName, end - start);
    }
}