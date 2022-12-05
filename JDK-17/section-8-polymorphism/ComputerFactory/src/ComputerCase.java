public class ComputerCase extends Product {

    private String powerSupply;

    public ComputerCase(String model, String manufacturer,
                        String powerSupply) {
        super(model, manufacturer);
        this.powerSupply = powerSupply;
    }

    public String getPowerSupply() {
        return powerSupply;
    }

    public void pressPowerButton() {
        System.out.println("Power button pressed");
    }

    @Override
    public String toString() {
        return "ComputerCase{" +
                "powerSupply='" + powerSupply + '\'' +
                "} " + super.toString();
    }
}
