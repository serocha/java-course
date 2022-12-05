public class Main {

    public static void main(String[] args) {

        // to showcase dynamic type assignment
        var vehicle1 = CarFactory.makeCar("Toyota Camry");
        vehicle1.startEngine();
        vehicle1.drive(60.0);
        vehicle1.drive(200);

        Car vehicle2 = CarFactory.makeCar("Toyota bZ4X");
        vehicle2.startEngine();
        vehicle2.drive(251);
        vehicle2.drive(20);
        vehicle2.refuel();
        vehicle2.drive(20);

        Car vehicle3 = CarFactory.makeCar("Toyota Prius");
        vehicle3.drive(500);
        vehicle3.drive(100);
        vehicle3.refuel();
        vehicle3.drive(50);
    }
}