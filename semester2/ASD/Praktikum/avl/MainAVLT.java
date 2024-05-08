class Node {
    int data;
    int tinggi; // tinggi node
    Node pKiri;
    Node pKanan;
    Node pInduk; // pointer ke induk
    // constructor node

    public Node(int dt, int tg, Node pKi, Node pKa, Node pI) {
        this.data = dt;
        this.tinggi = tg;
        this.pKiri = pKi;
        this.pKanan = pKa;
        this.pInduk = pI;
    }
}

public class MainAVLT {

    public static void main(String[] args) {
        MainAVLT avlt = new MainAVLT();
        int[] node = { 8, 16, 20, 12, 13, 69, 79 };
        for (int i : node) {
            avlt.sisipDt(i);
            avlt.inOrderTraversal();
            System.out.println();
        }

        avlt.delete(16);
        avlt.delete(12);
        avlt.inOrderTraversal();
    }

    private Node root;

    public MainAVLT() {
        root = null;
    }

    // cari dt di tree, mengembalikan true jika ditemukan
    // dan false jika tidak
    public boolean cariDt(int dt) {
        Node temp = root;
        while (temp != null) {
            if (dt == temp.data)
                return true;
            // cariDt subtree pKiri
            else if (dt < temp.data)
                temp = temp.pKiri;
            // cariDt subtree pKanan
            else
                temp = temp.pKanan;
        }
        // dt tidak ditemukan
        return false;
    }

