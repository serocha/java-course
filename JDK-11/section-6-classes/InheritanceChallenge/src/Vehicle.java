public class Vehicle {

    protected final String type;
    private final String steering;
    private int currentSpeed;
    private int maxSpeed;

    public Vehicle (String type, String steering, int maxSpeed) {
        this(type, steering, maxSpeed, 0);
    }
    public Vehicle (String type, String steering, int maxSpeed, int currentSpeed) {
        this.type = type;
        this.steering = steering; // type of steering
        this.currentSpeed = currentSpeed;
        this.maxSpeed = maxSpeed;
    }

    public String getType() {
        return type;
    }

    public String getSteering() {
        return steering;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void changeSpeed(int speed) {
        if ((currentSpeed + speed) > maxSpeed) {
            System.out.println(type + " increased speed to max of " + maxSpeed);
            currentSpeed = maxSpeed;
        } else if ((currentSpeed + speed) <= 0) {
            System.out.println(type + " decreased speed and came to a stop.");
            currentSpeed = 0;
        } else {
            String modifier;
            if (speed > 0) {
                modifier = "increased";
            } else if (speed < 0) {
                modifier = "decreased";
            } else {
                modifier = "didn't change";
            }
            currentSpeed += speed;
            System.out.println(type + " " + modifier + " speed. Current speed is " + currentSpeed);
        }
    }

    public String toString() {
        return "Type: " + type + "\n" +
                "Steering: " + steering + "\n" +
                "Max Speed: " + maxSpeed + "\n" +
                "Current Speed: " + currentSpeed + "\n";
    }
}
