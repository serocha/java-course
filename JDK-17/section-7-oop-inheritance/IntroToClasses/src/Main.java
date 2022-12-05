public class Main {
    public static void main(String[] args) {
        Car toyota = new Car("Toyota", "Camry", "green", 2, true);
        Car subaru = new Car("Subaru", "Outback", "purple", 1, false);

        toyota.describeCar();
        subaru.describeCar();
        toyota.setModel("Supra");
        toyota.describeCar();
    }
}
