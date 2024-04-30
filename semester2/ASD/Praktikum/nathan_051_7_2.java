import java.util.Scanner;

public class nathan_051_7_2 {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        BST bst = new BST();
        int n = than.nextInt();
        than.nextLine();
        for (int i = 0; i < n; i++) {
            String[] perintah = than.nextLine().split(" ");
            switch (perintah[0]) {
                case "Tambah":
                    System.out.println("Masukkan tahun: ");
                    int tahun = than.nextInt();
                    than.nextLine();
                    System.out.println("Masukkan judul: ");
                    String judul = than.nextLine();
                    System.out.println("Masukkan penulis: ");
                    String penulis = than.nextLine();
                    bst.add(tahun, judul, penulis);
                    break;
                case "Hapus":
                    System.out.println("Masukkan tahun buku yang ingin dihapus: ");
                    int tahunHapus = than.nextInt();
                    if (than.hasNextLine()) {
                        than.nextLine();
                    }
                    bst.delete(tahunHapus);
                    break;
                case "Cari":
                    System.out.println("1. Cari Buku Paling Lama");
                    System.out.println("2. Cari Buku Paling Baru");
                    System.out.println("3. Cari Buku Lain");
                    System.out.println("Masukkan pilihan Anda:");
                    int pilihan = than.nextInt();
                    if (than.hasNextLine()) {
                        than.nextLine();
                    }
                    switch (pilihan) {
                        case 1:
                            bst.MIN(bst.root);
                            break;
                        case 2:
                            bst.MAX(bst.root);
                            break;
                        case 3:
                            System.out.println("Masukkan tahun buku yang ingin dicari: ");
                            int tahunCari = than.nextInt();
                            if (than.hasNextLine()) {
                                than.nextLine();
                            }
                            bst.search(tahunCari);

                            break;
                        default:
                            break;
                    }

                    break;
                case "Tampilkan":
                    bst.preorder(bst.root);
                    break;

                default:
                    break;
            }
        }

    }
}

class NodeBST {
    int tahun;
    String judul, penulis;
    NodeBST left, right;

    public NodeBST(int tahun, String judul, String penulis) {
        this.tahun = tahun;
        this.judul = judul;
        this.penulis = penulis;
        left = right = null;
    }
}

class BST {
    NodeBST root;

    public void add(int tahun, String judul, String penulis) {
        root = add(root, tahun, judul, penulis);
    }

    public NodeBST add(NodeBST current, int tahun, String judul, String penulis) {
        NodeBST temp = current;
        if (temp == null) {
            temp = new NodeBST(tahun, judul, penulis);
        } else if (tahun < current.tahun) {
            temp.left = add(current.left, tahun, judul, penulis);
        } else if (tahun > current.tahun) {
            temp.right = add(current.right, tahun, judul, penulis);
        }
        // else if (tahun == current.tahun) {
        // temp = new NodeBST(tahun, judul, penulis);
        // }
        System.out.println("Data berhasil ditambahkan");
        return temp;
    }

    public void delete(int tahun) {
        root = delete(root, tahun);
    }

    public NodeBST delete(NodeBST current, int tahun) {
        // if (root == null) {
        // System.out.println("Data tidak ditemukan");
        // return null;
        // }
        if (current == null) {
            System.out.println("Data tidak ditemukan");
            return null;
        }
        if (tahun < current.tahun) {
            current.left = delete(current.left, tahun);
            return current;
        } else if (tahun > current.tahun) {
            current.right = delete(current.right, tahun);
            return current;
        } else {
            // jika data yang akan dihapus merupakan leaf node
            if (current.left == null && current.right == null) {
                System.out.println("Data berhasil dihapus");
                return null;
            }
            // jika data yang dihapus memiliki 1 child node
            if (current.right == null) {
                System.out.println("Data berhasil dihapus");
                return current.left;
            }
            if (current.left == null) {
                System.out.println("Data berhasil dihapus");
                return current.right;
            }
            // jika data yang dihapus memiliki 2 child node
            int smallestValue = findSmallestValue(current.right);
            current.tahun = smallestValue;
            current.right = delete(current.right, smallestValue);
            System.out.println("Data berhasil dihapus");
            return current;
        }
    }

    public int findSmallestValue(NodeBST root) {
        if (root.left == null) {
            return root.tahun;
        } else {
            return findSmallestValue(root.left);
        }
    }

    public int MIN(NodeBST root) {
        if (root.left == null) {
            System.out.println(root.tahun + " - " + root.judul + " - " + root.penulis);
            return root.tahun;
        } else {
            return MIN(root.left);
        }
    }

    public int MAX(NodeBST root) {
        if (root.right == null) {
            System.out.println(root.tahun + " - " + root.judul + " - " + root.penulis);
            return root.tahun;
        } else {
            return MAX(root.right);
        }
    }

    public boolean search(int tahun) {
        return search(root, tahun);
    }

    public boolean search(NodeBST current, int tahun) {
        if (current == null) {
            System.out.println("Buku tidak ada");
            return false;
        }
        if (tahun == current.tahun) {
            System.out.println(current.tahun + " - " + current.judul + " - " + current.penulis);
            return true;
        }
        if (tahun < current.tahun) {
            return search(current.left, tahun);
        } else {
            return search(current.right, tahun);
        }
    }

    public int findBiggestValue(NodeBST root) {
        if (root.right == null) {
            return root.tahun;
        } else {
            return findBiggestValue(root.right);
        }
    }

    public void preorder(NodeBST current) {
        if (root == null) {
            System.out.println("Tidak ada data yang ditemukan");
            return;
        } else {
            System.out.println(current.tahun + " - " + current.judul + " - " + current.penulis);
            if (current.left != null) {
                preorder(current.left);
            }
            if (current.right != null) {
                preorder(current.right);
            }
        }
    }
}
