package lr1;

import java.util.Scanner;

public class example9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите название месяца: ");
        String month = in.nextLine();

        System.out.println("Введите продолжительность месяца в днях: ");
        int day = in.nextInt();

        System.out.println(month + " - " + day + " дней.");

        in.close();

    }
}

