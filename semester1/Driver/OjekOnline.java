package Driver;
/*
 * NAMA KELOMPOK :
 * 1.
 * 2.
 * 3.
 */

import java.util.Scanner;

public class OjekOnline {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);

        // INPUT
        System.out.printf("%-30s\n", "===============Ojek Online===============");
        System.out.println("Pilih jenis kendaraan dengan mengetik:\nMobil || Motor");
        System.out.printf("%-30s\n", "=========================================");
        String kendaraan = than.nextLine();
        System.out.printf("%-30s\n", "=========================================");
        System.out.println("Masukkan jarak yang ingin ditempuh: ");
        double j = than.nextDouble();
        than.nextLine();
        System.out.printf("%-30s\n", "=========================================");
        System.out.println("Masukkan metode pembayaran dengan mengetik:\ngopay || ovo || cash");
        System.out.printf("%-30s\n", "=========================================");
        String metode = than.nextLine();
        System.out.printf("%-30s\n", "=========================================");
        double mobil = 0;
        double motor = 0;
        double disc = 0;
        double harga = 0;

        // Harga
        if (j <= 2) {
            mobil = 25000;
            motor = 15000;
        } else if (j <= 5) {
            mobil = 40000;
            motor = 20000;
        } else if (j <= 10) {
            mobil = 65000;
            motor = 30000;
        } else {
            mobil = j * 15000;
            motor = j * 8000;
        }

        // Metode Pembayaran
        if (metode.equalsIgnoreCase("gopay"))
            disc = 0.9;
        if (metode.equalsIgnoreCase("ovo"))
            disc = 0.95;
        if (metode.equalsIgnoreCase("cash"))
            disc = 1;

        // Output
        if (kendaraan.equalsIgnoreCase("mobil"))
            harga = disc * mobil;
        if (kendaraan.equalsIgnoreCase("motor"))
            harga = disc * motor;
        System.out.printf("%s Rp.%.2f,- %s", "Harga yang perlu dibayar\n--->", harga,
                "\nMohon segera dibayar ya, plis....");
        than.close();
    }
}
