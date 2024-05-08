import java.util.Date;
import customer.*;

public class PercentOffPromo extends Promotion {
    private double percentOff;

    public PercentOffPromo(String promoCode, Date startDate, Date endDate, double percentOff) {
        // super(promoCode, startDate, endDate);
        this.percentOff = percentOff;
    }

    public double hitungDiskon(double price) {
        return price * percentOff / 100;
    }

    public double hitungCashback(double price) {
        return 0;
    }

    public double getPercentOff() {
        return percentOff;
    }

    public void setPercentOff(double percentOff) {
        this.percentOff = percentOff;
    }

    public boolean isCustomerEligible(Guest user) {
        return true;
    }

    public boolean isMinimumPriceEligible(double price) {
        return true;
    }

    public boolean isShippingFeeEligible(double price) {
        return true;
    }

    public int compareTo(Object o) {
        return 0;
    }
}
