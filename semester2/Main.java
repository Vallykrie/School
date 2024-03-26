import java.util.Scanner;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) throws NoSuchElementException {
        Scanner than = new Scanner(System.in);
        boolean isRunning = true;
        String nama, alamat, nomorAnggota;
        int batasPinjam, batasWaktu;
        LinkedList<AnggotaPerpustakaan> anggota = new LinkedList<AnggotaPerpustakaan>();

        while (isRunning) {
            System.out.println("Menu:");
            System.out.println("1. Tambah Anggota Biasa");
            System.out.println("2. Tambah Anggota Premium");
            System.out.println("3. Tampilkan Semua Anggota");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            int pilihMenu = than.nextInt();
            than.nextLine();
            System.out.println(pilihMenu);

            switch (pilihMenu) {
                case 1:
                    // anggota.addLast(tambahAnggota(jenisAnggota.BIASA));
                    System.out.print("Masukkan nama anggota: ");
                    nama = than.nextLine();
                    System.out.println(nama);
                    System.out.print("Masukkan alamat anggota: ");
                    alamat = than.nextLine();
                    System.out.println(alamat);
                    System.out.print("Masukkan nomor anggota: ");
                    nomorAnggota = than.nextLine();
                    System.out.println(nomorAnggota);
                    System.out.print("Masukkan batas peminjaman: ");
                    batasPinjam = than.nextInt();
                    than.nextLine();
                    System.out.println(batasPinjam);
                    System.out.print("Masukkan batas waktu: ");
                    batasWaktu = than.nextInt();
                    than.nextLine();
                    System.out.println(batasWaktu);

                    AnggotaPerpustakaan anggotaBiasa = new AnggotaPerpustakaan(nama, alamat, nomorAnggota,
                            jenisAnggota.BIASA,
                            batasPinjam,
                            batasWaktu);

                    anggota.addLast(anggotaBiasa);
                    System.out.println("Anggota Biasa berhasil ditambahkan.");
                    System.out.println();
                    break;
                case 2:
                    // anggota.addLast(tambahAnggota(jenisAnggota.PREMIUM));
                    System.out.print("Masukkan nama anggota: ");
                    nama = than.nextLine();
                    System.out.println(nama);
                    System.out.print("Masukkan alamat anggota: ");
                    alamat = than.nextLine();
                    System.out.println(alamat);
                    System.out.print("Masukkan nomor anggota: ");
                    nomorAnggota = than.nextLine();
                    System.out.println(nomorAnggota);
                    System.out.print("Masukkan batas peminjaman: ");
                    batasPinjam = than.nextInt();
                    than.nextLine();
                    System.out.println(batasPinjam);
                    System.out.print("Masukkan batas waktu: ");
                    batasWaktu = than.nextInt();
                    than.nextLine();
                    System.out.println(batasWaktu);

                    AnggotaPerpustakaan anggotaPremium = new AnggotaPerpustakaan(nama, alamat, nomorAnggota,
                            jenisAnggota.PREMIUM,
                            batasPinjam,
                            batasWaktu);

                    anggota.addLast(anggotaPremium);
                    System.out.println("Anggota Premium berhasil ditambahkan.");
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Daftar Semua Anggota: ");
                    for (AnggotaPerpustakaan i : anggota) {
                        i.show();
                    }
                    System.out.println();
                    System.out.println();

                    break;
                case 4:
                    System.out.println("Terima kasih!");
                    isRunning = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        }
        than.close();
    }

    static AnggotaPerpustakaan tambahAnggota(jenisAnggota jenis) throws NoSuchElementException {
        Scanner than = new Scanner(System.in);

        System.out.print("Masukkan nama anggota: ");
        String nama = than.nextLine();
        System.out.print("Masukkan alamat anggota: ");
        String alamat = than.nextLine();
        System.out.print("Masukkan nomor anggota: ");
        String nomorAnggota = than.nextLine();
        System.out.print("Masukkan batas peminjaman: ");
        int batasPinjam = than.nextInt();
        than.nextLine();
        System.out.print("Masukkan batas waktu: ");
        int batasWaktu = than.nextInt();
        than.nextLine();

        AnggotaPerpustakaan anggota = new AnggotaPerpustakaan(nama, alamat, nomorAnggota, jenis, batasPinjam,
                batasWaktu);
        than.close();
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
