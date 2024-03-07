package filkomtravel.studikasus1;

public class Mobil extends Kendaraan{
    public Mobil(String model, String color, String numberPlate, int capacity) {
        super(model, color, numberPlate, capacity);
    }

    public void printInfo() {
        System.out.println("Model: " + getModel());
        System.out.println("Color: " + getColor());
        System.out.println("Number Plate: " + getNumberPlate());
        System.out.println("Capacity: " + getCapacity());
    }

    
    
}
