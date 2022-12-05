public class Main {
    public static void main(String[] args) {

        Car sedan = new Car(100, "Honda", "Civic", 4);
        sedan.changeSpeed(15);
        sedan.changeSpeed(100);
        sedan.changeSpeed(-100);
        System.out.println(sedan);
    }
}