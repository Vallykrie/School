package Prima;


import java.util.Scanner;

public class BilanganPrima {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        System.out.print("Tampilkan semua bilangan prima antara 3 - ");
        int a = than.nextInt();
        String prime = "";

        for (int i = 3; i <= a; i++) {
            boolean isPrime = true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                prime += String.valueOf(i) + " ";
            }
        }

        System.out.println(prime);
        than.close();
    }
}
