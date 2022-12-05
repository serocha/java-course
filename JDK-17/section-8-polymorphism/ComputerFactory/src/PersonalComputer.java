public class PersonalComputer extends Product {

    private Monitor monitor;
    private Motherboard motherboard;
    private ComputerCase computerCase;


    public PersonalComputer(String model, String manufacturer,
                            Monitor monitor, Motherboard motherboard, ComputerCase computerCase) {
        super(model, manufacturer);
        this.monitor = monitor;
        this.motherboard = motherboard;
        this.computerCase = computerCase;
    }

    private void drawLogo() {
        monitor.drawPixelAt(1200, 50, "yellow");
    }

    public void power() {
        computerCase.pressPowerButton();
        drawLogo();
    }

    @Override
    public String toString() {
        return "PersonalComputer{" +
                "monitor=" + monitor +
                ", motherboard=" + motherboard +
                ", computerCase=" + computerCase +
                "} " + super.toString();
    }
}
