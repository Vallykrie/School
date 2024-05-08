// package ASD.Praktikum;

import java.util.Scanner;

class NodeAVL {
    String playerName;
    int score;
    int height;
    NodeAVL left, right;

    NodeAVL(String playerName, int score) {
        this.playerName = playerName;
        this.score = score;
        this.height = 1;
        this.left = this.right = null;
    }
}

class AVL {
    NodeAVL root;

    int height(NodeAVL node) {
        if (node == null)
            return 0;
        return node.height;
    }

    int balanceFactor(NodeAVL node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    NodeAVL rightRotate(NodeAVL y) {
        NodeAVL x = y.left;
        NodeAVL T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    NodeAVL leftRotate(NodeAVL x) {
        NodeAVL y = x.right;
        NodeAVL T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    NodeAVL insert(NodeAVL node, String playerName, int score) {
        if (node == null)
            return new NodeAVL(playerName, score);
        if (playerName.compareTo(node.playerName) < 0)
            node.left = insert(node.left, playerName, score);
        else if (playerName.compareTo(node.playerName) > 0)
            node.right = insert(node.right, playerName, score);
        else {
            node.score = score;
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = balanceFactor(node);

        if (balance > 1 && score < node.left.score)
            return rightRotate(node);

        if (balance < -1 && score > node.right.score)
            return leftRotate(node);

        if (balance > 1 && score > node.left.score) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && score < node.right.score) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    NodeAVL minValueNode(NodeAVL node) {
        NodeAVL current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    void preorder(NodeAVL node) {
        if (node != null) {
            System.out.println(node.playerName + " = " + node.score);
            preorder(node.left);
            preorder(node.right);
        }
    }

    void displayLeaderboard() {
        if (root == null) {
            System.out.println("Leaderboard kosong");
            return;
        }
        preorder(root);
    }

    void comparePlayers(String player1, String player2) {
        NodeAVL p1 = search(root, player1);
        NodeAVL p2 = search(root, player2);

        if (p1 == null || p2 == null) {
            System.out.println("Tidak bisa dibandingkan karena pemain tidak terdaftar");
            return;
        }

        if (p1.score > p2.score)
            System.out.println(player1 + " lebih unggul dari " + player2);
        else if (p1.score < p2.score)
            System.out.println(player2 + " lebih unggul dari " + player1);
        else
            System.out.println("Skor kedua pemain sama");
    }

    void searchPlayer(String player, String type) {
        NodeAVL p = search(root, player);

        if (p == null) {
            System.out.println("Pemain belum terdaftar");
            return;
        }

        switch (type) {
            case "TERTINGGI":
                System.out.println("Pemain dengan skor tertinggi adalah " + p.playerName + " dengan skor " + p.score);
                break;
            case "TERENDAH":
                System.out.println("Pemain dengan skor terendah adalah " + p.playerName + " dengan skor " + p.score);
                break;
            default:
                System.out.println("Skor yang dimiliki oleh " + p.playerName + " adalah " + p.score);
        }
    }

    NodeAVL search(NodeAVL node, String playerName) {
        if (node == null || playerName.equals(node.playerName))
            return node;

        if (playerName.compareTo(node.playerName) < 0)
            return search(node.left, playerName);

        return search(node.right, playerName);
    }

    NodeAVL findHighestScore(NodeAVL node) {
        if (node == null || node.right == null)
            return node;
        return findHighestScore(node.right);
    }

    NodeAVL findLowestScore(NodeAVL node) {
        if (node == null || node.left == null)
            return node;
        return findLowestScore(node.left);
    }
}

public class nathan_051_8_2 {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        int n = than.nextInt();
        than.nextLine();
        AVL leaderboard = new AVL();

        for (int i = 0; i < n; i++) {
            String[] command = than.nextLine().split(" ");
            switch (command[0]) {
                case "MAIN":
                    command = command[1].split("-");
                    String playerName = command[0];
                    int score = Integer.parseInt(command[1]);
                    leaderboard.root = leaderboard.insert(leaderboard.root, playerName, score);
                    System.out.println(playerName + " telah menyelesaikan permainan dengan skor " + score);
                    break;
                case "BANDINGKAN":
                    command = command[1].split("/");
                    leaderboard.comparePlayers(command[0], command[1]);
                    break;
                case "CARI":
                    if (command[1].equals("TERTINGGI")) {
                        NodeAVL tertinggi = leaderboard.findHighestScore(leaderboard.root);
                        System.out.println("Pemain dengan skor tertinggi adalah " + tertinggi.playerName
                                + " dengan skor " + tertinggi.score);
                    } else if (command[1].equals("TERENDAH")) {
                        NodeAVL terendah = leaderboard.findLowestScore(leaderboard.root);
                        System.out.println("Pemain dengan skor terendah adalah " + terendah.playerName + " dengan skor "
                                + terendah.score);
                    } else
                        leaderboard.searchPlayer(command[2], "LAINNYA");
                    break;
                case "TAMPILKAN":
                    leaderboard.displayLeaderboard();
                    break;
            }
        }
    }
}
