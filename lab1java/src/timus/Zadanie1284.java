package timus;

import java.util.*;
import java.io.*;

public class Zadanie1284 {
    static class Card {
        int value;
        int suit;

        Card(int value, int suit) {
            this.value = value;
            this.suit = suit;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Card card = (Card) o;
            return value == card.value && suit == card.suit;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, suit);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] parts = br.readLine().split(" ");
            int value = Integer.parseInt(parts[0]);
            int suit = Integer.parseInt(parts[1]);
            cards.add(new Card(value, suit));
        }

        // Разделение на синие и желтые масти
        Set<Integer> blueSuits = new HashSet<>();
        Set<Integer> yellowSuits = new HashSet<>();
        Map<Integer, List<Integer>> suitToValues = new HashMap<>();
        for (Card card : cards) {
            suitToValues.computeIfAbsent(card.suit, k -> new ArrayList<>()).add(card.value);
            if (card.suit % 2 == 1) {
                blueSuits.add(card.suit);
            } else {
                yellowSuits.add(card.suit);
            }
        }

        int X = blueSuits.size();
        int Y = yellowSuits.size();
        assert Math.abs(X - Y) <= 1;

        List<List<Integer>> possibleSuitOrders = new ArrayList<>();
        if (X == Y + 1) {
            // Начинаем с синей
            List<Integer> suitsOrder = new ArrayList<>();
            List<Integer> blue = new ArrayList<>(blueSuits);
            Collections.sort(blue);
            List<Integer> yellow = new ArrayList<>(yellowSuits);
            Collections.sort(yellow);
            for (int i = 0; i < Y; i++) {
                suitsOrder.add(blue.get(i));
                suitsOrder.add(yellow.get(i));
            }
            suitsOrder.add(blue.get(blue.size() - 1));
            possibleSuitOrders.add(suitsOrder);
        } else if (Y == X + 1) {
            // Начинаем с желтой
            List<Integer> suitsOrder = new ArrayList<>();
            List<Integer> blue = new ArrayList<>(blueSuits);
            Collections.sort(blue);
            List<Integer> yellow = new ArrayList<>(yellowSuits);
            Collections.sort(yellow);
            for (int i = 0; i < X; i++) {
                suitsOrder.add(yellow.get(i));
                suitsOrder.add(blue.get(i));
            }
            suitsOrder.add(yellow.get(yellow.size() - 1));
            possibleSuitOrders.add(suitsOrder);
        } else {
            // X == Y, можно начинать с любой
            // Вариант 1: начинаем с синей
            List<Integer> suitsOrder1 = new ArrayList<>();
            List<Integer> blue = new ArrayList<>(blueSuits);
            Collections.sort(blue);
            List<Integer> yellow = new ArrayList<>(yellowSuits);
            Collections.sort(yellow);
            for (int i = 0; i < X; i++) {
                suitsOrder1.add(blue.get(i));
                suitsOrder1.add(yellow.get(i));
            }
            possibleSuitOrders.add(suitsOrder1);
            // Вариант 2: начинаем с желтой
            List<Integer> suitsOrder2 = new ArrayList<>();
            for (int i = 0; i < Y; i++) {
                suitsOrder2.add(yellow.get(i));
                suitsOrder2.add(blue.get(i));
            }
            possibleSuitOrders.add(suitsOrder2);
        }

        int minOperations = Integer.MAX_VALUE;

        for (List<Integer> suitsOrder : possibleSuitOrders) {
            for (boolean ascending : new boolean[]{true, false}) {
                // Строим целевую последовательность карт
                List<Card> target = new ArrayList<>();
                for (int suit : suitsOrder) {
                    List<Integer> values = new ArrayList<>(suitToValues.get(suit));
                    if (ascending) {
                        Collections.sort(values);
                    } else {
                        Collections.sort(values, Collections.reverseOrder());
                    }
                    for (int value : values) {
                        target.add(new Card(value, suit));
                    }
                }

                // Находим самую длинную подпоследовательность в исходном порядке, которая совпадает с целевой
                Map<Card, Integer> indexInTarget = new HashMap<>();
                for (int i = 0; i < target.size(); i++) {
                    indexInTarget.put(target.get(i), i);
                }

                List<Integer> sequence = new ArrayList<>();
                for (Card card : cards) {
                    if (indexInTarget.containsKey(card)) {
                        sequence.add(indexInTarget.get(card));
                    }
                }

                // Находим длину самой длинной возрастающей подпоследовательности
                int lisLength = lis(sequence);
                int operations = N - lisLength;
                if (operations < minOperations) {
                    minOperations = operations;
                }
            }
        }

        System.out.println(minOperations);
    }

    private static int lis(List<Integer> sequence) {
        if (sequence.isEmpty()) {
            return 0;
        }
        List<Integer> tails = new ArrayList<>();
        for (int num : sequence) {
            int left = 0;
            int right = tails.size();
            while (left < right) {
                int mid = (left + right) / 2;
                if (tails.get(mid) < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (left == tails.size()) {
                tails.add(num);
            } else {
                tails.set(left, num);
            }
        }
        return tails.size();
    }
}