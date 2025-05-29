package lr2;

public class Example2 {
    public static void main(String[] args) {
        int rows = 6;
        int cols = 6;
        int[][] matrix = new int[rows][cols];

        int value = 1;

        for (int i = 0; i < rows; i++) {
            // Чётная строка — слева направо
            if (i % 2 == 0) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = value++;
                }
            }
            // Нечётная строка — справа налево
            else {
                for (int j = cols - 1; j >= 0; j--) {
                    matrix[i][j] = value++;
                }
            }
        }

        // Вывод массива на экран
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
