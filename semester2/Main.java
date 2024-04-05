import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        String input = than.nextLine();
        String[] perintah = input.split(" ");
        LinkedList<Pakaian> bajuTumpukan = new LinkedList<>();
        PQ bajuTumpukanPQ = new PQ();
        LinkedList<Pakaian> celanaTumpukan = new LinkedList<>();
        PQ celanaTumpukanPQ = new PQ();

        while (true) {
            switch (perintah[1]) {
                case "ADD":
                    String jenis = perintah[2];
                    int priority = Integer.parseInt(perintah[3]);
                    String merk = perintah[4];
                    String size = perintah[5];
                    String warna = perintah[6];
                    Pakaian pakaian = new Pakaian(jenis, merk, size, warna);
                    if (jenis.equals("BAJU")) {
                        bajuTumpukan.add(pakaian);
                        bajuTumpukanPQ.enqueue(pakaian, priority);
                    } else if (jenis.equals("CELANA")) {
                        celanaTumpukan.add(pakaian);
                        celanaTumpukanPQ.enqueue(pakaian, priority);
                    }
                    System.out.println(jenis + " dengan merk " + merk + " size " + size + " warna " + warna
                            + " berhasil ditambahkan");
                    break;
                case "CEK":
                    if (perintah[2].equals("BAJU")) {
                        if (!bajuTumpukanPQ.isEmpty()) {
                            bajuTumpukanPQ.display("BAJU");
                        } else {
                            System.out.println("Tumpukan masih kosong!");
                        }
                    } else if (perintah[2].equals("CELANA")) {
                        if (!celanaTumpukanPQ.isEmpty()) {
                            bajuTumpukanPQ.display("CELANA");
                        } else {
                            System.out.println("Tumpukan masih kosong!");
                        }
                    }
                    break;
                case "KELUAR":
                    if (!bajuTumpukanPQ.isEmpty() && !celanaTumpukanPQ.isEmpty()) {
                        System.out.println("tidak ada baju dan celana yang tersisa");
                    } else if (!bajuTumpukanPQ.isEmpty()) {
                        System.out.println("tidak ada celana yang tersisa");
                    } else if (!celanaTumpukanPQ.isEmpty()) {
                        System.out.println("tidak ada baju yang tersisa");
                    } else {
                        bajuTumpukanPQ.dequeue();
                        celanaTumpukanPQ.dequeue();
                        break;
                    }

                    break;
                case "STOP":
                    return;
            }
        }
    }
}

class PQ {
    NodePQ head, tail;
    int size = 0;

    public void display(String type) {
        NodePQ pointer = head;
        System.out.println("Daftar " + type + " :");
        int count = 1;
        while (pointer != null) {
            Pakaian tmp = pointer.data;
            System.out.println(count + " merk: " + tmp.merk + " size: " + tmp.size + " warna: " + tmp.warna);
            pointer = pointer.next;
            count++;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(Pakaian data, int priority) {
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
    int priority;
    Pakaian data;
    NodePQ next;

    public NodePQ(Pakaian data, int priority) {
        this.data = data;
        this.priority = priority;
        this.next = null;
    }

}

class Pakaian {
    String jenis;
    String merk;
    String size;
    String warna;

    public Pakaian(String jenis, String merk, String size, String warna) {
        this.jenis = jenis;
        this.merk = merk;
        this.size = size;
        this.warna = warna;
    }

    @Override
    public String toString() {
        return "merk: " + merk + " size: " + size + " warna: " + warna;
    }
}

class LinkedList<T> {

    /*
     * Private Attributes and Methods
     */
    private class Node {
        public T item; // data
        public Node next; // pointer ke node selanjutnya
    }

    private Node head; // pointer ke node pertama
    private int n; // jumlah node
    private Node iterator;

    /* Mendapatkan pointer ke node di index tertentu. Index dimulai dari 0 */
    private Node node_at(int index) {
        Node iter = head;
        for (int i = 1; i <= index; i++) {
            iter = iter.next;
        }
        return iter;
    }

    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    /* Membuat node */
    private Node create_node(T item) {
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = null;
        n++;
        return newNode;
    }

    /* Menghapus node */
    private T del_node(Node node) {
        node.next = null;
        n--;
        return node.item;
    }

    /* Menyisipkan node pada bagian awal list */
    private void add_front(T item) {
        Node newNode = create_node(item);
        newNode.next = head;
        head = newNode;
    }

    /* Menyisipkan node setelah node tertentu */
    private void add_after(T item, Node node) {
        Node newNode = create_node(item);
        newNode.next = node.next;
        node.next = newNode;
    }

    /* Mengambil data pada bagian awal list */
    private T remove_front() {
        Node node = head;
        head = head.next;
        return del_node(node);
    }

    /* Mengambil data pada bagian tengah list */
    private T remove_after(Node previous) {
        Node node = previous.next;
        previous.next = node.next;
        return del_node(node);
    }

    /*
     * Public methods
     */
    public LinkedList() {
        head = null;
        n = 0;
        iterator = null;
    }

    /* Mendapatkan jumlah node dalam list */
    public int size() {
        return n;
    }

    /* Menambahkan data pada index tertentu */
    public void add(int index, T item) throws IndexOutOfBoundsException {
        if (index < 0 || (index > n)) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds! Allowed index: 0 to " + n);
        }

        if (index == 0) { // Jika ingin menyisipkan node pada bagian awal list
            add_front(item);
        } else { // Jika ingin menyisipkan node pada bagian lain dari list
            add_after(item, node_at(index - 1));
        }
    }

    /* Menambahkan data pada akhir list */
    public void add(T item) {
        add(n, item);
    }

    /* Melihat data pada index tertentu */
    public T get(int index) throws IndexOutOfBoundsException {
        if (n == 0) {
            throw new IndexOutOfBoundsException("List is empty.");
        }

        if (index < 0 || (index >= n)) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds! Allowed index: 0 to " + (n - 1));
        }

        Node node = node_at(index);
        return node.item;
    }

    /* Mengambil data dari index tertentu */
    public T remove(int index) throws IndexOutOfBoundsException {
        if (n == 0) {
            throw new IndexOutOfBoundsException("List is empty.");
        }

        if (index < 0 || (index >= n)) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds! Allowed index: 0 to " + (n - 1));
        }

        T item;
        if (index == 0) { // Jika ingin mengambil data pada bagian awal list
            item = remove_front();
        } else { // Jika ingin mengambil node pada bagian lain dari list
            item = remove_after(node_at(index - 1));
        }

        return item;
    }

    /* Mengubah posisi iterator ke head */
    public void first() {
        iterator = head;
    }

    /* Mengecek apakah ada elemen selanjutnya */
    public boolean hasNext() {
        return (iterator == null) ? false : true;
    }

    /* Mengecek apakah ada elemen selanjutnya */
    public T next() throws IndexOutOfBoundsException {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException("End of the list. Call reset() to reset the iterator.");
        }

        T item = iterator.item;
        iterator = iterator.next;
        return item;
    }

    @Override
    public String toString() {
        String result = "";
        for (Node i = head; i != null; i = i.next) {
            result += String.valueOf(i.item) + " ";
        }
        return result;
    }
}