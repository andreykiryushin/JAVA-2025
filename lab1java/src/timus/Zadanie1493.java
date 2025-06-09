package timus;

import java.util.Scanner;

public class Zadanie1493 {
    public static int getSum(String subStr) {
        int result = 0;

        for (int i = 0; i < subStr.length(); i++){
            result += Character.getNumericValue(subStr.charAt(i));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();
        String first = str.substring(0, 3);
        String second = str.substring(3, 6);

        int sumFirst = getSum(first);
        int beforeSecondInt = Integer.parseInt(second) - 1;
        int afterSecondInt = Integer.parseInt(second) + 1;
        int sumSecondBefore = getSum(Integer.toString(beforeSecondInt));
        int sumSecondAfter = getSum(Integer.toString(afterSecondInt));

        if (sumFirst == sumSecondBefore || sumFirst == sumSecondAfter) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}