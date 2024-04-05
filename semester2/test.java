import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        int Gua = than.nextInt();
        than.nextLine();
        double[] total = new double[Gua];

        for (int i = 0; i < Gua; i++) {
            String ukir = than.nextLine();
            String[] ukirSplit = ukir.split(" ");
            int banyakUkiran = ukirSplit.length;
            PQ pq = new PQ();

            for (int j = 0; j < banyakUkiran; j++) {
                pq.enqueue(j, Integer.parseInt(ukirSplit[j]));
            }

            int maxUkir = pq.dequeue();
            total[i] = maxUkir;
            for (int j = 0; j < banyakUkiran - 1; j++) {
                int tmp = pq.dequeue();
                if (tmp == maxUkir) {
                    total[i] += tmp;
                } else
                    break;

            }

        }

        double ans = 0;
        for (int i = 0; i < Gua; i++) {
            ans += total[i];
        }
        ans /= Gua;

        System.out.printf("%.2f", ans);
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

    public int dequeue() {
        if (!isEmpty()) {
            int tmp = head.priority;
            head = head.next;
            size--;
            return tmp;
        }
        return 0;
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