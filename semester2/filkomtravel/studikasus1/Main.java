package semester2.filkomtravel.studikasus1;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;
import semester2.filkomtravel.User;

public class Main {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);

         // Price Formats
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("Rp #,###.00", symbols);

        User admin = new User("admin", "admin", "admin", "admin");

        // Declare
        boolean isRunning = true;
        String divider = "-".repeat(50);
        String divider2 = "=".repeat(50);

        // Menu
        while (isRunning) {
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
                    System.out.println(" ".repeat(22) + "Login" + " ".repeat(23));
                    System.out.println();
                    System.out.print("Username: ");
                    String username = than.nextLine();
                    System.out.print("Password: ");
                    String password = than.nextLine();
                    break;

                case 2:
                    
                    break;
            
                default:
                    break;
            }
        }

    }
}