    // sisip dt ke dalam tree, returns true if berhasil,
    // false jika gagal
    // tree diseimbangkan menggunakan algoritma AVL
    public boolean sisipDt(int dt) {
        if (root == null) {
            // sisip dt di root
            root = new Node(dt, 1, null, null, null);
            return true;
        } else {
            // mulai dari root
            Node temp = root;
            Node prev = null;
            // cari lokasi penyisipan dt
            while (temp != null) {
                if (dt == temp.data)
                    return false;
                // sisip dt di subtree pKiri
                else if (dt < temp.data) {
                    prev = temp;
                    temp = temp.pKiri;
                }
                // sisip dt di subtree pKanan
                else {
                    prev = temp;
                    temp = temp.pKanan;
                }
            }
            // buat node baru
            temp = new Node(dt, 1, null, null, prev);
            if (dt < prev.data)
                prev.pKiri = temp; // sisip di pKiri
            else
                prev.pKanan = temp; // sisipDt at pKanan
            // mulai dari node yang disisipkan dan
            // bergerak menuju root
            while (temp != null) {
                // subtree pKiri dan pKanan memenuhi kondisi AVL
                if (Math.abs(tinggi(temp.pKiri) - tinggi(temp.pKanan)) <= 1) {
                    temp.tinggi = Math.max(tinggi(temp.pKiri), tinggi(temp.pKanan)) + 1;
                }
                // kasus 1 algoritma AVL
                else if (tinggi(temp.pKiri) - tinggi(temp.pKanan) >= 2
                        && tinggi(temp.pKiri.pKiri) >= tinggi(temp.pKiri.pKanan)) {
                    Node parent = temp.pInduk;
                    Node pKiri = temp.pKiri;
                    temp.pKiri = pKiri.pKanan;
                    if (temp.pKiri != null)
                        temp.pKiri.pInduk = temp;
                    pKiri.pKanan = temp;
                    temp.pInduk = pKiri;
                    pKiri.pInduk = parent;
                    if (parent == null)
                        root = pKiri;
                    else if (parent.pKiri == temp)
                        parent.pKiri = pKiri;
                    else
                        parent.pKanan = pKiri;
                    // hitung tinggi subtree pKanan
                    temp.tinggi = Math.max(tinggi(temp.pKiri), tinggi(temp.pKanan)) + 1;
                    temp = pKiri;
                    // hitung tinggi dari root
                    temp.tinggi = Math.max(tinggi(temp.pKiri), tinggi(temp.pKanan)) + 1;
                }
                // case 2 algoritma AVl
                else if (tinggi(temp.pKanan) - tinggi(temp.pKiri) >= 2
                        && tinggi(temp.pKanan.pKanan) >= tinggi(temp.pKanan.pKiri)) {
                    Node parent = temp.pInduk;
                    Node pKanan = temp.pKanan;
                    temp.pKanan = pKanan.pKiri;
                    if (temp.pKanan != null)
                        temp.pKanan.pInduk = temp;
                    pKanan.pKiri = temp;
                    temp.pInduk = pKanan;
                    pKanan.pInduk = parent;
                    if (parent == null)
                        root = pKanan;
                    else if (parent.pKanan == temp)
                        parent.pKanan = pKanan;
                    else
                        parent.pKiri = pKanan;
                    // hitung tinggi subtree pKanan
                    temp.tinggi = Math.max(tinggi(temp.pKiri), tinggi(temp.pKanan)) + 1;
                    temp = pKanan;
                    // hitung tinggi dari root
                    temp.tinggi = Math.max(tinggi(temp.pKiri), tinggi(temp.pKanan)) + 1;
                }
                // kasus 3 dari algoritma AVL
                else if (tinggi(temp.pKiri) - tinggi(temp.pKanan) >= 2
                        && tinggi(temp.pKiri.pKanan) >= tinggi(temp.pKiri.pKiri)) {
                    Node parent = temp.pInduk;
                    Node pKiripKanan = temp.pKiri.pKanan;
                    temp.pKiri.pKanan = pKiripKanan.pKiri;
                    if (temp.pKiri.pKanan != null)
                        temp.pKiri.pKanan.pInduk = temp.pKiri;
                    pKiripKanan.pKiri = temp.pKiri;
                    temp.pKiri.pInduk = pKiripKanan;
                    temp.pKiri = pKiripKanan.pKanan;
                    if (temp.pKiri != null)
                        temp.pKiri.pInduk = temp;
                    pKiripKanan.pKanan = temp;
                    temp.pInduk = pKiripKanan;
                    pKiripKanan.pInduk = parent;
                    if (parent == null)
                        root = pKiripKanan;
                    else if (parent.pKiri == temp)
                        parent.pKiri = pKiripKanan;
                    else
                        parent.pKanan = pKiripKanan;
                    // hitung tinggi subtree pKanan
                    temp.tinggi = Math.max(tinggi(temp.pKiri), tinggi(temp.pKanan)) + 1;
                    temp = pKiripKanan;
                    // hitung tinggi dari root
                    temp.tinggi = Math.max(tinggi(temp.pKiri), tinggi(temp.pKanan)) + 1;
                }
                // kasus 4 dari algoritma AVL
                else if (tinggi(temp.pKanan) - tinggi(temp.pKiri) >= 2
                        && tinggi(temp.pKanan.pKiri) >= tinggi(temp.pKanan.pKanan)) {
                    Node parent = temp.pInduk;
                    Node pKananpKiri = temp.pKanan.pKiri;
                    temp.pKanan.pKiri = pKananpKiri.pKanan;
                    if (temp.pKanan.pKiri != null)
                        temp.pKanan.pKiri.pInduk = temp.pKanan;
                    pKananpKiri.pKanan = temp.pKanan;
                    temp.pKanan.pInduk = pKananpKiri;
                    temp.pKanan = pKananpKiri.pKiri;
                    if (temp.pKanan != null)
                        temp.pKanan.pInduk = temp;
                    pKananpKiri.pKiri = temp;
                    temp.pInduk = pKananpKiri;
                    pKananpKiri.pInduk = parent;
                    if (parent == null)
                        root = pKananpKiri;
                    else if (parent.pKanan == temp)
                        parent.pKanan = pKananpKiri;
                    else
                        parent.pKiri = pKananpKiri;
                    temp.tinggi = Math.max(tinggi(temp.pKiri), tinggi(temp.pKanan)) + 1;
                    temp = pKananpKiri;
                    temp.tinggi = Math.max(tinggi(temp.pKiri), tinggi(temp.pKanan)) + 1;
                }
                temp = temp.pInduk;
            }
            // penyisipan berhasil
            return true;
        }
    }

    public int tinggi() {
        return root.tinggi;
    }

    private int tinggi(Node node) {
        if (node == null)
            return 0;
        else
            return node.tinggi;
    }

    // hitung node-node dari tree
    public int jumlahNode() {
        return jumlahNode(root);
    }

    public void inOrderTraversal() {
        inOrder(root);
    }

    private void inOrder(Node r) {
        if (r == null)
            return;
        inOrder(r.pKiri);
        System.out.printf("-%d", r.data);
        inOrder(r.pKanan);
    }

    // hitung node-node dari tree
    private int jumlahNode(Node node) {
        if (node == null)
            return 0;
        else
            return 1 + jumlahNode(node.pKiri) + jumlahNode(node.pKanan);
    }

