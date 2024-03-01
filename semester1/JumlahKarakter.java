import java.util.Scanner;

public class JumlahKarakter {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);

        // Input
        System.out.print("Masukkan text : ");
        String text = than.nextLine();
        text = text.toLowerCase();

        int[] jumlahKarakter = new int[256];

        for (int i = 0; i < text.length(); i++) {
            char karakter = text.charAt(i);
            System.out.println(karakter);

            if (karakter < 256) {
                jumlahKarakter[karakter]++;
            }
        }

        // Output
        System.out.println("-".repeat(30));
        System.out.printf("|%-14s|%-13s|\n", "Character", "Jumlah");
        System.out.println("-".repeat(30));
        for (int i = 0; i < 256; i++) {
            if (jumlahKarakter[i] > 0) {
                System.out.printf("|'%s'%-11s|%-13s|\n", (char) i," ", jumlahKarakter[i]);
            }
        }
        System.out.println("-".repeat(30));
        than.close();
    }
}
