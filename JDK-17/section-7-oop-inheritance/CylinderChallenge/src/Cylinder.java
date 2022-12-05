public class Cylinder extends Circle {
    private double height;

    public Cylinder(double radius, double height) {
        super(radius); // pass radius to super class constructor
        this.height = height < 0 ? 0 : height;
    }

    public double getHeight() {
        return height;
    }

    public double getVolume() {
        // super class has area
        return height * super.getArea();
    }
}
