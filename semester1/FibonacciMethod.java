import java.util.Scanner;

public class FibonacciMethod {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        System.out.print("Masukkan angka n: ");
        int a = than.nextInt();
        int b = fib(a);
        System.out.println(b);
        than.close();
    }

    public static int fib (int n){
        if (n==0 || n==1) {
            return 1;
        } else {
            return fib(n-1) + fib(n-2);
        }
    }

}
