public class HourlyEmployee extends Employee {

    private double hourlyPayRate;

    public HourlyEmployee(String name, String birthDate, long employeeID, String hireDate, double hourlyPayRate) {
        this(name, birthDate, employeeID, hireDate, "", hourlyPayRate);
    }

    public HourlyEmployee(String name, String birthDate, long employeeID, String hireDate, String endDate, double hourlyPayRate) {
        super(name, birthDate, employeeID, hireDate, endDate);
        this.hourlyPayRate = hourlyPayRate;
    }

    @Override
    public double collectPay(double hoursWorked) {
        return super.collectPay(hourlyPayRate * hoursWorked);
    }

    public double doublePay(double hoursWorked) {
        System.out.print("Employee worked overtime, ");
        return collectPay(hoursWorked * 2); // uses the overridden method, not super
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Hourly rate: $" + hourlyPayRate;
    }
}
