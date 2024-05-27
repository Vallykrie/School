package Searching;

public class nathan_051_11_2 {
    public static void main(String[] args) {
        java.util.Scanner than = new java.util.Scanner(System.in);
        int n1 = than.nextInt();
        int[] input = new int[n1];
        for (int i = 0; i < n1; i++) {
            input[i] = than.nextInt();
        }
        than.nextLine();
        int n2 = than.nextInt();
        int[] cari = new int[n2];
        for (int i = 0; i < n2; i++) {
            cari[i] = than.nextInt();
        }

        input = bubblesort(input);
        System.out.println(java.util.Arrays.toString(input));
        // System.out.print("[");
        // for (int i = 0; i < cari.length; i++) {
        //     System.out.print(input[i] + (i == cari.length - 1 ? "" : ", "));
        // }
        // System.out.print("]");
        for (int i = 0; i < n2; i++) {
            int tmp = linearSearch(input, cari[i]);
            System.out.println("Ukuran sepatu " + cari[i] + (tmp==-1?" tidak ditemukan dalam rak ":" ditemukan pada rak posisi " + (tmp)));
        }

    }

    public static int[] bubblesort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static int linearSearch(int[] arr, int data) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == data) {
                return i;
            }
        }
        return -1;
    }
}
