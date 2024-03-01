public class AbstractDataType {
    public static void main(String[] args) {
        Plane plane = new Square(5);
        System.out.println(plane.area());
        System.out.println(plane.circumference());

        plane = new Rectangle(10, 5);
        System.out.println(plane.area());
        System.out.println(plane.circumference());
    }
}

/*
 * The Abstract Data Type of a Plane
 */
interface Plane {
    public double area();
    public double circumference();
}

/*
 * The Classes that implements the Abstract Data Type of a Plane
 */
class Square implements Plane {
    double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return this.side * this.side;
    }

    @Override
    public double circumference() {
        return this.side * 4;
    }
}

class Rectangle implements Plane {
    double width;
    double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return this.width * this.height;
    }

    @Override
    public double circumference() {
        return (this.width + this.height) * 2;
    }
}
