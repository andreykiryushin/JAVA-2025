package timus;

import java.math.BigInteger;
import java.util.Scanner;

public class Zadanie1180 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger N = scanner.nextBigInteger();
        scanner.close();

        // массив выигрышных и проигрышных состояний
        // 10^250 слишком велик, поэтому нужно только знать, победа или нет
        int MAX_POWER = 1000; // запас по числу бит (с запасом для 10^250)
        boolean[] win = new boolean[MAX_POWER + 1];
        win[0] = false; // 0 камней — проигрыш

        // вычисляем динамически возможные позиции
        for (int i = 1; i <= MAX_POWER; i++) {
            for (int pow = 0; (1 << pow) <= i; pow++) {
                if (!win[i - (1 << pow)]) {
                    win[i] = true;
                    break;
                }
            }
        }

        // теперь определим, сколько бит в числе N
        int bits = N.bitLength();
        boolean winner = win[bits];

        // выводим кто выигрывает
        if (!winner) {
            System.out.println(2); // выигрывает второй
        } else {
            System.out.println(1); // выигрывает первый
            // найти минимальное количество камней (степень двойки),
            // чтобы после этого оставалось проигрышное состояние
            for (int pow = 0; pow <= bits; pow++) {
                BigInteger move = BigInteger.valueOf(1L << pow);
                if (N.compareTo(move) >= 0) {
                    BigInteger remaining = N.subtract(move);
                    if (!win[remaining.bitLength()]) {
                        System.out.println(move);
                        break;
                    }
                }
            }
        }
    }
}
