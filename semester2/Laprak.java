public class Laprak {
    public static void main(String[] args) {
        Mahasiswa mahasiswa1 = new Mahasiswa("235150207111000", "Nickolas Wewe", 3.3);
        Mahasiswa mahasiswa2 = new Mahasiswa("235150207111001", "Jason TIF", 2.8);
        Mahasiswa mahasiswa4 = new Mahasiswa("235150207111003", "Rener Apathy", 1.2);
        Mahasiswa mahasiswa3 = new Mahasiswa("235150207111002", "Than Nathan", 4.0);

        SLL list = new SLL();
        list.inisialisasi();
        list.addSorted(new Node(mahasiswa1));
        list.addSorted(new Node(mahasiswa2));
        list.addSorted(new Node(mahasiswa3));
        list.addSorted(new Node(mahasiswa4));

        System.out.println("Daftar mahasiswa: ");
        Node temp = list.head;
        while (temp != null) {
            Mahasiswa mahasiswa = (Mahasiswa) temp.data;
            System.out.println("NIM: " + mahasiswa.getNim());
            System.out.println("Nama: " + mahasiswa.getNama());
            System.out.println("IPK: " + mahasiswa.getIpk());
            System.out.println();
            temp = temp.next;
        }

    }
}

class Mahasiswa {
    String nim;
    String nama;
    double ipk;

    public Mahasiswa(String nim, String nama, double ipk) {
        this.nim = nim;
        this.nama = nama;
        this.ipk = ipk;
    }

    public double getIpk() {
        return ipk;
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }
}

class Node {
    Object data;
    Node next;

    public Node(Mahasiswa data) {
        this.data = data;
        this.next = null;
    }
}

class SLL {
    Node head, tail;
    int size = 0;

    void inisialisasi() {
        head = null;
    }

    boolean isEmpty() {
        return (size == 0);
    }

    int size() {
        return size;
    }

    void addFirst(Node input) {
        if (isEmpty()) {
            head = input;
            tail = input;
        } else {
            input.next = head;
            head = input;
        }
        size++;
    }

    void addLast(Node input) {
        if (isEmpty()) {
            head = input;
            tail = input;
        } else {
            tail.next = input;
            tail = input;
        }
        size++;
    }

    void removeFirst() {
        if (isEmpty()) {
            
        } else {
            head = head.next;
            size--;
            if (isEmpty()) {
                tail = null;
            }
        }
    }

    void removeLast() {
        if (isEmpty()) {
            
        } else if (size == 1) {
            head = null;
            tail = null;
            size--;
        } else {
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
            size--;
        }
    }

    void insert(int index, Node input) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index == 0) {
            addFirst(input);
        } else if (index == size) {
            addLast(input);
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            input.next = temp.next;
            temp.next = input;
            size++;
        }
    }

    int search(Object value) {
        Node temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.data.equals(value)) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1; 
    }

    Node get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    void addSorted(Node input) {
        if (isEmpty() || ((Mahasiswa) input.data).getIpk() <= ((Mahasiswa) head.data).getIpk()) {
            addFirst(input);
        } else if ( ((Mahasiswa) input.data).getIpk() >= ((Mahasiswa) tail.data).getIpk()) {
            addLast(input);
        } else {
            Node temp = head;
            while (temp.next != null && ((Mahasiswa) input.data).getIpk() > ((Mahasiswa) temp.next.data).getIpk()) {
                temp = temp.next;
            }
            input.next = temp.next;
            temp.next = input;
            size++;
        }
    }
}