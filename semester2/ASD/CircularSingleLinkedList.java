class NodeCSLL {
    Object data;
    NodeCSLL setelah;
}

public class CircularSingleLinkedList {
    private NodeCSLL pAwal;

    public CircularSingleLinkedList() {
        pAwal = null;
    }

    public void SisipDataDiAwal(Object data) {
        NodeCSLL pBaru = new NodeCSLL();
        pBaru.data = data;
        pBaru.setelah = pBaru;

        if (pAwal == null) {
            pAwal = pBaru;
        } else {
            pBaru.setelah = pAwal;
            NodeCSLL pBantu = pAwal;
            while (pBantu.setelah != pAwal) {
                pBantu = pBantu.setelah;
            }
            pBantu.setelah = pBaru;
            pAwal = pBaru;
        }
    }

    public void SisipDataDiAkhir(Object data) {
        NodeCSLL pBaru = new NodeCSLL();
        pBaru.data = data;
        pBaru.setelah = pBaru;

        if (pAwal == null) {
            pAwal = pBaru;
        } else {
            NodeCSLL pBantu = pAwal;
            while (pBantu.setelah != pAwal) {
                pBantu = pBantu.setelah;
            }
            pBantu.setelah = pBaru;
            pBaru.setelah = pAwal;
        }
    }

    public void hapusData(Object dtHapus) {
        if (pAwal != null) {
            NodeCSLL pSbl = null;
            NodeCSLL pKini = pAwal;
            boolean ketemu = false;

            do {
                if (pKini.data.equals(dtHapus)) {
                    ketemu = true;
                } else {
                    pSbl = pKini;
                    pKini = pKini.setelah;
                }
            } while (!ketemu && pKini != pAwal);

            if (ketemu) {
                if (pSbl == null) {
                    NodeCSLL pHapus = pAwal;
                    pAwal = pKini.setelah;
                    NodeCSLL pBantu = pAwal;
                    while (pBantu.setelah != pHapus) {
                        pBantu = pBantu.setelah;
                    }
                    pBantu.setelah = pAwal;
                    pHapus = null;
                } else {
                    pSbl.setelah = pKini.setelah;
                    NodeCSLL pHapus = pKini;
                    pHapus = null;
                }
            }
        }
    }

    public void hapusSatuDataDiAwal() {
        if (pAwal != null) {
            NodeCSLL pHapus = pAwal;
            pAwal = pAwal.setelah;
            NodeCSLL pBantu = pAwal;
            while (pBantu.setelah != pHapus) {
                pBantu = pBantu.setelah;
            }
            pBantu.setelah = pAwal;
            pHapus = null;
        }
    }

    public void hapusSatuDataDiAkhir() {
        if (pAwal != null) {
            NodeCSLL pSbl = null;
            NodeCSLL pKini = pAwal;

            while (pKini.setelah != pAwal) {
                pSbl = pKini;
                pKini = pKini.setelah;
            }

            if (pSbl == null) {
                pAwal = null;
            } else {
                pSbl.setelah = pAwal;
            }

            pKini = null;
        }
    }

    public void cetak(String Komentar) {
        System.out.println(Komentar);
        NodeCSLL pCetak = pAwal;

        if (pCetak != null) {
            do {
                System.out.print(pCetak.data + "->");
                pCetak = pCetak.setelah;
            } while (pCetak != pAwal);
        }

        System.out.println();
    }

    public static void main(String[] args) {
        CircularSingleLinkedList csll = new CircularSingleLinkedList();
        csll.SisipDataDiAwal(new Integer(50));
        csll.SisipDataDiAwal(new Integer(60));
        csll.SisipDataDiAwal(new Integer(70));
        csll.SisipDataDiAwal(new Integer(8));
        csll.SisipDataDiAwal(new Integer(9));
        csll.SisipDataDiAwal(new Integer(90));
        csll.SisipDataDiAwal(new Integer(19));
        csll.cetak("csll Asal");
        csll.hapusData(8);
        csll.cetak("csll stl 8 dihapus");
        csll.hapusData(90);
        csll.cetak("csll stl 90 dihapus");
    }
}