package order;

import java.util.Date;
import customer.*;
import vehicle.*;

public class Items {
    Vehicle vehicle;
    int rentalTime;
    Date date;
    Date end;

    public Items(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
