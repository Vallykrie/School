package OOP.Praktikum;

import java.util.Scanner;

public class MainStudent {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);

        Student anna = new Student();
        anna.setName("Anna");
        anna.setAddress("Malang");
        anna.setAge(20);
        anna.setMath(100);
        anna.setScience(89);
        anna.setEnglish(80);
        anna.displayMessage();

        // menggunakan constructor lain
        System.out.println("===================");
        Student chris = new Student("Chris", "Kediri", 21);
        chris.setMath(70);
        chris.setScience(60);
        chris.setEnglish(90);
        chris.displayMessage();

        // siswa dengan nama anna dirubah informasi alamat dan umurnya melalui
        // constructor
        System.out.println("===================");
        anna = new Student("anna", "Batu", 18);
        anna.displayMessage();

        // siswa denagan nama chris dirubah informasi alamat dan umurnya melalui method
        System.out.println("===================");
        chris.setAddress("Surabaya");
        chris.setAge(22);
        chris.displayMessage();

        // menggunakan constructor dengan param nilai pelajaran
        System.out.println("===================");
        Student thanathan = new Student(100, 100, 100);
        thanathan.displayMessage();

        // memasukkan jumlah siswa sesuai dengan keinginan user
        System.out.println("===================");
        System.out.print("Masukkan jumlah siswa: ");
        int jumlahSiswa = than.nextInt();
        than.nextLine();

        Student[] siswa = new Student[jumlahSiswa];

        for (int i = 0; i < jumlahSiswa; i++) {
            System.out.println();
            System.out.println("Siswa ke-" + (i + 1));
            System.out.print("Nama: ");
            String nama = than.nextLine();
            System.out.print("Alamat: ");
            String alamat = than.nextLine();
            System.out.print("Umur: ");
            int umur = than.nextInt();
            than.nextLine();

            siswa[i] = new Student(nama, alamat, umur);
        }

        Student.jumlahObjek();
    }
}