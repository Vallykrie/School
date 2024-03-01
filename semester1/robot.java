import java.util.Scanner;

public class robot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String bingung = scanner.nextLine();
        String jenisRobot = scanner.nextLine();
        String membuat = "";
        String robotApa = "";
        scanner.close();

        int a = bingung.charAt(0) % 64;
        int b = bingung.charAt(1) % 64;
        int c = bingung.charAt(2) % 64;
        int d = bingung.charAt(3) % 64;
        int e = bingung.charAt(4) % 64;
        int f = bingung.charAt(5) % 64;

        if (a == b && b == c && c == d || f == e && e == d && d == c || b == c && c == d && d == e) {
            membuat = "Membuat robot ";
            // GAJAH
            if (a == b && b == c && c == d && e == f) {
                robotApa = "Gajah";
            }
            if (a == b && f == e && e == d && d == c) {
                robotApa = "Gajah";
            }
            if (a == f && b == c && c == d && d == e) {
                robotApa = "Gajah";
            }
            // BERUANG
            if (a == b && b == c && c == d && e > f) {
                robotApa = "Beruang";
            }
            if (a == b && b == c && c == d && e < f) {
                robotApa = "Beruang";
            }
            if (a < b && f == e && e == d && d < c) {
                robotApa = "Beruang";
            }
            if (a > b && f == e && e == d && d == c) {
                robotApa = "Beruang";
            }
            if (a < f && b == c && c == d && d == e) {
                robotApa = "Beruang";
            }
            if (a > f && b == c && c == d && d == e) {
                robotApa = "Beruang";
            }
            // JERAPAH
            if (a == b && b == c && c == d && e * 2 == f) {
                robotApa = "Jerapah";
            }
            if (a == b && b == c && c == d && f * 2 == e) {
                robotApa = "Jerapah";
            }
            if (a * 2 == b && f == e && e == d && d == c) {
                robotApa = "Jerapah";
            }
            if (b * 2 == a && f == e && e == d && d == c) {
                robotApa = "Jerapah";
            }
            if (a * 2 == f && b == c && c == d && d == e) {
                robotApa = "Jerapah";
            }
            if (f * 2 == a && b == c && c == d && d == e) {
                robotApa = "Jerapah";
            }
        } else
            membuat = "Tidak dapat membuat robot";
        if (jenisRobot.equals(robotApa)) {
            System.out.println("Yey, dapat membuat robot " + jenisRobot);
        } else
            System.out.println("Yah, tidak dapat membuat robot " + jenisRobot);
        System.out.println(membuat + robotApa);
    }
}