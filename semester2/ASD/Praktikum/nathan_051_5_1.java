import java.util.Scanner;

public class nathan_051_5_1 {
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

class PQ {
    NodePQ head, tail;
    int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int data, int priority) {
        NodePQ input = new NodePQ(data, priority);
        if (isEmpty()) {
            head = tail = input;
        } else {
            if (input.priority > head.priority) {
                input.next = head;
                head = input;
            } else {
                NodePQ pointer = head;
                while (pointer.next != null && pointer.next.priority >= input.priority) {
                    pointer = pointer.next;
                }
                input.next = pointer.next;
                pointer.next = input;
            }
        }
        size++;
    }

    public void dequeue() {
        if (!isEmpty()) {
            head = head.next;
            size--;
        }
    }

    public void print() {
        NodePQ pointer = head;
        while (pointer != null) {
            System.out.print(pointer.data + " ");
            pointer = pointer.next;
        }
        System.out.println();
    }

}

class NodePQ {
    int data, priority;
    NodePQ next;

    public NodePQ(int data, int priority) {
        this.data = data;
        this.priority = priority;
        this.next = null;
    }

}