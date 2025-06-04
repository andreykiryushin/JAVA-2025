package lr6;

public class Ex3 {
    public static void main(String[] args) {
        // Создаем и запускаем поток для четных чисел
        Thread evenThread = new Thread(() -> {
            for (int i = 2; i <= 10; i += 2) {
                System.out.println("Четный поток: " + i);
                try {
                    Thread.sleep(500); // Задержка 0.5 секунды
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Создаем и запускаем поток для нечетных чисел
        Thread oddThread = new Thread(() -> {
            for (int i = 1; i <= 9; i += 2) {
                System.out.println("Нечетный поток: " + i);
                try {
                    Thread.sleep(500); // Задержка 0.5 секунды
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Запускаем оба потока
        evenThread.start();
        oddThread.start();

        // Ждем завершения обоих потоков
        try {
            evenThread.join();
            oddThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Оба потока завершили работу");
    }
}