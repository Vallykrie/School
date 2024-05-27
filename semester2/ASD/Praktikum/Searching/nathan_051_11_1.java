package Searching;

public class nathan_051_11_1 {
    public static void main(String[] args) {
        java.util.Scanner than = new java.util.Scanner(System.in);
        String input = than.nextLine();
        char cari = input.charAt(0);
        String[] data = than.nextLine().split(" ");
        save[] save = new save[data.length];
        for (int i = 0; i < data.length; i++) {
            char[] tmp = data[i].toCharArray();
            save[i] = new save(data[i], linearSearch(tmp, cari));
        }

        save = bubblesort(save);
        print(save);

    }

    public static int linearSearch(char[] arr, char data) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == data) {
                count++;
            }
        }
        return count;
    }

    public static save[] bubblesort(save[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].count > arr[j + 1].count) {
                    save temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void print(save[] arr) {
        System.out.println("Hasil Searching");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].name + " = " + arr[i].count);
        }
    }
}

class save{
    String name;
    int count;

    public save(String name, int count) {
        this.name = name;
        this.count = count;
    }
}
