import java.util.Scanner;

public class promo1010 {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        int a = than.nextByte();
        int ks = than.nextByte();
        int kv = than.nextByte();
        int c = than.nextByte();
        int mr = than.nextByte();

        double hargaA = a * 20000;
        double hargaKS = ks * 28000;
        double hargaKV = kv * 23000;
        double hargaC = c * 31000;
        double hargaMR = mr * 35000;

        double diskonA = 0;
        double diskonKS = 0;
        double diskonKV = 0;
        double diskonMR = 0;
        double diskonTotal = 0;

        boolean q = a > 3;
        boolean w = ks > 2;
        boolean e = kv > 4;
        boolean r = mr > 2;
        
        if (q) diskonA = hargaA * 0.05;
        if (w) diskonKS = hargaKS * 0.08;
        if (e) diskonKV = hargaKV * 0.12;
        if (r) diskonMR = 10000;
        double total = (hargaA - diskonA) + (hargaKS - diskonKS) + (hargaKV - diskonKV) + hargaC + (hargaMR - diskonMR);
        if (total > 250000) {
            diskonTotal = total * 0.1;
        }

        System.out.printf("Harga total americano    : Rp%.1f\n", hargaA - diskonA);
        System.out.printf("Harga total kopi susu    : Rp%.1f\n", hargaKS - diskonKS);
        System.out.printf("Harga total kopi vietnam : Rp%.1f\n", hargaKV - diskonKV);
        System.out.printf("Harga total cappucino    : Rp%.1f\n", hargaC);
        System.out.printf("Harga total mocha rum    : Rp%.1f\n", hargaMR - diskonMR);
        System.out.printf("=====================================\n");
        System.out.printf("Total harga pesanan      : Rp%.1f\n", total);
        System.out.printf("Harga yang harus dibayar : Rp%.1f\n", total - diskonTotal);

    }
}
