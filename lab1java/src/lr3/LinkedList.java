package lr3;

public class LinkedList {
    private Node head;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // === Методы с использованием цикла ===

    // Создание списка с головы
    public void createHead(int[] values) {
        for (int i = values.length - 1; i >= 0; i--) {
            addFirst(values[i]);
        }
    }

    // Создание списка с хвоста
    public void createTail(int[] values) {
        for (int value : values) {
            addLast(value);
        }
    }

    // Добавление в начало
    public void addFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    // Добавление в конец
    public void addLast(int value) {
        if (head == null) {
            addFirst(value);
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(value);
    }

    // Вставка по индексу
    public void insert(int index, int value) {
        if (index == 0) {
            addFirst(value);
            return;
        }

        Node current = head;
        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;
        }

        if (current != null) {
            Node newNode = new Node(value);
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // Удаление первого элемента
    public void removeFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    // Удаление последнего элемента
    public void removeLast() {
        if (head == null || head.next == null) {
            head = null;
            return;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    // Удаление по индексу
    public void remove(int index) {
        if (index == 0) {
            removeFirst();
            return;
        }

        Node current = head;
        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;
        }

        if (current != null && current.next != null) {
            current.next = current.next.next;
        }
    }

    // Вывод списка (цикл)
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        return sb.toString().trim();
    }

    // === Методы с использованием рекурсии ===

    // Рекурсивное создание с головы
    public void createHeadRec(int[] values) {
        head = createHeadRecHelper(values, 0);
    }

    private Node createHeadRecHelper(int[] values, int index) {
        if (index >= values.length) {
            return null;
        }
        Node node = new Node(values[index]);
        node.next = createHeadRecHelper(values, index + 1);
        return node;
    }

    // Рекурсивное создание с хвоста
    public void createTailRec(int[] values) {
        if (values.length == 0) return;
        head = new Node(values[0]);
        createTailRecHelper(head, values, 1);
    }

    private void createTailRecHelper(Node current, int[] values, int index) {
        if (index >= values.length) return;
        current.next = new Node(values[index]);
        createTailRecHelper(current.next, values, index + 1);
    }

    // Рекурсивный вывод
    public String toStringRec() {
        return toStringRecHelper(head).trim();
    }

    private String toStringRecHelper(Node node) {
        if (node == null) return "";
        return node.data + " " + toStringRecHelper(node.next);
    }

    // === Демонстрация работы ===
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        System.out.println("=== Методы с циклами ===");
        list.createHead(new int[]{3, 2, 1});
        System.out.println("createHead: " + list);

        list = new LinkedList();
        list.createTail(new int[]{1, 2, 3});
        System.out.println("createTail: " + list);

        list.addFirst(0);
        System.out.println("addFirst(0): " + list);

        list.addLast(4);
        System.out.println("addLast(4): " + list);

        list.insert(2, 99);
        System.out.println("insert(2, 99): " + list);

        list.removeFirst();
        System.out.println("removeFirst(): " + list);

        list.removeLast();
        System.out.println("removeLast(): " + list);

        list.remove(2);
        System.out.println("remove(2): " + list);

        System.out.println("\n=== Методы с рекурсией ===");
        list = new LinkedList();
        list.createHeadRec(new int[]{3, 2, 1});
        System.out.println("createHeadRec: " + list.toStringRec());

        list = new LinkedList();
        list.createTailRec(new int[]{1, 2, 3});
        System.out.println("createTailRec: " + list.toStringRec());
    }
}