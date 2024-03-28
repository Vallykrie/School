import java.util.Scanner;

public class nathan_051_5_2 {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        String kartu = than.nextLine();
        int shuffle = than.nextInt();
        String result = kartu;
        Queue q = new Queue();

        String a = kartu.substring(0, kartu.length() / 2);
        String b = kartu.substring(kartu.length() / 2, kartu.length());

        for (int i = 0; i < shuffle; i++) {
            result = "";
            for (int j = 0; j < a.length(); j++) {
                result += a.charAt(j);
                result += b.charAt(j);
            }
            a = result.substring(0, result.length() / 2);
            b = result.substring(result.length() / 2, result.length());
        }

        for (int i = 0; i < kartu.length(); i++) {
            q.enqueue(result.charAt(i));
        }

        q.print();
    }
}

class NodeQueue {
    char data;
    NodeQueue next;

    public NodeQueue(char data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    NodeQueue head, tail;
    int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(char data) {
        NodeQueue input = new NodeQueue(data);
        if (isEmpty()) {
            tail = head = input;
        } else {
            tail.next = input;
            tail = input;
        }
        size++;
    }

    public void dequeue() {
        if (!isEmpty()) {
            head = head.next;
            size--;
        }
    }

    public void peek() {
        System.out.println(head.data);
    }

    public void print() {
        NodeQueue pointer = head;
        while (pointer != null) {
            System.out.print(pointer.data);
            pointer = pointer.next;
        }
        System.out.println();
    }
}
