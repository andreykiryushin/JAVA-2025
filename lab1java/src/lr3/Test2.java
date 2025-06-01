package lr3;

public class Test2 {
    public static void main(String[] args) {
        // Создание односвязного списка
        Node head = null;

        // Добавление элементов в начало списка (9 и 8)
        for (int i = 9; i >= 8; i--) {
            head = new Node(i, head);
        }

        // Обход списка и вывод значений
        Node ref = head;
        while (ref != null) {
            System.out.print(" " + ref.value);
            ref = ref.next;
        }
    }
}

// Определение класса Node
class Node1 {
    int value;
    Node next;

    public Node1(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}