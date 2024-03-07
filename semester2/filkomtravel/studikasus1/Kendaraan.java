package filkomtravel.studikasus1;

public class Kendaraan {
    private String model, color, numberPlate;
    private int capacity;

    Kendaraan(String model, String color, String numberPlate, int capacity) {
        this.model = model;
        this.color = color;
        this.numberPlate = numberPlate;
        this.capacity = capacity;
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
    
}
