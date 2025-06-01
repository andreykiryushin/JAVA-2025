package lr3;

public class Primer1 {
    public static void main(String[] args) {
        int x = 1; // Начальное значение x (можно изменить)

        System.out.println("Последовательность значений:");
        while (x >= 0 && x < 20) {
            System.out.print(x + " ");
            x = 2 * x + 1; // Вычисляем следующее значение
        }
    }
}