import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        int N = than.nextInt();
        than.nextLine();
        String radar[] = new String [N];
        int countFish = 0;
        for (int i = 0; i < N; i++) {
            radar[i] = than.nextLine();
        } 
        
        int pertanyaan = than.nextInt();
        than.nextLine();
        for (int i = 0; i < pertanyaan; i++) {
            int N2 = than.nextInt();
            String radar2[] = new String [N2];
            countFish = 0;
            for (int j = 0; j < N2; j++) {
                radar2[j] = radar[j];
            }
            radar2.
            System.out.println(countFish);
        }

    }
}
