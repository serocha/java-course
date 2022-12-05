public class Main {

    // not really seeing how this exercise illustrates polymorphism

    public static void main(String[] args) {

        CorvetteStingray stingray = new CorvetteStingray();
        stingray.toggleSportMode();
        stingray.accelerate();
        stingray.startEngine();
        stingray.accelerate();
        stingray.toggleSportMode();
        stingray.accelerate();

        Pinnacle pinnacle = new Pinnacle();
        pinnacle.brake();
        pinnacle.startEngine();
        pinnacle.brake();
    }
}

class Car {

    private String name;
    private String manufacturer;
    private int cylinders;
    private int wheels;
    private int doors;
    private boolean isOn;

    public Car(String name, String manufacturer, int cylinders, int wheels, int doors) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.cylinders = cylinders;
        this.wheels = wheels;
        this.doors = doors;
        this.isOn = false;
    }

    public void startEngine() {
        if (isOn) {
            System.out.println("The " + name + " is already on...");
            return;
        }
        isOn = true;
        System.out.println("The " + name + "'s engine started up.");
    }

    public void stopEngine() {
        if (!isOn) {
            System.out.println("The " + name + "'s engine is already off...");
            return;
        }
        isOn = false;
        System.out.println("The " + name + "'s engine is now off.");
    }

    public void accelerate() {
        if (!isOn) {
            System.out.println("The " + name + " isn't  on...");
            return;
        }
        System.out.println("The " + name + " accelerates.");
    }

    public void brake() {
        if (!isOn) {
            System.out.println("The " + name + " isn't  on...");
            return;
        }
        System.out.println("The " + name + " brakes.");
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public boolean getIsOn() {
        return isOn;
    }
}

class Camry extends Car {

    public Camry() {
        super("Camry", "Toyota", 4, 4, 4);
    }
}

class CorvetteStingray extends Car {

    private boolean sportMode;

    public CorvetteStingray() {
        this(false);
    }

    public CorvetteStingray(boolean sportMode) {
        super("Corvette Stingray", "Chevrolet", 8, 4, 2);
        this.sportMode = sportMode;
    }

    public void toggleSportMode() {
        if (sportMode) {
            System.out.println("Touring mode activated. Increased fuel economy and drive quality.");
        } else {
            System.out.println("Sport mode activated. Increased steering response and acceleration.");
        }
        sportMode = !sportMode;
    }

    @Override
    public void accelerate() {
        if (sportMode && getIsOn()) {
            System.out.println("The " + getName() + " accelerates quickly.");
        } else {
            super.accelerate();
        }
    }
}

class Pinnacle extends Car {

    public Pinnacle() {
        super("Pinnacle", "Mack", 6, 6, 2);
    }

    @Override
    public void brake() {
        super.brake();
        if (getIsOn()) {
            System.out.println("The airbrakes help decelerate the " + getName() + " quickly.");
        }
    }
}
