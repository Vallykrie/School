package customer;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Date;
import order.*;
import promotion.CashbackPromo;
import promotion.PercentOffPromo;
import promotion.Promotion;
import vehicle.Mobil;
import vehicle.Vehicle;

public abstract class Customer {

    private String name;
    private String id;
    private double balance;
    private Promotion promotion;
    Vehicle vehicle;

    public ArrayList<Order> orders = new ArrayList<>();

    protected Customer(String id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void topUpBalance(double amount) {
        this.balance += amount;
        // System.out.println(String.format("TOPUP SUCCESS: %s %.2f => %.2f", this.name,
        // initialBalance, this.balance));
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public String applyPromo(String idMenu, int qty, Date tanggalAwal, String promoCode, ArrayList<Promotion> promoList,
            int minimumPurchase) {
        ArrayList<Order> orderList = new ArrayList<>();
        Order order = new Order(this.id, idMenu, qty, tanggalAwal, orderList);
        return order.applyPromo(promoCode, promoList, new Date(), minimumPurchase);
    }

    public boolean checkout(ArrayList<Order> orderList, ArrayList<Promotion> promoList) {
        double total = 0;
        for (Order order : orderList) {
            total += order.getTotalPrice();
        }

        if (this.balance < total) {
            System.out.println("CHECK_OUT FAILED: " + this.id + " " + this.name + " INSUFFICIENT_BALANCE");
            return false;
        }

        this.balance -= total;
        for (Order order : orderList) {
            order.setCheckOut(true);
        }
        orderList.addAll(orders);
        orders.clear();

        return true;
    }

    public void printOrder(ArrayList<Order> orderList, int cnt) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        DecimalFormatSymbols sym = new DecimalFormatSymbols();
        sym.setDecimalSeparator(',');
        sym.setGroupingSeparator('.');
        DecimalFormat df = new DecimalFormat("###,###.##", sym);
        Order order = orderList.get(orderList.size() - 1);
        System.out.println("\nKode Pemesan: " + getId());
        System.out.println("Nama: " + getName());
        if (order.isCheckOut()) {
            System.out.println("Nomor Pesanan: " + cnt);
            SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd MMMM yyyy");
            System.out.println("Tanggal Pesanan: " + dateFormat2.format(order.getTanggalAwal()));
            cnt += 1;
        }
        System.out.printf("%3s | %-25s | %3s | %8s \n", "No", "Menu", "Dur.", "Subtotal");
        System.out.println("=================================================");

        int count = 1;
        for (Order orderr : orderList) {
            String menu = orderr.getNama() + " " + orderr.getPlatNomor();
            Date tanggalAwal = orderr.getTanggalAwal();
            Date tanggalAkhir = orderr.getTanggalAkhir();

            System.out.printf("%3d | %-25s | %4d | %8s \n", count, menu, orderr.getQty(),
                    df.format(order.getHarga() * order.getQty()));
            System.out.printf("      %s%s%5s\n", dateFormat.format(tanggalAwal), " - ",
                    dateFormat.format(tanggalAkhir));

            count++;
        }
        System.out.println("=================================================");
        String subtotal = df.format(order.getSubTotalPrice());
        String total = df.format(order.getTotalPrice());
        String balance = df.format(this.balance);
        if (!order.isCheckOut()) {
            balance = df.format(this.balance - order.getTotalPrice());
        }

        System.out.printf("%-32s: %14s \n", "Sub Total", subtotal);
        System.out.println("=================================================");

        System.out.printf("%-32s: %14s \n", "Total", total);
        // System.out.println(order.getPromotion());
        if (order.getPromotion() != null) {
            Promotion promo = (order.getPromotion());
            if (this instanceof Member) {
                if (promo instanceof CashbackPromo) {
                    String dsc = df.format(order.getPromotion().getCashback(order));
                    System.out.printf("%-32s: %15s\n", "PROMO: " + order.getPromotion().getPromoCode(), dsc);
                } else if (promo instanceof PercentOffPromo) {
                    String dsc = df.format(order.getPromotion().getPrice(order));
                    System.out.printf("%-32s: %15s\n", "PROMO: " + order.getPromotion().getPromoCode(), "-" + dsc);
                }
            }
        }
        System.out.printf("%-32s: %14s \n", "Saldo", balance);
        System.out.println("");
        cnt++;
    }

    public void printHistory() {
        System.out.println("Kode Pemesan: " + getId());
        System.out.println("Nama: " + getName());
        System.out.printf("Saldo: %.0f\n", getBalance());
        System.out.printf("%4s | %10s | %5s | %5s | %8s | %-8s%n", "No", "Nomor Pesanan", "Motor", "Mobil", "Subtotal",
                "PROMO");
        System.out.println("==========================================================");
        int list = 1;
        for (Order order : orders) {
            if (order.isCheckOut()) {
                int mobil = 0;
                int motor = 0;
                for (Items orderr : order.getItems()) {
                    if (orderr.getVehicle() instanceof Mobil) {
                        mobil++;
                    } else {
                        motor++;
                    }
                }
                System.out.printf("%4d| %13d | %5d | %5d | %8d | %-8s\n", list, order.getNum(), motor, mobil,
                        order.getSubTotalPrice(),
                        order.getPromotion() != null ? order.getPromotion().getPromoCode() : "-");
            }
        }
        System.out.println("==========================================================");
    }
}
