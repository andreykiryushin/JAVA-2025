package lr7;
import java.io.*;
public class Zadanie8 {
    public static void main(String[] args){
        Triangle triangle = new Triangle(40, 30,50);
        try {
            FileOutputStream fileOut = new FileOutputStream("src/lr7/triangle.json");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(triangle);
            out.close();
            fileOut.close();
            System.out.println("Объект Triangle сериализован в triangle.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fileInp = new FileInputStream("src/lr7/triangle.json");
            ObjectInputStream inp = new ObjectInputStream(fileInp);
            Triangle deserializedTriangle = (Triangle)inp.readObject();
            inp.close();
            System.out.println("Поля объекта Triangle : " + deserializedTriangle.getSizes());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
class Triangle implements Serializable {
    private int size1;
    private int size2;
    private int size3;

    public Triangle(int size1, int size2,int size3) {
        this.size1 = size1;
        this.size2 = size2;
        this.size3 = size3;
    }
    public String getSizes (){
        return "size1:" + size1 + ", size2:" + size2 + ", size3:" + size3;
    }
}