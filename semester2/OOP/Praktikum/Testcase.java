package OOP.Praktikum;

public class Testcase {
        public static void main(String[] args) {
                // 1. Manusia
                // a.
                Manusia manusia1 = new Manusia("Budi", "1234567890", true, true);
                System.out.println(manusia1);
                System.out.println();
                // b.
                Manusia manusia2 = new Manusia("Siti", "0987654321", false, true);
                System.out.println(manusia2);
                System.out.println();
                // c.
                Manusia manusia3 = new Manusia("Joni", "2341233453", true, false);
                System.out.println(manusia3);
                System.out.println();

                // 2. MahasiswaFILKOM (sesuai status Anda)
                // a.
                MahasiswaFILKOM mahasiswa1 = new MahasiswaFILKOM("Nathan", "235150207111051", true, false,
                                "235150207111051",
                                2.2);
                System.out.println(mahasiswa1);
                System.out.println();
                // b.
                mahasiswa1.setIpk(3.25);
                System.out.println(mahasiswa1);
                System.out.println();
                // c.
                mahasiswa1.setIpk(3.84);
                System.out.println(mahasiswa1);
                System.out.println();

                // 3. Pekerja
                // a.
                Pekerja pekerja1 = new Pekerja("Joko", "1234567890", true, true, 5000000,
                                java.time.LocalDate.of(2022, 1, 1),
                                2);
                System.out.println(pekerja1);
                System.out.println();
                // b.
                pekerja1.setTahunMasuk(java.time.LocalDate.of(2015, 1, 1));
                System.out.println(pekerja1);
                System.out.println();
                // c.
                pekerja1.setTahunMasuk(java.time.LocalDate.of(2004, 1, 1));
                pekerja1.setJumlahAnak(10);
                System.out.println(pekerja1);
                System.out.println();

                // 4. Manager
                Manager manager1 = new Manager("Anton", "1234567890", true, true, 7500,
                                java.time.LocalDate.of(2009, 1, 1), 2,
                                "IT");
                System.out.println(manager1);

        }
}
