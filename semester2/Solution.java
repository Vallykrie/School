import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        LinkedList listKTM = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String process = input.replaceAll(" ", ", ");
            listKTM.add(process);
        }

        for (int i = 0; i < m; i++) {
            System.out.println(listKTM.get(i));
        }

        scanner.close();
    }
}