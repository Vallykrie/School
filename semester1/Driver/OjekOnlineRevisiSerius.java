package Driver;

/*
 * NAMA KELOMPOK :
 * 1. JOSE PUTRA PERDANA TANEO (235150200111047)
 * 2. KOMANG DAVID DANANJAYA SUARTANA (235150200111044)
 * 3. PANDE KADEK NATHAN PRABHASWARA SUDIARA PUTRA (235150207111051)
 */

import java.text.DecimalFormatSymbols;
import java.text.DecimalFormat;
import java.util.Scanner;

public class OjekOnlineRevisiSerius {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);

        // Declare
        boolean isRunning = true;
        String nama = "";
        double mobil = 0;
        double motor = 0;
        double disc = 0;
        double harga = 0;
        int banyakDriver = 0;
        String[] namaDriver = new String[2_147_483];

        // Random Driver or Carier Arrays
        String[] firstName = { "Made", "Putra", "Abdul", "Doni" };
        String[] middleName = { "Yanto", "Kurniawan", "Dimas", "Arif", "Fajar", "Bayu", "Ricky" };
        String[] lastName = { "Filkom", "Bogor", "Seblak", "Kebab", "Indomie", "Lontong", "Batagor" };
        String[] platNomor = { "DK", "N", "AG", "AA", "B", "AE", "RRQ" };
        String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // Price Formats
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("Rp #,###.00", symbols);
        String divider = "-".repeat(43);

        // Menu Looping
        while (isRunning) {

            // Menu
            System.out.println("--------------- Ojek Online ---------------");
            System.out.println("1. Naik Ojek");
            System.out.println("2. Kirim Barang");
            System.out.println("3. Tambah Nama Driver");
            System.out.println("0. Keluar");
            System.out.print("-> ");
            String pilihan = than.nextLine();

            // Generate Random Driver or Carier Name
            int jumlahNama = (int) ((Math.random() * 3) + 1);
            String namaGOJEK = "";
            if (jumlahNama == 1) {
                namaGOJEK += firstName[(int) (Math.random() * firstName.length)];
            } else if (jumlahNama == 2) {
                namaGOJEK += firstName[(int) (Math.random() * firstName.length)] + " "
                        + lastName[(int) (Math.random() * lastName.length)];
            } else if (jumlahNama == 3) {
                namaGOJEK += firstName[(int) (Math.random() * firstName.length)] + " "
                        + middleName[(int) (Math.random() * middleName.length)] + " "
                        + lastName[(int) (Math.random() * lastName.length)];
            }

            // Pilihan Menu
            switch (pilihan) {

                // Naik Ojek
                case "1":
                    // Input
                    System.out.println(divider);
                    System.out.println("Pilih jenis kendaraan dengan mengetik:\nMobil atau motor");
                    System.out.print("-> ");
                    String kendaraan = than.nextLine();
                    System.out.println(divider);
                    System.out.println("Masukkan jarak yang ingin ditempuh: ");
                    System.out.print("-> ");
                    double jarak = than.nextDouble();
                    than.nextLine();
                    System.out.println(divider);
                    System.out.println("Masukkan metode pembayaran dengan mengetik:\ngopay atau ovo atau cash");
                    System.out.print("-> ");
                    String metode = than.nextLine();

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
                    if (metode.equalsIgnoreCase("gopay")) {
                        disc = 0.9;
                    } else if (metode.equalsIgnoreCase("ovo")) {
                        disc = 0.95;
                    } else if (metode.equalsIgnoreCase("cash")) {
                        disc = 1;
                    } else
                        disc = 1;

                    // Output
                    if (kendaraan.equalsIgnoreCase("mobil"))
                        harga = disc * mobil;
                    if (kendaraan.equalsIgnoreCase("motor"))
                        harga = disc * motor;
                    System.out.println(divider);
                    System.out.println("Driver anda :");
                    System.out.println(namaGOJEK);
                    System.out.println(platNomor[(int) (Math.random() * platNomor.length)] + " "
                            + (int) (Math.random() * 10) + (int) (Math.random() * 10) + (int) (Math.random() * 10)
                            + (int) (Math.random() * 10) + " "
                            + Alphabet.charAt((int) (Math.random() * Alphabet.length()))
                            + Alphabet.charAt((int) (Math.random() * Alphabet.length()))
                            + Alphabet.charAt((int) (Math.random() * Alphabet.length())));
                    System.out.println();
                    System.out.println("Detail Pembayaran :");
                    System.out.println(df.format(harga));

                    break;

                // Kirim Barang
                case "2":
                    // Input
                    System.out.println(divider);
                    System.out.print("Masukkan berat barang (kg) : ");
                    int weight = than.nextInt();
                    than.nextLine();
                    System.out.println(divider);
                    System.out.println("Masukkan metode pembayaran dengan mengetik:\ngopay atau ovo atau cash");
                    System.out.print("-> ");
                    metode = than.nextLine();

                    // Metode Pembayaran
                    disc = metodePembayaran(metode);

                    // Output
                    System.out.println(divider);
                    System.out.println("Kurir anda :");
                    System.out.println(namaGOJEK);

                    System.out.println(platNomor[(int) (Math.random() * platNomor.length)] + " "
                            + (int) (Math.random() * 10) + (int) (Math.random() * 10) + (int) (Math.random() * 10)
                            + (int) (Math.random() * 10) + " "
                            + Alphabet.charAt((int) (Math.random() * Alphabet.length()))
                            + Alphabet.charAt((int) (Math.random() * Alphabet.length()))
                            + Alphabet.charAt((int) (Math.random() * Alphabet.length())));

                    System.out.println();
                    System.out.println("Detail Pembayaran :");
                    System.out.println(df.format(weight * 10000 * disc));

                    break;
                // Tamba Nama Driver
                case "3":
                    // Input
                    System.out.println(divider);
                    System.out.println("Masukkan nama driver \n(ketik stop untuk berhenti) : ");
                    while (!nama.equalsIgnoreCase("stop")) {
                        nama = than.nextLine();
                        namaDriver[banyakDriver] = nama;
                        banyakDriver++;
                    }
                    nama = "";
                    banyakDriver--;

                    // Output
                    System.out.println(divider);
                    System.out.println("List Driver :");
                    for (int i = 0; i < banyakDriver; i++) {
                        System.out.print((i + 1) + ". ");
                        System.out.println(namaDriver[i]);
                    }
                    break;

                // Keluar
                case "0":
                    System.out.println("-".repeat(13) + " Terimakasih :D " + "-".repeat(14));
                    isRunning = false;
                    break;

                // Invalid
                default:
                    System.out.println(divider);
                    System.out.println("!! Pilihan tidak valid.\n!! Silahkan pilih menu yang tersedia.");
                    break;
            }
        }
        than.close();
    }

    public static double metodePembayaran(String pembayaran) {
        if (pembayaran.equalsIgnoreCase("gopay")) {
            return 0.9;
        } else if (pembayaran.equalsIgnoreCase("ovo")) {
            return 0.95;
        } else if (pembayaran.equalsIgnoreCase("cash")) {
            return 1;
        } else
            return 1;
    }

}
