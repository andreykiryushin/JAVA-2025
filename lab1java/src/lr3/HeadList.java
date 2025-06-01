package lr3;

public class HeadList {
    static class Node {
        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {

        Node head = null;


        head = new Node(3, head);
        head = new Node(2, head);
        head = new Node(1, head);


        Node current = head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
}