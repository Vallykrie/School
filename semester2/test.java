import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class DoublyNode {
    public String data;
    public DoublyNode prev;
    public DoublyNode next;

    DoublyNode() {
    }

    DoublyNode(String data) {
        this.data = data;
    }

    DoublyNode(String data, DoublyNode prev, DoublyNode next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}

class DoublyLinkedList {
    DoublyNode head;
    DoublyNode tail;
    int size;

    public DoublyLinkedList() {
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
        DoublyNode current = head;
        while (current != null) {
            System.out.print(current.data + (current.next != null ? " -- " : ""));
            current = current.next;
        }
        System.out.println();
    }

    void addFirst(String data) {
        DoublyNode newNode = new DoublyNode(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void printToFirst() {
        DoublyNode current = tail;
        while (current != null) {
            System.out.print(current.data + (current.prev != null ? " -- " : ""));
            current = current.prev;
        }
        System.out.println();
    }

    public void addLast(String data) {
        DoublyNode newNode = new DoublyNode(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void removeFirst() {
        if (!isEmpty()) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            size--;
        }
    }

    public void removeLast() {
        if (!isEmpty()) {
            if (head == tail) {
                head = tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
            size--;
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        size = 0;
    }

    public void remove(int index) {
        if (index < 0 || index >= size)
            return;

        DoublyNode current = head;
        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
        }
    }

    public void remove(String key) {
        DoublyNode current = head;
        while (current != null) {
            if (current.data.equals(key)) {
                if (current == head) {
                    removeFirst();
                } else if (current == tail) {
                    removeLast();
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    size--;
                }
                return;
            }
            current = current.next;
        }
    }

    public void insert(int index, String data) {
        if (index < 0 || index > size)
            return;

        if (index == 0) {
            addFirst(data);
        } else if (index == size - 1) {
            addLast(data);
        } else {
            DoublyNode newNode = new DoublyNode(data);
            DoublyNode current = head;
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
        DoublyNode current = head;
        while (current != null) {
            if (current.data.equals(key)) {
                DoublyNode newNode = new DoublyNode(input);
                newNode.next = current.next;
                newNode.prev = current;
                if (current.next != null) {
                    current.next.prev = newNode;
                }
                current.next = newNode;
                if (current == tail) {
                    tail = newNode;
                }
                size++;
                return;
            }
            current = current.next;
        }
        addLast(key);
    }

    public void insertBefore(String input, String key) {
        if (head != null && head.data.equals(key)) {
            addFirst(key);
            return;
        }

        DoublyNode current = head;
        while (current != null) {
            if (current.data.equals(key)) {
                DoublyNode newNode = new DoublyNode(input);
                current.prev.next = newNode;
                newNode.prev = current.prev;
                newNode.next = current;
                current.prev = newNode;
                size++;
                return;
            }
            current = current.next;
        }
        addLast(key);
    }

    public String get(int index) {
        if (index < 0 || index >= size)
            return "Index out of bounds";
        DoublyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public String get(String key) {
        DoublyNode current = head;
        while (current != null) {
            if (current.data.equals(key)) {
                return current.data;
            }
            current = current.next;
        }
        return "Book not found";
    }
}

public class test {
    // Jangan ubah
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

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