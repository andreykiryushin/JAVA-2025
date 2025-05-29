package lr2;

public class Example5 {
    // Поля класса
    private double length;
    private double width;

    // Конструктор с параметрами
    public Example5(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Методы доступа (геттеры)
    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    // Методы изменения (сеттеры)
    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    // Метод вычисления площади
    public double calculateArea() {
        return length * width;
    }

    // Метод вычисления периметра
    public double calculatePerimeter() {
        return 2 * (length + width);
    }

    // Метод для вывода информации о прямоугольнике
    public void displayInfo() {
        System.out.println("Прямоугольник:");
        System.out.println("Длина: " + length);
        System.out.println("Ширина: " + width);
        System.out.println("Площадь: " + calculateArea());
        System.out.println("Периметр: " + calculatePerimeter());
    }

    // Пример использования класса
    public static void main(String[] args) {
        // Создание прямоугольника
        Example5 rectangle = new Example5(5.0, 3.0);

        // Вывод информации
        rectangle.displayInfo();

        // Изменение размеров
        rectangle.setLength(7.5);
        rectangle.setWidth(4.2);

        // Вывод обновленной информации
        System.out.println("\nПосле изменения размеров:");
        rectangle.displayInfo();
    }
}