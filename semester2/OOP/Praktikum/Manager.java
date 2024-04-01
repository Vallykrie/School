package OOP.Praktikum;

import java.time.LocalDate;

public class Manager extends Pekerja {
    private String departemen;

    Manager() {
    }

    Manager(String nama, String nik, boolean jenisKelamin, boolean isMenikah, double gaji, LocalDate tahunMasuk,
            int jumlahAnak, String departemen) {
        super(nama, nik, jenisKelamin, isMenikah, gaji, tahunMasuk, jumlahAnak);
        this.departemen = departemen;
    }

    @Override
    public double getGaji() {
        return super.getGaji() + super.getGaji() * 0.1;
    }

    @Override
    public String toString() {
        return super.toString() + "\nDepartemen\t: " + departemen;
    }

    // setter and getter
    public String getDepartemen() {
        return departemen;
    }

    public void setDepartemen(String departemen) {
        this.departemen = departemen;
    }
}