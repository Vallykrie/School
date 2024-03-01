/*
 *  Nama : Pande Kadek Nathan Prabhaswara Sudiara Putra
 *  NIM  : 235150207111051
 */

import java.util.Scanner;

public class KonversiBilangan {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);

        // DECLARE
        String devider = "-".repeat(50);
        boolean isRunning = true;
        String BINER;
        String HEXA;
        int DESIMAL;

        // MENU
        while (isRunning) {
            System.out.println("-".repeat(15) + " KONVERSI BILANGAN " + "-".repeat(16));
            System.out.println("1. BINER\t\t--> \t\tDESIMAL");
            System.out.println("2. DESIMAL\t\t--> \t\tBINER");
            System.out.println("3. BINER\t\t--> \t\tHEXA");
            System.out.println("4. HEXA\t\t\t--> \t\tBINER");
            System.out.println("5. DESIMAL\t\t--> \t\tHEXA");
            System.out.println("6. HEXA\t\t\t--> \t\tDESIMAL");
            System.out.println("7. DESIMAL\t\t--> \t\tOKTAL");
            System.out.println("0. EXIT");
            System.out.print("-> ");
            String menu = than.nextLine();
            switch (menu) {

                // BINER -> DESIMAL
                case "1":
                    System.out.println(devider);
                    System.out.println("Input bilangan BINER");
                    System.out.print("-> ");
                    BINER = than.nextLine();
                    DESIMAL = Integer.parseInt(BINER, 2);
                    System.out.println("Hasil bilangan DESIMAL");
                    System.out.println("-> " + DESIMAL);

                    break;

                // DESIMAL -> BINER
                case "2":
                    System.out.println(devider);
                    System.out.println("Input bilangan DESIMAL");
                    System.out.print("-> ");
                    DESIMAL = than.nextInt();
                    than.nextLine();
                    BINER = Integer.toBinaryString(DESIMAL);
                    System.out.println("Hasil bilangan BINER");
                    System.out.println("-> " + BINER);

                    break;

                // BINER -> HEXADESIMAL
                case "3":
                    System.out.println(devider);
                    System.out.println("Input bilangan BINER");
                    System.out.print("-> ");
                    BINER = than.nextLine();
                    DESIMAL = Integer.parseInt(BINER, 2);
                    HEXA = Integer.toHexString(DESIMAL).toUpperCase();
                    System.out.println("Hasil bilangan HEXADESIMAL");
                    System.out.println("-> " + HEXA);

                    break;

                // HEXADESIMAL -> BINER
                case "4":
                    System.out.println(devider);
                    System.out.println("Input bilangan HEXADESIMAL");
                    System.out.print("-> ");
                    HEXA = than.nextLine();
                    DESIMAL = Integer.parseInt(HEXA, 16);
                    BINER = Integer.toBinaryString(DESIMAL);
                    System.out.println("Hasil bilangan BINER");
                    System.out.println("-> " + BINER);

                    break;

                // DESIMAL -> HEXADESIMAL
                case "5":
                    System.out.println(devider);
                    System.out.println("Input bilangan DESIMAL");
                    System.out.print("-> ");
                    DESIMAL = than.nextInt();
                    than.nextLine();
                    HEXA = Integer.toHexString(DESIMAL).toUpperCase();
                    System.out.println("Hasil bilangan HEXADESIMAL");
                    System.out.println("-> " + HEXA);

                    break;

                // HEXADESIMAL -> DESIMAL
                case "6":
                    System.out.println(devider);
                    System.out.println("Input bilangan HEXADESIMAL");
                    System.out.print("-> ");
                    HEXA = than.nextLine();
                    DESIMAL = Integer.parseInt(HEXA, 16);
                    System.out.println("Hasil bilangan DESIMAL");
                    System.out.println("-> " + DESIMAL);

                    break;

                case "7":
                    System.out.println(devider);
                    System.out.println("Input bilangan DESIMAL");
                    System.out.print("-> ");
                    DESIMAL = than.nextInt();
                    than.nextLine();

                    String OKTAL = Integer.toOctalString(DESIMAL);

                    System.out.println("Hasil bilangan OKTAL");
                    System.out.println("-> " + OKTAL);
                    break;

                // EXIT
                case "0":
                    System.out.println(devider);
                    isRunning = false;
                    break;

                default:
                    break;
            }

        }
        than.close();
    }
}
