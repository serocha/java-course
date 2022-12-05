public class Car {

    private final String description;

    public Car(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void startEngine() {
        System.out.println(this.getDescription() + " has started its engine.");
    }

    public void drive(double milesTraveled) {
        runEngine(milesTraveled);
        System.out.printf(this.getDescription() + " drives for %.2f miles. %n", milesTraveled);
    }

    public void refuel() {
        System.out.println(description + " has fully refueled.");
    }

    protected void runEngine(double milesTraveled) {
        System.out.println(this.getClass().getSimpleName() + "'s engine is running.");
    }
}
