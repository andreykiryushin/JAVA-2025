package lr5;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Zadanie6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку");
        String string = in.nextLine();
        System.out.println("Введите подстроку");
        String substring = in.nextLine();
        List<String> strings = List.of(string.split(  " "));
        System.out.println("\n"+ "Исходный список строк : " + "\n");
        for (String e : strings) {
            System.out.println(e);
        }
        List<String> stringsAfter = filterSubstring(strings,substring);
        System.out.println("\n"+ "Список строк содержащих подстроку: " + "\n");
        for (String e : stringsAfter) {
            System.out.println(e);
        }
    }

    public static List<String> filterSubstring (List<String> list, String substring)
    {
        return list.stream()
                .filter(s -> s.contains(substring))
                .collect(Collectors.toList());
    }
}