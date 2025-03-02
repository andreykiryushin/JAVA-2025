package lr1;

import java.util.Scanner;

public class example15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите первое число: ");
        int a = in.nextInt();

        System.out.println("Введите второе число: ");
        int b  = in.nextInt();
        int SUMM = a + b;
        int SUB = a - b;


        System.out.println("Сумма:" + SUMM + "," + "Разность:" + SUB);
        in.close();

    }
}
