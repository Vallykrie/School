// package ASD.Praktikum.avl;

import java.util.Scanner;

public class nathan_051_8_2 {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        AVL avl = new AVL();
        int n = than.nextInt();
        than.nextLine();
        for (int i = 0; i < n; i++) {
            String[] perintah = than.nextLine().split(" ");
            switch (perintah[0]) {
                case "TAMPILKAN":
                    avl.preorder();
                    break;
                case "MAIN":
                    String[] pisahInput1 = perintah[1].split("-");
                    avl.insert(pisahInput1[0], Integer.parseInt(pisahInput1[1]));
                    System.out.println(pisahInput1[0] + " telah menyelesaikan permainan dengan skor " + pisahInput1[1]);
                    break;
                case "BANDINGKAN":
                    String[] pisahInput2 = perintah[1].split("/");
                    int compare = avl.comparePlayers(pisahInput2[0], pisahInput2[1]);
                    String nama1 = pisahInput2[0];
                    String nama2 = pisahInput2[1];
                    if (compare == 1) {
                        System.out.println(nama1 + " lebih unggul dari " + nama2);
                    } else if (compare == 2) {
                        System.out.println(nama2 + " lebih unggul dari " + nama1);
                    } else if (compare == 0) {
                        System.out.println("Tidak bisa dibandingkan karena pemain tidak terdaftar");
                    }
                    break;
                case "CARI":
                    if (perintah[1].equals("TERTINGGI")) {
                        if (avl.root != null) {
                            NodeAVL tmp = avl.scoreMax(avl.root);
                            if (tmp != null) {
                                System.out.println("Pemain dengan skor tertinggi adalah " + tmp.nama + " dengan skor "
                                        + tmp.score);
                            } else {
                                System.out.println("Pemain belum terdaftar");
                            }
                        } else {
                            System.out.println("Pemain belum terdaftar");
                        }
                    } else if (perintah[1].equals("TERENDAH")) {
                        avl.scoreMin(avl.root);
                        if (avl.root != null) {
                            NodeAVL tmp = avl.scoreMin(avl.root);
                            if (tmp != null) {
                                System.out.println(
                                        "Pemain dengan skor terendah adalah " + tmp.nama + " dengan skor "
                                                + tmp.score);
                            } else {
                                System.out.println("Pemain belum terdaftar");
                            }
                        } else {
                            System.out.println("Pemain belum terdaftar");
                        }
                    } else {
                        avl.cariNama(perintah[2]);
                    }
                    break;
            }
        }
    }
}

class NodeAVL {
    String nama;
    int score, tinggi;
    NodeAVL kakiKiri, kakiKanan;

    public NodeAVL(String nama, int score) {
        this.nama = nama;
        this.score = score;
        tinggi = 1;
    }
}

class AVL {
    NodeAVL root;

    public void insert(String nama, int score) {
        int cari = found(nama);
        if (cari == -1) {
            root = insert(root, nama, score);
        } else {
            delete(cari);
            root = insert(root, nama, score);
        }

    }

    public NodeAVL insert(NodeAVL root, String nama, int score) {

        if (root == null) {
            root = new NodeAVL(nama, score);
            return root;
        }

        if (score < root.score) {
            root.kakiKiri = insert(root.kakiKiri, nama, score);
        } else if (score > root.score) {
            root.kakiKanan = insert(root.kakiKanan, nama, score);
        } else {
            return root;
        }

        root.tinggi = 1 + (max(height(root.kakiKanan), height(root.kakiKiri)));
        int balance = hitungBalance(root);

        if (balance > 1 && score < root.kakiKiri.score) {
            return rightRotate(root);
        }

        if (balance < -1 && score > root.kakiKanan.score) {
            return leftRotate(root);
        }

        if (balance > 1 && score > root.kakiKiri.score) {
            root.kakiKiri = leftRotate(root.kakiKiri);
            return rightRotate(root);
        }

        if (balance < -1 && score < root.kakiKanan.score) {
            root.kakiKanan = rightRotate(root.kakiKanan);
            return leftRotate(root);
        }

        return root;
    }

    public int comparePlayers(String nama1, String nama2) {
        return comparePlayers(root, nama1, nama2);
    }

    public int comparePlayers(NodeAVL root, String nama1, String nama2) {
        int cari1 = found(nama1);
        int cari2 = found(nama2);

        if (cari1 != -1 && cari2 != -1) {
            if (cari1 > cari2) {
                return 1;
            } else {
                return 2;
            }
        } else {
            return 0;
        }
    }

    public boolean cariNama(String nama) {
        return cariNama(root, nama);
    }

    public boolean cariNama(NodeAVL root, String nama) {
        int cari = found(nama);
        if (cari != -1) {
            System.out.println("Skor yang dimiliki oleh " + nama + " adalah " + cari);
            return true;
        } else {
            System.out.println("Pemain belum terdaftar");
            return false;
        }
    }

