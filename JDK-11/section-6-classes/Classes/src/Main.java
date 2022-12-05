public class Main {
    public static void main(String[] args) {
        // instantiate new objects from the class
        Car toyota = new Car();
        Car honda = new Car();

        toyota.setMake("Toyota");
        toyota.setModel("Camry");
        honda.setMake("Honda");
        honda.setModel("Civic");

        System.out.println(toyota.getMake() + " " + toyota.getModel());
        System.out.println(honda.getMake() + " " + honda.getModel());
    }
}