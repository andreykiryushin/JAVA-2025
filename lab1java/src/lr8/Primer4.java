package lr8;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Primer4 {
    public static void main(String[] args) throws IOException, ParseException {
        try{
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("src/lr8/example-json.json"));
            JSONObject json0bject = (JSONObject) obj;

            System.out.println("Корневой элемент: " + json0bject.keySet().iterator().next());
            JSONArray jsonArray = (JSONArray)json0bject.get("books");

            for (Object o : jsonArray) {
                JSONObject book = (JSONObject)o;
                System.out.println("\nТекущий злемент: book");
                System.out.println("Название книги: " + book.get("title"));
                System.out.println("Автор: "+ book.get("author"));
                System.out.println("Год издания: "+ book.get("year"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}