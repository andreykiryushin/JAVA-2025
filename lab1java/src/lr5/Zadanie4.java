package lr5;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Zadanie4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        List<String> strings = List.of(string.split(  " "));
        System.out.println("\n"+ "Исходный список строк : " + "\n");
        for (String e : strings) {
            System.out.println(e);
        }
        List<String> stringsAfter = filterCapitalizedStrings(strings);
        System.out.println("\n"+
                "Список строк которые начинаются с большой буквы " + "\n");
        for (String e : stringsAfter) {
            System.out.println(e);
        }
    }

    public static List<String> filterCapitalizedStrings (List<String> list)
    {
        return list.stream()
                .filter(s -> Character.isUpperCase(s.charAt(0)))
                .collect(Collectors.toList());
    }
}