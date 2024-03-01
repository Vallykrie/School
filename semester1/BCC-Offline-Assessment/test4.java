import java.util.Scanner;

public class test4 {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        int N = than.nextInt();
        than.nextLine();
        String radar[] = new String [N];
        int countFish = 0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            radar[i] = than.nextLine();
        } 
        
        int pertanyaan = than.nextInt();
        than.nextLine();
        for (int i = 0; i < pertanyaan; i++) {
            int N2 = than.nextInt();
            countFish = 0;
            count = 0;
            for (int j = 0; j < N2; j++) {
                for (int k = 0; k < N2; k++) {
                    if (radar[j].charAt(k)=='.') {
                        count++;
                    }
                }
            }
            countFish += N2*N2 - count;
            System.out.println(countFish);
        }

    }
}