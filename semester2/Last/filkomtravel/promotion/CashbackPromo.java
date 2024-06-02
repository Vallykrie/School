package promotion;

import customer.*;
import order.*;
import java.util.Date;
import java.util.Calendar;

import java.util.Calendar;
import java.util.Date;

public class CashbackPromo extends Promotion {
    int cashback;

    public CashbackPromo(String promoCode, Date begin, Date end, int discountPercent, int maxDiscount, int minimumPurchase) {
        super(promoCode, begin, end, discountPercent, maxDiscount, minimumPurchase);
    }

    @Override
    public boolean isCustomerEligible(Object customer) {
        if (customer instanceof Guest) {
            return false;
        } else if (customer instanceof Member member) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(member.getTanggalDaftar());

            calendar.add(Calendar.DAY_OF_YEAR, 30);

            Date currentDate = new Date();

            if (!currentDate.after(calendar.getTime())) {
                return false;
            }

            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean isMinimumPriceEligible(Object x) {
        if (x instanceof Order order && order.getSubTotalPrice() > super.getMinimumPurchase()){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean isShippingFeeEligible(Object x) {
        return false;
    }

    @Override
    public double getTotalPrice(Object input) {
        Order orderX = (Order) input;
        return 0.0;
    }

    @Override
    public double getTotalCashback() {
        return 0;
    }

    @Override
    public double getTotalShippingFee() {
        return 0;
    }

    @Override
    public int compareTo(Promotion input) {
        return 0;
    }

}