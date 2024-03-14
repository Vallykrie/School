import java.util.Scanner;

public class nathan_051_3_2 {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);

        String namaBarang = "";
        int hargaBarang = 0;

        DLL dll = new DLL();
        int loop = than.nextInt();
        than.nextLine();

        for (int i = 0; i < loop; i++) {
            String perintah = than.nextLine();
            switch (perintah) {
                case "TAMBAH":
                    namaBarang = than.nextLine();
                    hargaBarang = than.nextInt();
                    if (i == loop - 1) {

                    } else {
                        than.nextLine();
                    }

                    dll.addFirst(namaBarang, hargaBarang);
                    System.out.println(namaBarang + " berhasil ditambah");

                    break;
                case "HAPUS":
                    namaBarang = than.nextLine();

                    if (dll.isRemove(namaBarang)) {
                        System.out.println(namaBarang + " berhasil dihapus");
                    } else {
                        System.out.println("Tidak dapat menghapus, barang tidak ditemukan");
                    }

                    break;
                case "CARI":
                    namaBarang = than.nextLine();
                    dll.search(namaBarang);

                    break;
                case "HITUNG":
                    int total = dll.sum();

                    if (total != 0) {
                        System.out.println("Total = " + total);
                    } else {
                        System.out.println("Tidak ada transaksi yang sedang dilakukan");
                    }

                    break;
                case "CETAK":
                    dll.printToLast();
                    break;

                default:
                    break;
            }
            System.out.println();
        }
    }

}

class NodeDLL {
    String barang;
    int harga;
    NodeDLL prev;
    NodeDLL next;

    public NodeDLL(String barang, int harga) {
        this.barang = barang;
        this.harga = harga;
        this.prev = null;
        this.next = null;
    }
}

class DLL {

    NodeDLL head, tail;
    int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(String barang, int harga) {
        NodeDLL input = new NodeDLL(barang, harga);

        if (isEmpty()) {
            head = tail = input;
        } else {
            input.next = head;
            head.prev = input;
            head = input;
        }
        size++;
    }

    // public void addLast(int data) {
    // NodeDLL input = new NodeDLL(data);
    // if (isEmpty()) {
    // head = tail = input;
    // } else {
    // input.prev = tail;
    // tail.next = input;
    // tail = input;
    // }
    // size++;
    // }

    // public void removeFirst() {
    // if (!isEmpty()) {
    // if (size == 1) {
    // head = tail = null;
    // } else {
    // head = head.next;
    // head.prev = null;
    // }
    // size--;
    // }

    // }

    // public void removeLast() {
    // if (!isEmpty()) {
    // if (size == 1) {
    // head = tail = null;
    // } else {
    // tail = tail.prev;
    // tail.next = null;
    // }
    // size--;
    // }

    // }

    public boolean isRemove(String barang) {
        NodeDLL temp = head;

        while (temp != null) {
            if (temp.barang.equals(barang)) {
                if (temp == head) {
                    head = temp.next;
                    if (head != null) {
                        head.prev = null;
                    } else {
                        tail = null;
                    }
                } else if (temp == tail) {
                    tail = temp.prev;
                    tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }

                return true;
            }

            temp = temp.next;
        }

        return false;
    }

    public void search(String barang) {
        NodeDLL pointer = head;
        boolean found = false;
        if (pointer == null) {
            System.out.println("Barang tidak ditemukan");
            return;
        }
        while (pointer != null) {
            if (pointer.barang.equals(barang)) {
                System.out.println("Barang = " + pointer.barang + " \nHarga = " + pointer.harga);
                found = true;
            }
            pointer = pointer.next;
        }
        if (found == false) {
            System.out.println("Barang tidak ditemukan");

        }
    }

    public void printToLast() {
        if (head == null) {
            System.out.println("Belum ada transaksi yang dibuat");
        } else {
            NodeDLL pointer = head;

            System.out.print("Daftar Transaksi : ");
            while (pointer != null) {
                System.out.print(pointer.barang);
                if (pointer.next != null) {
                    System.out.print(", ");
                }
                pointer = pointer.next;
            }
            System.out.println();
        }
    }

    public void printToFirst() {
        if (head == null) {
            System.out.println("Belum ada transaksi yang dibuat");
        } else {
            NodeDLL pointer = tail;

            System.out.print("Daftar Transaksi : ");
            while (pointer != null) {
                System.out.print(pointer.barang);
                if (pointer.prev != null) {
                    System.out.print(", ");
                }
                pointer = pointer.prev;
            }
            System.out.println();
        }
    }

    public int sum() {
        int sum = 0;
        NodeDLL temp = head;
        int n = this.size;
        if (temp == null) {
            return sum;
        } else {
            for (int i = 0; i < n; i++) {
                sum += temp.harga;
                temp = temp.next;
            }
        }

        return sum;
    }
}