package ASD.Praktikum;

class CompleteBinaryTree {
    private int[] tree;
    private int max;
    private int size;

    public CompleteBinaryTree(int capacity) {
        this.max = capacity;
        tree = new int[max + 1];
        size = 0;
    }

    public void insert(int value) {
        if (size == max) {
            System.out.println("Tree is full");
            return;
        }
        size++;
        tree[size] = value;
        heapUp(size);
    }

    private void heapUp(int index) {
        while (index > 1) {
            int parentIndex = index / 2;
            if (tree[index] < tree[parentIndex]) {
                int temp = tree[index];
                tree[index] = tree[parentIndex];
                tree[parentIndex] = temp;
            }
            index = parentIndex;
        }
    }

    public void display() {
        for (int i = 1; i <= size; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();
    }
}

public class BinaryTree {
    public static void main(String[] args) {
        CompleteBinaryTree tree = new CompleteBinaryTree(10);
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);

        System.out.print("Binary Tree: ");
        tree.display();
    }
}
