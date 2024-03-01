import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);

        // input
        System.out.print("Masukkan angka n: ");
        int n = than.nextInt();
        than.close();

        // Deret Fibonacci
        long n1 = 0;
        long n2 = 1;


        for (int i = 1; i <= n; i++) {
            System.out.print(n1 + " ");

            // Fibonacci rule
            long n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
    }
}
