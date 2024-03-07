package filkomtravel.studikasus1;

public class Van extends Kendaraan{
    final String type = "Van";

    Van(String model, String color, String numberPlate, int capacity, double price) {
        super(model, color, numberPlate, capacity, price);
    }
}
