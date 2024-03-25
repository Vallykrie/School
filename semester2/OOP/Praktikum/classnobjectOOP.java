package OOP.Praktikum;

import java.util.Scanner;

// revisi kak hehehe tadi gaisi class dan object, mohon mff T_T
class Hewan {
    String nama;
    String jenis;
    String namaIlmiah;
    int umur;
    String asal;
    int iterasi;

    Hewan(String nama, String jenis, String namaIlmiah, int umur, String asal, int iterasi) {
        this.nama = nama;
        this.jenis = jenis;
        this.namaIlmiah = namaIlmiah;
        this.umur = umur;
        this.asal = asal;
        this.iterasi = iterasi;
    }

    void cetak() {
        System.out.println("============================================================");
        System.out.println(iterasi + 1 + ". " + "\"" + nama + "\"");
        System.out.println("hewan ini berjenis " + "\"" + jenis + "\"");
        System.out.println("dan bernama ilmiah " + "\"" + namaIlmiah + "\"");
        System.out.println("\"" + nama + "\"" + " sudah berusia " + umur + " tahun");
        System.out.println("dan berasal dari negara " + "\"" + asal + "\"");
        System.out.println("============================================================");
    }

}

public class classnobjectOOP {

    public static void main(String[] args) throws Exception {
        Scanner than = new Scanner(System.in);
        int loop = than.nextInt();
        than.nextLine();
        System.out.println("Halo, Selamat datang di Batu Secret Zoo, berikut adalah list hewan kami!");
        for (int i = 0; i < loop; i++) {
            String nama = than.nextLine();
            String jenis = than.nextLine();
            String namaIlmiah = than.nextLine();
            int umur = than.nextInt();
            than.nextLine();
            String asal = than.nextLine();
            Hewan hewan1 = new Hewan(nama, jenis, namaIlmiah, umur, asal, i);
            hewan1.cetak();

        }
        System.out.println("Terimakasih!");
    }
}