import java.util.Scanner;

public class MainiMobil {
    public static void main(String[] args) {

        Scanner than = new Scanner(System.in);
        System.out.println("Masukkan kecepatan mobil : ");
        int kecepatan = than.nextInt();
        System.out.println("Masukkan manufaktur mobil : ");
        String manufaktur = than.next();
        System.out.println("Masukkan no plat mobil : ");
        String noPlat = than.next();
        System.out.println("Masukkan warna mobil : ");
        String warna = than.next();
        System.out.println("================");
        // instan objek bernama m1
        Mobil m1 = new Mobil();
        m1.setKecepatan(50);
        m1.setManufaktur("Toyota");
        m1.setNoPlat("AB 1231 UA");
        m1.setWarna("Merah");
        m1.displayMessage();
        System.out.println("================");
        // instan objek baru bernama m2
        Mobil m2 = new Mobil();
        m2.setKecepatan(100);
        m2.setManufaktur("Mitsubishi");
        m2.setNoPlat("N 1134 AG");
        m2.setWarna("Pink");
        m2.displayMessage();
        System.out.println("================");
        // merubah warna dari objek m1
        System.out.println("mobil pada objek m1 di rubah menjadi warnahijau");
        m1.setWarna("Hijau");
        // menampilkan hasil perubahan
        m1.displayMessage();
    }
}