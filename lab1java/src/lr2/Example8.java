package lr2;

public class Example8 {

    public static class Animal {
        private String name;
        private int age;

        public Animal (String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void makeSound() {
            System.out.println("Животное издает звук.");
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            if (age > 0) {
                this.age = age;
            } else {
                System.out.println("Возраст должен быть положительным числом.");
            }
        }
    }


    public static class Dog extends Animal {
        private String breed;

        public Dog(String name, int age, String breed) {
            super(name, age);
            this.breed = breed;
        }

        public void bark() {
            System.out.println("Гав-гав!");
        }

        @Override
        public void makeSound() {
            System.out.println("Собака лает: Гав-гав!");
        }

        public String getBreed() {
            return breed;
        }

        public void setBreed(String breed) {
            this.breed = breed;
        }
    }

    public static class Cat extends Animal {
        private String foodType;

        public Cat(String name, int age, String foodType) {
            super(name, age);
            this.foodType = foodType;
        }

        public void purr() {
            System.out.println("Мяу-Мяууу");
        }

        @Override
        public void makeSound() {
            System.out.println("Кошка мяукает: Мяу!");
        }

        public String getFoodType() {
            return foodType;
        }

        public void setFoodType(String foodType) {
            this.foodType = foodType;
        }
    }

    public static class Bird extends Animal {
        private boolean canFly;

        public Bird(String name, int age, boolean canFly) {
            super(name, age);
            this.canFly = canFly;
        }

        public void fly() {
            if (canFly) {
                System.out.println("Птица летит!");
            } else {
                System.out.println("Эта птица не может летать.");
            }
        }

        @Override
        public void makeSound() {
            System.out.println("Птица поет: Чик-чирик!");
        }

        public boolean canFly() {
            return canFly;
        }

        public void setCanFly(boolean canFly) {
            this.canFly = canFly;
        }
    }

    // Фигуры
    abstract static class Shape {

        public abstract double calculateArea();
        public abstract double calculatePerimeter();
    }

    static class Circle extends Shape {
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

    static class Square extends Shape {
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

    static class Triangle extends Shape {
        private double sideA;
        private double sideB;
        private double sideC;

        public Triangle(double sideA, double sideB, double sideC) {
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
        }

        // Реализация метода для вычисления площади (по формуле Герона)
        @Override
        public double calculateArea() {
            double p = (sideA + sideB + sideC) / 2;  // Полупериметр
            return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
        }

        @Override
        public double calculatePerimeter() {
            return sideA + sideB + sideC;
        }

        public double getSideA() {
            return sideA;
        }

        public void setSideA(double sideA) {
            this.sideA = sideA;
        }

        public double getSideB() {
            return sideB;
        }

        public void setSideB(double sideB) {
            this.sideB = sideB;
        }

        public double getSideC() {
            return sideC;
        }

        public void setSideC(double sideC) {
            this.sideC = sideC;
        }
    }

    public static void main(String[] args) {

        Dog dog = new Dog("Мухтар", 3, "Овчарка");
        Cat cat = new Cat("Снежок", 19, "Вискас");
        Bird bird = new Bird("Кеша", 1, true);

        dog.makeSound();
        dog.bark();
        System.out.println("Порода собаки: " + dog.getBreed());

        // Работа с кошкой
        cat.makeSound();
        cat.purr();
        System.out.println("Тип корма кошки: " + cat.getFoodType());

        // Работа с птицей
        bird.makeSound();
        bird.fly();
        System.out.println("Может ли птица летать: " + bird.canFly());

        Circle circle = new Circle(10);
        Square square = new Square(5);
        Triangle triangle = new Triangle(3, 5, 7);

        // Вычисляем площадь и периметр
        System.out.println("Круг: Площадь - " + circle.calculateArea() + ", Периметр - " + circle.calculatePerimeter());
        System.out.println("Квадрат: Площадь - " + square.calculateArea() + ", Периметр - " + square.calculatePerimeter());
        System.out.println("Треугольник: Площадь - " + triangle.calculateArea() + ", Периметр - " + triangle.calculatePerimeter());
    }

}