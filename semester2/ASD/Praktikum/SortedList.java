public class SortedList {
    /*
     * Private Attributes and Methods
     */
    private class Node {
        public int item; // data
        public Node prev; // pointer ke node sebelumnya
        public Node next; // pointer ke node selanjutnya
    }

    private Node head; // pointer ke node pertama
    private int n; // jumlah node

    /* Membuat node */
    private Node create_node(int item) {
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = newNode.prev = null;
        n++;
        return newNode;
    }

    /* Menghapus node */
    private int del_node(Node node) {
        node.next = node.prev = null;
        n--;
        return node.item;
    }

    /* Menyisipkan node pada bagian awal list */
    private void add_front(int item) {
        Node newNode = create_node(item);
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
    }

    /* Menyisipkan node sebelum node tertentu */
    private void add_before(int item, Node node) {
        Node newNode = create_node(item);
        newNode.prev = node.prev;
        newNode.next = node;
        if (node.prev != null) {
            node.prev.next = newNode;
        }
        node.prev = newNode;
    }

    /* Menyisipkan node setelah node tertentu */
    private void add_after(int item, Node node) {
        Node newNode = create_node(item);
        newNode.prev = node;
        newNode.next = node.next;
        if (node.next != null) {
            node.next.prev = newNode;
        }
        node.next = newNode;
    }

    /*
     * Public methods
     */
    public SortedList() {
        head = null;
        n = 0;
    }

    /* Mendapatkan jumlah node dalam list */
    public int size() {
        return n;
    }

    /* Menambahkan data secara terurut */
    public void add(int item) {
        if (n == 0) { // Jika list kosong
            add_front(item);
        } else if (item <= head.item) { // Jika item <= item pada head
            add_front(item);
        } else {
            Node node = head;
            while (true) {
                if (item <= node.item) { // Jika item <= item pada node
                    add_before(item, node);
                    break;
                }

                if (node.next == null) {
                    add_after(item, node);
                    break;
                }

                node = node.next;
            }
        }
    }

    /* Melihat data pada awal list */
    public int get() throws IndexOutOfBoundsException {
        if (n == 0) {
            throw new IndexOutOfBoundsException("List is empty.");
        }

        return head.item;
    }

    /* Mengambil data dari awal list */
    public int remove() throws IndexOutOfBoundsException {
        if (n == 0) {
            throw new IndexOutOfBoundsException("List is empty.");
        }

        Node node = head;
        head = head.next;
        if (head != null) {
            head.prev = node;
        }
        return del_node(node);
    }

    @Override
    public String toString() {
        String result = "";
        for (Node i = head; i != null; i = i.next) {
            result += String.valueOf(i.item) + " ";
        }
        return "[" + result.strip() + "]";
    }

    public static void main(String[] args) {
        SortedList sorted = new SortedList();
        System.out.println("Add");
        sorted.add(3);
        System.out.println(sorted);
        sorted.add(1);
        System.out.println(sorted);
        sorted.add(2);
        System.out.println(sorted);
        sorted.add(4);
        System.out.println(sorted);
        System.out.println();

        System.out.println("Get");
        System.out.println(sorted.get());
        System.out.println(sorted);
        System.out.println();

        System.out.println("Remove");
        System.out.println(sorted.remove());
        System.out.println(sorted);
        System.out.println(sorted.remove());
        System.out.println(sorted);
        System.out.println(sorted.remove());
        System.out.println(sorted);
        System.out.println(sorted.remove());
        System.out.println(sorted);
        System.out.println();
    }
}