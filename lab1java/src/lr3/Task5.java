package lr3;

import java.util.HashMap;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        Scanner id = new Scanner(System.in);

        System.out.println("Введите через пробел ключ и значение (10 пар)");
        for (int i = 0; i < 10; i++) {
            String[] elements = id.nextLine().split(" ");
            hashMap.put(Integer.parseInt(elements[0]), elements[1]);
        }

        long res3 = 1;
        boolean hasLongEl = false;
        StringBuilder res2 = new StringBuilder();

        System.out.println("Элементы, где ключ > 5:");
        for (var entry : hashMap.entrySet()) {
            if (entry.getValue().length() > 5) {
                res3 *= entry.getKey();
                hasLongEl = true;
            }

            if (entry.getKey() == 0) {
                res2.append(entry.getValue()).append(". ");
            }

            if (entry.getKey() > 5) {
                System.out.println(entry.getValue());
            }
        }

        if (res2.length() > 0) {
            res2.setLength(res2.length() - 2);
            System.out.println("Элементы, где ключ = 0: " + res2.toString());
        } else {
            System.out.println("Элементов, где ключ = 0, нет");
        }

        if (hasLongEl) {
            System.out.println("Произведение ключей, где длина строки > 5: " + res3);
        } else {
            System.out.println("Нет строк с длиной > 5");
        }
    }
}