public class Car {
    private String make;
    private String model;
    private int doors;
    private int wheels;
    private String engine;
    private String color;
    public void setMake(String make) {
        // you can include validation within your setters
        String validMake = make.toLowerCase();
        if (validMake.equals("toyota") || validMake.equals("honda")) {
            this.make = make;
        } else {
            this.make = "Unknown";
        }
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }
    public String getModel() {
        return model;
    }
}
