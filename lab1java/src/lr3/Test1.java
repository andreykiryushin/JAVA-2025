package lr3;

public class Test1 {
    public static void main(String[] args) {
        // Создание узлов списка
        Node node0 = new Node(0, null);
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);

        // Связывание узлов в список
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;

        // Обход списка и вывод значений
        Node ref = node0;
        while (ref != null) {
            System.out.print(" " + ref.value);
            ref = ref.next;
        }
    }
}

// Класс Node (должен быть определен отдельно)
class Node {
    int value;
    Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}