package vehicle;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * The Vehicle class represents a vehicle with its model, color, number plate,
 * capacity, and price.
 */
public abstract class Vehicle {
    private String model, name, numberPlate, type;
    private int capacity;
    private double price;

    public Vehicle(String type, String model, String name, String numberPlate, double price) {
        this.model = model;
        this.type = type;
        this.name = name;
        this.numberPlate = numberPlate;
        this.price = price;
    }

    public void printInfo() {
        // Price Formats
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("Rp #,###.00", symbols);

        System.out.println("Model\t\t\t: " + model);
        System.out.println("name\t\t\t: " + name);
        System.out.println("Plat Nomor\t\t: " + numberPlate);
        System.out.println("Kapasitas penumpang\t: " + capacity);
        System.out.println("Harga\t\t\t: " + df.format(price) + "/jam");
        System.out.println("-".repeat(50));
    }

    public String getModel() {
        return model;
    }

    public String getName() {
        return name;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setName(String color) {
        this.name = color;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
