package problems.linkedlist;

public class LinkedList {
    private Node head;
    private Node tail;
    class Node {
        private int value;
        Node next;
        public Node(int value) {
            value = this.value;
            this.next = null;
        }
    }

    public LinkedList(int value) {
        Node n = new Node(value);
        head = tail = n;
    }
}
