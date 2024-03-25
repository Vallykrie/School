package OOP.Praktikum;

public class Mobil {
    private String noPlat;
    private String warna;
    private String manufaktur;
    private int kecepatan;
    private double waktu;
    private double jarak;

    public void setNoPlat(String s) {
        noPlat = s;
    }

    public void setWarna(String s) {
        warna = s;
    }

    public void setManufaktur(String s) {
        manufaktur = s;
    }

    public void setKecepatan(int i) {
        kecepatan = i;
        double kecepatanMs = rubahKecepatan(kecepatan);
    }

    public void setWaktu(double d) {
        waktu = d;
        double sekon = rubahSekon(waktu);
    }

    private double rubahSekon(double waktu) {
        return waktu * 3600;
    }

    private double rubahKecepatan(int kecepatan) {
        return kecepatan * 1000 / 3600;
    }

    public void hitungJarak(int kecepatan, double waktu) {
        jarak = kecepatan * waktu;
    }

    public void displayMessage() {
        System.out.println("Mobil anda adalah bermerek " + manufaktur);
        System.out.println("mempunyai nomor plat " + noPlat);
        System.out.println("serta memililki warna " + warna);
        System.out.println("jarak yang dapat ditempuh " + jarak / 1000 + " km");
        System.out.println("dan mampu menempuh kecepatan " + kecepatan);
    }
}
