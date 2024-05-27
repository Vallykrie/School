package Sorting;

import java.util.Random;

public class sorting {
    public static void main(String[] args) {

        // 50 data acak
        Random rndm = new Random(1);
        int[] data = new int[50];
        for (int i = 0; i < data.length; i++) {
            data[i] = rndm.nextInt();
        }

        System.out.println("Banyaknya iterasi bubblesort: " + bubblesort(data));
        System.out.println("Banyaknya iterasi selectionsort: " + selectionsort(data));

    }

    public static int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[r];
        arr[r] = temp;
        return i + 1;
    }

    public static void quicksort(int[] arr, int l, int r) {
        if (l < r) {
            int p = partition(arr, l, r);
            quicksort(arr, l, p - 1);
            quicksort(arr, p + 1, r);
        }
    }

    public static void quicksort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    public static int bubblesort(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                count++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return count;
    }

    public static int selectionsort(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int minNumber = arr[i];
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                count++;
                if (arr[j] < minNumber) {
                    minNumber = arr[j];
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return count;
    }
}
