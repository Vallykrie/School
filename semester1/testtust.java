import java.util.Scanner;

public class testtust {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        String[][] kursiBioskop = new String[8][8];

        /*
         * A |_| |_| |_| |_| |_| |_| |_| |_|
         * B |_| |_| |_| |_| |_| |_| |_| |_|
         * C |_| |_| |_| |_| |_| |_| |_| |_|
         * D |_| |X| |X| |_| |_| |_| |_| |_|
         * E |_| |_| |_| |_| |_| |_| |_| |_|
         * F |_| |_| |_| |_| |_| |_| |_| |_|
         * G |_| |_| |_| |_| |_| |_| |_| |_|
         * H |_| |_| |_| |_| |_| |_| |_| |_|
         * 
         * 1 2 3 4 5 6 7 8
         * ------------ Layar Bioskop ------------
         */

        for (int i = 0; i < kursiBioskop.length; i++) {
            for (int j = 0; j < kursiBioskop.length; j++) {
                kursiBioskop[i][j] = "|_| ";
            }
        }

        // Looping pembuatan tanggal yang benar
        boolean salah = true;
        while (salah) {
            System.out.println("Booking date (DD/MM/YY): ");
            String bookingDate = than.nextLine();
            String date = bookingDate.substring(0, 2);
            String months = bookingDate.substring(3, 5);
            String year = bookingDate.substring(6);
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
            salah = false;
        }
        while (true) {
            // Tampilan bioskop
            for (int i = 0; i < kursiBioskop.length; i++) {
                System.out.print((char) ('A'+i));
                System.out.print("   ");
                for (int j = 0; j < kursiBioskop.length; j++) {
                    System.out.print(kursiBioskop[i][j]);
                    if (j==3) {
                        System.out.print("   ");
                    }
                }
                System.out.println();
            }
            System.out.println();
            System.out.println("     1   2   3   4      5   6   7   8");
            System.out.println("------------ Layar Bioskop ------------");
    
            // Input
            System.out.println("");
            System.out.println("Pilih kursi yang tersedia (contoh : 8B) ");
            System.out.print("-> ");
            String bookingKursi = than.nextLine();
            bookingKursi.toUpperCase();
    
            // Algoritma
            int x = Character.getNumericValue(bookingKursi.charAt(0))-1;
            int y = bookingKursi.charAt(1)%65;
            kursiBioskop[y][x]="|X| ";
            
        }
        


    }
}
