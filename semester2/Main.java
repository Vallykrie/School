import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Data tim A
        int[] tinggiTimA = { 168, 170, 165, 168, 172, 170, 169, 165, 171, 166 };
        int[] beratTimA = { 50, 60, 56, 55, 60, 70, 66, 56, 72, 56 };

        // Data tim B
        int[] tinggiTimB = { 170, 167, 165, 166, 168, 175, 172, 171, 168, 169 };
        int[] beratTimB = { 66, 60, 59, 58, 58, 71, 68, 68, 65, 60 };

        // 1. Mencari data pemain di antara kedua tim
        // a. Yang mempunyai tinggi badan sama
        ArrayList<String> tinggiSama = new ArrayList<>();
        int countA = 0, countB = 0;
        for (int tinggiA : tinggiTimA) {
            countA++;
            countB = 0;
            for (int tinggiB : tinggiTimB) {
                countB++;
                if (tinggiA == tinggiB) {
                    tinggiSama.add("Tim A No. " + countA + " dan Tim B No. " + countB + "\n");
                }
            }
        }
        System.out.println(
                "a. Yang mempunyai tinggi badan sama: \n"
                        + tinggiSama.toString().replace("[", "").replace("]", "").replace(", ", ""));

        // b. Yang mempunyai berat badan sama
        ArrayList<String> beratSama = new ArrayList<>();
        for (int i = 0; i < beratTimA.length; i++) {
            for (int j = 0; j < beratTimB.length; j++) {
                if (beratTimA[i] == beratTimB[j]) {
                    beratSama.add("Tim A No. " + (i + 1) + " dan Tim B No. " + (j + 1) + "\n");
                }
            }
        }
        System.out.println("b. Yang mempunyai berat badan sama: \n"
                + beratSama.toString().replace("[", "").replace("]", "").replace(", ", ""));

        // c. Rentang nilai dari tinggi badan kedua tim
        int tinggiMin = Math.min(getMin(tinggiTimA), getMin(tinggiTimB));
        int tinggiMax = Math.max(getMax(tinggiTimA), getMax(tinggiTimB));
        System.out
                .println("c. Rentang nilai dari tinggi badan kedua tim: \n   " + tinggiMin + "cm - " + tinggiMax
                        + "cm\n");

        // d. Rentang nilai dari berat badan kedua tim
        int beratMinA = getMin(beratTimA);
        int beratMaxA = getMax(beratTimA);
        int beratMinB = getMin(beratTimB);
        int beratMaxB = getMax(beratTimB);
        System.out.println("d. Rentang nilai dari berat badan tim A: \n   " + beratMinA + "kg - " + beratMaxA + "kg");
        System.out.println("   Rentang nilai dari berat badan tim B: \n   " + beratMinB + "kg - " + beratMaxB + "kg\n");

        // e. Tinggi badan pada tim A yang tidak ada pada tim B
        ArrayList<Integer> tinggiTimAUnique = new ArrayList<>();
        for (int tinggi : tinggiTimA) {
            if (!contains(tinggiTimB, tinggi)) {
                tinggiTimAUnique.add(tinggi);
            }
        }
        System.out.println("e. Tinggi badan pada tim A yang tidak ada pada tim B: " + tinggiTimAUnique + "\n");

        // f. Berat badan pada tim B yang tidak ada pada tim A
        ArrayList<Integer> beratTimBUnique = new ArrayList<>();
        for (int berat : beratTimB) {
            if (!contains(beratTimA, berat)) {
                beratTimBUnique.add(berat);
            }
        }
        System.out.println("f. Berat badan pada tim B yang tidak ada pada tim A: " + beratTimBUnique + "\n");

        // 2. Implementasi Map
        // a) Map untuk menyimpan data tim A dan tim B
        Map<String, int[]> dataTimA = new HashMap<>();
        dataTimA.put("Tinggi", tinggiTimA);
        dataTimA.put("Berat", beratTimA);

        Map<String, int[]> dataTimB = new HashMap<>();
        dataTimB.put("Tinggi", tinggiTimB);
        dataTimB.put("Berat", beratTimB);

        // b) Update data Map untuk tim B
        // Kesalahan: Pemain dengan tinggi 168 memiliki berat 66
        dataTimB.get("Berat")[4] = 66;
        dataTimB.get("Berat")[8] = 66;

        // c) Implementasikan Map untuk menyimpan data tinggi badan dan berat badan
        // dari tim A yang tinggi badannya sama dengan tim B
        Map<String, ArrayList<Integer>> dataSama = new HashMap<>();
        ArrayList<Integer> tinggiSamaList = new ArrayList<>();
        ArrayList<Integer> beratSamaList = new ArrayList<>();
        for (int i = 0; i < tinggiTimA.length; i++) {
            if (contains(tinggiTimB, tinggiTimA[i])) {
                tinggiSamaList.add(tinggiTimA[i]);
                beratSamaList.add(beratTimA[i]);
            }
        }
        dataSama.put("Tinggi", tinggiSamaList);
        dataSama.put("Berat", beratSamaList);
        System.out.println("Data Map tinggi dan berat badan tim A yang sama dengan tim B: " + dataSama);

        // d) Update data Map sesuai kondisi terakhir
        // Pemain dengan tinggi badan kurang dari 168 dinyatakan dikeluarkan dari tim
        ArrayList<Integer> tinggiTimAFiltered = new ArrayList<>();
        ArrayList<Integer> beratTimAFiltered = new ArrayList<>();
        for (int i = 0; i < tinggiSamaList.size(); i++) {
            if (tinggiSamaList.get(i) >= 168) {
                tinggiTimAFiltered.add(tinggiSamaList.get(i));
                beratTimAFiltered.add(beratSamaList.get(i));
            }
        }
        dataSama.put("Tinggi", tinggiTimAFiltered);
        dataSama.put("Berat", beratTimAFiltered);
        System.out.println("Data Map tinggi dan berat badan tim A yang tinggi badannya >= 168: " + dataSama);
    }

    private static int getMin(int[] array) {
        int min = array[0];
        for (int value : array) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    private static int getMax(int[] array) {
        int max = array[0];
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    private static boolean contains(int[] array, int value) {
        for (int i : array) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }
}
