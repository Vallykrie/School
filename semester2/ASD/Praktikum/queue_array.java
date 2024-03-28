import java.util.Scanner;

class Node {
    char data;
    Node prev;
    Node next;

    public Node(char data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class queue_array {
    Scanner masuk = new Scanner(System.in);

    Node head;
    Node tail;
    int keluar = 0;

    public void enqueue(char item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("# Queue No urut/index : " + item + ", Queue :" + item);
    }

    public void dequeue() {
        if (tail == null) {
            System.out.println("## Queue kosong");
        } else {
            System.out.println("## Dequeue Value :" + tail.data);
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            } else {
                head = null;
            }
        }
    }

    public void printAll() {
        System.out.println("## Queue Size : " + getSize());
        Node current = head;
        int index = 0;
        while (current != null) {
            System.out.println("## No Urut/index : " + index + ", Value :" + current.data);
            current = current.next;
            index++;
        }
    }

    public int getSize() {
        int size = 0;
        Node current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    public void menu() {
        System.out.print("\nMasukkan operasi yang akan dilakukan (1:enqueue, 2:dequeue, 3:print) : ");
        int choice = masuk.nextInt();
        masuk.nextLine();
        switch (choice) {
            case 1: {
                System.out.print("\nMasukkan huruf yang akan di-enqueue : ");
                char item = masuk.nextLine().charAt(0);
                enqueue(item);
            }
                break;
            case 2:
                dequeue();
                break;
            case 3:
                printAll();
                break;
            default:
                System.out.print("\n1:enqueue, 2:dequeue, 3:print\n");
                keluar = 1;
                break;
        }
    }

    public static void main(String[] args) {
        queue_array queue = new queue_array();
        do {
            queue.menu();
        } while (queue.keluar == 0);
    }
}