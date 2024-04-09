package OOP.Praktikum.polymorfisme;

public abstract class Kue {
    protected String nama;
    protected double harga;

    public abstract double hitungHarga();

    @Override
    public String toString() {
        return "Nama Kue: " + nama + "\nHarga: " + harga;
    }
}