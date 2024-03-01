import java.util.Scanner;

public class testSerius {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        String inputText = than.nextLine();
        if (inputText.length() < 0 && inputText.length() < 2) {
            System.out.println(inputText);
        }
        String result = acakDongKak(inputText);
        System.out.println(result);

    }

    public static String acakDongKak(String inputText) {
        String tumpukanPertama = "";
        String tumpukanKedua = "";

        if (inputText.length() < 2) {
            return inputText;
        } else if (inputText.length() % 2 == 0) {
            tumpukanPertama = inputText.substring(0, inputText.length() / 2);
            tumpukanKedua = inputText.substring(inputText.length() / 2);
        } else {
            tumpukanPertama = inputText.substring(0, (inputText.length() / 2) + 1);
            tumpukanKedua = inputText.substring((inputText.length() / 2) + 1);
        }
        String acakDongPertama = acakDongKak(tumpukanPertama);
        String acakDongKedua = acakDongKak(tumpukanKedua);

        StringBuilder nath = new StringBuilder();
        int i = 0;
        int j = 0;
        for (i = 0, j = 0; i < acakDongPertama.length() && j < acakDongKedua.length(); i++, j++) {
            nath.append(acakDongPertama.charAt(i));
            nath.append(acakDongKedua.charAt(j));
        }
        nath.append(acakDongPertama.substring(i));
        nath.append(acakDongKedua.substring(j));
        return nath.toString();
    }
}