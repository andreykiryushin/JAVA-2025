package lr6;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;
public class Ex6 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер массива:");
        int size = in.nextInt();

        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000); // числа от 0 до 9999
        }

        System.out.println("Массив: " + Arrays.toString(array));
        System.out.println("Сумма элементов: " + parallelSum(array));
    }

    public static int parallelSum(int[] array) throws InterruptedException, ExecutionException {
        // Получаем количество ядер процессора
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(cores);

        // Размер части массива для каждого потока
        int chunkSize = (array.length + cores - 1) / cores;

        // Список для хранения Future результатов
        List<Future<Integer>> futures = new ArrayList<>();

        // Раздаем задачи потокам
        for (int i = 0; i < cores; i++) {
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, array.length);

            if (start >= array.length) break;

            final int finalStart = start;
            final int finalEnd = end;

            Callable<Integer> task = () -> {
                int sum = 0;
                for (int j = finalStart; j < finalEnd; j++) {
                    sum += array[j];
                }
                return sum;
            };

            futures.add(executor.submit(task));
        }

        // Суммируем результаты
        int totalSum = 0;
        for (Future<Integer> future : futures) {
            totalSum += future.get();
        }

        executor.shutdown();
        return totalSum;
    }
}