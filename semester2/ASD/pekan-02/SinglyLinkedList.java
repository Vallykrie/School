/*
 * The Classes that implements the Abstract Data Type of a LinkedList
 */
public class SinglyLinkedList<T> implements LinkedList<T> {

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
    public SinglyLinkedList() {
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

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.add(0, 1);
        System.out.println(list);
        list.add(1, 2);
        System.out.println(list);
        list.add(1, 3);
        System.out.println(list);
        list.add(2, 4);
        System.out.println(list);
        list.add(0, 5);
        System.out.println(list);

        list.add(6);
        list.add(7);
        
        list.first();
        while (list.hasNext()) {
            System.out.print(list.next() + " ");
        }
        System.out.println();

        System.out.println("Size: " + list.size());

        System.out.println("Get first, received: " + list.get(0) + ", rest of the list: " + list);
        System.out.println("Remove index: 0, received: " + list.remove(0) + ", rest of the list: " + list);
        System.out.println("Remove index: 5, received: " + list.remove(5) + ", rest of the list: " + list);
        System.out.println("Remove index: 4, received: " + list.remove(4) + ", rest of the list: " + list);

        list.add(8);
        System.out.println(list);

        System.out.println("Remove index: 2, received: " + list.remove(2) + ", rest of the list: " + list);
        System.out.println("Remove index: 2, received: " + list.remove(2) + ", rest of the list: " + list);
        System.out.println("Remove index: 2, received: " + list.remove(2) + ", rest of the list: " + list);
        System.out.println("Remove index: 1, received: " + list.remove(1) + ", rest of the list: " + list);
        System.out.println("Remove index: 0, received: " + list.remove(0) + ", rest of the list: " + list);

        System.out.println("Size: " + list.size());

        list.add(9);
        System.out.println(list);

        System.out.println("Size: " + list.size());
    }
}

/*
 * The Abstract Data Type of a LinkedList
 */
interface LinkedList<T> {
    /* Mendapatkan jumlah node dalam list */
    public int size();

    /* Menambahkan data pada index tertentu */
    public void add(int index, T item) throws IndexOutOfBoundsException;

    /* Menambahkan data pada akhir list */
    public void add(T item);

    /* Melihat data pada index tertentu */
    public T get(int index) throws IndexOutOfBoundsException;

    /* Mengambil data dari index tertentu */
    public T remove(int index) throws IndexOutOfBoundsException;
}