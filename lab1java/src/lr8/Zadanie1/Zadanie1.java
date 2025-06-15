package lr8.Zadanie1;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.Scanner;

public class Zadanie1 {
    private static final String FILE_PATH = "src/lr8/animals.xml";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            while (true) {
                System.out.println("\n1. Добавить животное");
                System.out.println("2. Найти животное по типу");
                System.out.println("3. Найти животное по возрасту");
                System.out.println("4. Удалить животное");
                System.out.println("5. Выход");
                System.out.print("Выберите действие: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Очистка буфера

                switch (choice) {
                    case 1 -> addAnimal();
                    case 2 -> searchByType();
                    case 3 -> searchByAge();
                    case 4 -> deleteAnimal();
                    case 5 -> {
                        System.out.println("Выход...");
                        return;
                    }
                    default -> System.out.println("Неверный выбор!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Добавление животного
    private static void addAnimal() throws Exception {
        Document doc = getDocument();
        Element root = doc.getDocumentElement();

        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        System.out.print("Введите тип (кот, собака и т.д.): ");
        String type = scanner.nextLine();
        System.out.print("Введите возраст: ");
        String age = scanner.nextLine();
        System.out.print("Введите цвет: ");
        String color = scanner.nextLine();

        Element animal = doc.createElement("animal");
        animal.setAttribute("id", String.valueOf(getNextId(doc)));

        Element nameElem = doc.createElement("name");
        nameElem.appendChild(doc.createTextNode(name));
        animal.appendChild(nameElem);

        Element typeElem = doc.createElement("type");
        typeElem.appendChild(doc.createTextNode(type));
        animal.appendChild(typeElem);

        Element ageElem = doc.createElement("age");
        ageElem.appendChild(doc.createTextNode(age));
        animal.appendChild(ageElem);

        Element colorElem = doc.createElement("color");
        colorElem.appendChild(doc.createTextNode(color));
        animal.appendChild(colorElem);

        root.appendChild(animal);
        saveDocument(doc);
        System.out.println("Животное добавлено!");
    }

    // Поиск по типу
    private static void searchByType() throws Exception {
        System.out.print("Введите тип животного: ");
        String type = scanner.nextLine();
        Document doc = getDocument();
        NodeList animals = doc.getElementsByTagName("animal");

        boolean found = false;
        for (int i = 0; i < animals.getLength(); i++) {
            Element animal = (Element) animals.item(i);
            String animalType = animal.getElementsByTagName("type").item(0).getTextContent();

            if (animalType.equalsIgnoreCase(type)) {
                printAnimal(animal);
                found = true;
            }
        }
        if (!found) System.out.println("Животные не найдены.");
    }

    // Поиск по возрасту
    private static void searchByAge() throws Exception {
        System.out.print("Введите возраст: ");
        String age = scanner.nextLine();
        Document doc = getDocument();
        NodeList animals = doc.getElementsByTagName("animal");

        boolean found = false;
        for (int i = 0; i < animals.getLength(); i++) {
            Element animal = (Element) animals.item(i);
            String animalAge = animal.getElementsByTagName("age").item(0).getTextContent();

            if (animalAge.equals(age)) {
                printAnimal(animal);
                found = true;
            }
        }
        if (!found) System.out.println("Животные не найдены.");
    }

    // Удаление животного
    private static void deleteAnimal() throws Exception {
        System.out.print("Введите имя животного для удаления: ");
        String name = scanner.nextLine();
        Document doc = getDocument();
        NodeList animals = doc.getElementsByTagName("animal");

        for (int i = 0; i < animals.getLength(); i++) {
            Element animal = (Element) animals.item(i);
            String animalName = animal.getElementsByTagName("name").item(0).getTextContent();

            if (animalName.equalsIgnoreCase(name)) {
                animal.getParentNode().removeChild(animal);
                saveDocument(doc);
                System.out.println("Животное удалено!");
                return;
            }
        }
        System.out.println("Животное не найдено.");
    }

    // Вспомогательные методы
    private static Document getDocument() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(new File(FILE_PATH));
    }

    private static void saveDocument(Document doc) throws Exception {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(FILE_PATH));
        transformer.transform(source, result);
    }

    private static int getNextId(Document doc) {
        NodeList animals = doc.getElementsByTagName("animal");
        return animals.getLength() + 1;
    }

    private static void printAnimal(Element animal) {
        String name = animal.getElementsByTagName("name").item(0).getTextContent();
        String type = animal.getElementsByTagName("type").item(0).getTextContent();
        String age = animal.getElementsByTagName("age").item(0).getTextContent();
        String color = animal.getElementsByTagName("color").item(0).getTextContent();
        System.out.printf("Имя: %s, Тип: %s, Возраст: %s, Цвет: %s\n", name, type, age, color);
    }
}