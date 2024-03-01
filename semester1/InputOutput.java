import java.util.Scanner;

public class InputOutput {
    public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in)) {
            // sc merupakan variable yang dapat dirubah
            int angkaInt = in.nextInt();
            in.nextLine();
            String kalimat = in.nextLine();
            String kata = in.next();
            char huruf = in.next().charAt(0);
            in.nextLine();

            System.out.println(" Angka int adalah " + angkaInt);
            System.out.println(kalimat);
            System.out.println(kata);
            System.out.println(huruf);
        }
    }
}
