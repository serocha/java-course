public class CarFactory {

    public static Car makeCar(String description) {
        return switch(description) {
            case "Toyota Camry" -> new GasPoweredCar("Toyota Camry", 4, 33.5, 16);
            case "Toyota bZ4X" -> new ElectricCar("Toyota bZ4X", 20, 12.6, 20);
            case "Toyota Prius" -> new HybridCar("Toyota Prius", 4, 34, 12, 2, 12.5);
            default -> new GasPoweredCar("Yugo Koral", 4, 31, 9);
        };
    }
}
