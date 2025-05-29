package lr2;

// Интерфейс для геометрических фигур
interface Shape {
    double calculateArea();    // Метод для вычисления площади
    double calculatePerimeter(); // Метод для вычисления периметра
}

// Класс круга
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}

// Класс квадрата
class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
}

// Класс треугольника
class Triangle implements Shape {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double calculateArea() {
        // Формула Герона
        double p = calculatePerimeter() / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    public double getSideA() { return sideA; }
    public double getSideB() { return sideB; }
    public double getSideC() { return sideC; }

    public void setSideA(double sideA) { this.sideA = sideA; }
    public void setSideB(double sideB) { this.sideB = sideB; }
    public void setSideC(double sideC) { this.sideC = sideC; }
}

// Главный класс для демонстрации
public class Example6 {
    public static void main(String[] args) {
        // Создаем фигуры
        Shape circle = new Circle(5.0);
        Shape square = new Square(4.0);
        Shape triangle = new Triangle(3.0, 4.0, 5.0);

        // Выводим информацию о фигурах
        printShapeInfo(circle, "Круг");
        printShapeInfo(square, "Квадрат");
        printShapeInfo(triangle, "Треугольник");
    }

    private static void printShapeInfo(Shape shape, String shapeName) {
        System.out.println("\n" + shapeName + ":");
        System.out.printf("Площадь: %.2f\n", shape.calculateArea());
        System.out.printf("Периметр: %.2f\n", shape.calculatePerimeter());
    }
}