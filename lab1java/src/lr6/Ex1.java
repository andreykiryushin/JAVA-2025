import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Ex1 {
    public static void main(String[] args) {
        // Создаем и запускаем первый поток
        Thread thread1 = new Thread(new TimePrinter("Поток 1"));
        thread1.start();

        // Создаем и запускаем второй поток
        Thread thread2 = new Thread(new TimePrinter("Поток 2"));
        thread2.start();

        // Ожидаем 10 секунд
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Прерываем потоки
        thread1.interrupt();
        thread2.interrupt();
    }

    static class TimePrinter implements Runnable {
        private final String threadName;
        private final DateTimeFormatter timeFormatter =
                DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

        public TimePrinter(String name) {
            this.threadName = name;
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.printf("%s: текущее время - %s%n",
                        threadName,
                        LocalTime.now().format(timeFormatter));

                try {
                    Thread.sleep(500); // Пауза 0.5 секунды между выводами
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Повторно устанавливаем флаг прерывания
                }
            }
            System.out.printf("%s завершил работу%n", threadName);
        }
    }
}