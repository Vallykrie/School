import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        CDLL cdll = new CDLL();
        int value = 0;

        int loop = than.nextInt();
        than.nextLine();
        for (int i = 0; i < loop; i++) {
            String perintah = than.nextLine();
            String[] eachCommand = perintah.split(" ");
            switch (eachCommand[0]) {
                case "PRINT":
                    if (eachCommand[1].equals("ALL")) {
                        cdll.printToLast();

                    } else if (eachCommand[1].equals("SPECIAL")) {
                        cdll.printSpecial();

                    }
                    break;
                case "ADD":
                    if (eachCommand[1].equals("FIRST")) {
                        value = Integer.parseInt(eachCommand[2]);
                        cdll.addFirst(value);

                    } else if (eachCommand[1].equals("LAST")) {
                        value = Integer.parseInt(eachCommand[2]);
                        cdll.addLast(value);
                    }

                    break;
                case "REMOVE":
                    if (eachCommand[1].equals("FIRST")) {
                        cdll.removeFirst();
                    } else if (eachCommand[1].equals("LAST")) {
                        cdll.removeLast();
                    }

                    break;
                case "IS":
                    value = Integer.parseInt(eachCommand[2]);
                    cdll.isExist(value);
                    break;

                default:
                    break;
            }
        }

    }

}

class NodeDLL {
    int data;
    NodeDLL next;
    NodeDLL prev;

    public NodeDLL(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class CDLL {
    NodeDLL head, tail;
    int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(int data) {
        NodeDLL input = new NodeDLL(data);
        if (isEmpty()) {
            head = tail = input;
        } else {
            input.next = head;
            head.prev = input;
            head = input;
        }
        tail.next = head;
        head.prev = tail;
        size++;
    }

    public void addLast(int data) {
        NodeDLL input = new NodeDLL(data);
        if (isEmpty()) {
            head = tail = input;
        } else {
            input.prev = tail;
            tail.next = input;
            tail = input;
        }
        tail.next = head;
        head.prev = tail;
        size++;
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("DATA IS EMPTY!");
            return;
        }
        if (size == 1) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }
        size--;
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("DATA IS EMPTY!");
            return;
        }
        if (size == 1) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = head;
            head.prev = tail;
        }
        size--;
    }

    public void isExist(int data) {
        NodeDLL pointer = head;
        boolean found = false;
        while (pointer != null) {
            if (pointer.data == data) {
                System.out.println("YES");
                found = true;
            }
            pointer = pointer.next;
            if (pointer == head)
                break;
        }
        if (found == false) {
            System.out.println("NO");
        }
    }

    public void printToLast() {
        if (isEmpty()) {
            return;
        }
        NodeDLL pointer = head;
        while (pointer != tail) {
            System.out.print(pointer.data + " ");
            pointer = pointer.next;
        }
        System.out.print(pointer.data);
        System.out.println();
    }

    public void printSpecial() {
        // 12345
        NodeDLL pointer = tail;
        while (pointer.next != tail) {
            System.out.print(pointer.data + " ");
            pointer = pointer.next;
        }
        System.out.print(pointer.data);
        System.out.println();
    }
}