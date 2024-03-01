import java.util.*;

public class test1 {
    static class Pemain {
        int id, serang, bertahan, peringkatSerang, peringkatBertahan, peringkatTotal;

        Pemain(int id, int ser, int ber) {
            this.id = id;
            this.serang = ser;
            this.bertahan = ber;
        }
    }

    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        int jumlahPemain;
        jumlahPemain = than.nextInt();
        Pemain[] pemain = new Pemain[jumlahPemain];
        for (int i = 0; i < jumlahPemain; i++) {
            pemain[i] = new Pemain(i + 1, than.nextInt(), 0);
        }
        for (int i = 0; i < jumlahPemain; i++) {
            pemain[i].bertahan = than.nextInt();
        }
        int jumlahPerintah;
        jumlahPerintah = than.nextInt();
        than.nextLine();
        while (jumlahPerintah-- > 0) {
            String[] perintah = than.nextLine().split(" ");
            switch (perintah[0]) {
                case "tampilkan":
                    switch (perintah[1]) {
                        case "kemampuan":
                            System.out.print("Kemampuan serang: ");
                            for (int i = 0; i < jumlahPemain; i++) {
                                System.out.print(pemain[i].serang + " ");
                            }
                            System.out.println();
                            System.out.print("Kemampuan bertahan: ");
                            for (int i = 0; i < jumlahPemain; i++) {
                                System.out.print(pemain[i].bertahan + " ");
                            }
                            System.out.println();
                            break;
                        default:
                            Arrays.sort(pemain, Comparator.comparingInt((Pemain p) -> p.serang).reversed());
                            for (int i = 0, peringkat = 1; i < jumlahPemain; i++) {
                                if (i > 0 && pemain[i].serang < pemain[i - 1].serang) peringkat = i + 1;
                                pemain[i].peringkatSerang = peringkat;
                            }
                            Arrays.sort(pemain, Comparator.comparingInt((Pemain p) -> p.bertahan).reversed());
                            for (int i = 0, peringkat = 1; i < jumlahPemain; i++) {
                                if (i > 0 && pemain[i].bertahan < pemain[i - 1].bertahan) peringkat = i + 1;
                                pemain[i].peringkatBertahan = peringkat;
                            }
                            Arrays.sort(pemain, Comparator.comparingInt((Pemain p) -> p.peringkatSerang + p.peringkatBertahan));
                            for (int i = 0, peringkat = 1; i < jumlahPemain; i++) {
                                if (i > 0 && pemain[i].peringkatSerang + pemain[i].peringkatBertahan > pemain[i - 1].peringkatSerang + pemain[i - 1].peringkatBertahan)
                                    peringkat = i + 1;
                                pemain[i].peringkatTotal = peringkat;
                            }
                            Arrays.sort(pemain, Comparator.comparingInt((Pemain p) -> p.id));
                            System.out.print("Peringkat serang: ");
                            for (int i = 0; i < jumlahPemain; i++) {
                                System.out.print(pemain[i].peringkatSerang + " ");
                            }
                            System.out.println();
                            System.out.print("Peringkat bertahan: ");
                            for (int i = 0; i < jumlahPemain; i++) {
                                System.out.print(pemain[i].peringkatBertahan + " ");
                            }
                            System.out.println();
                            System.out.print("Peringkat total: ");
                            for (int i = 0; i < jumlahPemain; i++) {
                                System.out.print(pemain[i].peringkatTotal + " ");
                            }
                            System.out.println();
                            break;
                    }
                    break;
                default:
                    int i = Integer.parseInt(perintah[2]) - 1;
                    int x = Integer.parseInt(perintah[3]);
                    switch (perintah[1]) {
                        case "serang":
                            pemain[i].serang += x;
                            pemain[i].bertahan -= x / 2;
                            break;
                        default:
                            pemain[i].bertahan += x;
                            pemain[i].serang -= x / 2;
                            break;
                    }
                    System.out.println("Melatih kemampuan " + perintah[1] + " pemain ke-" + (i + 1) + " sebanyak " + x + " poin");
                    break;
            }
        }
    }
}
