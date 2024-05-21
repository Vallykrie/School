/**
 * No Tim A Tim B
 * Tinggi Badan (cm) Berat Badan (kg) Tinggi Badan (cm) Berat Badan (kg)
 * 1 168 50 170 66
 * 2 170 60 167 60
 * 3 165 56 165 59
 * 4 168 55 166 58
 * 5 172 60 168 58
 * 6 170 70 175 71
 * 7 169 66 172 68
 * 8 165 56 171 68
 * 9 171 72 168 65
 * 10 166 56 169 60
 */

public class BAB10_1 {
    public static void main(String[] args) {
        java.util.Scanner than = new java.util.Scanner(System.in);
        int arrTinggiBadanA[] = { 168, 170, 165, 168, 172, 170, 169, 165, 171, 166 };
        int arrBeratBadanA[] = { 50, 60, 56, 55, 60, 70, 66, 56, 72, 56 };
        int arrTinggiBadanB[] = { 170, 167, 165, 166, 168, 175, 172, 171, 168, 169 };
        int arrBeratBadanB[] = { 66, 60, 59, 58, 58, 71, 68, 68, 65, 60 };
        int temp = 0;

        // Berdasarkan Tinggi Badannya secara Ascending/menaik dan Descending/menurun
        System.out.println("a. Berdasarkan Tinggi Badan secara Ascending/menaik dan Descending/menurun");

        System.out.print("Tinggi Badan A Ascending : ");
        for (int i = 0; i < arrTinggiBadanA.length; i++) {
            for (int j = i + 1; j < arrTinggiBadanA.length; j++) {
                if (arrTinggiBadanA[i] > arrTinggiBadanA[j]) {
                    temp = arrTinggiBadanA[i];
                    arrTinggiBadanA[i] = arrTinggiBadanA[j];
                    arrTinggiBadanA[j] = temp;
                }
            }
            System.out.print(arrTinggiBadanA[i]);
            if (i == arrTinggiBadanA.length - 1) {
                System.out.print(" ");
            } else {
                System.out.print(", ");
            }
        }
        System.out.println();

        System.out.print("Tinggi Badan A Descending : ");
        for (int i = 0; i < arrTinggiBadanA.length; i++) {
            for (int j = i + 1; j < arrTinggiBadanA.length; j++) {
                if (arrTinggiBadanA[i] < arrTinggiBadanA[j]) {
                    temp = arrTinggiBadanA[i];
                    arrTinggiBadanA[i] = arrTinggiBadanA[j];
                    arrTinggiBadanA[j] = temp;
                }
            }
            System.out.print(arrTinggiBadanA[i]);
            if (i == arrTinggiBadanA.length - 1) {
                System.out.print(" ");
            } else {
                System.out.print(", ");
            }
        }
        System.out.println();

        System.out.print("Tinggi Badan B Ascending : ");
        for (int i = 0; i < arrTinggiBadanB.length; i++) {
            for (int j = i + 1; j < arrTinggiBadanB.length; j++) {
                if (arrTinggiBadanB[i] > arrTinggiBadanB[j]) {
                    temp = arrTinggiBadanB[i];
                    arrTinggiBadanB[i] = arrTinggiBadanB[j];
                    arrTinggiBadanB[j] = temp;
                }
            }
            System.out.print(arrTinggiBadanB[i]);
            if (i == arrTinggiBadanB.length - 1) {
                System.out.print(" ");
            } else {
                System.out.print(", ");
            }
        }
        System.out.println();

        System.out.print("Tinggi Badan B Descending : ");
        for (int i = 0; i < arrTinggiBadanB.length; i++) {
            for (int j = i + 1; j < arrTinggiBadanB.length; j++) {
                if (arrTinggiBadanB[i] < arrTinggiBadanB[j]) {
                    temp = arrTinggiBadanB[i];
                    arrTinggiBadanB[i] = arrTinggiBadanB[j];
                    arrTinggiBadanB[j] = temp;
                }
            }
            System.out.print(arrTinggiBadanB[i]);
            if (i == arrTinggiBadanB.length - 1) {
                System.out.print(" ");
            } else {
                System.out.print(", ");
            }
        }
        System.out.println("\n");

        // Berdasarkan Berat Badannya secara Ascending/menaik dan Descending/menurun
        System.out.println("b. Berdasarkan Berat Badan secara Ascending/menaik dan Descending/menurun");

        System.out.print("Berat Badan A Ascending : ");
        for (int i = 0; i < arrBeratBadanA.length; i++) {
            for (int j = i + 1; j < arrBeratBadanA.length; j++) {
                if (arrBeratBadanA[i] > arrBeratBadanA[j]) {
                    temp = arrBeratBadanA[i];
                    arrBeratBadanA[i] = arrBeratBadanA[j];
                    arrBeratBadanA[j] = temp;
                }
            }
            System.out.print(arrBeratBadanA[i]);
            if (i == arrBeratBadanA.length - 1) {
                System.out.print(" ");
            } else {
                System.out.print(", ");
            }
        }
        System.out.println();

        System.out.print("Berat Badan A Descending : ");
        for (int i = 0; i < arrBeratBadanA.length; i++) {
            for (int j = i + 1; j < arrBeratBadanA.length; j++) {
                if (arrBeratBadanA[i] < arrBeratBadanA[j]) {
                    temp = arrBeratBadanA[i];
                    arrBeratBadanA[i] = arrBeratBadanA[j];
                    arrBeratBadanA[j] = temp;
                }
            }
            System.out.print(arrBeratBadanA[i]);
            if (i == arrBeratBadanA.length - 1) {
                System.out.print(" ");
            } else {
                System.out.print(", ");
            }
        }
        System.out.println();

        System.out.print("Berat Badan B Ascending : ");
        for (int i = 0; i < arrBeratBadanB.length; i++) {
            for (int j = i + 1; j < arrBeratBadanB.length; j++) {
                if (arrBeratBadanB[i] > arrBeratBadanB[j]) {
                    temp = arrBeratBadanB[i];
                    arrBeratBadanB[i] = arrBeratBadanB[j];
                    arrBeratBadanB[j] = temp;
                }
            }
            System.out.print(arrBeratBadanB[i]);
            if (i == arrBeratBadanB.length - 1) {
                System.out.print(" ");
            } else {
                System.out.print(", ");
            }
        }
        System.out.println();

        System.out.print("Berat Badan B Descending : ");
        for (int i = 0; i < arrBeratBadanB.length; i++) {
            for (int j = i + 1; j < arrBeratBadanB.length; j++) {
                if (arrBeratBadanB[i] < arrBeratBadanB[j]) {
                    temp = arrBeratBadanB[i];
                    arrBeratBadanB[i] = arrBeratBadanB[j];
                    arrBeratBadanB[j] = temp;
                }
            }
            System.out.print(arrBeratBadanB[i]);
            if (i == arrBeratBadanB.length - 1) {
                System.out.print(" ");
            } else {
                System.out.print(", ");
            }
        }
        System.out.println("\n");

        // Cari nilai maksimum dan minimum Tinggi Badan dan Berat Badan untuk pemain
        // dari masing-masing tim.
        System.out.print(
                "c. Cari nilai maksimum dan minimum Tinggi Badan dan Berat Badan untuk pemain dari masing-masing tim\n");
        System.out.println("Tim A");
        System.out.println("Tinggi Badan Maksimum : " + arrTinggiBadanA[arrTinggiBadanA.length - 1]);
        System.out.println("Tinggi Badan Minimum : " + arrTinggiBadanA[0]);
        System.out.println("Berat Badan Maksimum : " + arrBeratBadanA[arrBeratBadanA.length - 1]);
        System.out.println("Berat Badan Minimum : " + arrBeratBadanA[0]);
        System.out.println();
        System.out.println("Tim B");
        System.out.println("Tinggi Badan Maksimum : " + arrTinggiBadanB[arrTinggiBadanB.length - 1]);
        System.out.println("Tinggi Badan Minimum : " + arrTinggiBadanB[0]);
        System.out.println("Berat Badan Maksimum : " + arrBeratBadanB[arrBeratBadanB.length - 1]);
        System.out.println("Berat Badan Minimum : " + arrBeratBadanB[0]);
        System.out.println();

        // Copy seluruh anggota Tim B ke Tim C yang baru dibentuk
        int arrTinggiBadanC[] = new int[arrTinggiBadanB.length];
        int arrBeratBadanC[] = new int[arrBeratBadanB.length];
        System.arraycopy(arrTinggiBadanB, 0, arrTinggiBadanC, 0, arrTinggiBadanB.length);
        System.arraycopy(arrBeratBadanB, 0, arrBeratBadanC, 0, arrBeratBadanB.length);

        // Tampilkan seluruh anggota Tim C
        System.out.println("d. Tampilkan seluruh anggota Tim C");
        System.out.println("No\tTinggi Badan\tBerat Badan");
        for (int i = 0; i < arrTinggiBadanC.length; i++) {
            System.out.println((i + 1) + "\t" + arrTinggiBadanC[i] + "\t\t" + arrBeratBadanC[i]);
        }
        System.out.println();

    }
}
