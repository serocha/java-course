public class Customer {
    private String customerName; // could be a constant because no setters are available
    private double creditLimit;
    private String customerEmail;

    public Customer() {
        this("DEFAULT", 10000.0, "NO EMAIL");
    }

    public Customer(String customerName, double creditLimit) {
        this(customerName, creditLimit, "NO EMAIL");
    }

    public Customer(String customerName, double creditLimit, String customerEmail) {
        this.customerName = customerName;
        this.creditLimit = creditLimit;
        this.customerEmail = customerEmail;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }
}
