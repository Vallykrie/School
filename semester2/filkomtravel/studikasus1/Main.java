package filkomtravel.studikasus1;

import java.util.Scanner;
import java.util.LinkedList;

/**
 * The Main class represents the main entry point of the Filkom Travel
 * application.
 * It provides functionality for user login, registration, and vehicle selection
 * for rental.
 * The class contains a main method that executes the application logic.
 */
public class Main {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);

        // Declare
        boolean isRunning = true;
        boolean masihMemilih = false;
        boolean inMenu = false;
        String divider1 = "-".repeat(50);
        String divider2 = "=".repeat(50);
        String username = "";
        String password = "";
        String email = "";
        String namaLengkap = "";

        // Data Kendaraan
        Vehicle mobil1 = new Mobil("Toyota", "Hitam", "AB 1234 CD", 6, 16000);
        Vehicle van1 = new Van("Hiace", "Putih", "B 5678 CD", 16, 40000);
        Vehicle motor1 = new Motor("Vario", "Merah", "N 1234 CD", 2, 5000);

        // Data User
        User admin = new User("admin", "admin", "admin", "admin");
        LinkedList<User> userList = new LinkedList<>();
        userList.add(admin);

        // Menu 1
        while (isRunning) {
            System.out.println(divider2);
            System.out.println(" ".repeat(9) + "Selamat Datang di Filkom Travel" + " ".repeat(10));
            System.out.println();
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Keluar");
            System.out.println();
            System.out.println("Ketik 1, 2, atau 3");
            System.out.print("-> ");
            int pilih = than.nextInt();
            than.nextLine();

            switch (pilih) {
                case 1:
                    System.out.println(divider2);
                    System.out.println(" ".repeat(22) + "Login" + " ".repeat(23));
                    System.out.println();
                    System.out.print("Username: ");
                    username = than.nextLine();
                    System.out.print("Password: ");
                    password = than.nextLine();
                    System.out.println();
                    System.out.println(divider1);
                    if (User.login(username, password, userList)) {
                        System.out.println("Login Berhasil");
                        inMenu = true;
                    } else {
                        System.out.println("Username atau Password salah");
                        inMenu = false;
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
                    inMenu = false;
                    break;
                case 3:
                    isRunning = false;
                    masihMemilih = false;
                    break;

                default:
                    System.out.println("Input invalid!");
                    break;
            }

            // Menu 2

            while (inMenu) {
                System.out.println(divider2);
                int biarRapi = 5 + username.length();
                int alignCenter = (50 - biarRapi)/2;
                System.out.println(" ".repeat(alignCenter) + "Hi, " + username  + "!" +" ".repeat(alignCenter));
                System.out.println();
                System.out.println("1. Profile");
                System.out.println("2. Sewa Kendaraan");
                System.out.println();
                System.out.println("Ketik 1, atau 2");
                System.out.print("-> ");
                pilih = than.nextInt();
                than.nextLine();

                switch (pilih) {
                    case 1:
                        userList.get(User.get(username, userList)).viewProfile();
                        break;
                    case 2:
                        
                        break;
                
                    default:
                        break;
                }
                
            }

            while (masihMemilih) {
                System.out.println(divider2);
                System.out.println(" ".repeat(8) + "Pilih Kendaraan yang Ingin di Sewa" + " ".repeat(8));
                System.out.println();
                System.out.println("1. Van");
                System.out.println("2. Mobil");
                System.out.println("3. Motor");
                System.out.println("4. Keluar");
                System.out.println();
                System.out.println("Ketik 1, 2, 3, atau 4");
                System.out.print("-> ");
                pilih = than.nextInt();
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

                            // Nota
                            Receipt nota = new Receipt(tanggalSewa, jam, van1.getPrice() * jam, jamSewa);
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

                            // Nota
                            Receipt nota = new Receipt(tanggalSewa, jam, mobil1.getPrice() * jam, jamSewa);
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

                            // Nota
                            Receipt nota = new Receipt(tanggalSewa, jam, motor1.getPrice() * jam, jamSewa);
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
        than.close();
    }
}
