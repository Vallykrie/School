package ASD.Praktikum;

import java.util.Scanner;

class NodeAVL {
    String barang;
    int data;
    NodeAVL left, right;
    int height;

    NodeAVL(String barang, int data) {
        this.barang = barang;
        this.data = data;
        height = 1;
        left = right = null;
    }
}

class AVL {
    NodeAVL root;
    int nomorkurang = 0;
    int nomorlebih = 0;

    public int height(NodeAVL N) {
        if (N == null) {
            return 0;
        }
        return N.height;
    }

    public NodeAVL rightRotate(NodeAVL y) {
        NodeAVL x = y.left;
        NodeAVL T2 = x.right;
        // rotasi kanan
        x.right = y;
        y.left = T2;
        // perbarui tinggi dari node
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    public int getBalance(NodeAVL N) {
        if (N == null) {
            return 0;
        }
        return height(N.left) - height(N.right);
    }

    public NodeAVL leftRotate(NodeAVL x) {
        NodeAVL y = x.right;
        NodeAVL T2 = y.left;
        // rotasi kiri
        y.left = x;
        x.right = T2;
        // perbarui tinggi dari node
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    public void add(String barang, int data) {
        root = add(root, barang, data);
    }

    public NodeAVL add(NodeAVL node, String barang, int data) {
        if (node == null) {
            return (new NodeAVL(barang, data));
        }
        if (data < node.data) {
            node.left = add(node.left, barang, data);
        } else if (data > node.data) {
            node.right = add(node.right, barang, data);
        } else {
            return node;
        }
        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);
        // right rotation (left of left)
        if (balance > 1 && data < node.left.data) {
            return rightRotate(node);
        }
        // left rotation (right of right)
        if (balance < -1 && data > node.right.data) {
            return leftRotate(node);
        }
        // left-right rotation (right of left)
        if (balance > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // right-left rotation (left of right)
        if (balance < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    int nomorLebih = 1;
    int nomorKurang = 1;

    boolean search(NodeAVL root, String condition, int harga) {
        if (root == null) {
            return false;
        }
        if (condition.equals("LEBIH DARI")) {
            boolean found = false;
            boolean leftFound = search(root.right, condition, harga);
            if (root.data > harga) {
                System.out.println(nomorLebih++ + ". " + root.barang + " = Rp" + root.data);
                found = true;
            }
            boolean rightFound = search(root.left, condition, harga);
            return found || leftFound || rightFound;
        } else if (condition.equals("KURANG DARI")) {
            boolean rightFound = search(root.right, condition, harga);
            boolean found = false;
            if (root.data < harga) {
                System.out.println(nomorKurang++ + ". " + root.barang + " = Rp" + root.data);
                found = true;
            }
            boolean leftFound = search(root.left, condition, harga);

            return leftFound || found || rightFound;
        } else if (condition.equals("SAMA DENGAN")) {
            boolean leftFound = search(root.left, condition, harga);
            boolean found = false;
            if (root.data == harga) {
                System.out.println(root.barang + " = Rp" + root.data);
                found = true;
            }
            boolean rightFound = search(root.right, condition, harga);
            return leftFound || found || rightFound;
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        AVL avl = new AVL();
        while (n-- > 0) {
            String command[] = sc.nextLine().split(" ");
            switch (command[0]) {
                case "TAMBAH":
                    String barang[] = sc.nextLine().split(";");
                    for (int i = 0; i < barang.length; i++) {
                        String a[] = barang[i].split(",");
                        avl.add(a[0], Integer.parseInt(a[1]));
                    }
                    System.out.println("Data " + barang.length + " barang berhasil ditambah\n");
                    break;
                case "CARI":
                    String find[] = sc.nextLine().split(" ");
                    String condition = find[0] + " " + find[1];
                    int harga = Integer.parseInt(find[2]);
                    if (!avl.search(avl.root, condition, harga)) {
                        System.out.println("Data barang tidak ditemukan\n");
                    } else {
                        System.out.println();
                    }
                    break;
                default:
                    break;
            }
        }
    }
}