public class HybridCar extends Car{

    private final GasPoweredMotor gasMotor;
    private final ElectricMotor electricMotor;

    public HybridCar(String description, int cylinders, double avgMiPerGallon, int maxGallonsFuel,
                     int batterySize, double avgMiPerCharge) {
        this(description, cylinders, avgMiPerGallon, maxGallonsFuel, maxGallonsFuel,
                batterySize, avgMiPerCharge, batterySize);
    }

    public HybridCar(String description, int cylinders, double avgMiPerGallon, int maxGallonsFuel, double currentGallonsFuel,
                     int batterySize, double avgMiPerCharge, double currentCharge) {
        super(description);
        gasMotor = new GasPoweredMotor(cylinders, avgMiPerGallon, maxGallonsFuel, currentGallonsFuel);
        electricMotor = new ElectricMotor(batterySize, avgMiPerCharge, currentCharge);
    }

    @Override
    public void refuel() {
        System.out.println(this.getDescription() + " has fully refueled and recharged.");
        electricMotor.rechargeBattery();
        gasMotor.refuel();
    }

    public double totalRange() {
        return (gasMotor.getAvgMiPerGallon() * gasMotor.getCurrentGallonsFuel()) +
                (electricMotor.getAvgMiPerCharge() * electricMotor.getCurrentCharge()) +
                (gasMotor.getCurrentGallonsFuel() * electricMotor.getAvgMiPerCharge());
    }

    @Override
    public void drive(double milesTraveled) {
        if (totalRange() > milesTraveled) {
            super.drive(milesTraveled);

            double gasBurned = 0;
            double chargeBurned = 0;

            while (milesTraveled > 0) {
                if (electricMotor.getCurrentCharge() > 0) {
                    if (milesTraveled < electricMotor.getAvgMiPerCharge()) {
                        electricMotor.runEngine(milesTraveled);
                        chargeBurned += (milesTraveled / electricMotor.getAvgMiPerCharge());
                        milesTraveled = 0;
                    } else {
                        electricMotor.runEngine(electricMotor.getAvgMiPerCharge());
                        chargeBurned += 1;
                        milesTraveled -= electricMotor.getAvgMiPerCharge();
                    }
                } else if (gasMotor.getCurrentGallonsFuel() > 0) {
                    if (milesTraveled < gasMotor.getAvgMiPerGallon()) {
                        gasMotor.runEngine(milesTraveled);
                        gasBurned += (milesTraveled / gasMotor.getAvgMiPerGallon());
                        milesTraveled = 0;
                    } else {
                        gasMotor.runEngine(gasMotor.getAvgMiPerGallon());
                        electricMotor.hybridCharge();
                        gasBurned += 1;
                        milesTraveled -= gasMotor.getAvgMiPerGallon();
                    }
                } else {
                    System.out.println("Something went wrong...");
                    break;
                }
            }
            System.out.printf(this.getDescription() + " burned %.2f gallons of fuel and %.2f units of charge %n", gasBurned, chargeBurned);
        } else {
            System.out.println("Not enough fuel and charge.");
        }
    }
}
