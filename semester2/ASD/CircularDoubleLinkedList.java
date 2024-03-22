class NodeCDLL {
    Object data;
    NodeCDLL sebelum;
    NodeCDLL setelah;
}

public class CircularDoubleLinkedList {
    private NodeCDLL pAwal;

    public CircularDoubleLinkedList() {
        pAwal = null;
    }

    public void SisipDataDiAwal(Object data) {
        NodeCDLL pBaru = new NodeCDLL();
        pBaru.data = data;
        pBaru.sebelum = pBaru;
        pBaru.setelah = pBaru;
        if (pAwal == null) {
            pAwal = pBaru;
        } else {
            pBaru.sebelum = pAwal.sebelum;
            pBaru.setelah = pAwal;
            pAwal.sebelum.setelah = pBaru;
            pAwal.sebelum = pBaru;
            pAwal = pBaru;
        }
    }

    public void SisipDataDiAkhir(Object data) {
        NodeCDLL pBaru = new NodeCDLL();
        pBaru.data = data;
        pBaru.sebelum = pBaru;
        pBaru.setelah = pBaru;
        if (pAwal == null) {
            pAwal = pBaru;
        } else {
            pBaru.sebelum = pAwal.sebelum;
            pBaru.setelah = pAwal;
            pAwal.sebelum.setelah = pBaru;
            pAwal.sebelum = pBaru;
        }
    }

    public void hapusData(Object dtHapus) {
        if (pAwal == null) {
            return;
        }

        NodeCDLL pCari = pAwal;
        NodeCDLL pSebelum = null;

        do {
            if (pCari.data.equals(dtHapus)) {
                if (pCari == pAwal) {
                    pAwal = pCari.setelah;
                    pAwal.sebelum = pCari.sebelum;
                    pAwal.sebelum.setelah = pAwal;
                } else {
                    pSebelum.setelah = pCari.setelah;
                    pCari.setelah.sebelum = pSebelum;
                }
                return;
            }

            pSebelum = pCari;
            pCari = pCari.setelah;
        } while (pCari != pAwal);
    }

    public void cetak(String Komentar) {
        System.out.println(Komentar);
        NodeCDLL pCetak = pAwal;

        if (pCetak != null) {
            do {
                System.out.print(pCetak.data + "->");
                pCetak = pCetak.setelah;
            } while (pCetak != pAwal);
        }

        System.out.println();
    }

    public static void main(String[] args) {
        CircularDoubleLinkedList cdll = new CircularDoubleLinkedList();
        cdll.SisipDataDiAwal(new Integer(50));
        cdll.SisipDataDiAwal(new Integer(60));
        cdll.SisipDataDiAwal(new Integer(70));
        cdll.SisipDataDiAwal(new Integer(8));
        cdll.SisipDataDiAwal(new Integer(9));
        cdll.SisipDataDiAwal(new Integer(90));
        cdll.SisipDataDiAwal(new Integer(19));
        cdll.cetak("cdll Asal");
        cdll.hapusData(8);
        cdll.cetak("csll stl 8 dihapus");
        cdll.hapusData(90);
        cdll.cetak("csll stl 90 dihapus");
    }
}