import java.util.Scanner;

public class MainHT {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        HT ht = new HT();
        int n = than.nextInt();
        than.nextLine();
        for (int i = 0; i < n; i++) {
            String perintah[] = than.nextLine().split(" ");
            switch (perintah[0]) {
                case "TAMBAH":
                    switch (perintah[1]) {
                        case "ARRAY":
                            String[] inpArr = than.nextLine().split(" ");
                            for (String a : inpArr) {
                                ht.add(Integer.parseInt(a));
                            }
                            System.out.println("Array angka berhasil ditambah");
                            break;
                        case "SATUAN":
                            int inp = than.nextInt();
                            if (than.hasNextLine()) {
                                than.nextLine();
                            }
                            ht.add(inp);
                            System.out.println("Satuan angka berhasil ditambah");
                        default:
                            break;
                    }
                    break;

                case "PRINT":
                    switch (perintah[1]) {
                        case "PREORDER":
                            System.out.print("Preorder = ");
                            ht.preorder(ht.root);
                            System.out.println();
                            break;
                        case "INORDER":
                            System.out.print("Inorder = ");
                            ht.inorder(ht.root);
                            System.out.println();
                            break;
                        case "POSTORDER":
                            System.out.print("Postorder = ");
                            ht.postorder(ht.root);
                            System.out.println();
                            break;
                        case "MIN":
                            System.out.println("MIN = " + ht.min());
                            System.out.print("Preorder = ");
                            ht.preorder(ht.root);
                            System.out.println();
                            break;

                        default:
                            break;
                    }
                    break;

                default:
                    break;
            }
        }

    }
}

class NodeHT {

    int data;
    NodeHT left, right, parent;

    public NodeHT(int data) {
        this.data = data;
        left = right = null;
    }

    public NodeHT(int data, NodeHT parent) {
        this.data = data;
        this.parent = parent;
        left = right = null;
    }
}

class HT {
    NodeHT root, last;
    // root
    // B C

    public void add(int input) {
        if (root == null) {
            root = new NodeHT(input);
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

            NodeHT pointer = queue.dequeue();
            // pointer Node: 1
            if (pointer.left == null) {
                pointer.left = new NodeHT(input, pointer);
                last = pointer.left;
                heapifyUp(pointer.left);
                return;
            } else {
                queue.enqueue(pointer.left);
            }

            if (pointer.right == null) {
                pointer.right = new NodeHT(input, pointer);
                last = pointer.right;
                heapifyUp(pointer.right);
                return;
            } else {
                queue.enqueue(pointer.right);
            }
        }

    }

    public void heapifyUp(NodeHT node) {
        if (node.parent == null) {
            return;
        }
        int parentData = node.parent.data;
        if (node.data < parentData) {
            node.parent.data = node.data;
            node.data = parentData;
            heapifyUp(node.parent);
        }

    }

    public int min() {
        if (root == null) {
            return -1;
        }
        int min = root.data;
        if (root == last) {
            root = last = null;
        } else {
            if (last.parent != null) {
                root.data = last.data;
                if (last == last.parent.right) {
                    last.parent.right = null;
                    last = last.parent.left;
                } else {
                    last.parent.left = null;
                    Queue queue = new Queue();
                    queue.enqueue(root);
                    last = root;
                    while (!queue.isEmpty()) {
                        NodeHT pointer = queue.dequeue();
                        if (pointer.left == null) {
                            break;
                        } else {
                            queue.enqueue(pointer.left);
                            last = pointer.left;
                        }

                        if (pointer.right == null) {
                            break;
                        } else {
                            queue.enqueue(pointer.right);
                            last = pointer.right;
                        }
                    }
                }
            } else {
                root = last;
            }
            heapifyDown(root);
        }
        return min;
    }

    public void heapifyDown(NodeHT node) {
        int parentData = node.data;
        int leftData = Integer.MAX_VALUE, rightData = Integer.MAX_VALUE;
        if (node.left != null) {
            leftData = node.left.data;
        }
        if (node.right != null) {
            rightData = node.right.data;
        }
        if (leftData < parentData || rightData < parentData) {
            if (leftData < rightData) {
                node.data = leftData;
                node.left.data = parentData;
                heapifyDown(node.left);
            } else {
                node.data = rightData;
                node.right.data = parentData;
                heapifyDown(node.right);
            }
            if (node.data != Integer.MAX_VALUE) {
                heapifyDown(node);
            }

        }
    }

    public void preorder(NodeHT current) {
        if (root == null)
            return;
        System.out.print(current.data + " ");
        if (current.left != null) {
            preorder(current.left);
        }
        if (current.right != null) {
            preorder(current.right);
        }
    }

    public void inorder(NodeHT current) {
        if (root == null)
            return;
        if (current.left != null) {
            inorder(current.left);
        }
        System.out.print(current.data + " ");
        if (current.right != null) {
            inorder(current.right);
        }
    }

    public void postorder(NodeHT current) {
        if (root == null)
            return;
        if (current.left != null) {
            postorder(current.left);
        }
        if (current.right != null) {
            postorder(current.right);
        }
        System.out.print(current.data + " ");
    }
}

class NodeQueue {
    NodeHT data;
    NodeQueue next;

    public NodeQueue(NodeHT data) {
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

    public void enqueue(NodeHT data) {
        NodeQueue input = new NodeQueue(data);
        if (isEmpty()) {
            head = tail = input;
        } else {
            tail.next = input;
            tail = input;
        }
        size++;
    }

    public NodeHT dequeue() {
        if (!isEmpty()) {
            NodeHT temp = head.data;
            head = head.next;
            size--;
            return temp;
        }
        return null;
    }
}