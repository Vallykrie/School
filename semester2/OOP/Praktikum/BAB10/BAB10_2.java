import java.util.ArrayList;
import java.util.Collections;

public class BAB10_2 {
    public static void main(String[] args) {
        ArrayList<Integer> arlTinggiBadanA = new ArrayList<>();
        ArrayList<Integer> arlBeratBadanA = new ArrayList<>();
        ArrayList<Integer> arlTinggiBadanB = new ArrayList<>();
        ArrayList<Integer> arlBeratBadanB = new ArrayList<>();

        int arrTinggiBadanA[] = { 168, 170, 165, 168, 172, 170, 169, 165, 171, 166 };
        int arrBeratBadanA[] = { 50, 60, 56, 55, 60, 70, 66, 56, 72, 56 };
        int arrTinggiBadanB[] = { 170, 167, 165, 166, 168, 175, 172, 171, 168, 169 };
        int arrBeratBadanB[] = { 66, 60, 59, 58, 58, 71, 68, 68, 65, 60 };

        // a) Implementasikan ArrayList untuk menyimpan data tim A dan tim B dalam
        // bentuk ArrayList terpisah.
        for (int i = 0; i < arrTinggiBadanA.length; i++) {
            arlTinggiBadanA.add(arrTinggiBadanA[i]);
            arlBeratBadanA.add(arrBeratBadanA[i]);
            arlTinggiBadanB.add(arrTinggiBadanB[i]);
            arlBeratBadanB.add(arrBeratBadanB[i]);
        }
        Collections.sort(arlTinggiBadanA);
        Collections.sort(arlBeratBadanA);
        Collections.sort(arlTinggiBadanB);
        Collections.sort(arlBeratBadanB);

        // b) Dari data tim B, dicari jumlah pemain yang mempunyai tinggi badan 168 cm
        // dan 160 cm.
        int countTinggiBadanB = Collections.frequency(arlTinggiBadanB, 168)
                + Collections.frequency(arlTinggiBadanB, 160);

        // c) Dari data tim A, dicari jumlah pemain yang mempunyai berat badan 56 kg dan
        // 53 kg.
        int countBeratBadanA = Collections.frequency(arlBeratBadanA, 56) + Collections.frequency(arlBeratBadanA, 53);

        // d) Ingin diketahui apakah pemain di Tim A ada yang mempunyai tinggi badan
        // atau berat badan yang sama dengan pemain di Tim B?
        boolean isSame = false;
        for (int i = 0; i < arlTinggiBadanA.size(); i++) {
            if (Collections.binarySearch(arlTinggiBadanB, arlTinggiBadanA.get(i)) >= 0
                    || Collections.binarySearch(arlBeratBadanB, arlBeratBadanA.get(i)) >= 0) {
                isSame = true;
                break;
            }
        }

        // Jawaban:
        System.out.println(
                "a) Implementasikan ArrayList untuk menyimpan data tim A dan tim B dalam bentuk ArrayList terpisah.");
        System.out.print("b) Dari data tim B, jumlah pemain yang mempunyai tinggi badan 168 cm dan 160 cm adalah: ");
        System.out.println(countTinggiBadanB);
        System.out.print("c) Dari data tim A, jumlah pemain yang mempunyai berat badan 56 kg dan 53 kg adalah: ");
        System.out.println(countBeratBadanA);
        System.out.print(
                "d) Ingin diketahui apakah pemain di Tim A ada yang mempunyai tinggi badan atau berat badan yang sama dengan pemain di Tim B? ");
        System.out.println(isSame ? "Ada" : "Tidak Ada");

    }
}
