package lr4;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Zadanie3 {
    public static void main(String[] args){
        try{
            Scanner id = new Scanner(System.in);
            System.out.println("Введите длину массива");
            int arraySize = id.nextInt();
            byte[] Numbers = new byte[arraySize];
            System.out.println("Введите массив поэлементно (byte)");
            for (int i = 0; i < arraySize; i++)
                Numbers[i] = id.nextByte();
            int sum = 0;
            for (int i = 0; i < arraySize; i++)
                sum += Numbers[i];
            System.out.println("Сумма всех значений: " + sum);

        }catch (InputMismatchException inputMismatchException ) {
            if (inputMismatchException.getMessage() == null)
                System.out.println("Неверный формат введеных данных!");
            else
                System.out.println("Значение за границами диапазона типа");

        }catch (Exception e) {
            System.out.println("Неизвестная ошибка: " + e.getMessage());
        }
    }
}