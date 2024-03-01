import java.util.Scanner;

public class MatrixPrak {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);

        // Input
        System.out.print("Enter the size of the squere matrix: ");
        int input = than.nextInt();
        than.nextLine();
        int[][] matriks1 = new int[input][input];
        int[][] matriks2 = new int[input][input];

        // Matrix 1
        System.out.println("Matrix 1:");
        for (int i = 0; i < input; i++) {
            String BiarApaGadikasiSpasi = than.nextLine();
            for (int j = 0; j < input; j++) {
                matriks1[i][j] = Integer.parseInt(BiarApaGadikasiSpasi.substring(j, j + 1));
            }
        }

        // Matrix 2
        System.out.println("Matrix 2:");
        for (int i = 0; i < input; i++) {
            String BiarApaGadikasiSpasi = than.nextLine();
            for (int j = 0; j < input; j++) {
                matriks2[i][j] = Integer.parseInt(BiarApaGadikasiSpasi.substring(j, j + 1));
            }
        }

        // Calculations
        int[][] hasilPerkalian = new int[input][input];
        for (int i = 0; i < input; i++) {
            for (int j = 0; j < input; j++) {
                for (int k = 0; k < input; k++) {
                    hasilPerkalian[i][j] += matriks1[i][k] * matriks2[k][j];
                }
            }
        }

        // Output
        System.out.println("Matrix Multiplication Result: ");
        for (int i = 0; i < input; i++) {
            for (int j = 0; j < input; j++) {
                System.out.print(hasilPerkalian[i][j] + " ");
            }
            System.out.println();
        }

        than.close();
    }
}
