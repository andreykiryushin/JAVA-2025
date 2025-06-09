package timus;

public class Zadanie1601 {

    public static void main(String[] args) {
        // Пример входной строки
        String input = "HELLO WORLD! hOW ARE YOU? i'M FINE.";

        String fixedMessage = fixCaps(input);
        System.out.println("До:\n" + input);
        System.out.println("\nПосле:\n" + fixedMessage);
    }

    private static String fixCaps(String text) {
        StringBuilder result = new StringBuilder();
        boolean newSentence = true;

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                if (newSentence) {
                    result.append(Character.toUpperCase(c));
                    newSentence = false;
                } else {
                    result.append(Character.toLowerCase(c));
                }
            } else {
                result.append(c);
                if (c == '.' || c == '!' || c == '?') {
                    newSentence = true;
                }
            }
        }
        return result.toString();
    }
}
