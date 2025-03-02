package lr1;

import java.util.Scanner;

public class example6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите имя: ");
        String firstName = in.nextLine();

        System.out.println("Введите фамилию: ");
        String lastName = in.nextLine();

        System.out.println("Введите отчество: ");
        String secondName = in.nextLine();

        System.out.println("Hello " + lastName + ", " + firstName + ", " + secondName);
    }
}
