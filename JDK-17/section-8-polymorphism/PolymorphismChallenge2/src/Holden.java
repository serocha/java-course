public class Holden extends Car {

    public Holden(String name, int cylinders) {
        super(name, cylinders);
    }

    @Override
    public String startEngine() {
        System.out.printf("The %s's engine sputters to life. %n", getName());
        return super.startEngine();
    }

    @Override
    public String accelerate() {
        System.out.printf("There's a knocking sound as the %s speeds up. %n", getName());
        return super.accelerate();
    }

    @Override
    public String brake() {
        System.out.printf("The %s fishtails as it tries to slow down. %n", getName());
        return super.brake();
    }
}
