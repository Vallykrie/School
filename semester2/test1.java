class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class CircularDoublyLinkedList {
    Node head;

    public CircularDoublyLinkedList() {
        this.head = null;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            newNode.next = head;
            newNode.prev = head.prev;
            head.prev.next = newNode;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            newNode.next = head;
            newNode.prev = head.prev;
            head.prev.next = newNode;
            head.prev = newNode;
        }
    }

    public void removeFirst() {
        if (head == null) {
            System.out.println("DATA IS EMPTY!");
        } else if (head.next == head) {
            head = null;
        } else {
            head.prev.next = head.next;
            head.next.prev = head.prev;
            head = head.next;
        }
    }

    public void removeLast() {
        if (head == null) {
            System.out.println("DATA IS EMPTY!");
        } else if (head.next == head) {
            head = null;
        } else {
            head.prev.prev.next = head;
            head.prev = head.prev.prev;
        }
    }

    public boolean isThere(int data) {
        if (head == null) {
            return false;
        } else {
            Node current = head;
            do {
                if (current.data == data) {
                    return true;
                }
                current = current.next;
            } while (current != head);
            return false;
        }
    }

    public void printAll() {
        if (head == null) {
            System.out.println("DATA IS EMPTY!");
        } else {
            Node current = head;
            do {
                System.out.print(current.data + " ");
                current = current.next;
            } while (current != head);
            System.out.println();
        }
    }

    public void printSpecial() {
        if (head == null) {
            System.out.println("DATA IS EMPTY!");
        } else {
            Node current = head.prev;
            while (current != head) {
                System.out.print(current.data + " ");
                current = current.prev;
            }
            System.out.println();
        }
    }
}

public class test1 {
    public static void main(String[] args) {
        CircularDoublyLinkedList cdll = new CircularDoublyLinkedList();

        // Sample input commands
        cdll.addLast(60);
        cdll.addLast(5);
        cdll.addLast(6);
        cdll.addLast(1);
        cdll.printAll();
        System.out.println(cdll.isThere(99));
        cdll.removeFirst();
        cdll.removeLast();
        cdll.printSpecial();
    }
}