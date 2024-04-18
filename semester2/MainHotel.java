import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;

class Guest {
    private String name;
    private int roomCount;

    public Guest(String name, int age, String NIK, int roomCount) {
        this.name = name;
        this.roomCount = roomCount;
    }

    public String getName() {
        return name;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public double calculateBill() {
        double originalPrice = roomCount * 500000.0;
        double discount = 0.0;

        if (roomCount > 10) {
            discount = 0.35;
        } else if (roomCount > 5) {
            discount = 0.20;
        } else if (roomCount > 2) {
            discount = 0.10;
        }

        double discountAmount = originalPrice * discount;
        double finalPrice = originalPrice - discountAmount;
        return finalPrice;
    }

    public double getDiscountPercentage() {
        double discount = 0.0;

        if (roomCount > 10) {
            discount = 0.35;
        } else if (roomCount > 5) {
            discount = 0.20;
        } else if (roomCount > 2) {
            discount = 0.10;
        }

        return discount * 100;
    }

    public void displayBill() {
        double originalPrice = roomCount * 500000.0;
        double discountPercentage = getDiscountPercentage();

        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("Rp#,###.00", symbols);

        String formattedOriginalPrice = df.format(originalPrice);
        String formattedDiscountAmount = df.format(originalPrice * (discountPercentage / 100));
        double DiscountPrice = originalPrice - (originalPrice * discountPercentage / 100);
        String formattedDiscountPrice = df.format(DiscountPrice);

        System.out.println("--------------------------------------------------");
        System.out.println("Nama Tamu: " + name);
        System.out.println("Harga Asli: " + formattedOriginalPrice);

        if (discountPercentage > 0.0) {
            System.out.println("Diskon Diterima: " + (int) discountPercentage + "%");
            System.out.println("Potongan Harga: " + formattedDiscountAmount);
            System.out.println("Total Tagihan: " + formattedDiscountPrice);
        } else {
            System.out.println("Tidak mendapatkan diskon");
            System.out.println("Total Tagihan: " + formattedOriginalPrice);
        }
    }
}

public class MainHotel {
    public static void main(String[] args) {
        Scanner than = new Scanner(System.in);
        int guestCount = Integer.parseInt(than.nextLine());

        for (int i = 0; i < guestCount; i++) {
            String name = than.nextLine();
            int age = Integer.parseInt(than.nextLine());
            String NIK = than.nextLine();
            int roomCount = Integer.parseInt(than.nextLine());

            Guest guest = new Guest(name, age, NIK, roomCount);
            guest.displayBill();
        }
        System.out.println("--------------------------------------------------");
        than.close();
    }
}