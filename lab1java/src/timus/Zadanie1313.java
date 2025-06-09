package timus;

import java.util.*;

public class Zadanie1313 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> set1 = readSet(sc);
        Set<Integer> set2 = readSet(sc);
        Set<Integer> set3 = readSet(sc);

        set1.retainAll(set2);
        set1.retainAll(set3);
        System.out.println(set1.size());
    }

    static Set<Integer> readSet(Scanner sc) {
        int n = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        while (n-- > 0) set.add(sc.nextInt());
        return set;
    }
}