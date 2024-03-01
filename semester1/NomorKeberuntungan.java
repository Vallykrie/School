import java.util.Scanner;

public class NomorKeberuntungan {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        int a = than.nextInt();
        int b = than.nextInt();
        int c = than.nextInt();

        int min = Math.min(Math.min(a, b), c);
        int max = Math.max(Math.max(a, b), c);
        int d = max - min;

        System.out.println("Terbesar " + max);
        System.out.println("Terkecil " + min);
        System.out.println("Selisih " + max + " - " + min + " = " + d);

        String dibagi = "";
        if (d % 2 == 0)
            dibagi += "2 ";
        if (d % 3 == 0)
            dibagi += "3 ";
        if (d % 5 == 0)
            dibagi += "5 ";
        if (d % 7 == 0)
            dibagi += "7 ";
        if (d % 11 == 0)
            dibagi += "11 ";

        if (dibagi.isEmpty()) {
            System.out.println("Tidak ada");
        } else {
            System.out.println("Habis dibagi " + dibagi);
        }

        if (dibagi.equals("2 3 5 7 11 ") || (dibagi.equals(""))) {
            System.out.println("Jackpot!!!");
        } else {
            System.out.println("Belum hoki!");
        }
    }
}
