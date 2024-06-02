package order;

import java.util.*;
import promotion.PercentOffPromo;
import promotion.Promotion;
import vehicle.Vehicle;

public class Order {
    private String idPemesan;
    private String idMenu;
    private int qty;
    private Date tanggalAwal;
    private Date tanggalAkhir;
    private ArrayList<Order> orderList;
    Vehicle vehicle;
    private int orderNum;
    private int harga;
    private int subTotalPrice;
    private int totalPrice;
    private Promotion promotion;
    private String nama;
    private String platNomor;
    private boolean isCheckOut;
    private ArrayList<Items> items = new ArrayList<>();

    public Order(String idPemesan, String idMenu, int qty, Date tanggalAwal, ArrayList<Order> orderList, String nama,
            String platNomor, int harga) {
        this.idPemesan = idPemesan;
        this.idMenu = idMenu;
        this.qty = qty;
        this.tanggalAwal = tanggalAwal;
        this.orderList = orderList;
        this.nama = nama;
        this.platNomor = platNomor;
        this.harga = harga;
        this.tanggalAkhir = calculateTanggalAkhir();
        this.subTotalPrice = calculateSubTotalPrice();
        this.totalPrice = calculateTotalPrice();
    }

    public Order(String idPemesan, String idMenu, int qty, Date tanggalAwal, ArrayList<Order> orderList) {
        this.idPemesan = idPemesan;
        this.idMenu = idMenu;
        this.qty = qty;
        this.tanggalAwal = tanggalAwal;
        this.orderList = orderList;
        this.tanggalAkhir = calculateTanggalAkhir();
        this.subTotalPrice = calculateSubTotalPrice();
        this.totalPrice = calculateTotalPrice();
    }

    public String getPlatNomor() {
        return platNomor;
    }

    public boolean isCheckOut() {
        return isCheckOut;
    }

    public void setTanggalAkhir(Date tanggalAkhir) {
        this.tanggalAkhir = tanggalAkhir;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setSubTotalPrice(int subTotalPrice) {
        this.subTotalPrice = subTotalPrice;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ArrayList<Items> getItems() {
        return items;
    }

    public void addItems(Vehicle vehicle) {
        items.add(new Items(vehicle));
    }

    public void setCheckOut(boolean checkOut) {
        isCheckOut = checkOut;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public String getNama() {
        return nama;
    }

    public String getIdPemesan() {
        return idPemesan;
    }

    public void setIdPemesan(String idPemesan) {
        this.idPemesan = idPemesan;
    }

    public String getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(String idMenu) {
        this.idMenu = idMenu;
    }

    public int getQty() {
        return qty;
    }

    public int getNum() {
        return orderNum;
    }

    public void setNum(int orderNum) {
        orderNum = orderNum;
    }

    public int getHarga() {
        return harga;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Date getTanggalAwal() {
        return tanggalAwal;
    }

    public void setTanggalAwal(Date tanggalAwal) {
        this.tanggalAwal = tanggalAwal;
        this.tanggalAkhir = calculateTanggalAkhir();
    }

    public Date getTanggalAkhir() {
        return tanggalAkhir;
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }

    // Calculate subtotal price
    private int calculateSubTotalPrice() {
        int subTotal = 0;
        for (Order order : orderList) {
            subTotal += order.getHarga();
        }
        return subTotal;
    }

    private int calculateTotalPrice() {
        int calculatedTotalPrice = getSubTotalPrice();
        if (promotion instanceof PercentOffPromo) {
            calculatedTotalPrice = getSubTotalPrice() - (getSubTotalPrice() * promotion.getDiscountPercent() / 100);
        }
        return calculatedTotalPrice;
    }

    public int getTotalPrice() {
        return calculateTotalPrice();
    }

    public int getSubTotalPrice() {
        return calculateSubTotalPrice();
    }

    public static boolean orderExists(String idPemesan, String idMenu, ArrayList<Order> orderList) {
        for (Order order : orderList) {
            if (order.getIdPemesan().equals(idPemesan) && order.getIdMenu().equals(idMenu)) {
                return true;
            }
        }
        return false;
    }

    public static Order findOrder(String idPemesan, String idMenu, ArrayList<Order> orderList) {
        for (Order order : orderList) {
            if (order.getIdPemesan().equals(idPemesan) && order.getIdMenu().equals(idMenu)) {
                return order;
            }
        }
        return null;
    }

    private Promotion findPromoByCode(String promoCode, ArrayList<Promotion> promoList) {
        for (Promotion promo : promoList) {
            if (promo.getPromoCode().equals(promoCode)) {
                return promo;
            }
        }
        return null;
    }

    public String applyPromo(String promoCode, ArrayList<Promotion> promoList, Date currentDate, int minimumPurchase) {
        Promotion promo = findPromoByCode(promoCode, promoList);
        if (promo == null) {
            return "APPLY_PROMO FAILED: " + promoCode;
        }

        if (currentDate.after(promo.getDateEnd()) || currentDate.before(promo.getDateStart())) {
            return "APPLY_PROMO FAILED: " + promoCode + " IS EXPIRED";
        }
        if (getSubTotalPrice() < minimumPurchase) {
            return "APPLY_PROMO FAILED: " + promoCode;
        }

        this.promotion = promo;
        this.totalPrice = calculateTotalPrice();
        this.setPromotion(this.promotion);
        this.getPromotion().setTotalDiscount(this.getPromotion().getDiscountPercent() * this.getTotalPrice() / 100);
        return "APPLY_PROMO SUCCESS: " + promoCode;
    }

    private Date calculateTanggalAkhir() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.tanggalAwal);
        calendar.add(Calendar.DAY_OF_MONTH, this.qty);
        return calendar.getTime();
    }

}
