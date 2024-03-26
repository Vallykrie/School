import java.util.Scanner;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        boolean isRunning = true;
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

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        }
    }

    static void tambahAnggota() {

    }
}

class AnggotaPerpustakaan {
    private String nama, alamat, nomorAnggota;

}
