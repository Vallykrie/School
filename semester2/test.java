import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class test {

    public static void main(String[] args) {

        Scanner than = new Scanner(System.in);
        int input = than.nextInt();
        than.nextLine();
        for (int i = 0; i < input; i++) {
            String nama = than.nextLine();
            int umur = than.nextInt();
            than.nextLine();
            String NIK = than.nextLine();
            int jumlah = than.nextInt();
            if (than.hasNextLine()) {
                than.nextLine();
            }

            double disc = 1;
            if (jumlah > 10) {
                disc = 0.65;
            } else if (jumlah > 5) {
                disc = 0.8;
            } else if (jumlah > 2) {
                disc = 0.9;
            }
            print(nama, umur, NIK, jumlah, disc);
        }
        System.out.println("--------------------------------------------------");
    }

    static void print(String nama, int umur, String NIK, int jumlah, double disc) {
        // Price Formats
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("Rp#,###.00", symbols);

        if (disc == 1) {
            System.out.println("--------------------------------------------------");
            System.out.println("Nama Tamu: " + nama);
            System.out.println("Harga Asli: " + df.format(jumlah * 500_000));
            System.out.println("Tidak mendapatkan diskon");
            System.out.println("Total Tagihan: " + df.format(jumlah * 500_000));
        } else {
            System.out.println("--------------------------------------------------");
            System.out.println("Nama Tamu: " + nama);
            System.out.println("Harga Asli: " + df.format(jumlah * 500_000));
            if (disc == 0.65) {
                System.out.println("Diskon Diterima: 35%");
            } else if (disc == 0.8) {
                System.out.println("Diskon Diterima: 20%");
            } else if (disc == 0.9) {
                System.out.println("Diskon Diterima: 10%");
            }
            System.out.println("Potongan Harga: " + df.format((jumlah * 500_000) * (1 - disc)));
            System.out.println("Total Tagihan: " + df.format((jumlah * 500_000) * disc));

        }
    }
}