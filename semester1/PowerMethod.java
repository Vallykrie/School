import java.util.Scanner;

public class PowerMethod {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        System.out.print("Masukkan angka a: ");
        int a = than.nextInt();
        System.out.print("Masukkan angka b: ");
        int b = than.nextInt();
        System.out.println("a pangkat b adalah: " + power(a, b));
        than.close();
    }

    public static long power(int a, int b) {
        if (b == 0) {
            return 1;
        } else {
            long result = power(a, b / 2) % 1000000007;
            result = (result * result) % 1000000007;
    
            if (b % 2 == 1) {
                result = (result * a) % 1000000007;
            }
    
            return result;
        }
    }
    

}
