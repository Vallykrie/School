import java.util.Scanner;

public class nathan_051_5_1 {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        int n = than.nextInt();
        than.nextLine();
        PQ pq = new PQ();
        for (int i = 0; i < n; i++) {
            String perintah = than.nextLine();
            switch (perintah) {
                case "ADD":
                    String nama = than.nextLine();
                    int prioritas = than.nextInt();
                    if (than.hasNextLine()) {
                        than.nextLine();

                    }
                    pq.enqueue(nama, prioritas);
                    // Tugas "TUGAS 1" telah ditambahkan dengan prioritas 3
                    System.out.println("Tugas \"" + nama + "\" telah ditambahkan dengan prioritas " + prioritas);
                    break;
                case "EXECUTE":
                    pq.dequeue();
                    // Menjalankan Tugas "TUGAS 2" dengan prioritas 1

                    break;
                case "DISPLAY":
                    pq.print();

                    break;
            }
            if (perintah.equalsIgnoreCase("add")) {
                String ss = than.nextLine();
                int q = than.nextInt();
                if (than.hasNextLine()) {
                    than.nextLine();
                }
                pq.enqueue(ss, q);
                System.out.println("Tugas \"" + ss + "\" telah ditambahkan dengan prioritas " + q);
            } else if (perintah.equalsIgnoreCase("display")) {
                pq.print();
            } else if (perintah.equalsIgnoreCase("execute")) {
                NodePQ front = pq.dequeue();
                if (front != null) {
                    System.out.println("Menjalankan Tugas \"" + front.data + "\" dengan prioritas " + front.priority);
                } else {
                    System.out.println("Tidak ada tugas yang bisa dilaksanakan");
                }
            }
            System.out.println();
        }
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

    public void enqueue(String data, int priority) {
        NodePQ input = new NodePQ(data, priority);
        if (isEmpty()) {
            head = tail = input;
        } else {
            if (input.priority < head.priority) {
                input.next = head;
                head = input;
            } else {
                NodePQ pointer = head;
                while (pointer.next != null && pointer.next.priority <= input.priority) {
                    pointer = pointer.next;
                }
                input.next = pointer.next;
                pointer.next = input;
            }
        }
        // System.out.println();
        size++;
    }

    public NodePQ dequeue() {
        if (!isEmpty()) {
            NodePQ taskToExecute = head;
            head = head.next;
            size--;
            return taskToExecute;
            // System.out.println();
        }
        return null;
    }

    public void print() {
        NodePQ pointer = head;
        if (isEmpty()) {
            System.out.println("Tidak ada tugas dalam antrian");
        } else {
            System.out.println("Tugas dalam antrian:");
            while (pointer != null) {
                System.out.println("- " + pointer.data + " (prioritas " + pointer.priority + ")");
                pointer = pointer.next;
            }
            // System.out.println();
        }
    }
}

class NodePQ {
    String data;
    int priority;
    NodePQ next;

    public NodePQ(String data, int priority) {
        this.data = data;
        this.priority = priority;
        this.next = null;
    }
}