package OOP.Praktikum;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah siswa: ");
        int jumlahSiswa = scanner.nextInt();

        Student[] siswa = new Student[jumlahSiswa];

        for (int i = 0; i < jumlahSiswa; i++) {
            System.out.println("Siswa ke-" + (i + 1));
            System.out.print("Nama: ");
            String nama = scanner.next();
            System.out.print("Alamat: ");
            String alamat = scanner.next();
            System.out.print("Umur: ");
            int umur = scanner.nextInt();

            siswa[i] = new Student(nama, alamat, umur);
        }

        scanner.close();

        // Melakukan operasi lainnya dengan array siswa
        // ...

        // Contoh penggunaan metode displayMessage() pada setiap siswa
        for (int i = 0; i < jumlahSiswa; i++) {
            siswa[i].displayMessage();
        }
    }
}
