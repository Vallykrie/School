import java.util.Scanner;

public class nathan_051_6_2 {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);

        String[] nodesInput = than.nextLine().split(" ");
        BT bt = new BT();
        for (String node : nodesInput) {
            int value = Integer.parseInt(node);
            bt.add(value);
        }
        int limit = Integer.parseInt(than.nextLine());

        System.out.print("Print tree : ");
        bt.preorder(limit);
        System.out.println("Sum tree : " + bt.sum(limit));
        System.out.println("Count tree : " + bt.count(limit));

        than.close();
    }
}

class NodeBT {
    // root
    // B C
    int data;
    NodeBT left, right;

    public NodeBT(int data) {
        this.data = data;
        left = right = null;
    }
}

class BT {
    static int count;
    NodeBT root;
    // root
    // B C

    public void add(int input) {
        if (root == null) {
            root = new NodeBT(input);
            return;
        }
        // add(2)
        // add(3)

        // kondisi:
        // 1
        // 2 3

        Queue queue = new Queue();
        queue.enqueue(root);
        // queue : 3
        while (!queue.isEmpty()) {

            NodeBT pointer = queue.dequeue();
            // pointer Node: 1
            if (pointer.left == null) {
                pointer.left = new NodeBT(input);
                return;
            } else {
                queue.enqueue(pointer.left);
            }

            if (pointer.right == null) {
                pointer.right = new NodeBT(input);
                return;
            } else {
                queue.enqueue(pointer.right);
            }
        }
    }

    public void inorder(NodeBT current) {
        if (current.left != null) {
            inorder(current.left);
        }
        System.out.print(current.data + " ");
        if (current.right != null) {
            inorder(current.right);
        }
    }

    public void preorder(int limit) {
        count = 0;
        preorder(root, limit);
        System.out.println();
    }

    private void preorder(NodeBT current, int limit) {
        if (current.data == limit) {
            System.out.print(current.data + " ");
            return;
        } else {
            System.out.print(current.data + " ");
            if (current.left != null) {
                if (current.data == limit) {
                    // System.out.print(current.data + " ");
                    return;
                }
                preorder(current.left, limit);
            }
            if (current.right != null) {
                if (current.data == limit) {
                    // System.out.print(current.data + " ");
                    return;
                }
                preorder(current.right, limit);
            }
        }
    }

    public int sum(int limit) {
        count = 0;
        return sum(root, limit);
    }

    private int sum(NodeBT root, int limit) {
        if (root == null || root.data > limit) {
            return 0;
        }
        count++;
        return root.data + sum(root.left, limit) + sum(root.right, limit);
    }

    public int count(int limit) {
        count = 0;
        return count(root, limit);
    }

    private int count(NodeBT root, int limit) {
        if (root == null || root.data > limit) {
            return 0;
        }
        count++;
        return 1 + count(root.left, limit) + count(root.right, limit);
    }

    // post-order?

    class NodeQueue {
        NodeBT data;
        NodeQueue next;

        public NodeQueue(NodeBT data) {
            this.data = data;
            this.next = null;
        }
    }

    class Queue {
        NodeQueue head, tail;
        int size = 0;

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void enqueue(NodeBT data) {
            NodeQueue input = new NodeQueue(data);
            if (isEmpty()) {
                head = tail = input;
            } else {
                tail.next = input;
                tail = input;
            }
            size++;
        }

        public NodeBT dequeue() {
            if (!isEmpty()) {
                NodeBT temp = head.data;
                head = head.next;
                size--;
                return temp;
            }
            return null;
        }
    }
}