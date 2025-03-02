package lr1;

import java.util.Scanner;

public class example11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Ваше имя: ");
        String name = in.nextLine();

        System.out.println("Напишите свой год рождения: ");
        int year = in.nextInt();
        int age = 2025 - year;

        System.out.println("Ваше имя и  возраст: " + name +", " + age);
        in.close();

    }
}
