import java.util.Scanner;

public class MainiMobil {
    public static void main(String[] args) {

        Scanner than = new Scanner(System.in);
        System.out.println("Masukkan kecepatan mobil : ");
        int kecepatan = than.nextInt();
        than.nextLine();
        System.out.println("Masukkan manufaktur mobil : ");
        String manufaktur = than.nextLine();
        System.out.println("Masukkan no plat mobil : ");
        String noPlat = than.nextLine();
        System.out.println("Masukkan warna mobil : ");
        String warna = than.nextLine();

        Mobil m1 = new Mobil();
        m1.setKecepatan(kecepatan);
        m1.setManufaktur(manufaktur);
        m1.setNoPlat(noPlat);
        m1.setWarna(warna);
        m1.displayMessage();
        System.out.println("=====================================");
    }
}