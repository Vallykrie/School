package filkomtravel.studikasus1;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);

        // Price Formats
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("Rp #,###.00", symbols);

        // Declare
        boolean isRunning = true;
        String divider1 = "-".repeat(50);
        String divider2 = "=".repeat(50);
        String username = "";
        String password = "";
        String email = "";
        String namaLengkap = "";

        // Data Kendaraan
        Kendaraan mobil1 = new Mobil("Toyota", "Hitam", "AB 1234 CD", 4);
        Kendaraan mobil2 = new Mobil("Rubicon", "Pink", "B 5678 CD", 4);

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
            System.out.println();
            System.out.println("Ketik 1 atau 2 ");
            System.out.print("-> ");
            int menu = than.nextInt();

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
                    } else {
                        System.out.println("Username atau Password salah");
                    }
                    break;

                case 2:
                    System.out.println(" ".repeat(21) + "Register" + " ".repeat(21));
                    System.out.println();
                    System.out.print("Nama Panjang: ");
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
                    break;

                default:
                    break;
            }
        }

    }
}
