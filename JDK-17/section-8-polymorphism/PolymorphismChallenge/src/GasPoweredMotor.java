public class GasPoweredMotor {

    private final int cylinders;
    private final double avgMiPerGallon;
    private final int maxGallonsFuel;
    private double currentGallonsFuel;

    public GasPoweredMotor(int cylinders, double avgMiPerGallon, int maxGallonsFuel, double currentGallonsFuel) {
        this.cylinders = cylinders;
        this.avgMiPerGallon = avgMiPerGallon;
        this.maxGallonsFuel = maxGallonsFuel;
        this.currentGallonsFuel = currentGallonsFuel;
    }

    protected int getCylinders() {
        return cylinders;
    }

    public double getAvgMiPerGallon() {
        return avgMiPerGallon;
    }

    public double getCurrentGallonsFuel() {
        return currentGallonsFuel;
    }

    protected void refuel() {
        currentGallonsFuel = maxGallonsFuel;
    }

    protected void runEngine(double milesTraveled) {
        burnFuel(gallonsConsumed(milesTraveled));
    }

    private void burnFuel(double fuelBurned) {
        currentGallonsFuel -= fuelBurned;
    }

    private double gallonsConsumed(double milesTraveled) {
        return milesTraveled / avgMiPerGallon;
    }
}
