public class BankAccount {
    private int accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    public BankAccount(int accountNumber, double balance, String customerName, String email, String phoneNumber) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public BankAccount(double balance, String customerName) {
        this(0, balance, customerName, "NO EMAIL", "NO PHONE NUMBER");
        accountNumber = generateAccountNumber(); // silly method, just for fun
    }

    public BankAccount() {
        // default parameters, calls another overloaded constructor and populates with default parameters
        this(0, 0.0, "DEFAULT", "NO EMAIL", "NO PHONE NUMBER");
        accountNumber = generateAccountNumber();
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void printAccountDetails() {
        System.out.println();
        System.out.println("Account #"+ accountNumber);
        System.out.println("Balance: $" + String.format("%.2f", balance));
        System.out.println("Owner: " + customerName);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phoneNumber);
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void depositFunds(double deposit) {
        if (deposit == 0) {
            System.out.println("No deposit. Transaction cancelled.");
        }else if (deposit > 0 && (deposit == (deposit*100)/100)) {
            this.balance += deposit;
            System.out.println("$" + deposit + " deposited to account. New balance is $" + this.balance + "");
        } else {
            System.out.println("Invalid deposit: " + deposit);
        }
    }

    public void withdrawFunds(double withdrawal) {
        if (withdrawal > this.balance) {
            System.out.println("Insufficient funds.");
        } else if (withdrawal > 0 && (withdrawal == (withdrawal*100)/100)) {
            this.balance -= withdrawal;
            System.out.println("$" + withdrawal + " withdrawn from account. New balance is $" + this.balance + "");
        } else {
            System.out.println("Invalid withdrawal: " + withdrawal);
        }
    }

    private int generateAccountNumber() {
        // obviously you'd want to check if an account # exists, but this is for demo purposes
        return (int) (Math.random() * 999999);
    }
}
