package filkomtravel.studikasus1;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);

        // Declare
        boolean isRunning = true;
        boolean masihMemilih = false;
        String divider1 = "-".repeat(50);
        String divider2 = "=".repeat(50);
        String username = "";
        String password = "";
        String email = "";
        String namaLengkap = "";

        // Data Kendaraan
        Kendaraan mobil1 = new Mobil("Toyota", "Hitam", "AB 1234 CD", 6, 16000);
        Kendaraan van1 = new Van("Hiace", "Putih", "B 5678 CD", 16, 40000);
        Kendaraan motor1 = new Motor("Vario", "Merah", "N 1234 CD", 2, 5000);

        // Data User
        User admin = new User("admin", "admin", "admin", "admin");
        LinkedList<User> userList = new LinkedList<>();
        userList.add(admin);

        // Menu
        while (isRunning) {
            System.out.println(divider2);
            System.out.println(" ".repeat(9) + "Selamat Datang di Filkom Travel" + " ".repeat(10));
            System.out.println();
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.println();
            System.out.println("Ketik 1, 2, atau 3");
            System.out.print("-> ");
            int menu = than.nextInt();
            than.nextLine();

            switch (menu) {
                case 1:
                    System.out.println(divider2);
                    System.out.println(" ".repeat(22) + "Login" + " ".repeat(23));
                    System.out.println();
                    System.out.print("Username: ");
                    username = than.nextLine();
                    System.out.print("Password: ");
                    password = than.nextLine();
                    System.out.println(divider1);
                    if (User.login(username, password, userList)) {
                        System.out.println("Login Berhasil");
                        masihMemilih = true;
                    } else {
                        System.out.println("Username atau Password salah");
                        masihMemilih = false;
                    }
                    break;

                case 2:
                    System.out.println(divider2);
                    System.out.println(" ".repeat(21) + "Register" + " ".repeat(21));
                    System.out.println();
                    System.out.print("Nama Lengkap: ");
                    namaLengkap = than.nextLine();
                    System.out.print("Username: ");
                    username = than.nextLine();
                    System.out.print("Email: ");
                    email = than.nextLine();
                    System.out.print("Password: ");
                    password = than.nextLine();
                    System.out.print("Confirm Password: ");
                    password = than.nextLine();
                    User newUser = new User(username, password, email, namaLengkap);
                    userList.add(newUser);
                    masihMemilih = false;
                    break;
                case 3:
                    isRunning = false;
                    masihMemilih = false;
                    break;

                default:
                    System.out.println("Input invalid!");
                    break;
            }
            while (masihMemilih) {
                System.out.println(divider2);
                System.out.println(" ".repeat(8) + "Pilih Kendaraan yang Ingin di Sewa" + " ".repeat(8));
                System.out.println();
                System.out.println("1. Van");
                System.out.println("2. Mobil");
                System.out.println("3. Motor");
                System.out.println("4. Exit");
                System.out.println();
                System.out.println("Ketik 1, 2, 3, atau 4");
                System.out.print("-> ");
                int pilih = than.nextInt();
                than.nextLine();
                String jawab;

                switch (pilih) {
                    case 1: // Add case label for option 1
                        System.out.println(divider1);
                        van1.printInfo();
                        System.out.println();
                        System.out.println("Apakah anda ingin menyewa kendaraan ini? (y/n)");
                        jawab = than.nextLine();
                        if (jawab.equalsIgnoreCase("y")) {
                            System.out.println("Berapa jam anda ingin menyewa?");
                            int jam = than.nextInt();
                            than.nextLine();
                            System.out.print("Tanggal sewa (yyyy/mm/dd): ");
                            String tanggal = than.nextLine();
                            System.out.print("Jam sewa (hh:mm): ");
                            String waktu = than.nextLine();
                            String[] tanggalSewa = tanggal.split("/");
                            String[] jamSewa = waktu.split(":");
                            System.out.println(divider2);

                            // Nota
                            Nota nota = new Nota(tanggalSewa, jam, van1.getPrice() * jam, jamSewa);
                            nota.print();
                            masihMemilih = false;
                            isRunning = false;
                        }

                        break;
                    case 2:
                        System.out.println(divider1);
                        mobil1.printInfo();
                        System.out.println();
                        System.out.println("Apakah anda ingin menyewa kendaraan ini? (y/n)");
                        jawab = than.nextLine();
                        if (jawab.equalsIgnoreCase("y")) {
                            System.out.println("Berapa jam anda ingin menyewa?");
                            int jam = than.nextInt();
                            than.nextLine();
                            System.out.print("Tanggal sewa (yyyy/mm/dd): ");
                            String tanggal = than.nextLine();
                            System.out.print("Jam sewa (hh:mm): ");
                            String waktu = than.nextLine();
                            String[] tanggalSewa = tanggal.split("/");
                            String[] jamSewa = waktu.split(":");
                            System.out.println(divider2);

                            // Nota
                            Nota nota = new Nota(tanggalSewa, jam, mobil1.getPrice() * jam, jamSewa);
                            nota.print();
                            masihMemilih = false;
                            isRunning = false;
                        }
                        break;
                    case 3:
                        System.out.println(divider1);
                        motor1.printInfo();
                        System.out.println();
                        System.out.println("Apakah anda ingin menyewa kendaraan ini? (y/n)");
                        jawab = than.nextLine();
                        if (jawab.equalsIgnoreCase("y")) {
                            System.out.println("Berapa jam anda ingin menyewa?");
                            int jam = than.nextInt();
                            than.nextLine();
                            System.out.print("Tanggal sewa (yyyy/mm/dd): ");
                            String tanggal = than.nextLine();
                            System.out.print("Jam sewa (hh:mm): ");
                            String waktu = than.nextLine();
                            String[] tanggalSewa = tanggal.split("/");
                            String[] jamSewa = waktu.split(":");
                            System.out.println(divider2);

                            // Nota
                            Nota nota = new Nota(tanggalSewa, jam, motor1.getPrice() * jam, jamSewa);
                            nota.print();
                            masihMemilih = false;
                            isRunning = false;
                        }
                        break;
                    case 4:
                        masihMemilih = false;
                        isRunning = false;
                        break;

                    default:
                        break;
                }
            }

        }

    }
}
