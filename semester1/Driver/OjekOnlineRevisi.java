package Driver;
/*
 * NAMA KELOMPOK :
 * 1.
 * 2.
 * 3.
 */

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;

public class OjekOnlineRevisi {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        
        // Declare
        boolean isRunning = true;
        double mobil = 0;
        double motor = 0;
        double disc = 0;
        double harga = 0;

        // Format
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("Rp #,###.00", symbols);
        String devider = "-".repeat(43);

        while (isRunning) {

            // Menu
            System.out.println("--------------- Ojek Online ---------------");
            System.out.println("1. Naik Ojek");
            System.out.println("2. Kirim Barang");
            System.out.println("0. Keluar");
            System.out.print("-> ");
            String pilihan = than.nextLine();

            // Pilihan Menu
            switch (pilihan) {

                // Naik Ojek
                case "1":
                    // Input
                    System.out.println(devider);
                    System.out.println("Pilih jenis kendaraan dengan mengetik:\nMobil atau motor");
                    System.out.print("-> ");
                    String kendaraan = than.nextLine();
                    System.out.println(devider);
                    System.out.println("Masukkan jarak yang ingin ditempuh: ");
                    System.out.print("-> ");
                    double jarak = than.nextDouble();
                    than.nextLine();
                    System.out.println(devider);
                    System.out.println("Masukkan metode pembayaran dengan mengetik:\ngopay atau ovo atau cash");
                    System.out.print("-> ");
                    String metode = than.nextLine();
                    System.out.println(devider);

                    // Harga
                    if (jarak <= 2) {
                        mobil = 25000;
                        motor = 15000;
                    } else if (jarak <= 5) {
                        mobil = 40000;
                        motor = 20000;
                    } else if (jarak <= 10) {
                        mobil = 65000;
                        motor = 30000;
                    } else {
                        mobil = jarak * 15000;
                        motor = jarak * 8000;
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
                    System.out.println("Harga yang perlu dibayar\n---> " + df.format(harga)
                            + "\nMohon segera dibayar ya, plis...");

                    break;

                // Kirim Barang
                case "2":
                    // Input
                    System.out.println(devider);
                    System.out.print("Masukkan berat barang (kg) : ");
                    int weight = than.nextInt();
                    than.nextLine();
                    System.out.println(devider);
                    System.out.println("Masukkan metode pembayaran dengan mengetik:\ngopay atau ovo atau cash");
                    System.out.print("-> ");
                    metode = than.nextLine();

                    // Metode Pembayaran
                    if (metode.equalsIgnoreCase("gopay"))
                        disc = 0.9;
                    if (metode.equalsIgnoreCase("ovo"))
                        disc = 0.95;
                    if (metode.equalsIgnoreCase("cash"))
                        disc = 1;

                    // Output
                    System.out.println(devider);
                    System.out.println("Harga yang perlu dibayar\n---> " + df.format(weight * 10000 * disc)
                            + "\nMohon segera dibayar ya, plis...");
                    break;

                // Keluar
                case "0":
                    System.out.println("Terimakasih :D");
                    isRunning = false;
                    break;
                
                // Invalid
                default:
                    System.out.println(devider);
                    System.out.println("!! Pilihan tidak valid.\n!! Silahkan pilih menu yang tersedia.");
                    break;
            }
        }
        than.close();
    }
}