    public NodeAVL scoreMin(NodeAVL root) {
        if (root == null) {
            return null;
        }
        if (root.kakiKiri == null) {
            return root;
        }
        return scoreMin(root.kakiKiri);
    }

    public NodeAVL scoreMax(NodeAVL root) {
        if (root == null) {
            return null;
        }
        if (root.kakiKanan == null) {
            return root;
        }
        return scoreMax(root.kakiKanan);
    }

    public int height(NodeAVL root) {
        if (root == null) {
            return 0;
        }
        return root.tinggi;
    }

    public int max(int kakiKanan, int kakiKiri) {
        return (kakiKanan > kakiKiri) ? kakiKanan : kakiKiri;
    }

    public int hitungBalance(NodeAVL root) {
        if (root == null) {
            return 0;

        }

        return height(root.kakiKiri) - height(root.kakiKanan);
    }

    public NodeAVL rightRotate(NodeAVL root) {
        NodeAVL tampungKiri = root.kakiKiri;
        NodeAVL anakKanan = tampungKiri.kakiKanan;
        tampungKiri.kakiKanan = root;
        root.kakiKiri = anakKanan;
        root.tinggi = 1 + max(height(root.kakiKiri), height(root.kakiKanan));
        tampungKiri.tinggi = 1 + max(height(tampungKiri.kakiKiri), height(tampungKiri.kakiKanan));

        return tampungKiri;
    }

    public NodeAVL leftRotate(NodeAVL root) {
        NodeAVL tampungKanan = root.kakiKanan;
        NodeAVL anakKiri = tampungKanan.kakiKiri;
        tampungKanan.kakiKiri = root;
        root.kakiKanan = anakKiri;
        root.tinggi = 1 + max(height(root.kakiKiri), height(root.kakiKanan));
        tampungKanan.tinggi = 1 + max(height(tampungKanan.kakiKiri), height(tampungKanan.kakiKanan));

        return tampungKanan;
    }

    public void preorder() {
        NodeAVL tampung = root;
        if (tampung == null) {
            System.out.println("Leaderboard kosong");
        } else {
            preorder(tampung);
        }
    }

    public void preorder(NodeAVL root) {
        System.out.println(root.nama + " = " + root.score);

        if (root.kakiKiri != null) {
            preorder(root.kakiKiri);
        }

        if (root.kakiKanan != null) {
            preorder(root.kakiKanan);
        }
    }

    public void delete(int tahun) {
        root = delete(root, tahun);
    }

    private NodeAVL delete(NodeAVL root, int score) {
        if (root == null) {
            return root;
        }

        if (score < root.score) {
            root.kakiKiri = delete(root.kakiKiri, score);
        } else if (score > root.score) {
            root.kakiKanan = delete(root.kakiKanan, score);
        } else {
            if (root.kakiKiri == null) {
                return root.kakiKanan;
            } else if (root.kakiKanan == null) {
                return root.kakiKiri;
            }
            root.score = minValue(root.kakiKanan);
            root.nama = minValueNama(root.kakiKanan);
            root.kakiKanan = delete(root.kakiKanan, root.score);
            return root;
        }

        root.tinggi = 1 + (max(height(root.kakiKanan), height(root.kakiKiri)));
        int balance = hitungBalance(root);

        if (balance > 1 && score < root.kakiKiri.score) {
            return rightRotate(root);
        }

        if (balance > 1 && score > root.kakiKanan.score) {
            return leftRotate(root);
        }

        if (balance > 1 && score > root.kakiKiri.score) {
            root.kakiKiri = leftRotate(root.kakiKiri);
            return rightRotate(root);
        }

        if (balance > 1 && score < root.kakiKanan.score) {
            root.kakiKanan = rightRotate(root.kakiKanan);
            return leftRotate(root);
        }

        return root;

    }

    private int minValue(NodeAVL root) {
        int min = root.score;
        while (root.kakiKiri != null) {
            min = root.kakiKiri.score;
            root = root.kakiKiri;
        }
        return min;
    }

    private String minValueNama(NodeAVL root) {
        int min = root.score;
        String nama = root.nama;
        while (root.kakiKiri != null) {
            min = root.kakiKiri.score;
            nama = root.kakiKiri.nama;
            root = root.kakiKiri;
        }
        return nama;
    }

    public int found(String nama) {
        int tmp = -1;

        if (root == null) {
            return -1;
        }
        found(root, nama, tmp);
        if (tmp != -1) {
            return tmp;
        }
        return -1;
    }

    public void found(NodeAVL root, String nama, int tmp) {
        if (root.nama.equals(nama)) {
            tmp = root.score;
        }

        if (root.kakiKiri != null) {
            found(root.kakiKiri, nama, tmp);
        }

        if (root.kakiKanan != null) {
            found(root.kakiKanan, nama, tmp);
        }

    }

}