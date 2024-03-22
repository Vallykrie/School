import java.io.*;
import java.util.*;

public class nathan_051_2_2 {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        int n = than.nextInt();
        than.nextLine();
        SLL sll = new SLL();
        for (int i = 0; i < n; i++) {
            String perintah = than.nextLine();
            String[] parts = perintah.split(" ");
            switch (parts[0]) {
                case "KENDARAAN":
                    if (parts[1].equals("MASUK")) {
                        String pengemudi = than.nextLine();
                        String kendaraanPlat = than.nextLine();
                        sll.insert(pengemudi, kendaraanPlat);
                        System.out.println(pengemudi + " berhasil memakirkan kendaraan");
                    } else if (parts[1].equals("KELUAR")) {
                        String kendaraanPlat = than.nextLine();
                        String pengemudi = sll.returnDriver(kendaraanPlat);
                        boolean removed = sll.remove(kendaraanPlat);
                        if (removed) {
                            System.out.println(pengemudi + " berhasil keluar parkiran");
                        } else {
                            System.out.println("Tidak dapat menghapus, kendaraan tidak ditemukan");
                        }
                    }
                    break;
                case "CARI":
                String kendaraanPlat = than.nextLine();
                boolean found = sll.search(kendaraanPlat);
                if (found) {
                    System.out.println("Kendaraan sedang parkir");
                } else {
                    System.out.println("Kendaraan tidak ada");
                }
                    break;
                default:
                    break;
            }
        }
    }
}

class Node {
    String pengemudi;
    String kendaraanPlat;
    Node next;

    public Node(String pengemudi, String kendaraanPlat) {
        this.pengemudi = pengemudi;
        this.kendaraanPlat = kendaraanPlat;
        this.next = null;
    }
}

class SLL {
    Node head;

    public void insert(String pengemudi, String kendaraanPlat) {
        Node newNode = new Node(pengemudi, kendaraanPlat);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public boolean remove(String kendaraanPlat) {
        if (head == null) {
            return false;
        } else if (head.kendaraanPlat.equals(kendaraanPlat)) {
            head = head.next;
            return true;
        } else {
            Node prev = head;
            Node curr = head.next;
            while (curr != null) {
                if (curr.kendaraanPlat.equals(kendaraanPlat)) {
                    prev.next = curr.next;
                    return true;
                }
                prev = curr;
                curr = curr.next;
            }
            return false;
        }
    }

    public boolean search(String kendaraanPlat) {
        Node temp = head;
        while (temp != null) {
            if (temp.kendaraanPlat.equals(kendaraanPlat)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public String returnDriver(String kendaraanPlat) {
        Node temp = head;
        boolean found = false;
        String save = "";
        while (temp != null) {
            if (temp.kendaraanPlat.equals(kendaraanPlat)) {
                found = true;
                save = temp.pengemudi;
            }
            temp = temp.next;
        }
        return save;

    }
}