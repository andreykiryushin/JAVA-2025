package lr1;

import java.util.Scanner;

public class example12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Сколько Вам лет?: ");
        int age = in.nextInt();
        int year = 2025 - age;

        System.out.println("Ваш год рождения: " + year);
        in.close();

    }
}
