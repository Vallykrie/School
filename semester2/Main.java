import java.util.Scanner;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) throws NoSuchElementException {
        Scanner than = new Scanner(System.in);
        boolean isRunning = true;
        LinkedList<AnggotaPerpustakaan> anggota = new LinkedList<AnggotaPerpustakaan>();

        while (isRunning) {
            System.out.println("Menu:");
            System.out.println("1. Tambah Anggota Biasa");
            System.out.println("2. Tambah Anggota Premium");
            System.out.println("3. Tampilkan Semua Anggota");
            System.out.println("4. Keluar");
            System.out.print("Pilih Menu: ");
            int pilihMenu = than.nextInt();
            than.nextLine();

            switch (pilihMenu) {
                case 1:
                    anggota.addLast(tambahAnggota(jenisAnggota.BIASA));

                    break;
                case 2:
                    anggota.addLast(tambahAnggota(jenisAnggota.PREMIUM));

                    break;
                case 3:
                    System.out.println("Daftar Semua Anggota: ");
                    for (AnggotaPerpustakaan i : anggota) {
                        i.show();
                    }

                    break;
                case 4:
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        }
        than.close();
    }

    static AnggotaPerpustakaan tambahAnggota(jenisAnggota jenis) throws NoSuchElementException {
        Scanner nath = new Scanner(System.in);

        System.out.print("Masukkan nama anggota: ");
        String nama = nath.nextLine();
        System.out.print("Masukkan alamat anggota: ");
        String alamat = nath.nextLine();
        System.out.print("Masukkan nomor anggota: ");
        String nomorAnggota = nath.nextLine();
        System.out.print("Masukkan batas peminjaman: ");
        int batasPinjam = nath.nextInt();
        nath.nextLine();
        System.out.print("Masukkan batas waktu: ");
        int batasWaktu = nath.nextInt();
        nath.nextLine();

        AnggotaPerpustakaan anggota = new AnggotaPerpustakaan(nama, alamat, nomorAnggota, jenis, batasPinjam,
                batasWaktu);
        nath.close();
        return anggota;
    }
}

enum jenisAnggota {
    BIASA, PREMIUM
}

class AnggotaPerpustakaan {
    private String nama, alamat, nomorAnggota;
    private int batasPinjam, batasWaktu;
    private jenisAnggota jenis;

    AnggotaPerpustakaan(String nama, String alamat, String nomorAnggota, jenisAnggota jenis, int batasPinjam,
            int batasWaktu) {
        this.nama = nama;
        this.alamat = alamat;
        this.nomorAnggota = nomorAnggota;
        this.jenis = jenis;
        this.batasPinjam = batasPinjam;
        this.batasWaktu = batasWaktu;
    }

    public void show() {
        System.out.println("Nama: " + nama);
        System.out.println("Alamat: " + alamat);
        System.out.println("Nomor Anggota: " + nomorAnggota);
        System.out.println("Batas Peminjaman: " + batasPinjam);
        System.out.println("Batas Waktu: " + batasWaktu);
    }
}
