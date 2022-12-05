public class SalariedEmployee extends Employee {

    private double annualSalary;
    private boolean isRetired;

    public SalariedEmployee(String name, String birthDate, long employeeID, String hireDate, double annualSalary) {
        this(name, birthDate, employeeID, hireDate, annualSalary, false);
    }

    public SalariedEmployee(String name, String birthDate, long employeeID, String hireDate,
                            double annualSalary, boolean isRetired) {
        this(name, birthDate, employeeID, hireDate, "", annualSalary, isRetired);
    }
    public SalariedEmployee(String name, String birthDate, long employeeID, String hireDate,
                            String endDate, double annualSalary, boolean isRetired) {
        super(name, birthDate, employeeID, hireDate, endDate);
        this.annualSalary = annualSalary;
        this.isRetired = isRetired;
    }

    public void retire(String retireDate) {
        System.out.println(name + " retired on " + retireDate);
        this.isRetired = true;
        super.terminate(retireDate);
    }

    public double collectPay() {
        double payPerPeriod = annualSalary / 26; // every 2 weeks
        if (isRetired) {
            payPerPeriod *= 0.6;
            System.out.println(name + " drew from pension");
        }
        return super.collectPay(payPerPeriod);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Annual Salary: " + annualSalary + "\n" +
                (isRetired ? "Retired" : "");
    }

    // TODO: override toString() method
}
