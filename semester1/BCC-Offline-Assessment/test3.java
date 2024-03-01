import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        int N = than.nextInt();
        than.nextLine();
        String radar[] = new String [N];
        long countFish = 0;
        for (int i = 0; i < N; i++) {
            radar[i] = than.nextLine();
        } 
        
        int pertanyaan = than.nextInt();
        than.nextLine();
        for (int i = 0; i < pertanyaan; i++) {
            int N2 = than.nextInt();
            countFish = countFish(radar, N2);
            // for (int j = 0; j < N2; j++) {
            //     for (int k = 0; k < N2; k++) {
            //         if (radar[j].charAt(k)=='*') {
            //             countFish++;
            //         }
            //     }
            // }
            System.out.println(countFish);
        }

    }
    static long countFish (String radar[], int area){
        int countFish = 0;
        for (int j = 0; j < area; j++) {
            for (int k = 0; k < area; k++) {
                if (radar[j].charAt(k)=='*') {
                    countFish++;
                }
            }
        }
        return countFish;
    }
}
