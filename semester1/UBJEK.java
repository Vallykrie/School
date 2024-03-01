import java.util.Scanner;

public class UBJEK {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        float x1 = than.nextFloat();
        than.nextLine();
        float y1 = than.nextFloat();
        than.nextLine();
        float x2 = than.nextFloat();
        than.nextLine();
        float y2 = than.nextFloat();
        than.nextLine();
        float x3 = than.nextFloat();
        than.nextLine();
        float y3 = than.nextFloat();
        than.nextLine();
        String layanan = than.nextLine();
        if (layanan.equals("UBFOOD")) {
            float hargaBarang = than.nextFloat();
            // than.nextLine();
            float beratBarang = than.nextFloat();
            // than.nextLine();
            double driverToPelanggan = Math.sqrt(((x3 - x1) * (x3 - x1)) + ((y3 - y1) * (y3 - y1)));
            double pelangganToTujuan = Math.sqrt(((x2 - x3) * (x2 - x3)) + ((y2 - y3) * (y2 - y3)));
            double jarak = driverToPelanggan + pelangganToTujuan;
            double biaya = Math.ceil(beratBarang) * 10000 + pelangganToTujuan * 2000 + hargaBarang;
            System.out.printf("%s%.2f%s%.0f", "Jarak yang ditempuh oleh driver adalah ", jarak,
                    " KM dan biaya yang didapatkan oleh driver sejumlah Rp", biaya);
        }
        if (layanan.equals("UBJEK")) {
            double driverToPelanggan = Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)));
            double pelangganToTujuan = Math.sqrt(((x3 - x2) * (x3 - x2)) + ((y3 - y2) * (y3 - y2)));
            double jarak = driverToPelanggan + pelangganToTujuan;
            if (pelangganToTujuan > 10) {
                double sisaJarak = pelangganToTujuan - 10;
                // double biaya = (sisaJarak * 5000)*0.2 + 10 * 5000;
                double biaya = (pelangganToTujuan * 5000)*1.2;
                System.out.printf("%s%.2f%s%.0f", "Jarak yang ditempuh oleh driver adalah ", jarak,
                    " KM dan biaya yang didapatkan oleh driver sejumlah Rp", biaya);
            }
            else {
                double biaya = pelangganToTujuan * 5000;  
                System.out.printf("%s%.2f%s%.0f", "Jarak yang ditempuh oleh driver adalah ", jarak,
                        " KM dan biaya yang didapatkan oleh driver sejumlah Rp", biaya);
            } 
        }
        than.close();

    }

}
