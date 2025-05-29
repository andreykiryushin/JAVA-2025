package lr2;

public class Example4 {
    public static void main(String[] args) {
        // Создание объекта Person
        Person person = new Person("Иван", 30, "Мужской");

        // Вывод информации
        System.out.println("Первоначальные данные:");
        person.displayInfo();

        // Изменение данных
        person.setName("Петр");
        person.setAge(35);

        // Вывод обновленной информации
        System.out.println("\nПосле изменения:");
        person.displayInfo();
    }
}

class Person {
    private String name;
    private int age;
    private String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // Геттеры
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }

    // Сеттеры
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setGender(String gender) { this.gender = gender; }

    public void displayInfo() {
        System.out.println("Имя: " + name);
        System.out.println("Возраст: " + age);
        System.out.println("Пол: " + gender);
    }
}