package lr1;

import java.util.Scanner;
public class example8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите день недели: ");
        String day = in.nextLine();

        System.out.println("Введите название месяца: ");
        String month = in.nextLine();

        System.out.println("Введите сегодняшнюю дату: ");
        int date = in.nextInt();

        System.out.println(day + ", " + date + "," + month);

    }
}
