import java.util.Scanner;

public class Encoder {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);

        // Declare
        boolean isRunning = true;
        boolean maintainCase = true;
        boolean ignoreCase = false;
        boolean includeNonLetter = false;
        String case1 = "";
        String case2 = "";
        String case3 = "";
        String stringEncode = "";
        String stringEncodeNonLetter = "";
        char charEncode = ' ';
        int ASCII = 0;

        while (isRunning) {

            // Switch on or off.
            if (maintainCase == true)
                case1 = "ON";
            if (maintainCase == false)
                case1 = "OFF";
            if (ignoreCase == true)
                case2 = "ON";
            if (ignoreCase == false)
                case2 = "OFF";
            if (includeNonLetter == true)
                case3 = "ON";
            if (includeNonLetter == false)
                case3 = "OFF";

            // Menu
            System.out.println("Welcome to my encoder!");
            System.out.println("Program ini meng-encode text alphabet.");
            System.out.printf("%-35s%s\n", "1. Maintain case", case1);
            System.out.printf("%-35s%s\n", "2. Ignore case", case2);
            System.out.printf("%-35s%s\n", "3. Include non-letter", case3);
            System.out.printf("%-35s\n", "4. Input text");
            System.out.printf("%-35s\n", "9. Exit");
            System.out.print("Pilihan anda? ");
            int pilihan = than.nextInt();
            than.nextLine();

            // Reset
            stringEncode = "";
            stringEncodeNonLetter = "";

            // Pilihan
            switch (pilihan) {
                case 1:
                    if (maintainCase == true) {
                        ignoreCase = true;
                        maintainCase = false;
                    } else {
                        ignoreCase = false;
                        maintainCase = true;
                    }
                    break;

                case 2:
                    if (ignoreCase == true) {
                        ignoreCase = false;
                        maintainCase = true;
                    } else {
                        ignoreCase = true;
                        maintainCase = false;
                    }
                    break;

                case 3:
                    if (includeNonLetter == true) {
                        includeNonLetter = false;
                    } else
                        includeNonLetter = true;

                    break;

                case 4:
                // Input
                System.out.print("Masukkan text untuk diencode: ");
                String text = than.nextLine();
                System.out.print("Jumlah geser (integer): ");
                int geser = than.nextInt();

                    // Maintain case = true
                    if (maintainCase) {

                        // Encoding...
                        for (int i = 0; i < text.length(); i++) {
                            if (text.charAt(i) == ' ') {
                                stringEncode += " ";
                                continue;
                            }
                            char c = text.charAt(i);
                            ASCII = (int) text.charAt(i);
                            if (!(Character.isLetter(c))) {
                                stringEncode += text.charAt(i);
                                continue;
                            }
                            if (Character.isUpperCase(c)) {
                                ASCII = ((ASCII - 'A' + geser) % 26) + 'A';
                            } else
                                ASCII = ((ASCII - 'a' + geser) % 26) + 'a';
                            charEncode = (char) ASCII;
                            stringEncode += charEncode;

                        }
                        
                    }

                    // Ignore case = true
                    if (ignoreCase) {
                        text = text.toLowerCase();

                        // Encoding...
                        for (int i = 0; i < text.length(); i++) {
                            if (text.charAt(i) == ' ') {
                                stringEncode += " ";
                                continue;
                            }
                            ASCII = (int) text.charAt(i);
                            if (!(Character.isLetter(text.charAt(i)))) {
                                stringEncode += text.charAt(i);
                                continue;
                            }
                            ASCII = ((ASCII - 'a' + geser) % 26) + 'a';
                            charEncode = (char) ASCII;
                            stringEncode += charEncode;

                        }

                    }

                    // Include non-letter = true
                    if (includeNonLetter) {

                        // Encoding...
                        for (int i = 0; i < stringEncode.length(); i++) {
                            char ifLetter = stringEncode.charAt(i);
                            if (!(Character.isLetter(ifLetter))) {
                                
                                ASCII = (int) stringEncode.charAt(i);
                                ASCII += geser;
                                charEncode = (char) ASCII;
                            } else charEncode = ifLetter;
                            stringEncodeNonLetter += charEncode;
                        }

                    }

                    // Output
                    if (includeNonLetter) {
                        System.out.println("Encoded text: " + stringEncodeNonLetter);
                    } else if (ignoreCase) {
                        System.out.println("Encoded text: " + stringEncode);
                    } else System.out.println("Encoded text: " + stringEncode);

                    break;

                case 9:
                    isRunning = false;
                    break;

                default:
                    System.out.println("!!-------------------------------------------------------------!!");
                    System.out.println("Maaf pilihan anda tidak valid, silahkan pilih menu yang tersedia.");
                    System.out.println("!!-------------------------------------------------------------!!");
                    break;
            }
        }
        than.close();
    }
}
