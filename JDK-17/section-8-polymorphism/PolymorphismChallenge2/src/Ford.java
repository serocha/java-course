public class Ford extends Car {

    public Ford(String name, int cylinders) {
        super(name, cylinders);
    }

    @Override
    public String startEngine() {
        System.out.printf("The %s's engine roars to life. %n", getName());
        return super.startEngine();
    }

    @Override
    public String accelerate() {
        System.out.printf("A puff of smoke come out of the %s's diesel exhaust. %n", getName());
        return super.accelerate();
    }

    @Override
    public String brake() {
        System.out.printf("The %s skids forward as it brakes. %n", getName());
        return super.brake();
    }
}
