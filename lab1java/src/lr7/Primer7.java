package lr7;


import java.io.*;

public class Primer7 {
    public static void main(String[] args) throws IOException {
        Person person = new Person("Ivan Ivanоv", 30);
        try {
            FileOutputStream fileOut = new FileOutputStream("src/lr7/person.json");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(person);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in person.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName (){
        return name;
    }
    public int getAge () {
        return age;
    }
}