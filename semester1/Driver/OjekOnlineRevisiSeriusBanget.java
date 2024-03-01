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

public class OjekOnlineRevisiSeriusBanget {

    // Global Declare
    private static String pilihan = "";
    private static String metode = "";
    private static double hargaTotal = 0;
    private static double disc = 1;
    private static double harga = 0;
    private static boolean easterEgg = false;

    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);

        // Price Formats
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("Rp #,###.00", symbols);

        // Declare
        boolean isRunning = true;
        double mobil = 0;
        double motor = 0;

        // Biar apa? Biarin :D
        GoJek(than);

        // Menu Looping
        while (isRunning) {

            // Reset Value
            disc = 1;

            // Menu
            System.out.println("=============== Ojek Online ===============");
            System.out.printf("%-41s\n", "1. Order Ojek");
            System.out.printf("%-41s\n", "2. Kirim Barang");
            System.out.printf("%-41s\n", "3. Pesan Makan");
            System.out.printf("%-41s\n", "4. Naik Pesawat");
            System.out.printf("%-41s\n", "0. Keluar");
            System.out.printf("-> ");
            pilihan = than.nextLine();

            // Pilihan Menu
            switch (pilihan) {

                // Naik Ojek
                case "1":

                    // Input
                    divider1();
                    System.out.println("Pilih jenis kendaraan :\n(dengan mengetik Mobil atau motor)");
                    System.out.print("-> ");
                    String kendaraan = than.nextLine();
                    newLine();
                    System.out.println("Masukkan jarak yang ingin ditempuh: ");
                    System.out.print("-> ");
                    double jarak = than.nextDouble();
                    than.nextLine();
                    newLine();
                    System.out.println("Masukkan metode pembayaran : \n(dengan mengetik gopay atau ovo atau cash)");
                    System.out.print("-> ");
                    metode = than.nextLine();

                    // Calculate
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
                    disc = discount(metode);
                    if (kendaraan.equalsIgnoreCase("mobil")) {
                        harga = mobil;
                        hargaTotal = harga * disc;
                    } else if (kendaraan.equalsIgnoreCase("motor")) {
                        harga = motor;
                        hargaTotal = harga * disc;
                    }

                    // Output
                    divider1();
                    printOutput(harga, hargaTotal, df);
                    break;

                // Kirim Barang
                case "2":

                    // Input
                    divider1();
                    System.out.print("Masukkan berat barang (kg) : ");
                    int weight = than.nextInt();
                    than.nextLine();
                    newLine();
                    System.out.println("Masukkan metode pembayaran :\n(dengan mengetik gopay atau ovo atau cash)");
                    System.out.print("-> ");
                    metode = than.nextLine();
                    disc = discount(metode);

                    // Calculate
                    harga = weight * 10000;
                    hargaTotal = harga * disc;

                    // Output
                    divider1();
                    printOutput(harga, hargaTotal, df);
                    break;

                // Pesan Makan
                case "3":

                    // Declaration and Initialisation
                    int i = 0;
                    boolean menuMakan = true;
                    String[] daftarFoodShop = GenerateFoodShop();

                    // Menu
                    while (menuMakan) {
                        divider1();
                        System.out.println(" ".repeat(10) + "Mau makan apa hari ini?" + " ".repeat(10));
                        newLine();
                        for (int j = 1; j <= 5; j++) {
                            System.out.printf("%-43s\n", ((i) * 5) + j + ". " + daftarFoodShop[((i) * 5) + j]);
                        }
                        newLine();
                        System.out.println(" ".repeat(17) + "< " + (i + 1) + " / 9 >" + " ".repeat(17));

                        // Input
                        System.out.print("-> ");
                        String pilihan2 = than.nextLine();
                        if (pilihan2.equals(">")) {
                            if (i == 8) {
                                continue;
                            } else
                                i++;
                        } else if (pilihan2.equals("<")) {
                            if (i == 0) {
                                continue;
                            } else
                                i--;
                        } else if (pilihan2.charAt(0) > 48 && pilihan2.charAt(0) < 58) {

                            // Pengambilan jenis rumah makan
                            int simpenDeh = Integer.parseInt(pilihan2);
                            int dimanaSpasi = daftarFoodShop[simpenDeh].indexOf(" ");
                            String kataPertama = daftarFoodShop[simpenDeh].substring(0, dimanaSpasi);

                            // Easter Egg :P
                            if (daftarFoodShop[simpenDeh].contains("Murah"))
                                easterEgg = true;
                            menuMakan = false;

                            // Menu sesuai jenis tempat makan
                            switch (kataPertama) {
                                case "Restoran":
                                    menuRestoran(df, than);
                                    break;
                                case "Warung":
                                    menuWarung(df, than);
                                    break;
                                case "Kafe":
                                    menuKafe(df, than);
                                    break;
                                case "Depot":
                                    menuDepot(df, than);
                                    break;
                                case "Kedai":
                                    menuKedai(df, than);
                                    break;
                                case "Rumah":
                                    menuRumahMakan(df, than);
                                    break;

                                default:
                                    break;
                            }

                        }

                    }

                    // Reset
                    easterEgg = false;
                    break;

                // Naik Pesawat
                case "4":

                    // Input
                    divider1();
                    System.out.println("Nama penumpang pesawat:");
                    String namaPenumpang = than.nextLine();
                    newLine();
                    System.out.println("Daerah asal penumpang:");
                    String asalPenumpang = than.nextLine().toLowerCase();
                    newLine();
                    System.out.println("Daerah tujuan penumpang:");
                    String tujuanPenumpang = than.nextLine().toLowerCase();
                    newLine();

                    // Kelas Penerbangan
                    System.out.println("Pilih kelas penerbangan\n1. First Class\n2. Business Class\n3. Economy Class");
                    int kelasPenumpang = than.nextInt();
                    than.nextLine();
                    newLine();
                    double payMore = 0; // HAHAHAHAHA
                    String classFlight = "";
                    switch (kelasPenumpang) {
                        case 1:
                            classFlight = "First Class";
                            payMore = 1.25;
                            break;
                        case 2:
                            classFlight = "Business Class";
                            payMore = 1.15;
                            break;
                        case 3:
                            classFlight = "Economy Class";
                            payMore = 1.00;
                            break;

                        default:
                            payMore = 1;
                            break;
                    }

                    // Looping pembuatan tanggal yang benar
                    boolean salah = true;
                    while (salah) {
                        System.out.println("Tanggal penerbangan (DD/MM/YY): ");
                        String tanggalPenerbangan = than.nextLine();
                        String date = tanggalPenerbangan.substring(0, 2);
                        String months = tanggalPenerbangan.substring(3, 5);
                        String year = tanggalPenerbangan.substring(6);
                        if (months.equals("01") || months.equals("03")
                                || months.equals("05") || months.equals("07")
                                || months.equals("09") || months.equals("11")) {
                            if (Integer.parseInt(date) <= 31 && Integer.parseInt(date) > 0) {
                                salah = false;
                            } else {
                                System.out.println("!!Invalid Date!!");
                                continue;
                            }

                        } else if (months.equals("02")) {
                            if (Integer.parseInt(year) % 4 == 0) {
                                if (Integer.parseInt(date) <= 29 && Integer.parseInt(date) > 0) {
                                    salah = false;
                                } else {
                                    System.out.println("!!Invalid Date!!");
                                    continue;
                                }
                            } else {
                                if (Integer.parseInt(date) <= 28 && Integer.parseInt(date) > 0) {
                                    salah = false;
                                } else {
                                    System.out.println("!!Invalid Date!!");
                                    continue;
                                }
                            }
                        }

                        newLine();
                        System.out.println("Masukkan metode pembayaran :\n(dengan mengetik gopay atau ovo atau cash)");
                        System.out.print("-> ");
                        metode = than.nextLine();
                        disc = discount(metode);

                        // Algoritma jarak
                        int jarakPenerbangan = 0;
                        for (int j = 0; j < asalPenumpang.length(); j++) {
                            jarakPenerbangan += asalPenumpang.charAt(j);
                        }
                        for (int j = 0; j < tujuanPenumpang.length(); j++) {
                            jarakPenerbangan += tujuanPenumpang.charAt(j);
                        }
                        harga = Math.abs(jarakPenerbangan) * 1000 * payMore;
                        hargaTotal = harga * disc;

                        // Output
                        int seatNum =  (int) (Math.random() * 50 + 1);
                        String seat = Integer.toString(seatNum);
                        seat += (char) ((Math.random()*8) + 65);
                        divider1();
                        newLine();
                        System.out.printf("%43s\n", "OJEK TERBANG");
                        System.out.printf("// %s\n", classFlight);
                        System.out.printf("%-15s: %s\n", "Nama Penumpang", namaPenumpang.toUpperCase());
                        divider2();
                        System.out.printf("%-15s: %s\n", "From", asalPenumpang.toUpperCase() + " / " + asalPenumpang.substring(0, 3).toUpperCase());
                        System.out.printf("%-15s: %s\n", "To", tujuanPenumpang.toUpperCase() + " / " + tujuanPenumpang.substring(0, 3).toUpperCase());
                        divider2();
                        System.out.printf("%-14s%-14s%-15s\n", "Gate", "Seat", "Flight");
                        System.out.printf("%-14d%-14s%-15s\n", (int) (Math.random() * 27 + 1),
                                seat, asalPenumpang.substring(0, 3).toUpperCase()
                                        + tujuanPenumpang.substring(0, 3).toUpperCase() + year);
                        newLine();
                        System.out.println("// Detail Pembayaran");
                        divider2();
                        System.out.printf("%-15s:%27s\n", "Harga", df.format(harga));
                        System.out.printf("%-15s:%27s\n", "Diskon", df.format(hargaTotal - harga));
                        divider2();
                        System.out.printf("%-15s:%27s\n", "Total", df.format(hargaTotal));
                        newLine();
                        newLine();
                        salah = false;

                    }
                    break;

                // Keluar
                case "0":
                    System.out.println("=".repeat(14) + " Terimakasih :D " + "=".repeat(13));
                    isRunning = false;
                    break;

                // Invalid
                default:
                    divider1();
                    System.out.println("!! Pilihan tidak valid.\n!! Silahkan pilih menu yang tersedia.");
                    break;
            }
        }
        than.close();
    }

    // Pembatas
    public static void divider1() {
        System.out.println("=".repeat(43));
    }

    public static void divider2() {
        System.out.println("-".repeat(43));
    }

    public static void newLine() {
        System.out.println("");
    }

    // Diskon sesuai metode pembayaran
    public static double discount(String metodePembayaran) {
        if (metodePembayaran.equalsIgnoreCase("gopay")) {
            return 0.9;
        } else if (metodePembayaran.equalsIgnoreCase("ovo")) {
            return 0.95;
        } else if (metodePembayaran.equalsIgnoreCase("cash")) {
            return 1;
        } else
            return 1;
    }

    // Output Driver / Kurir
    public static String printNamaOjek() {
        // Initialized Name
        String[] firstName = { "Made", "Putra", "Abdul", "Doni" };
        String[] middleName = { "Yanto", "Kurniawan", "Dimas", "Arif", "Fajar", "Bayu", "Ricky" };
        String[] lastName = { "Filkom", "Bogor", "Seblak", "Kebab", "Indomie", "Lontong", "Batagor" };

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

        return namaGOJEK;
    }

    public static String printPlatNo() {
        // Initialized Plat
        String[] platNomor = { "DK", "N", "AG", "AA", "B", "AE", "RRQ" };
        String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // Output
        return (platNomor[(int) (Math.random() * platNomor.length)]
                + " "
                + (int) (Math.random() * 10)
                + (int) (Math.random() * 10)
                + (int) (Math.random() * 10)
                + (int) (Math.random() * 10)
                + " "
                + Alphabet.charAt((int) (Math.random() * Alphabet.length()))
                + Alphabet.charAt((int) (Math.random() * Alphabet.length()))
                + Alphabet.charAt((int) (Math.random() * Alphabet.length())));
    }

    // Generate tempat makan
    public static String[] GenerateFoodShop() {
        String[] jenisFoodShop = { "Restoran", "Warung", "Kafe", "Depot", "Kedai", "Rumah Makan" };
        String[] namaFoodShop = { "Bentar Lagi Bangkrut", "Kenyang", "Terserah", "Katanya Enak", "Enak Tenan", "Murah",
                "Setarbak", "Phan Tat" };
        String[] foodShop = new String[46];
        for (int i = 1; i <= foodShop.length - 1; i++) {
            foodShop[i] = jenisFoodShop[(int) (Math.random() * jenisFoodShop.length)]
                    + " "
                    + namaFoodShop[(int) (Math.random() * namaFoodShop.length)];

        }

        return foodShop;
    }

    // Menu Restoran
    public static void menuRestoran(DecimalFormat df, Scanner than) {
        String[] menu = { "Bruschetta", "Salad", "Panna Cotta", "Dim Sum", "Sup Tom Yum", "Sushi", "Mochi",
                "Tiramisu Matcha" };
        int[] hargaMenu = { 50000, 40000, 55000, 30000, 25000, 40000, 20000, 25000 };
        mesenMaeman(menu, hargaMenu, df, than);
    }

    // Menu Warung
    public static void menuWarung(DecimalFormat df, Scanner than) {
        String[] menu = { "Nasi Goreng", "Mie Goreng", "Bakso Malang", "Soto Ayam", "Nasi Rames", "Ikan Bakar",
                "Es Teh",
                "Tiramisu Matcha" };
        int[] hargaMenu = { 15000, 12000, 10000, 15000, 20000, 20000, 5000, 20000 };
        mesenMaeman(menu, hargaMenu, df, than);
    }

    // Menu Kafe
    public static void menuKafe(DecimalFormat df, Scanner than) {
        String[] menu = { "Espresso", "Latte", "Matcha Latte", "Smoothie Berry", "Orange Juice", "Tuna Sandwich",
                "Cheesecake" };
        int[] hargaMenu = { 20000, 25000, 27000, 30000, 15000, 30000, 35000 };
        mesenMaeman(menu, hargaMenu, df, than);
    }

    // Menu Depot
    public static void menuDepot(DecimalFormat df, Scanner than) {
        String[] menu = { "Pisang Goreng", "Tape Goreng", "Onde-onde", "Es Teh", "Es Degan", "Capcay",
                "Sapi Lada Hitam", "Sup Jagung" };
        int[] hargaMenu = { 8000, 10000, 7000, 5000, 8000, 20000, 35000, 25000 };
        mesenMaeman(menu, hargaMenu, df, than);
    }

    // Menu Kedai
    public static void menuKedai(DecimalFormat df, Scanner than) {
        String[] menu = { "Nasgor Ayam", "Nasgor Sapi", "Nasgor Kambing", "Soto Ayam", "Nasi Rames", "Ikan Goreng",
                "Es Teh",
                "Es Jeruk" };
        int[] hargaMenu = { 10000, 15000, 15000, 15000, 20000, 17000, 5000, 5000 };
        mesenMaeman(menu, hargaMenu, df, than);
    }

    // Menu Rumah Makan
    public static void menuRumahMakan(DecimalFormat df, Scanner than) {
        String[] menu = { "Ayam Rica-Rica", "Nasgor Seafood", "Sate Padang", "Sayur Lodeh", "Sup Tahu Jagung",
                "Kopi Hitam", "Jus Jeruk",
                "Es Teh" };
        int[] hargaMenu = { 25000, 27000, 15000, 20000, 25000, 8000, 8000, 6000 };
        mesenMaeman(menu, hargaMenu, df, than);
    }

    // Maeman Generator
    public static void mesenMaeman(String[] menu, int[] hargaMenu, DecimalFormat df, Scanner than) {
        int[] jumlahMakanan = new int[menu.length + 1];
        boolean masihMilih = true;

        // Easter Egg :P
        if (easterEgg) {
            for (int item = 0; item < hargaMenu.length; item++) {
                hargaMenu[item] *= 0.75;
            }
        }

        // Looping pemesanan
        while (masihMilih) {

            // Menu
            divider1();
            for (int i = 0; i < menu.length; i++) {
                System.out.printf("%d. %-17s%23s\n", i + 1, menu[i], df.format(hargaMenu[i]));
            }

            // Input
            newLine();
            System.out.println("(ketik 0 jika sudah selesai)");
            System.out.print("-> ");
            int milihMana = than.nextInt();
            than.nextLine();

            // Storing Jumlah Pesanan
            if (milihMana > 0 && milihMana <= menu.length) {
                jumlahMakanan[milihMana - 1]++;
                hargaTotal += hargaMenu[milihMana - 1];

                // Output
            } else if (milihMana == 0) {
                masihMilih = false;

                // Metode Pembayaran
                newLine();
                System.out.println("Masukkan metode pembayaran :\n(dengan mengetik gopay atau ovo atau cash)");
                System.out.print("-> ");
                metode = than.nextLine();
                disc = discount(metode);
                divider1();
                newLine();

                // Output Pesanan Makanan yang dibuat
                System.out.println("// Pesanan anda");
                divider2();
                for (int i = 0; i < jumlahMakanan.length; i++) {
                    if (jumlahMakanan[i] > 0) {
                        System.out.printf("(%d) %-17s%22s\n", jumlahMakanan[i], menu[i],
                                df.format(hargaMenu[i] * jumlahMakanan[i]));
                    }
                }
                harga = hargaTotal;
                hargaTotal *= disc;
                printOutput(harga, hargaTotal, df);

            } else
                continue;
        }
    }

    // Output
    public static void printOutput(double harga, double hargaTotal, DecimalFormat df) {

        // Keluaran
        newLine();
        if (pilihan.equals("2")) {
            System.out.println("// Kurir anda");
        } else
            System.out.println("// Driver anda");
        divider2();
        System.out.printf("%-15s:%27s\n", "Nama", printNamaOjek());
        System.out.printf("%-15s:%27s\n", "Plat Kendaraan", printPlatNo());
        newLine();
        newLine();
        System.out.println("// Detail Pembayaran");
        divider2();
        System.out.printf("%-15s:%27s\n", "Harga", df.format(harga));
        System.out.printf("%-15s:%27s\n", "Diskon", df.format(hargaTotal - harga));
        divider2();
        System.out.printf("%-15s:%27s\n", "Total", df.format(hargaTotal));
        newLine();
    }

    // Biar keren aja hehehe
    public static void GoJek(Scanner than) {
        String[] line = new String[100];
        newLine();
        line[1] = "                                   .,*/(((/*.                                   ";
        line[2] = "                         ./(((((((((((((((((((((((((((/                         ";
        line[3] = "                    ,((((((((((((((((((((((((((((((((((((((/                    ";
        line[4] = "                .((((((((((((((((((((((((((((((((((((((((((((((/                ";
        line[5] = "             ,(((((((((((((((((((((((((((((((((((((((((((((((((((((             ";
        line[6] = "           ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((*          ";
        line[7] = "         ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((/        ";
        line[8] = "       (((((((((((((((((((((((*                  .(((((((((((((((((((((((,      ";
        line[9] = "     ,((((((((((((((((((((.                           *((((((((((((((((((((     ";
        line[10] = "    /((((((((((((((((((.                                 *((((((((((((((((((.   ";
        line[11] = "   ((((((((((((((((((              ./((((((/*.             ,(((((((((((((((((,  ";
        line[12] = "  /((((((((((((((((.           /(((((((((((((((((*           /((((((((((((((((. ";
        line[13] = " ,((((((((((((((((          *(((((((((((((((((((((((          ,(((((((((((((((( ";
        line[14] = " ((((((((((((((((          (((((((((((((((((((((((((((         *(((((((((((((((*";
        line[15] = ".(((((((((((((((,        .(((((((((((((((((((((((((((((         ((((((((((((((((";
        line[16] = "/(((((((((((((((         ((((((((((((((((((((((((((((((,        *(((((((((((((((";
        line[17] = "((((((((((((((((         ((((((((((((((((((((((((((((((/        ,(((((((((((((((";
        line[18] = "*(((((((((((((((         /(((((((((((((((((((((((((((((.        *(((((((((((((((";
        line[19] = " (((((((((((((((*         ((((((((((((((((((((((((((((/         ((((((((((((((((";
        line[20] = " ((((((((((((((((.         ((((((((((((((((((((((((((*         /(((((((((((((((,";
        line[21] = " .((((((((((((((((.          ((((((((((((((((((((((*          ((((((((((((((((( ";
        line[22] = "  *((((((((((((((((*           .((((((((((((((((/            (((((((((((((((((  ";
        line[23] = "   /(((((((((((((((((,               .,**,,.               ((((((((((((((((((.  ";
        line[24] = "    ,((((((((((((((((((/                                .(((((((((((((((((((    ";
        line[25] = "      (((((((((((((((((((((.                         ,((((((((((((((((((((/     ";
        line[26] = "       *(((((((((((((((((((((((,                 /(((((((((((((((((((((((       ";
        line[27] = "         *(((((((((((((((((((((((*             ((((((((((((((((((((((((.        ";
        line[28] = "           ,((((((((((((((((((((((,           *((((((((((((((((((((((           ";
        line[29] = "              /(((((((((((((((((((,           *(((((((((((((((((((.             ";
        line[30] = "                 ,(((((((((((((((*             /((((((((((((((/.                ";
        line[31] = "                     ,(((((((((,                 *((((((((/.                    ";
        line[32] = "";
        line[33] = "";
        line[34] = "                                                            .@@@.               ";
        line[35] = "         ,#@@%* *@@@      ./%&%/.      @@@/     ./&@&/.     .@@@.    *@@&&*     ";
        line[36] = "      *@@@@@@@@@@@@@   /@@@@@@@@@@@(   @@@/  .@@@@&#%@@@@,  .@@@.  @@@@%        ";
        line[37] = "     /@@@*      %@@@  #@@@      .@@@#  @@@(  @@@*......@@@* .@@@%@@@@.          ";
        line[38] = "     (@@@       (@@@  %@@@       @@@%  @@@( .@@@@@@@@@@@@@# .@@@@@@@@@.         ";
        line[39] = "      &@@@@*.,#@@@@@   @@@@%, ,%@@@@   @@@(  (@@@%          .@@@.   &@@@        ";
        line[40] = "        ,@@@@@@%,@@@     *@@@@@@@/     @@@/    .&@@@@@@@.   .@@@.     &@@@      ";
        line[41] = "        ,.      @@@&                   @@@/                                     ";
        line[42] = "       @@@@@@@@@@@*                /@@@@@@                                      ";

        for (int i = 1; i <= 42; i++) {
            System.out.println(line[i]);
        }
        System.out.println("");
        than.nextLine();
        for (int i = 0; i < 100; i++) {
            System.out.println("");
        }

    }
}
