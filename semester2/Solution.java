// import java.util.LinkedList;

class Pakaian {
    String jenis;
    int kenyamanan;
    String merk;
    String size;
    String warna;

    public Pakaian(String jenis, int kenyamanan, String merk, String size, String warna) {
        this.jenis = jenis;
        this.kenyamanan = kenyamanan;
        this.merk = merk;
        this.size = size;
        this.warna = warna;
    }

    @Override
    public String toString() {
        return "merk: " + merk + " size: " + size + " warna: " + warna;
    }
}

class TumpukanPakaian {
    LinkedList<Pakaian> bajuTumpukan;
    LinkedList<Pakaian> celanaTumpukan;

    public TumpukanPakaian() {
        bajuTumpukan = new LinkedList<>();
        celanaTumpukan = new LinkedList<>();
    }

    public void addPakaian(String jenis, int kenyamanan, String merk, String size, String warna) {
        Pakaian pakaian = new Pakaian(jenis, kenyamanan, merk, size, warna);
        if (jenis.equals("BAJU")) {
            bajuTumpukan.add(pakaian);
        } else if (jenis.equals("CELANA")) {
            celanaTumpukan.add(pakaian);
        }
        System.out.println(jenis + " dengan " + pakaian.toString() + " berhasil ditambahkan");
    }

    public void cekPakaian(String jenis) {
        LinkedList<Pakaian> tumpukan;
        if (jenis.equals("BAJU")) {
            tumpukan = bajuTumpukan;
        } else if (jenis.equals("CELANA")) {
            tumpukan = celanaTumpukan;
        } else {
            System.out.println("Jenis pakaian tidak valid");
            return;
        }

        if (tumpukan.isEmpty()) {
            System.out.println("Tumpukan masih kosong!");
        } else {
            System.out.println("Daftar " + jenis + " :");
            int index = 1;
            for (Pakaian pakaian : tumpukan) {
                System.out.println(index + " " + pakaian.toString());
                index++;
            }
        }
    }

    public void keluar() {
        if (bajuTumpukan.isEmpty() && celanaTumpukan.isEmpty()) {
            System.out.println("Tidak ada baju dan celana yang tersisa");
        } else if (bajuTumpukan.isEmpty()) {
            System.out.println("Tidak ada baju yang tersisa");
            System.out.println("Daftar Celana :");
            for (Pakaian pakaian : celanaTumpukan) {
                System.out.println(pakaian.toString());
            }
        } else if (celanaTumpukan.isEmpty()) {
            System.out.println("Tidak ada celana yang tersisa");
            System.out.println("Daftar Baju :");
            for (Pakaian pakaian : bajuTumpukan) {
                System.out.println(pakaian.toString());
            }
        } else {
            System.out.println("Daftar Baju :");
            System.out.println(bajuTumpukan.remove_front().toString());
            System.out.println("Daftar Celana :");
            System.out.println(celanaTumpukan.remove_front().toString());
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        TumpukanPakaian tumpukanPakaian = new TumpukanPakaian();

        // Sample input
        tumpukanPakaian.addPakaian("BAJU", 1, "A", "XL", "MERAH");
        tumpukanPakaian.addPakaian("CELANA", 4, "A", "S", "HITAM");
        tumpukanPakaian.addPakaian("BAJU", 1, "B", "S", "BIRU");
        tumpukanPakaian.addPakaian("CELANA", 1, "B", "XL", "PUTIH");
        tumpukanPakaian.keluar();
        tumpukanPakaian.addPakaian("BAJU", 6, "F", "S", "BIRU");
        tumpukanPakaian.addPakaian("BAJU", 1, "C", "S", "BIRU");
        tumpukanPakaian.addPakaian("BAJU", 1, "D", "S", "BIRU");
        tumpukanPakaian.addPakaian("BAJU", 1, "E", "S", "BIRU");
        tumpukanPakaian.addPakaian("CELANA", 6, "F", "S", "BIRU");
        tumpukanPakaian.addPakaian("CELANA", 1, "C", "S", "BIRU");
        tumpukanPakaian.addPakaian("CELANA", 1, "D", "S", "BIRU");
        tumpukanPakaian.addPakaian("CELANA", 1, "E", "S", "BIRU");
        tumpukanPakaian.cekPakaian("BAJU");
        tumpukanPakaian.cekPakaian("BAJU");
        tumpukanPakaian.cekPakaian("CELANA");
        tumpukanPakaian.cekPakaian("CELANA");
        tumpukanPakaian.keluar();
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
        return head == null;
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
    public T remove_front() {
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