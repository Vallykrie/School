import java.lang.runtime.SwitchBootstraps;
import java.util.Scanner;

class Node {
    String judulLagu;
    String namaPenyanyi;
    Node next;

    public Node(String data1, String data2) {
        this.judulLagu = data1;
        this.namaPenyanyi = data2;
        this.next = null;
    }
}

class SLL {
    Node head;

    public void addSong(String judulLagu, String namaPenyanyi) {
        Node newNode = new Node(judulLagu, namaPenyanyi);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println(judulLagu + " berhasil disimpan");
    }

    public void deleteSong(String judulLagu) {
        if (head == null) {
            System.out.println("tidak dapat menghapus, lagu tidak ditemukan");
            return;
        }
        if (head.judulLagu.equals(judulLagu)) {
            head = head.next;
            System.out.println(judulLagu + " berhasil dihapus");
            return;
        }
        Node current = head;
        Node prev = null;
        while (current != null && !current.judulLagu.equals(judulLagu)) {
            prev = current;
            current = current.next;
        }
        if (current == null) {
            System.out.println("tidak dapat menghapus, lagu tidak ditemukan");
        } else {
            prev.next = current.next;
            System.out.println(judulLagu + " berhasil dihapus");
        }
    }

    public void searchSong(String judulLagu) {
        Node current = head;
        while (current != null && !current.judulLagu.equals(judulLagu)) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("lagu tidak ditemukan");
        } else {
            System.out.println("judul lagu = " + current.judulLagu + "\npenyanyi = " + current.namaPenyanyi);
        }
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        int n = than.nextInt();
        than.nextLine();

        SLL playlist = new SLL();

        for (int i = 0; i < n; i++) {
            String command = than.nextLine();
            String judulLagu;
            switch (command) {
                case "ADD":
                    judulLagu = than.nextLine();
                    String namaPenyanyi = than.nextLine();
                    playlist.addSong(judulLagu, namaPenyanyi);
                    break;
                case "DELETE":
                    judulLagu = than.nextLine();
                    playlist.deleteSong(judulLagu);
                    break;
                case "SEARCH":
                    judulLagu = than.nextLine();
                    playlist.searchSong(judulLagu);
                    break;

                default:
                    break;
            }
            System.out.println();
        }

        than.close();
    }
}