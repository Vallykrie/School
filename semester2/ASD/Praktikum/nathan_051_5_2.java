package Praktikum;

import java.util.Scanner;

public class nathan_051_5_2 {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        String kartu = than.nextLine();
        int shuffle = than.nextInt();
        String result = kartu;

        String a = kartu.substring(0, kartu.length() / 2);
        String b = kartu.substring(kartu.length() / 2, kartu.length());

        for (int i = 0; i < shuffle; i++) {
            result = "";
            for (int j = 0; j < a.length(); j++) {
                result += a.charAt(j);
                result += b.charAt(j);
            }
            a = result.substring(0, result.length() / 2);
            b = result.substring(result.length() / 2, result.length());
        }
        System.out.println(result);
    }
}
