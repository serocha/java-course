public class ElectricCar extends Car {

    private final ElectricMotor motor;

    public ElectricCar(String description, int batterySize, double avgMiPerCharge) {
        this(description, batterySize, avgMiPerCharge, (double) (batterySize/2));
    }

    public ElectricCar(String description, int batterySize, double avgMiPerCharge, double currentCharge) {
        super(description);
        this.motor = new ElectricMotor(batterySize, avgMiPerCharge, currentCharge);
    }

    @Override
    public void refuel() {
        System.out.println(this.getDescription() + " has fully recharged.");
        motor.rechargeBattery();
    }

    @Override
    public void drive(double milesTraveled) {
        if(motor.getCurrentCharge() * motor.getAvgMiPerCharge() > milesTraveled) {
            super.drive(milesTraveled);
            System.out.printf(this.getDescription() + " burned %.2f units of charge %n", milesTraveled / motor.getAvgMiPerCharge());
            motor.runEngine(milesTraveled);
        } else {
            System.out.println("Not enough charge.");
        }
    }
}
