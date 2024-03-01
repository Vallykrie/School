import java.util.Scanner;

public class dsurubuat {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        boolean isRunning = true;
        int sum = 0;
        double luasLingkaran = 0;

        while (isRunning) {
            System.out.println("1. Menghitung luas lingkaran");
            System.out.println("2. Menjumlahkan n buah bilangan");
            System.out.println("0. Keluar");
            String pilihan = than.nextLine();

            sum = 0;
            luasLingkaran = 0;
            
            switch (pilihan) {
                case "1":
                    System.out.print("Masukkan jari jari: ");
                    double jariJari = than.nextInt();
                    than.nextLine();
                    luasLingkaran = jariJari*jariJari*Math.PI;
                    System.out.println("Luas lingkaran: " + luasLingkaran);
                    
                    break;
                case "2":
                    System.out.print("Berapa jumlah angka yang ingin dihitung: ");
                    int n = than.nextInt();
                    for (int i = 1; i <= n; i++) {
                        System.out.print("Masukkan angka: ");
                        int angka = than.nextInt();
                        than.nextLine();
                        sum += angka;
                    }
                    System.out.println("Hasil: " + sum);
                    
                    break;
                case "0":
                    isRunning = false;
                    
                    break;
            
                default:
                System.out.println("Pilihan tidak valid");
                    break;
            }
        }
        than.close();   
    }
}
