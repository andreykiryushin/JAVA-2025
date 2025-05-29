package lr2;

import java.util.Scanner;

public class Example3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод текста для шифрования
        System.out.println("Введите текст для шифрования:");
        String text = scanner.nextLine();

        // Ввод ключа шифрования
        System.out.println("Введите ключ:");
        int key = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        // Шифрование текста
        String encryptedText = encrypt(text, key);
        System.out.println("Текст после преобразования: " + encryptedText);

        // Запрос на обратное преобразование
        System.out.println("Выполнить обратное преобразование? (y/n)");
        String answer = scanner.nextLine().toLowerCase();

        while (!answer.equals("y") && !answer.equals("n")) {
            System.out.println("Введите корректный ответ");
            answer = scanner.nextLine().toLowerCase();
        }

        if (answer.equals("y")) {
            String decryptedText = encrypt(encryptedText, -key);
            System.out.println("Текст после обратного преобразования: " + decryptedText);
        } else {
            System.out.println("До свидания!");
        }

        scanner.close();
    }

    // Метод для шифрования/дешифрования
    public static String encrypt(String text, int key) {
        StringBuilder result = new StringBuilder();

        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                int originalAlphabetPosition = character - base;
                int newAlphabetPosition = (originalAlphabetPosition + key) % 26;
                // Обработка отрицательных значений
                if (newAlphabetPosition < 0) {
                    newAlphabetPosition += 26;
                }
                char newCharacter = (char) (base + newAlphabetPosition);
                result.append(newCharacter);
            } else {
                // Оставляем символы, не являющиеся буквами, без изменений
                result.append(character);
            }
        }

        return result.toString();
    }
}