import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class NodeCDLL {
    public String data;
    public NodeCDLL prev;
    public NodeCDLL next;

    NodeCDLL(String data) {
        this.data = data;
    }
}

class CDLL {
    NodeCDLL head;
    NodeCDLL tail;
    int size;

    public CDLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printToLast() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        NodeCDLL current = head;
        do {
            System.out.print(current.data + (current.next != head ? " -- " : ""));
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    public void addFirst(String data) {
        NodeCDLL newNode = new NodeCDLL(data);
        if (isEmpty()) {
            head = tail = newNode;
            newNode.prev = newNode.next = newNode;
        } else {
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
        }
        size++;
    }

    public void printToFirst() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }
        NodeCDLL current = tail;
        do {
            System.out.print(current.data + (current.prev != tail ? " -- " : ""));
            current = current.prev;
        } while (current != tail);
        System.out.println();
    }

    public void addLast(String data) {
        if (isEmpty()) {
            addFirst(data);
        } else {
            NodeCDLL newNode = new NodeCDLL(data);
            newNode.next = head;
            newNode.prev = tail;
            tail.next = newNode;
            head.prev = newNode;
            tail = newNode;
            size++;
        }
    }

    public void removeFirst() {
        if (isEmpty()) {
            return;
        }
        if (head == tail) {
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
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = head;
            head.prev = tail;
        }
        size--;
    }

    public void makeEmpty() {
        head = tail = null;
        size = 0;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            removeFirst();
            return;
        } else if (index == size - 1) {
            removeLast();
            return;
        }
        NodeCDLL current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
        if (current == tail) {
            tail = current.prev;
        }
        size--;
    }

    public void remove(String key) {
        if (isEmpty()) {
            return;
        }
        NodeCDLL current = head;
        do {
            if (current.data.equals(key)) {
                if (current == head) {
                    removeFirst();
                    return;
                } else if (current == tail) {
                    removeLast();
                    return;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    size--;
                    return;
                }
            }
            current = current.next;
        } while (current != head);
    }

    public void insert(int index, String data) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {
            NodeCDLL newNode = new NodeCDLL(data);
            NodeCDLL current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }

    public void insertAfter(String input, String key) {
        NodeCDLL current = head;
        if (isEmpty()) {
            addFirst(input);
            return;
        }
        boolean found = false;
        do {
            if (current.data.equals(key)) {
                NodeCDLL newNode = new NodeCDLL(input);
                newNode.next = current.next;
                newNode.prev = current;
                current.next.prev = newNode;
                current.next = newNode;
                if (current == tail) {
                    tail = newNode;
                }
                size++;
                found = true;
                break;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            return;
        }
    }

    public void insertBefore(String input, String key) {
        if (isEmpty()) {
            addFirst(input);
            return;
        }
        NodeCDLL current = head;
        do {
            if (current.data.equals(key)) {
                NodeCDLL newNode = new NodeCDLL(input);
                newNode.next = current;
                newNode.prev = current.prev;
                current.prev.next = newNode;
                current.prev = newNode;
                if (current == head) {
                    head = newNode;
                }
                size++;
                return;
            }
            current = current.next;
        } while (current != head);
        addLast(input);
    }

    public String get(int index) {
        if (index < 0 || index >= size)
            return "Index out of bounds";
        NodeCDLL current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public String get(String key) {
        NodeCDLL current = head;
        do {
            if (current.data.equals(key)) {
                return current.data;
            }
            current = current.next;
        } while (current != head);
        return "Data not found";
    }
}

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CDLL doublyLinkedList = new CDLL();

        while (true) {
            String command = scanner.next();

            switch (command.toUpperCase()) {
                case "ADD":
                    scanner.nextLine();
                    String titleToAdd = scanner.nextLine().trim();
                    doublyLinkedList.addLast(titleToAdd);
                    break;

                case "ADDFIRST":
                    scanner.nextLine();
                    String titleToAddFirst = scanner.nextLine().trim();
                    doublyLinkedList.addFirst(titleToAddFirst);
                    break;

                case "REMOVE":
                    scanner.nextLine();
                    String inputToRemove = scanner.nextLine().trim();
                    if (inputToRemove.matches("\\d+")) {
                        int indexToRemove = Integer.parseInt(inputToRemove);
                        doublyLinkedList.remove(indexToRemove);
                    } else {
                        doublyLinkedList.remove(inputToRemove);
                    }
                    break;

                case "REMOVEFIRST":
                    doublyLinkedList.removeFirst();
                    break;

                case "REMOVELAST":
                    doublyLinkedList.removeLast();
                    break;

                case "INSERT":
                    int indexToInsert = Integer.parseInt(scanner.next());

                    scanner.nextLine();

                    String titleToInsert = scanner.nextLine().trim();
                    doublyLinkedList.insert(indexToInsert, titleToInsert);
                    break;

                case "INSERTBEFORE":
                    scanner.nextLine();
                    String titleBefore = scanner.nextLine().trim();
                    String newTitleBefore = scanner.nextLine().trim();
                    doublyLinkedList.insertBefore(newTitleBefore, titleBefore);
                    break;

                case "INSERTAFTER":
                    scanner.nextLine();
                    String titleAfter = scanner.nextLine().trim();
                    String newTitleAfter = scanner.nextLine().trim();
                    doublyLinkedList.insertAfter(newTitleAfter, titleAfter);
                    break;

                case "GET":
                    scanner.nextLine();
                    String input = scanner.nextLine().trim();
                    if (input.matches("\\d+")) {
                        int index = Integer.parseInt(input);
                        System.out.println("Book at index " + index + ": " + doublyLinkedList.get(index));
                    } else {
                        System.out.println("Book: " + doublyLinkedList.get(input));
                    }
                    break;

                case "SIZE":
                    System.out.println(doublyLinkedList.size());
                    break;

                case "PRINT":
                    doublyLinkedList.printToLast();
                    break;

                case "PRINTREVERSE":
                    doublyLinkedList.printToFirst();
                    break;

                case "QUIT":
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
    }
}