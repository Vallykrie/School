import java.util.Scanner;

public class nathan_051_4_2 {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        String postfix1 = than.nextLine();
        String postfix2 = than.nextLine();
        Stack stack1 = new Stack();
        int result = 0;

        for (int i = 0; i < postfix1.length(); i++) {
            char ch = postfix1.charAt(i);
            if (Character.isDigit(ch)) {
                stack1.push(ch - '0');
            } else {
                int operand2 = stack1.pop();
                int operand1 = stack1.pop();
                switch (ch) {
                    case '+':
                        result = operand1 + operand2;
                        break;
                    case '-':
                        result = operand1 - operand2;
                        break;
                    case '*':
                        result = operand1 * operand2;
                        break;
                    case '/':
                        result = operand1 / operand2;
                        break;
                    case '^':
                        result = (int) Math.pow(operand1, operand2);
                        break;
                }
                stack1.push(result);
            }
        }
        int result1 = stack1.pop();

        Stack stack2 = new Stack();
        for (int i = 0; i < postfix2.length(); i++) {
            char ch = postfix2.charAt(i);
            if (Character.isDigit(ch)) {
                stack2.push(ch - '0');
            } else {
                int b = stack2.pop();
                int a = stack2.pop();
                switch (ch) {
                    case '+':
                        result = a + b;
                        break;
                    case '-':
                        result = a - b;
                        break;
                    case '*':
                        result = a * b;
                        break;
                    case '/':
                        result = a / b;
                        break;
                    case '^':
                        result = (int) Math.pow(a, b);
                        break;
                }
                stack2.push(result);
            }
        }
        int result2 = stack2.pop();

        if (result1 == result2) {
            System.out.println("SAMA");
        } else {
            System.out.println("BEDA");
        }
    }
}

class Stack {
    NodeStack head, tail;
    char a;
    int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(int data) {
        NodeStack input = new NodeStack(data);
        if (isEmpty()) {
            head = tail = input;
        } else {
            tail.next = input;
            tail = input;
        }
        size++;
    }

    public int pop() {
        if (size == 0) {
            return 0;
        }
        int dataSebelumnya = tail.data;
        if (size == 1) {
            head = tail = null;
        } else {
            NodeStack pointer = head;
            while (pointer.next != tail) {
                pointer = pointer.next;
            }
            pointer.next = null;
            tail = pointer;
        }
        size--;
        return dataSebelumnya;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Kosong cuy");
        } else {
            NodeStack current = head;
            while (current != null) {
                System.out.println(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

}

class NodeStack {
    int data;
    NodeStack next;

    NodeStack(int data) {
        this.data = data;
        this.next = null;
    }
}