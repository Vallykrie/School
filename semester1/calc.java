import java.util.Scanner;

public class calc {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        // Menu
        boolean calcBerjalan = true;
        while (calcBerjalan) {
            System.out.printf("%-30s\n", "=======Simple Kalkulator=======");
            System.out.printf("%-30s\n", "Pilih operasi yang diinginkan ");
            System.out.printf("%-30s\n", "1 untuk Penjumlahan");
            System.out.printf("%-30s\n", "2 untuk Pengurangan");
            System.out.printf("%-30s\n", "3 untuk Perkalian");
            System.out.printf("%-30s\n", "4 untuk Pembagian");
            System.out.printf("%-30s\n", "5 untuk Modulus");
            System.out.printf("%-30s\n", "6 untuk Exit");
            System.out.printf("%-30s\n", "===============================");

            // Reset
            double sum = 0;
            String num = " ";
            String modulo = " ";
            int sumModulo = 0;

            // Input
            int menu = than.nextInt();

            // Kalkulator
            boolean calc = true;
            switch (menu) {
                case 1: // Penjumlahan
                    while (calc) {

                        System.out.printf("%-30s\n", "===============================");
                        System.out.printf("%-30s\n--->",
                                "Masukkan angka \nKetik exit untuk kembali\nKetik reset untuk ulang ");
                        num = than.next();
                        if (num.equalsIgnoreCase("exit")) {
                            calc = false;
                            break;
                        }
                        if (num.equalsIgnoreCase("reset")) {
                            sum = 0;
                        }
                        sum += Double.parseDouble(num);
                        System.out.printf("%s %.2f\n", "Hasil penjumlahan --> ", sum);
                    }
                    break;
                case 2: // Pengurangan
                    System.out.printf("%-30s\n", "===============================");
                    System.out.printf("%-30s: \n", "Masukkan angka pertama ");
                    sum = than.nextDouble();

                    while (calc) {

                        System.out.printf("%-30s\n", "===============================");
                        System.out.printf("%-30s: ", "Masukkan angka \nKetik exit untuk kembali \n");
                        num = than.next();
                        if (num.equalsIgnoreCase("exit")) {
                            calc = false;
                            break;
                        }
                        sum -= Double.parseDouble(num);
                        System.out.printf("%s %.2f\n", "Hasil pengurangan --> ", sum);
                    }
                    break;
                case 3: // Perkalian
                    System.out.printf("%-30s\n", "===============================");
                    System.out.printf("%-30s: \n", "Masukkan angka pertama ");
                    sum = than.nextDouble();

                    while (calc) {

                        System.out.printf("%-30s\n", "===============================");
                        System.out.printf("%-30s: ", "Masukkan angka \nKetik exit untuk kembali \n");
                        num = than.next();
                        if (num.equalsIgnoreCase("exit")) {
                            calc = false;
                            break;
                        }
                        sum *= Double.parseDouble(num);
                        System.out.printf("%s %.2f\n", "Hasil perkalian --> ", sum);
                    }
                    break;
                case 4: // Pembagian
                    System.out.printf("%-30s\n", "===============================");
                    System.out.printf("%-30s: \n", "Masukkan angka pertama ");
                    sum = than.nextDouble();
                    while (calc) {

                        System.out.printf("%-30s\n", "===============================");
                        System.out.printf("%-30s: ", "Masukkan angka \nKetik exit untuk kembali \n");
                        num = than.next();
                        if (num.equalsIgnoreCase("exit")) {
                            calc = false;
                            break;
                        }
                        sum /= Double.parseDouble(num);
                        System.out.printf("%s %.2f\n", "Hasil pembagian --> ", sum);
                    }
                    break;
                case 5: // Modulus
                    System.out.printf("%-30s\n", "===============================");
                    System.out.printf("%-30s: \n", "Masukkan angka pertama ");
                    sumModulo = than.nextInt();
                    while (calc) {

                        System.out.printf("%-30s\n", "===============================");
                        System.out.printf("%-30s: ", "Masukkan angka \nKetik exit untuk kembali \n");
                        modulo = than.next();
                        if (modulo.equalsIgnoreCase("exit")) {
                            calc = false;
                            break;
                        }
                        if (modulo == "0") {
                            System.out.println("404 ERROR\nMODULO BY 0");
                        } else {
                            sumModulo %= Integer.parseInt(modulo);
                        }
                        System.out.printf("%s %d\n", "Hasil modulo --> ", sumModulo);
                    }
                    break;
                case 6: // Break
                    System.out.printf("%-30s\n", "===============================");
                    System.out.println("          bye-bye :D");
                    System.out.printf("%-30s\n", "===============================");
                    calcBerjalan = false;
                    break;
                default: // Else
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }
        }
    }
}
