package OOP.Praktikum;

import java.time.LocalDate;
import java.time.Period;

public class Pekerja extends Manusia {
    private double gaji;
    private LocalDate tahunMasuk;
    private int jumlahAnak;

    Pekerja() {
    }

    Pekerja(String nama, String nik, boolean jenisKelamin, boolean isMenikah, double gaji, LocalDate tahunMasuk,
            int jumlahAnak) {
        super(nama, nik, jenisKelamin, isMenikah);
        this.gaji = gaji;
        this.tahunMasuk = tahunMasuk;
        this.jumlahAnak = jumlahAnak;
    }

    public double getBonus() {
        int lamaBekerja = Period.between(tahunMasuk, LocalDate.now()).getYears();
        if (lamaBekerja > 10) {
            return gaji * 0.15;
        } else if (lamaBekerja > 5) {
            return gaji * 0.10;
        } else {
            return gaji * 0.05;
        }
    }

    public double getGaji() {
        return gaji + getBonus() + jumlahAnak * 20;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTahun Masuk\t: " + tahunMasuk + "\nJumlah Anak\t: " + jumlahAnak + "\nGaji\t\t: "
                + getGaji();
    }

    // setters and getters
    public void setGaji(double gaji) {
        this.gaji = gaji;
    }

    public LocalDate getTahunMasuk() {
        return tahunMasuk;
    }

    public void setTahunMasuk(LocalDate tahunMasuk) {
        this.tahunMasuk = tahunMasuk;
    }

    public int getJumlahAnak() {
        return jumlahAnak;
    }

    public void setJumlahAnak(int jumlahAnak) {
        this.jumlahAnak = jumlahAnak;
    }

}
