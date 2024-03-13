import java.io.*;
import java.util.*;

public class coPilot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCommands = scanner.nextInt();
        scanner.nextLine();

        DLL dll = new DLL();

        for (int i = 0; i < numCommands; i++) {
            String command = scanner.nextLine();

            if (command.equals("TAMBAH")) {
                String barang = scanner.nextLine();
                int harga = scanner.nextInt();
                scanner.nextLine();

                dll.tambah(barang, harga);
                System.out.println(barang + " berhasil ditambah");
            } else if (command.equals("HAPUS")) {
                String barang = scanner.nextLine();

                if (dll.hapus(barang)) {
                    System.out.println(barang + " berhasil dihapus");
                } else {
                    System.out.println("Tidak dapat menghapus, barang tidak ditemukan");
                }
            } else if (command.equals("CARI")) {
                String barang = scanner.nextLine();
                NodeDLL node = dll.cari(barang);

                if (node != null) {
                    System.out.println("Barang = " + node.barang + " Harga = " + node.harga);
                } else {
                    System.out.println("Barang tidak ditemukan");
                }
            } else if (command.equals("HITUNG")) {
                int total = dll.hitung();

                if (total != 0) {
                    System.out.println("Total = " + total);
                } else {
                    System.out.println("Tidak ada transaksi yang sedang dilakukan");
                }
            } else if (command.equals("CETAK")) {
                dll.cetak();
            }
        }

        scanner.close();
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
    NodeDLL head;
    NodeDLL tail;

    public DLL() {
        this.head = null;
        this.tail = null;
    }

    public void tambah(String barang, int harga) {
        NodeDLL newNode = new NodeDLL(barang, harga);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public boolean hapus(String barang) {
        NodeDLL current = head;

        while (current != null) {
            if (current.barang.equals(barang)) {
                if (current == head) {
                    head = current.next;
                    if (head != null) {
                        head.prev = null;
                    } else {
                        tail = null;
                    }
                } else if (current == tail) {
                    tail = current.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }

                return true;
            }

            current = current.next;
        }

        return false;
    }

    public NodeDLL cari(String barang) {
        NodeDLL current = head;

        while (current != null) {
            if (current.barang.equals(barang)) {
                return current;
            }

            current = current.next;
        }

        return null;
    }

    public int hitung() {
        int total = 0;
        NodeDLL current = head;

        while (current != null) {
            total += current.harga;
            current = current.next;
        }

        return total;
    }

    public void cetak() {
        if (head == null) {
            System.out.println("Belum ada transaksi yang dibuat");
        } else {
            NodeDLL current = tail;

            System.out.print("Daftar Transaksi : ");
            while (current != null) {
                System.out.print(current.barang);
                if (current.prev != null) {
                    System.out.print(", ");
                }
                current = current.prev;
            }
            System.out.println();
        }
    }
}