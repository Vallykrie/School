import java.util.Scanner;

public class HahSegitiga {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        double x = than.nextDouble();
        double y = than.nextDouble();
        double z = than.nextDouble();

        boolean siku = false;
        boolean sisi = false;
        boolean kaki = false;

        double max = Math.max(x, Math.max(y, z));
        if (max == x) {
            siku = (x * x == y * y + z * z);
        } else if (max == y) {
            siku = (y * y == x * x + z * z);
        } else {
            siku = (z * z == x * x + y * y);
        }
        sisi = (x == y && y == z);
        kaki = (x == y || y == z || x == z);

        if (siku == true) {
            System.out.println("Segitiga siku-siku");
        } else if (sisi == true) {
            System.out.println("Segitiga sama sisi");
        } else if (kaki == true) {
            System.out.println("Segitiga sama kaki");
        } else {
            System.out.println("Segitiga sembarang");
        }
    }
}
