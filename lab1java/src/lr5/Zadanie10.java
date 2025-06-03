package lr5;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Zadanie10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку");
        String string = in.nextLine();
        List<String> strings = List.of(string.split(  " "));
        System.out.println("\n Исходный список строк : \n");
        for (String e : strings) {
            System.out.println(e);
        }
        List<String> stringsAfter = filterNonAlphabeticStrings(strings);
        System.out.println("\n Список строк, которые содержат только буквы: \n");
        for (String e : stringsAfter) {
            System.out.println(e);
        }
    }

    public static List<String> filterNonAlphabeticStrings (List<String> list)
    {
        return list.stream()
                .filter(s -> s.matches("[\\p{L}]+"))
                .collect(Collectors.toList());
    }
}