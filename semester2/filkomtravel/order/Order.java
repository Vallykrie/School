package order;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Calendar;
import vehicle.*;
import java.util.LinkedList;

public class Order {
    private LinkedList<Order> listPesanan = new LinkedList<Order>();
    private LinkedList<Receipt> listNota = new LinkedList<Receipt>();
    private int nomorPesanan = 0, nomorNota = 0;
    private Calendar tanggalPesanan;
    private Vehicle sewaan;
    private Status status;

    enum Status {
        UNPAID, SUCCESS, CANCELLED
    }

    public Order() {
    }

    public Order(int nomorPesanan, Calendar tanggalPesanan, Vehicle sewaan) {
        this.nomorPesanan = nomorPesanan;
        this.tanggalPesanan = tanggalPesanan;
        this.sewaan = sewaan;
        this.status = status.UNPAID;
    }

    public void printDetails() {
        // Price Formats
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("Rp #,###.00", symbols);

        listPesanan.forEach(pesanan -> {
            System.out.println("Nomor Pesanan: " + pesanan.nomorPesanan);
            System.out.println("Tanggal Pesanan: " + pesanan.tanggalPesanan.getTime());
            System.out.println("Model: " + pesanan.sewaan.getModel());
            System.out.println("Color: " + pesanan.sewaan.getColor());
            System.out.println("Status: " + pesanan.status);
            System.out.println();
        });
    }

    public void printNota(int index) {
        listNota.get(index).print();
    }

    public void printNota() {
        listNota.getLast().print();
    }

    public void pay(int nomorPesanan) {
        listPesanan.get(nomorPesanan).status = status.SUCCESS;
    }

    public boolean isEmpty() {
        return listPesanan.isEmpty();
    }

    public void checkOut(Vehicle sewaan) {
        Calendar date = Calendar.getInstance();
        int num = listPesanan.size() + 1;
        Order pesanan = new Order(num, date, sewaan);
        listPesanan.add(pesanan);
    }

    public void tambahNota(String[] tanggalSewa, int jam, double harga, String[] jamSewa, boolean isMember) {
        nomorNota++;
        Receipt nota = new Receipt(tanggalSewa, jam, harga, jamSewa, isMember, nomorNota);
        listNota.add(nota);
    }

    public boolean applyPromo() {
        return true;
    }
}

class MainOrder {
    public static void main(String[] args) {
        Vehicle mobil = new Mobil("Toyota Avanza", "Silver", "B 1234 XYZ", 7, 200000);
        Vehicle motor = new Motor("Honda Beat", "Black", "B 1234 XYZ", 2, 50000);
        Vehicle van = new Van("Toyota Hiace", "White", "B 1234 XYZ", 15, 500000);
        Order pesanan1 = new Order();
        pesanan1.checkOut(mobil);
        pesanan1.checkOut(van);
        pesanan1.checkOut(motor);
        pesanan1.printDetails();
    }
}
