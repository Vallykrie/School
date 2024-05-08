import customer.*;

public interface Applicable {
    public boolean isCustomerEligible(Guest user);

    public boolean isMinimumPriceEligible(double price);

    public boolean isShippingFeeEligible(double price);

    public double hitungDiskon(double price);

    public double hitungCashback(double price);
}
