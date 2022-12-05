public class ElectricMotor {

    private final int batterySize;
    private final double avgMiPerCharge;
    private double currentCharge;

    public ElectricMotor(int batterySize, double avgMiPerCharge, double currentCharge) {
        this.batterySize = batterySize;
        this.avgMiPerCharge = avgMiPerCharge;
        this.currentCharge = currentCharge;
    }

    public int getBatterySize() {
        return batterySize;
    }

    protected double getAvgMiPerCharge() {
        return avgMiPerCharge;
    }

    public double getCurrentCharge() {
        return currentCharge;
    }

    protected void rechargeBattery() {
        currentCharge = batterySize;
    }

    protected void runEngine(double milesTraveled){
        burnCharge(chargeConsumed(milesTraveled));
    }

    private void burnCharge(double chargeBurned) {
        currentCharge -= chargeBurned;
    }

    private double chargeConsumed(double milesTraveled){
        return milesTraveled / avgMiPerCharge;
    }

    protected void hybridCharge() {
        currentCharge += 1; // used for hybrid cars, restores 1 charge for 1 gallon fuel burned
    }
}
