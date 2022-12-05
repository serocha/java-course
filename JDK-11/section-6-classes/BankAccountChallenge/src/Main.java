public class Main {
    public static void main(String[] args) {
        // account creation
        BankAccount account1 = new BankAccount((int) (Math.random()*999999), 841.01,
                "Joe Schmoe", "joe.schmoe@email.com", "(555) 455-1919");
        BankAccount account2 = new BankAccount((int) (Math.random()*999999), 201913.52,
                "Hank Hill", "hankhill@propane.com", "(555) 881-1012");
        // overloaded constructors
        BankAccount account3 = new BankAccount(4028.98, "Sketchy Pete");
        BankAccount account4 = new BankAccount(); // default

        System.out.println("Account #" + account1.getAccountNumber());
        System.out.println("Balance: $" + account1.getBalance());
        System.out.println("Owner: " + account1.getCustomerName());
        System.out.println("Email: " + account1.getEmail());
        System.out.println("Phone: " + account1.getPhoneNumber());
        System.out.println();
        account1.depositFunds(45.12);
        account1.depositFunds(-12.50);
        account1.withdrawFunds(86.13);
        account1.withdrawFunds(900);
        account1.depositFunds(0);

        account2.printAccountDetails();
        account3.printAccountDetails();
        account4.printAccountDetails();

        /*VipCustomer customer1 = new VipCustomer();
        System.out.println("VIP 1 name: " + customer1.getCustomerName());
        VipCustomer customer2 = new VipCustomer("Tim", 25000.0);
        System.out.println("VIP 2 name: " + customer2.getCustomerName());
        VipCustomer customer3 = new VipCustomer("John", 50000.0, "jj@email.test");
        System.out.println("VIP 3 email: " + customer3.getCustomerEmail());*/
    }
}