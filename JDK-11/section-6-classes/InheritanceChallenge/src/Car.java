public class Car extends Vehicle {

    private final String make;
    private final String model;
    private int wheels;
    private int currentGear;


    public Car(int maxSpeed, String make, String model, int wheels) {
        this(maxSpeed, 0, make, model, wheels, 0);
    }

    public Car(int maxSpeed, int currentSpeed, String make, String model, int wheels, int currentGear) {
        super("Car", "steering wheel", maxSpeed, currentSpeed);
        this.make = make;
        this.model = model;
        this.wheels = wheels;
        this.currentGear = currentGear;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getWheels() {
        return wheels;
    }

    public int getCurrentGear() {
        return currentGear;
    }

    @Override
    public void changeSpeed(int speed) {
        super.changeSpeed(speed);
        int gear;
        if (getCurrentSpeed() == 0) {
            System.out.println(type + " is now in park.");
            gear = 0;
        } else if (getCurrentSpeed() < 25) {
            System.out.println(type + " is now in 1st gear.");
            gear = 1;
        } else if (getCurrentSpeed() < 45) {
            System.out.println(type + " is now in 2nd gear.");
            gear = 2;
        } else if (getCurrentSpeed() < 65) {
            System.out.println(type + " is now in 3rd gear.");
            gear = 3;
        } else {
            System.out.println(type + " is now in 4th gear.");
            gear = 4;
        }
        this.currentGear = gear;
    }

    public String toString() {
        return super.toString() +
                "Make: " + make + "\n" +
                "Model: " + model + "\n" +
                "Wheels: " + wheels + "\n" +
                "Current gear: " + currentGear + "\n";
    }
}
