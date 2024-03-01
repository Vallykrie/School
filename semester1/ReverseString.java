import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        String str = than.nextLine();
        for (int i = str.length() - 1; i >= 0; i--) {
            System.out.print(str.charAt(i));
        }
        than.close();
    }
}