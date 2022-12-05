public class Car {

    private String make;
    private String model;
    private String color;
    private int doors;
    private boolean convertible; // Java booleans default to false either way

    public Car(String make, String model, String color, int doors, boolean convertible) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.doors = validateDoors(doors);
        this.convertible = convertible;
    }

    public Car() {
        this("Make", "Model", "Color", 4, false);
    }
    public void describeCar() {
        System.out.println(color + " " +
                doors + "-door " +
                make + " " +
                model + " " +
                (convertible ? "convertible" : ""));
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getDoors() {
        return doors;
    }

    public boolean isConvertible() {
        return convertible;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDoors(int doors) {
        this.doors = validateDoors(doors);
    }

    public void setConvertible(boolean convertible) {
        this.convertible = convertible;
    }

    private int validateDoors(int doors) {
        if (doors != 2 && doors != 4) {
            System.out.println("Door value of " + doors + " is invalid. Defaulting to 4.");
            doors = 4;
        }
        return doors;
    }
}

