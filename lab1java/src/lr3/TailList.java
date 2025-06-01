package lr3;

public class TailList {
    static class Node {
        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        // Создание списка с хвоста
        Node head = null;
        Node tail = null;

        // Добавление первого элемента
        head = tail = new Node(1, null);

        // Добавление последующих элементов в конец
        tail.next = new Node(2, null);
        tail = tail.next;
        tail.next = new Node(3, null);
        tail = tail.next;

        // Вывод списка
        Node current = head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
}