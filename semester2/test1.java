import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        Stack bajuStack = new Stack();
        Stack celanaStack = new Stack();

        while (than.hasNextLine()) {
            String input = than.nextLine();
            String[] perintah = input.split(" ");

            switch (perintah[0]) {
                case "ADD":
                    String type = perintah[1];
                    int comfort = Integer.parseInt(perintah[2]);
                    String brand = perintah[3];
                    String size = perintah[4];
                    String color = perintah[5];

                    if (type.equals("BAJU")) {
                        Node newNode = new Node("Baju", comfort, brand, size, color);
                        bajuStack.push(newNode);
                        System.out.println("Baju" + " dengan merk " + brand + " size " + size + " warna " + color
                                + " berhasil ditambahkan");
                    } else if (type.equals("CELANA")) {
                        Node newNode = new Node("Celana", comfort, brand, size, color);
                        celanaStack.push(newNode);
                        System.out.println("Celana" + " dengan merk " + brand + " size " + size + " warna " + color
                                + " berhasil ditambahkan");
                    }
                    break;
                case "CEK":
                    type = perintah[1];
                    if (type.equals("BAJU")) {
                        if (!bajuStack.isEmpty()) {
                            bajuStack = bajuStack.display("Baju");
                        } else {
                            System.out.println("Tumpukan masih kosong!");
                        }
                    } else if (type.equals("CELANA")) {
                        if (!celanaStack.isEmpty()) {
                            celanaStack = celanaStack.display("Celana");
                        } else {
                            System.out.println("Tumpukan masih kosong!");
                        }
                    }

                    break;
                case "KELUAR":
                    if (bajuStack.isEmpty() && celanaStack.isEmpty()) {
                        System.out.println("tidak ada baju dan celana yang tersisa");
                    } else if (bajuStack.isEmpty()) {
                        System.out.println("tidak ada baju yang tersisa");
                    } else if (celanaStack.isEmpty()) {
                        System.out.println("tidak ada celana yang tersisa");
                    } else {
                        bajuStack.pop();
                        celanaStack.pop();
                    }
                    break;
                case "STOP":

                    return;

            }
        }
        than.close();
    }
}

class Node {
    String type;
    int comfort;
    String brand;
    String size;
    String color;
    Node next;

    public Node(String type, int comfort, String brand, String size, String color) {
        this.type = type;
        this.comfort = comfort;
        this.brand = brand;
        this.size = size;
        this.color = color;
        this.next = null;
    }
}

class Stack {
    Node top;

    public Stack() {
        this.top = null;
    }

    public void push(Node newNode) {
        if (top == null) {
            top = newNode;
        } else {
            if (newNode.comfort >= top.comfort) {
                newNode.next = top;
                top = newNode;
            } else {
                Node current = top;
                while (current.next != null && current.next.comfort > newNode.comfort) {
                    current = current.next;
                }
                newNode.next = current.next;
                current.next = newNode;
            }
        }
    }

    public Node pop() {
        if (top == null) {
            return null;
        }
        Node temp = top;
        top = top.next;
        temp.next = null;
        top.next = null;
        return temp;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public Stack display(String type) {
        Node current = top;
        System.out.println("Daftar " + type + " :");
        int count = 1;
        while (current != null) {
            System.out
                    .println(count + " merk: " + current.brand + " size: " + current.size + " warna: " + current.color);
            current = current.next;
            count++;
        }

        Stack tmp = new Stack();
        // for (Node i = top; i != null; i = i.next) {
        // Node newNode = new Node(i.type, i.comfort, i.brand, i.size, i.color);
        // tmp.push(newNode);
        // }
        while (top != null) {
            tmp.push(pop());
        }
        return tmp;

    }
}
