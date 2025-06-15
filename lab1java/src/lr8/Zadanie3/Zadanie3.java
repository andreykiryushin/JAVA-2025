package lr8.Zadanie3;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class Zadanie3 {
    public static void main(String[] args) {
        String url = "https://itlearn.ru/first-steps";
        int maxRetries = 3;
        int attempt = 0;
        Document data = tryConnect(url, maxRetries, attempt);

        if (data == null) {
            System.out.println("Не удалось получить данные");
            return;
        }

        writeFile(data);
    }

    public static void writeFile(Document data) {
        try {
            File xmlFile = new File("src/lr8/Zadanie3/task3.xml");
            xmlFile.getParentFile().mkdirs(); // Создаем директории, если их нет

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            org.w3c.dom.Document doc = docBuilder.newDocument();

            org.w3c.dom.Element rootElement = doc.createElement("links");
            doc.appendChild(rootElement);

            Elements links = data.select("a[href]");
            for (Element element : links) {
                String link = element.attr("abs:href");
                org.w3c.dom.Element linkEl = doc.createElement("link");
                linkEl.appendChild(doc.createTextNode(link));
                rootElement.appendChild(linkEl);
            }

            doc.setXmlStandalone(true);
            doc.normalizeDocument();

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(xmlFile);

            transformer.transform(source, result);
            System.out.println("Файл успешно записан: " + xmlFile.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Ошибка при записи файла!");
            e.printStackTrace();
        }
    }

    public static Document tryConnect(String url, int maxRetries, int attempt) {
        while (attempt < maxRetries) {
            try {
                System.out.println("Попытка подключения #" + (attempt + 1));
                Document data = Jsoup.connect(url).get();
                System.out.println("Подключение успешно!");
                return data;
            } catch (IOException e) {
                attempt++;
                System.err.println("Ошибка подключения к сайту: " + e.getMessage());
                if (attempt < maxRetries) {
                    System.out.println("Попытка переподключения (" + attempt + "/" + maxRetries + ")...");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                        System.err.println("Операция прервана.");
                        return null;
                    }
                } else {
                    System.out.println("Не удалось подключиться к сайту после " + maxRetries + " попыток.");
                    return null;
                }
            }
        }
        return null;
    }
}