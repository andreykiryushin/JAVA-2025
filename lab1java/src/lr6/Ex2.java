package lr6;

public class Ex2 {
    public static void main(String[] args) {
        // Создаем и запускаем поток
        Thread countThread = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);

                try {
                    // Задержка 1 секунда (1000 миллисекунд)
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Поток был прерван");
                    return; // Завершаем поток при прерывании
                }
            }
            System.out.println("Завершение счета");
        });

        countThread.start(); // Запускаем поток

        try {
            countThread.join(); // Ждем завершения потока
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Основной поток завершил работу");
    }
}