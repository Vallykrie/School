import java.util.Scanner;

public class AngkaSegitiga {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        int count = than.nextInt();
        System.out.println("");
        int i = 0;
        int j = 0;
        int countZ = count;

        // CASE 1:
        for (i = 1; i <= count; i++) {
            for (j = 1; j <= i; j++) {
                System.out.print(j);

            }
            System.out.println("");
        }
        for (i = count - 1; i > 0; i--) {
            for (j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println("");
        }

        // DEVIDER
        System.out.println("");

        // CASE 2:
        for (i = 1; i <= count; i++) {
            for (j = count; j >= i + 1; j--) {
                System.out.print(" ");
            }
            for (j = 1; j <= i; j++) {
                System.out.print(j);
            }
            for (int k = j-2; k > 0; k--) {
                System.out.print(k);
            }
            System.out.println("");
        }

        // DEVIDER
        System.out.println("");

        // CASE 3:
        for (i = 1; i <= count; i++) {
            for (j = count; j >= i + 1; j--) {
                System.out.print(" ");
            }
            for (j = 1; j <= i; j++) {
                System.out.print(j);
            }
            for (int k = j-2; k > 0; k--) {
                System.out.print(k);
            }
            System.out.println("");
        }
        for (i = 1; i <= count-1; i++) {
            for (j = 0; j <= i - 1; j++) {
                System.out.print(" ");
            }
            for (j = 1; j < countZ; j++) {
                System.out.print(j);
            }
            countZ -= 1;
            for (int k = j-2; k > 0; k--) {
                System.out.print(k);
            }
            System.out.println("");
    
        }
        
    }

}
