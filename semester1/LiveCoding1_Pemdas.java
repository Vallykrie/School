import java.util.Scanner;

public class LiveCoding1_Pemdas {
    public static void main(String[] args) {

        // Input
        Scanner than = new Scanner(System.in);
        String nama = than.nextLine();
        int jam = than.nextInt();
        int menit = than.nextInt();
        String a = than.next();
        long a$ = than.nextLong();
        long aQ = than.nextLong();
        String b = than.next();
        long b$ = than.nextLong();
        long bQ = than.nextLong();
        String c = than.next();
        long c$ = than.nextLong();
        long cQ = than.nextLong();
        String d = than.next();
        long d$ = than.nextLong();
        long dQ = than.nextLong();
        int waktu = than.nextInt();

        // Perhitungan
        long sum$ = a$ * aQ + b$ * bQ + c$ * cQ + d$ * dQ;
        double yen = sum$ / 103.0;
        int w = menit + waktu;
        int jamDon = ((jam * 60) + w) / 60;
        int menitDon = w % 60;
        jamDon %= 25;

        // Output
        System.out.printf("====================================================================");
        System.out.printf("\n");
        System.out.printf("%68s\n", "KATSU GKM FILKOM UB");
        System.out.printf("%68s\n", "Pemesan : " + nama);
        System.out.printf("%68s\n", "Jam : " + jam + " Menit : " + menit);
        System.out.printf("\n");
        System.out.printf("%-3s| %-25s | %-15s | %-15s |\n", "No.", "Nama Makanan", "Kuantitas", "Harga");
        System.out.printf("%-3s| %-25s | %-15s | %-15s |\n", "1.", a, aQ, a$);
        System.out.printf("%-3s| %-25s | %-15s | %-15s |\n", "2.", b, bQ, b$);
        System.out.printf("%-3s| %-25s | %-15s | %-15s |\n", "3.", c, cQ, c$);
        System.out.printf("%-3s| %-25s | %-15s | %-15s |\n", "4.", d, dQ, d$);
        System.out.printf("\n");
        System.out.printf("%49s| %-15s\n", "Total Harga", "Rp. " + sum$);
        System.out.printf("%49s| %.2f Yen\n", "Konversi Yen", yen);
        System.out.printf("\n");
        System.out.printf("%68s\n", "Jam : " + jamDon + " Menit : " + menitDon);

        System.out.printf("====================================================================");
        than.close();
    }
}
