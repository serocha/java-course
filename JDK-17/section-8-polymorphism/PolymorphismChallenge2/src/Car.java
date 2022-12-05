public class Car {

    private String name;
    private boolean engine;
    private int cylinders;
    private int wheels;

    public Car (String name, int cylinders) {
        this.name = name;
        this.engine = true;
        this.cylinders = cylinders;
        this.wheels = 4;
    }

    public String startEngine() {
       return this.getClass().getSimpleName() + "'s engine is starting.";
    }

    public String accelerate() {
        return this.getClass().getSimpleName() + " is accelerating.";
    }

    public String brake() {
        return this.getClass().getSimpleName() + " is braking.";
    }

    public String getName() {
        return name;
    }

    public int getCylinders() {
        return cylinders;
    }
}
