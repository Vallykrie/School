package OOP.Praktikum.polymorfisme;

public class MainKue {
    public static void main(String[] args) {
        // Random generator
        String[] nama = { "Croissant", "Donut", "Eclair", "Fruitcake", "Gingerbread", "Honeycake", "Jellyroll",
                "Kolache", "Lemonbar", "Madeleine" };
        double[] harga = { 10, 20, 25, 5, 15, 7, 23, 17, 27, 13 };
        int[] jumlah = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        Kue[] kue = new Kue[20];
        for (int i = 0; i < 20; i++) {
            int random = Math.toIntExact(Math.round(Math.random() * 9));
            if (random % 2 == 0) {
                kue[i] = new KuePesanan(nama[random], harga[random], jumlah[random]);
            } else {
                kue[i] = new KueJadi(nama[random], harga[random], jumlah[random]);
            }
        }

        double sum = 0;
        double sumJadi = 0;
        double sumPesanan = 0;
        int sumJumlah = 0;
        int sumBerat = 0;
        for (int i = 0; i < 20; i++) {
            System.out.println(i + 1 + ".");
            System.out.println(kue[i]);
            System.out.println("Jenis kue: " + kue[i].getClass().getSimpleName());
            System.out.println();

            sum += kue[i].hitungHarga();
            if (kue[i].getClass().getSimpleName().equals("KueJadi")) {
                sumJumlah += ((KueJadi) kue[i]).getJumlah();
                sumJadi += kue[i].hitungHarga();
            } else {
                sumBerat += ((KuePesanan) kue[i]).getBerat();
                sumPesanan += kue[i].hitungHarga();
            }

        }

        System.out.println("Total harga: $" + sum);
        System.out.println("-".repeat(30));
        System.out.println("Total harga KueJadi: $" + sumJadi);
        System.out.println("Total jumlah KueJadi: " + sumJumlah);
        System.out.println("-".repeat(30));
        System.out.println("Total harga KuePesanan: $" + sumPesanan);
        System.out.println("Total berat KuePesanan: " + sumBerat);
        System.out.println("-".repeat(30));

    }
}
