import java.util.Scanner;

public class DataBarangPakOgah {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        int loop = than.nextInt();
        than.nextLine();
        String[] kodeBarang = new String[8];
        String[] namaBarang = new String[8];
        String[] kategori = new String[8];
        String[] harga = new String[8];
        String[] stock = new String[8];
        for (int i = 0; i < loop; i++) {
            kodeBarang[i] = than.nextLine();
            namaBarang[i] = than.nextLine();
            kategori[i] = than.nextLine();
            harga[i] = than.nextLine();
            stock[i] = than.nextLine();
        }
        for (int i = 0; i < loop; i++) {
            boolean hasKategoriPrinted = false;
            for (int j = 0; j < loop; j++) {
                if (hasKategoriPrinted && kategori[j].equalsIgnoreCase(kategori[i])
                        && kategori[j] != "JanganDiPrintLagiSayang") {
                    System.out.println("Kode Barang: " + kodeBarang[j]);
                    System.out.println("Nama Barang: " + namaBarang[j]);
                    System.out.println("Harga: Rp." + harga[j]);
                    System.out.println("Stok: " + stock[j] + " unit");
                    System.out.println();
                    kategori[j] = "JanganDiPrintLagiSayang";

                } else if (kategori[j].equalsIgnoreCase(kategori[i]) && kategori[j] != "JanganDiPrintLagiSayang") {
                    System.out.println("Berdasarkan kategori " + kategori[j] + ":");
                    System.out.println();
                    System.out.println("Kode Barang: " + kodeBarang[j]);
                    System.out.println("Nama Barang: " + namaBarang[j]);
                    System.out.println("Harga: Rp." + harga[j]);
                    System.out.println("Stok: " + stock[j] + " unit");
                    System.out.println();
                    hasKategoriPrinted = true;
                }

            }
        }

    }

}