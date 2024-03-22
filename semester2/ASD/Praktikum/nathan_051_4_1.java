import java.util.Scanner;

public class nathan_051_4_1 {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        String input = than.nextLine();
        Stack stack = new Stack();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        boolean isPalindrome = true;
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println(input + " adalah palindrome.");
        } else
            System.out.println(input + " bukan palindrome.");
    }
}

class NodeStack {
    char data;
    NodeStack next;

    NodeStack(char data) {
        this.data = data;
    }
}

class Stack {
    NodeStack top;

    public void push(char data) {
        NodeStack node = new NodeStack(data);
        node.next = top;
        top = node;
    }

    public char pop() {
        char data = top.data;
        top = top.next;
        return data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}