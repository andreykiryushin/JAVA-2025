package lr4;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
public class Zadanie2 {
    public static void main(String[] args) {
        try {
            Scanner id = new Scanner(System.in);
            System.out.println("Введите высоту массива");
            int sizey = id.nextInt();
            System.out.println("Введите ширину массива");
            int sizex = id.nextInt();
            int[][] matrix = new int[sizey][sizex];
            int num = 0;
            for (int i = 0; i < sizey; i++)
                for (int j = 0; j < sizex; j++) {
                    matrix[i][j] = num;
                    num++;
                }
            System.out.println("Введите столбец:");
            int f = id.nextInt();
            System.out.println("Вывод столбца:");
            for (int i = 0; i < f; i++)
                System.out.print(matrix[i][f-1] + " ");
        } catch (InputMismatchException inputMismatchException ) {
            System.out.println("Неверный формат введеных данных!");
        } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException ) {
            System.out.println("Такого столбца нет!");
        } catch (Exception e) {
            System.out.println("Неизвестная ошибка: " + e.getMessage());
        }
    }
}