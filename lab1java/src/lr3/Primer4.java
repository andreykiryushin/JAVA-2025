package lr3;

public class Primer4 {
    // Рекурсивный метод вычисления факториала
    public static int factorial(int n) {
        if (n == 0 || n == 1) {  // Базовый случай
            return 1;
        }
        return n * factorial(n - 1);  // Рекурсивный вызов
    }

    public static void main(String[] args) {
        int number = 5;  // Число, для которого вычисляем факториал
        int result = factorial(number);
        System.out.println(number + "! = " + result);
    }
}