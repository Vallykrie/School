import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class nathan_051_2_1copy {
    public static void main(String[] args) {
        // Scanner than = new Scanner(System.in);
        // int loop = than.nextInt();
        // than.nextLine();
        // LinkedList list = new LinkedList();
        // list.makeEmpty();
        Scanner scanner = new Scanner(System.in);
        int jumlahPerintah = scanner.nextInt();
        scanner.nextLine();

        SLL sll = new SLL();
        // for (int i = 0; i < loop; i++) {
        //     String perintah = than.nextLine();
        //     String perintah1 = perintah.substring(0, perintah.indexOf(" "));
        //     int simpan = perintah.indexOf(" ");
        //     perintah = perintah.substring(simpan + 1, perintah.length());
        //     String perintah2 = "";
        //     int input = 0;
        //     if (perintah1.equals("TAMBAH") || perintah1.equals("TAMBAH ")) {
        //         // pakek!!!!!
        //         perintah2 = perintah.substring(0, perintah.indexOf(" "));
        //         input = Integer.parseInt(perintah.substring(perintah.indexOf(" ") + 1, perintah.length()));
        //         if (perintah2.equals("AWAL") || perintah2.equals("AWAL ") ) {
        //             list.prepend(input);
        //         } else if (perintah2.equals("AKHIR" ) || perintah2.equals("AKHIR ")) {
        //             list.append(input);
        //         }

        //     } else if (perintah1.equals("HAPUS")  || perintah1.equals("HAPUS ")) {
        //         perintah2 = perintah.substring(0, perintah.length());
        //             if (perintah2.equals("AWAL") || perintah2.equals("AWAL ")) {
        //                 list.removeFirst();
        //             } else if (perintah2.equals("AKHIR") || perintah2.equals("AKHIR ")) {
        //                 list.removeLast();
                    
        //         }
        //     } else if (perintah1.equals("LIHAT") || perintah1.equals("LIHAT ")) {
        //             list.printList();
        //     } else if (perintah1.equals("ADA") || perintah1.equals("ADA ")) {
        //         // pakek!!!!!
        //         perintah2 = perintah.substring(0, perintah.indexOf(" "));
        //         input = Integer.parseInt(perintah.substring(perintah.indexOf(" ") + 1, perintah.length()));
        //         list.search(input);
        //     } else if (perintah1.equals("BERAPA") || perintah1.equals("BERAPA ")) {
        //             list.getLength();
                
        //     }
        //     // System.out.println(perintah1);

        // }
        for (int i = 0; i < jumlahPerintah; i++) {
            String[] perintah = scanner.nextLine().split(" ");
            switch (perintah[0]) {
                case "TAMBAH":
                    int data = Integer.parseInt(perintah[2]);
                    if (perintah[1].equals("AWAL")) {
                        sll.tambahAwal(data);
                    } else if (perintah[1].equals("AKHIR")) {
                        sll.tambahAkhir(data);
                    }
                    break;
                case "HAPUS":
                    if (perintah[1].equals("AWAL")) {
                        sll.hapusAwal();
                    } else if (perintah[1].equals("AKHIR")) {
                        sll.hapusAkhir();
                    }
                    break;
                case "ADA":
                    int searchData = Integer.parseInt(perintah[2]);
                    System.out.println(sll.ada(searchData) ? "ADA" : "MAAF YAH KAMU SEDANG TIDAK BERUNTUNG, TERNYATA DATANYA GAK ADA");
                    break;
                case "LIHAT":
                    sll.lihatDong();
                    break;
                case "BERAPA":
                    System.out.println(sll.berapaTuh());
                    break;
                default:
                    break;
            }
        }
        scanner.close();
    }
}

class SLL {

    Node head, tail;
    int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public void tambahAkhir(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    public void hapusAwal() {
        if (!isEmpty()) {
            head = head.next;
            size--;
            if (isEmpty()) {
                tail = null;
            }
        }
    }
    public void tambahAwal(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    public void hapusAkhir() {
        if (!isEmpty()) {
            if (size == 1) {
                head = tail = null;
            } else {
                Node current = head;
                while (current.next != tail) {
                    current = current.next;
                }
                tail = current;
                tail.next = null;
            }
            size--;
        }
    }
    public void lihatDong() {
        if (isEmpty()) {
            System.out.println("Data Linked List kosong");
        } else {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public int berapaTuh() {
        return size;
    }
    public boolean ada(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}