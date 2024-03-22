import java.util.Scanner;

public class nathan_051_2_1 {

    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        int loop = than.nextInt();
        than.nextLine();
        LinkedList list = new LinkedList();
        list.makeEmpty();

        for (int i = 0; i < loop; i++) {
            String perintah = than.nextLine();
            String[] parts = perintah.split(" ");

            switch (parts[0]) {

                case "TAMBAH":
                    if (parts[1].equals("AWAL")) {
                        int data = Integer.parseInt(parts[2]);
                        list.prepend(data);
                    } else if (parts[1].equals("AKHIR")) {
                        int data = Integer.parseInt(parts[2]);
                        list.append(data);
                    }
                    break;
                case "HAPUS":
                    if (parts[1].equals("AWAL")) {
                        list.removeFirst();
                    } else if (parts[1].equals("AKHIR")) {
                        list.removeLast();
                    }
                    break;
                case "ADA":
                    int data = Integer.parseInt(parts[2]);
                    list.search(data);
                    break;
                case "LIHAT":
                list.printList();
                    break;
                case "BERAPA":
                list.getLength();
                    break;
                default:
                    break;
            }
        }
    }

}

class LinkedList {

    // CREATE CLASS VARIABLES, NODE CLASS, AND CONSTRUCTOR HERE //
    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int length;

    // public LinkedList(int value) {
    // Node newNode = new Node(value);
    // head = newNode;
    // tail = newNode;
    // length = 1;
    // }
    // //////////////////////////////////////////////////////////////

    public void printList() {
        if (length == 0) {
            System.out.println("Data Linked List kosong");
        } else {

            Node temp = head;
            while (temp != null) {
                System.out.print(temp.value + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public void getHead() {
        if (head == null) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
    }

    public void getTail() {
        if (head == null) {
            System.out.println("Tail: null");
        } else {
            System.out.println("Tail: " + tail.value);
        }
    }

    public void getLength() {
        System.out.println(length);
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    // add value from tail
    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {
        if (length == 0)
            return null;
        Node temp = head;
        Node pre = head;
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    // add value from head
    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        if (length == 0)
            return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) {
            tail = null;
        }
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length)
            return null;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public Node search(int value) {
        Node temp = head;
        boolean adaGak = false;
        for (int i = 0; i < length; i++) {
            if (temp.value == value) {
                System.out.println("ADA");
                adaGak = true;
            }
            temp = temp.next;
        }
        if (adaGak == false) {
            System.out.println("MAAF YAH KAMU SEDANG TIDAK BERUNTUNG, TERNYATA DATANYA GAK ADA");

        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length)
            return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length)
            return null;
        if (index == 0)
            return removeFirst();
        if (index == length - 1)
            return removeLast();

        Node prev = get(index - 1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;
        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }
}