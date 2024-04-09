package OOP.Praktikum.polymorfisme;

import java.time.LocalDate;

public abstract class Employee {
    private String name;
    private String noKTP;
    private LocalDate birthDate;
    private int produksiBarang; // produksi barang per minggu
    private double upahPerProduksi; // upah per barang

    public Employee(String name, String noKTP, LocalDate birthDate, int produksiBarang, double upahPerProduksi) {
        this.name = name;
        this.noKTP = noKTP;
        this.birthDate = birthDate;
        setProduksiBarang(produksiBarang);
        setUpahPerProduksi(upahPerProduksi);
    }

    public String getName() {
        return name;
    }

    public String getNoKTP() {
        return noKTP;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getProduksiBarang() {
        return produksiBarang;
    }

    public void setProduksiBarang(int produksiBarang) {
        this.produksiBarang = produksiBarang;
    }

    public double getUpahPerProduksi() {
        return upahPerProduksi;
    }

    public void setUpahPerProduksi(double upahPerProduksi) {
        this.upahPerProduksi = upahPerProduksi;
    }

    public double upahTambahan() {
        return getProduksiBarang() * getUpahPerProduksi() * 0.1;
    }

    public String toString() {
        return String.format(" " + getName() + "\nNo. KTP:" + getNoKTP());
    }

    public abstract double earnings(); // pendapatan
}