    public boolean cariData(int dt) {
        Node temp = root;
        while (temp != null) {
            if (dt == temp.data)
                return true;
            // cariDt subtree pKiri
            else if (dt < temp.data)
                temp = temp.pKiri;
            // cariDt subtree pKanan
            else
                temp = temp.pKanan;
        }
        // dt tidak ditemukan
        return false;
    }

    public boolean delete(int dt) {
        if (!cariData(dt)) {
            System.out.println("Data tidak ditemukan dalam pohon.");
            return false;
        }
        Node temp = root;
        Node parent = null;
        while (temp != null && temp.data != dt) {
            parent = temp;
            if (dt < temp.data)
                temp = temp.pKiri;
            else
                temp = temp.pKanan;
        }
        if (temp.pKiri == null && temp.pKanan == null) {
            if (temp == root) {
                root = null;
            } else {
                if (parent.pKiri == temp)
                    parent.pKiri = null;
                else
                    parent.pKanan = null;
            }
        } else if (temp.pKiri == null || temp.pKanan == null) {
            Node child = (temp.pKiri != null) ? temp.pKiri : temp.pKanan;
            if (temp == root) {
                root = child;
                root.pInduk = null;
            } else {
                if (parent.pKiri == temp)
                    parent.pKiri = child;
                else
                    parent.pKanan = child;
                child.pInduk = parent;
            }
        } else {
            Node pengganti = temp.pKanan;
            while (pengganti.pKiri != null) {
                pengganti = pengganti.pKiri;
            }
            temp.data = pengganti.data;
            if (pengganti.pKiri == null && pengganti.pKanan == null) {
                if (pengganti.pInduk.pKiri == pengganti)
                    pengganti.pInduk.pKiri = null;
                else
                    pengganti.pInduk.pKanan = null;
            } else {
                Node child = (pengganti.pKiri != null) ? pengganti.pKiri : pengganti.pKanan;
                if (pengganti.pInduk.pKiri == pengganti)
                    pengganti.pInduk.pKiri = child;
                else
                    pengganti.pInduk.pKanan = child;
                child.pInduk = pengganti.pInduk;
            }
        }
        balance(temp);
        return true;
    }

    private void balance(Node node) {
        while (node != null) {
            int tinggiKiri = (node.pKiri != null) ? node.pKiri.tinggi : 0;
            int tinggiKanan = (node.pKanan != null) ? node.pKanan.tinggi : 0;
            node.tinggi = Math.max(tinggiKiri, tinggiKanan) + 1;
            if (Math.abs(tinggiKiri - tinggiKanan) > 1) {
                if (tinggiKiri > tinggiKanan) {
                    if (tinggi(node.pKiri.pKiri) >= tinggi(node.pKiri.pKanan)) {
                        node = rotateRight(node);
                    } else {
                        node.pKiri = rotateLeft(node.pKiri);
                        node = rotateRight(node);
                    }
                } else {
                    if (tinggi(node.pKanan.pKanan) >= tinggi(node.pKanan.pKiri)) {
                        node = rotateLeft(node);
                    } else {
                        node.pKanan = rotateRight(node.pKanan);
                        node = rotateLeft(node);
                    }
                }
            }
            node = node.pInduk;
        }
    }

    private Node rotateRight(Node y) {
        Node x = y.pKiri;
        Node T = x.pKanan;
        x.pKanan = y;
        y.pKiri = T;
        y.tinggi = Math.max(tinggi(y.pKiri), tinggi(y.pKanan)) + 1;
        x.tinggi = Math.max(tinggi(x.pKiri), tinggi(x.pKanan)) + 1;
        if (T != null)
            T.pInduk = y;
        x.pInduk = y.pInduk;
        y.pInduk = x;
        if (y == root)
            root = x;
        return x;
    }

    private Node rotateLeft(Node x) {
        Node y = x.pKanan;
        Node T = y.pKiri;
        y.pKiri = x;
        x.pKanan = T;
        x.tinggi = Math.max(tinggi(x.pKiri), tinggi(x.pKanan)) + 1;
        y.tinggi = Math.max(tinggi(y.pKiri), tinggi(y.pKanan)) + 1;
        if (T != null)
            T.pInduk = x;
        y.pInduk = x.pInduk;
        x.pInduk = y;
        if (x == root)
            root = y;
        return y;
    }
}
