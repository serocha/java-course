public class DigitalProduct {

    private String programName;
    private String companyName;

    public DigitalProduct(String programName, String companyName) {
        this.programName = programName;
        this.companyName = companyName;
    }

    public void runProgram() {
        System.out.println("Program " + programName + " is running...");
    }
}
