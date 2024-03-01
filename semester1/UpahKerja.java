import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;

public class UpahKerja {
    public static void main(String[] args) {
        // Format & Scanner
        Scanner than = new Scanner(System.in);
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("Rp#,###.00", symbols);
        String seperator = "=".repeat(47);
        String seperator2 = "-".repeat(47);
        
        // INPUT
        System.out.printf("%47s\n", "=========Program penghitung upah kerja=========");
        System.out.println("Rules: ");
        System.out.println("1. Upah kerja berjumlah Rp50.000,-/jam");
        System.out.println("2. Kerja lebih dari 60 jam dianggap lembur.");
        System.out.println("3. Kerja kurang dari 50 jam terkena denda.");
        System.out.println("4. Upah lembur berjumlah Rp60.000,-/jam.");
        System.out.println("5. Denda kerja berjumlah Rp10.000,-/jam.");
        System.out.println(seperator);
        System.out.print("Masukkan jumlah jam kerja\t: ");
        int jamKerja = than.nextInt();
        System.out.println(seperator);

        // Calculation & OUTPUT
        double lembur = 0;
        double denda = 0;
        double upah = 0;
        double sisa = 0;
        if (jamKerja > 60) {
            sisa = jamKerja - 60;
            upah = (jamKerja - sisa) * 50000;
        } else {
            upah = jamKerja * 50000;
        }
        System.out.printf("%-15s: %30s\n", "Upah", df.format(upah));
        if (jamKerja > 60) {
            lembur = sisa * 60000.0;
            System.out.printf("%-15s: %30s\n", "Lembur", df.format(lembur));
        } else {
            String tidakLembur = "Tidak ada lembur";
            System.out.printf("%-15s: %30s\n", "Lembur", tidakLembur);
        }
        if (jamKerja < 50) {
            denda = (50 - jamKerja) * 10000.0;
            System.out.printf("%-15s: %30s\n", "Denda", df.format(denda));
        } else {
            String tidakDenda = "Tidak ada denda";
            System.out.printf("%-15s: %30s\n", "Denda", tidakDenda);
        }

        // Total OUTPUT
        double total = upah + lembur - denda;
        System.out.println(seperator2);
        if (total < 0) {
            System.out.printf("%-15s: %30s\n", "Total", "Membayar " + df.format(-total));
        } else {
            System.out.printf("%-15s: %30s\n", "Total", df.format(total));
        }
        than.close();
    }
}
