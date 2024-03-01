import java.util.Scanner;

public class Bunga {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        int N = than.nextInt();
        int M = than.nextInt();
        than.nextLine();
        int[][] peta = new int[N][M];

        for (int i = 0; i < N; i++) {
            String kumpulinDulu = than.nextLine();
            for (int j = 0; j < M; j++) {
                if (kumpulinDulu.charAt(j) == 'S') {
                    peta[i][j] = -9;
                } else
                    peta[i][j] = Integer.parseInt(kumpulinDulu.substring(j, j + 1));
            }
        }
        int[][] bunga = new int[N][M];
        bunga[N - 1][0] = peta[N - 1][0];
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < M; j++) {
                if ((i == N - 1 && j == 0)) {
                    continue;
                } else if (i < N - 1 && j > 0) {
                    bunga[i][j] = Math.max(bunga[i + 1][j], bunga[i][j - 1]) + peta[i][j];
                } else if (i < N - 1) {
                    bunga[i][j] = bunga[i + 1][j] + peta[i][j];
                } else if (j > 0) {
                    bunga[i][j] = bunga[i][j - 1] + peta[i][j];
                }

            }
        }

        System.out.println(bunga[0][M -1]);

        than.close();
    }
}
