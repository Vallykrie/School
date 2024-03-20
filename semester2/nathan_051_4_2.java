import java.util.Scanner;

public class nathan_051_4_2 {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        String postfix1 = than.nextLine();
        String postfix2 = than.nextLine();
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
        String operator1 = "";
        String operator2 = "";

        for (int i = postfix1.length(); i > 0; i--) {
            stack1.push(postfix1.charAt(i - 1));
        }

        for (int i = postfix2.length(); i > 0; i--) {
            stack2.push(postfix2.charAt(i - 1));
        }

        while (true) {
            operator1 = "";
            operator1 += stack1.pop();
            if (stack1.isEmpty()) {
                break;
            } else {
                operator1 += stack1.pop();
                operator1 += stack1.pop();

            }

            if (operator1.contains("+")) {
                operator1 = operator1.replace("+", "");
                double a = Character.getNumericValue(operator1.charAt(0));
                double b = Character.getNumericValue(operator1.charAt(1));
                double result = a + b;
                stack1.push((Character.forDigit((int) result, 10)));
            } else if (operator1.contains("-")) {
                operator1 = operator1.replace("-", "");
                double a = Character.getNumericValue(operator1.charAt(0));
                double b = Character.getNumericValue(operator1.charAt(1));
                double result = a - b;
                stack1.push((Character.forDigit((int) result, 10)));
            } else if (operator1.contains("*")) {
                operator1 = operator1.replace("*", "");
                double a = Character.getNumericValue(operator1.charAt(0));
                double b = Character.getNumericValue(operator1.charAt(1));
                double result = a * b;
                stack1.push((Character.forDigit((int) result, 10)));
            } else if (operator1.contains("/")) {
                operator1 = operator1.replace("/", "");
                double a = Character.getNumericValue(operator1.charAt(0));
                double b = Character.getNumericValue(operator1.charAt(1));
                double result = a / b;
                stack1.push((Character.forDigit((int) result, 10)));
            } else if (operator1.contains("^")) {
                operator1 = operator1.replace("^", "");
                double a = Character.getNumericValue(operator1.charAt(0));
                double b = Character.getNumericValue(operator1.charAt(1));
                double result = Math.pow(a, b);
                stack1.push((Character.forDigit((int) result, 10)));
            }
        }

        while (true) {
            operator2 = "";
            operator2 += stack2.pop();
            if (stack2.isEmpty()) {
                break;
            } else {
                operator2 += stack2.pop();
                operator2 += stack2.pop();

            }

            if (operator2.contains("+")) {
                operator2 = operator2.replace("+", "");
                double a = Character.getNumericValue(operator2.charAt(0));
                double b = Character.getNumericValue(operator2.charAt(1));
                double result = a + b;
                stack2.push((Character.forDigit((int) result, 10)));
            } else if (operator2.contains("-")) {
                operator2 = operator2.replace("-", "");
                double a = Character.getNumericValue(operator2.charAt(0));
                double b = Character.getNumericValue(operator2.charAt(1));
                double result = a - b;
                stack2.push((Character.forDigit((int) result, 10)));
            } else if (operator2.contains("*")) {
                operator2 = operator2.replace("*", "");
                double a = Character.getNumericValue(operator2.charAt(0));
                double b = Character.getNumericValue(operator2.charAt(1));
                double result = a * b;
                stack2.push((Character.forDigit((int) result, 10)));
            } else if (operator2.contains("/")) {
                operator2 = operator2.replace("/", "");
                double a = Character.getNumericValue(operator2.charAt(0));
                double b = Character.getNumericValue(operator2.charAt(1));
                double result = a / b;
                stack2.push((Character.forDigit((int) result, 10)));
            } else if (operator2.contains("^")) {
                operator2 = operator2.replace("^", "");
                double a = Character.getNumericValue(operator2.charAt(0));
                double b = Character.getNumericValue(operator2.charAt(1));
                double result = Math.pow(a, b);
                stack2.push((Character.forDigit((int) result, 10)));
            }
        }

        if (operator1.equals(operator2)) {
            System.out.println("SAMA");
        } else {
            System.out.println("BEDA");

        }
    }
}

class Stack {
    NodeStack head, tail;

    int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(char data) {
        NodeStack input = new NodeStack(data);
        if (isEmpty()) {
            head = tail = input;
        } else {
            tail.next = input;
            tail = input;
        }
        size++;
    }

    public char pop() {
        if (size == 0) {
            return 0;
        }
        char dataSebelumnya = tail.data;
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
    char data;
    NodeStack next;

    NodeStack(char data) {
        this.data = data;
        this.next = null;
    }
}