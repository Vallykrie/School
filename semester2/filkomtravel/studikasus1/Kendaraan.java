package filkomtravel.studikasus1;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Kendaraan {
    private String model, color, numberPlate;
    private int capacity;
    private double price;

    Kendaraan(String model, String color, String numberPlate, int capacity, double price) {
        this.model = model;
        this.color = color;
        this.numberPlate = numberPlate;
        this.capacity = capacity;
        this.price = price;
    }

    public void printInfo() {
        // Price Formats
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("Rp #,###.00", symbols);

        System.out.println("Model: " + model);
        System.out.println("Color: " + color);
        System.out.println("Number Plate: " + numberPlate);
        System.out.println("Capacity: " + capacity);
        System.out.println("Price: " + df.format(price));
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
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
