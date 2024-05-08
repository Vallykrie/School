import java.util.Calendar;
import vehicle.*;
import java.util.LinkedList;

public class Order {
    Calendar tanggalPesanan;
    static int nomorPesanan;
    Vehicle sewaan;
    LinkedList<Order> listPesanan = new LinkedList<Order>();

    public Order(Vehicle sewaan) {
        this.sewaan = sewaan;
        this.tanggalPesanan = Calendar.getInstance();
        this.nomorPesanan++;
        listPesanan.add(this);
    }

    public void print() {
        listPesanan.forEach(pesanan -> {
            System.out.println("Nomor Pesanan: " + pesanan.nomorPesanan);
            System.out.println("Tanggal Pesanan: " + pesanan.tanggalPesanan.getTime());
            System.out.println("Model: " + pesanan.sewaan.getModel());
            System.out.println("Color: " + pesanan.sewaan.getColor());
            System.out.println("Number Plate: " + pesanan.sewaan.getNumberPlate());
            System.out.println("Capacity: " + pesanan.sewaan.getCapacity());
            System.out.println("Price: " + pesanan.sewaan.getPrice());
            System.out.println();
        });
    }

    public void cancel() {
        listPesanan.remove(this);
    }

    public void tambahPesanan(Vehicle sewaan) {
        listPesanan.add(new Order(sewaan));
    }
}

class MainOrder {
    public static void main(String[] args) {
        Vehicle mobil = new Mobil("Toyota Avanza", "Silver", "B 1234 XYZ", 7, 200000);
        Vehicle motor = new Motor("Honda Beat", "Black", "B 1234 XYZ", 2, 50000);
        Vehicle van = new Van("Toyota Hiace", "White", "B 1234 XYZ", 15, 500000);
        Order pesanan1 = new Order(mobil);
        pesanan1.tambahPesanan(van);
        pesanan1.tambahPesanan(motor);
        pesanan1.print();
    }
}
