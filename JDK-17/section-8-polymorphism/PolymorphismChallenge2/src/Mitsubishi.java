public class Mitsubishi extends Car {

    public Mitsubishi(String name, int cylinders) {
        super(name, cylinders);
    }

    @Override
    public String startEngine() {
        System.out.printf("The %s's engine purrs. %n", getName());
        return super.startEngine(); //
    }

    @Override
    public String accelerate() {
        System.out.printf("The %s's supercharger whines. %n", getName());
        return super.accelerate();
    }

    @Override
    public String brake() {
        System.out.printf("The %s's brakes screech. %n", getName());
        return super.brake();
    }
}