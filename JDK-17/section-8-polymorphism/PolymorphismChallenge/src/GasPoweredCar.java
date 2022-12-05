public class GasPoweredCar extends Car {

    private final GasPoweredMotor motor;

    public GasPoweredCar(String description, int cylinders, double avgMiPerGallon, int maxGallonsFuel) {
        this(description, cylinders, avgMiPerGallon, maxGallonsFuel, (double) (maxGallonsFuel/2));
    }

    public GasPoweredCar(String description, int cylinders, double avgMiPerGallon, int maxGallonsFuel, double currentGallonsFuel) {
        super(description);
        motor = new GasPoweredMotor(cylinders, avgMiPerGallon, maxGallonsFuel, currentGallonsFuel);
    }

    @Override
    public void refuel() {
        System.out.println(getDescription() + " is fully refueled.");
        motor.refuel();
    }

    @Override
    public void drive(double milesTraveled) {
        if(motor.getCurrentGallonsFuel() * motor.getAvgMiPerGallon() > milesTraveled) {
            super.drive(milesTraveled);
            System.out.printf(this.getDescription() + " burned %.2f gallons of fuel %n", milesTraveled / motor.getAvgMiPerGallon());
            motor.runEngine(milesTraveled);
        } else {
            System.out.println("Not enough fuel.");
        }
    }
}
