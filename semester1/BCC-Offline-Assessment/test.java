import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        int n = than.nextInt();
        long bingung[] = new long[n];
        long simpen = 0;
        long count = 0;
        for (int i = 0; i < n; i++) {
            bingung[i] = than.nextInt();

        }
        for (int i = 1; i < n; i++) {
            while (bingung[i] < bingung[i - 1]) {
                simpen = bingung[i - 1] - bingung[i];
                bingung[i] += simpen;
                count += simpen;
            }
        }
        System.out.println(count);
    }
}
