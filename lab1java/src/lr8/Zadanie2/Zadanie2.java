package lr8.Zadanie2;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.stream.Stream;

public class Zadanie2 {
    private static Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            JSONParser jsonParser = new JSONParser();
            Object parsedData = jsonParser.parse(new FileReader("src/lr8/Zadanie2/animals.json"));
            JSONObject rootObject = (JSONObject) parsedData;

            displayAllAnimals(rootObject);
            JSONArray animalsArray = (JSONArray) rootObject.get("Animals");

            System.out.println();
            addNewAnimal(animalsArray);

            System.out.println();
            searchAnimal(animalsArray);

            System.out.println();
            removeAnimal(animalsArray);

            System.out.println();
            displayAllAnimals(rootObject);

            saveChangesToFile(rootObject);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            inputScanner.close();
        }
    }

    private static void addNewAnimal(JSONArray animalsArray) {
        while (true) {
            System.out.println("Добавить новое животное? (Да/Нет)");
            String userChoice = inputScanner.nextLine();

            if (userChoice.equalsIgnoreCase("Нет")) break;
            if (!userChoice.equalsIgnoreCase("Да")) continue;

            System.out.println("Введите кличку:");
            String name = inputScanner.nextLine();

            System.out.println("Введите вид животного:");
            String type = inputScanner.nextLine();

            System.out.println("Введите возраст:");
            String age = inputScanner.nextLine();

            System.out.println("Введите окрас:");
            String color = inputScanner.nextLine();

            JSONObject newAnimal = new JSONObject();
            newAnimal.put("Name", name);
            newAnimal.put("Type", type);
            newAnimal.put("Age", age);
            newAnimal.put("Color", color);

            animalsArray.add(newAnimal);
        }
    }

    private static void searchAnimal(JSONArray animalsArray) {
        while (true) {
            System.out.println("Найти животное? (Да/Нет)");
            String userChoice = inputScanner.nextLine();

            if (userChoice.equalsIgnoreCase("Нет")) break;
            if (!userChoice.equalsIgnoreCase("Да")) continue;

            System.out.println("Введите кличку для поиска:");
            String searchName = inputScanner.nextLine();

            for (Object item : animalsArray) {
                JSONObject animal = (JSONObject) item;
                if (searchName.equalsIgnoreCase((String) animal.get("Name"))) {
                    System.out.println("\nНайдено животное:");
                    System.out.println("Кличка: " + animal.get("Name"));
                    System.out.println("Вид: " + animal.get("Type"));
                    System.out.println("Возраст: " + animal.get("Age"));
                    System.out.println("Окрас: " + animal.get("Color"));
                }
            }
        }
    }

    private static void removeAnimal(JSONArray animalsArray) {
        while (true) {
            System.out.println("Удалить животное? (Да/Нет)");
            String userChoice = inputScanner.nextLine();

            if (userChoice.equalsIgnoreCase("Нет")) break;
            if (!userChoice.equalsIgnoreCase("Да")) continue;

            System.out.println("Введите кличку для удаления:");
            String nameToRemove = inputScanner.nextLine();

            Iterator<Object> iterator = animalsArray.iterator();
            while (iterator.hasNext()) {
                JSONObject animal = (JSONObject) iterator.next();
                if (nameToRemove.equalsIgnoreCase((String) animal.get("Name"))) {
                    iterator.remove();
                }
            }
        }
    }

    private static void displayAllAnimals(JSONObject rootObject) {
        System.out.println("Основной элемент: " + rootObject.keySet().iterator().next());
        JSONArray animalsArray = (JSONArray) rootObject.get("Animals");

        for (Object item : animalsArray) {
            JSONObject animal = (JSONObject) item;
            System.out.println("\nТекущая запись: животное");
            System.out.println("Кличка: " + animal.get("Name"));
            System.out.println("Вид: " + animal.get("Type"));
            System.out.println("Возраст: " + animal.get("Age"));
            System.out.println("Окрас: " + animal.get("Color"));
        }
    }

    private static void saveChangesToFile(JSONObject rootObject) {
        try (FileWriter fileWriter = new FileWriter("src/lr8/Zadanie2/animals.json")) {
            fileWriter.write(rootObject.toJSONString());
            fileWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}