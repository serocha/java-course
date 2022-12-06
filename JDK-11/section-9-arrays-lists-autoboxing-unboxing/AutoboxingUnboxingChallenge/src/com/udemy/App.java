package com.udemy;

/*
* Much of App's functionality was originally in Bank
* Would be better to restructure how methods are passed, but it works for the purpose of this exercise
* Should put the different menu methods in their own classes
*
* Could refactor conditional isCustomer() checks within a separate method to reduce the System.out.println() calls
*/

import java.util.Scanner;

public class App {

    private final Scanner scanner = new Scanner(System.in);
    protected static final double ACCOUNT_MINIMUM = 25.0;

    Bank bank = new Bank("Clark W. Griswold Bank");
    public void runApp() {
        boolean isRunning = true;

        while(isRunning) {
            String MAIN_MENU = """
                     System
                    1 --> Manage Branches
                    2 --> Manage Accounts
                    3 --> Start New Transaction
                    4 --> Quit
                    """;
            int menuInput = getMenuInput(4, bank.getBankName() + MAIN_MENU);
            switch(menuInput) {
                case 1 -> branchMenu();
                case 2 -> customerMenu();
                case 3 -> transactionMenu();
                case 4 -> {
                    System.out.println("Exiting application...");
                    isRunning = false;
                }
                default -> System.out.println("Something went wrong...");
            }
        }
    }

    private void branchMenu() {
        boolean isRunning = true;
        String strInput;
        String BRANCH_MENU = """
                    Branch Menu
                    1 --> Open New Branch
                    2 --> Search for Branch
                    3 --> List All Branches
                    4 --> List Accounts At Branch
                    5 --> Delete Branch
                    6 --> Go Back
                    """;

        while(isRunning) {
            int menuInput = getMenuInput(6, BRANCH_MENU);
            switch (menuInput) {
                case 1 -> {
                    strInput = getStrInput("Enter new branch name: ");
                    if (!bank.isBranch(strInput)) {
                        bank.addBranch(strInput);
                        System.out.println(strInput + " branch was created.");
                    } else {
                        System.out.println("Branch already exists.");
                    }
                    endMenuAction();
                }
                case 2 -> {
                    strInput = getStrInput("Enter name of branch to search for: ");
                    if (bank.isBranch(strInput)) {
                        System.out.println(strInput + " branch found. It currently has " +
                                bank.getBranch(strInput).getCustomerList().size() + " accounts open.");
                    } else {
                        System.out.println("Branch not found.");
                    }
                    endMenuAction();
                }
                case 3 -> {
                    String branches = !bank.getAllBranches().isEmpty() ? bank.getAllBranches() : "No branches open.\n";
                    System.out.print(branches);
                    endMenuAction();
                }
                case 4 -> {
                    strInput = getStrInput("Please enter the name of the branch: ");
                    if (bank.isBranch(strInput)) {
                        System.out.println(bank.getBranch(strInput).getAccountList());
                    } else {
                        System.out.print("Branch not found.");
                    }
                    endMenuAction();
                }
                case 5 -> {
                    strInput = getStrInput("Enter name of branch to delete: ");
                    if (bank.isBranch(strInput)) {
                        String branchName = strInput;
                        strInput = getStrInput("Enter the name again to confirm: ");
                        if (branchName.equals(strInput)) {
                            bank.getBranchList().remove(bank.getBranch(strInput)); // messy implementation
                            System.out.print(branchName + " has been deleted. ");
                            endMenuAction();
                        } else {
                            System.out.println("Deletion canceled. ");
                            endMenuAction();
                        }
                    }
                }
                case 6 -> {
                    System.out.println("Going back...");
                    isRunning = false;
                    System.out.println();
                }
                default -> System.out.println("Something went wrong...");
            }
        }
    }

    private void customerMenu() {
        boolean isRunning = true;
        String nameInput;
        String branchInput;
        String ACCOUNTS_MENU = """
                Accounts Menu
                1 --> Open New Account
                2 --> Delete Account
                3 --> Search for Account
                4 --> List All Accounts
                5 --> Go Back
                """;
        while (isRunning) {
            int menuInput = getMenuInput(5, ACCOUNTS_MENU);
            switch(menuInput) {
                case 1 -> {
                    nameInput = getStrInput("Enter a name for the account: ");
                    if (!bank.isCustomer(nameInput)) {
                        branchInput = getStrInput("Enter the name of the branch to open the account with: ");
                        if (bank.isBranch(branchInput)) {
                            double doubleInput = getDoubleInput("Accounts require a minimum of $%.2f.%nEnter initial deposit amount: ".formatted(ACCOUNT_MINIMUM), ACCOUNT_MINIMUM);
                            if (doubleInput == -1.0) {
                                System.out.println("Account creation cancelled.");
                                break;
                            }
                            bank.addCustomer(nameInput,doubleInput,branchInput);
                            System.out.println("New account created under " + nameInput + " at " + branchInput + " branch.");
                        } else {
                            System.out.println("Branch not found.");
                        }
                    } else {
                        System.out.println("Account under that name already exists.");
                    }
                    endMenuAction();
                }
                case 2 -> {
                    nameInput = getStrInput("Enter the name of the account to delete: ");
                    if (bank.isCustomer(nameInput)) {
                        bank.deleteCustomer(nameInput);
                        System.out.println("Account deleted.");
                    } else {
                        System.out.println("Account not found.");
                    }
                    endMenuAction();
                }
                case 3 -> {
                    nameInput = getStrInput("Enter the name of the account to search for: ");
                    if (bank.isCustomer(nameInput)) {
                        branchInput = bank.getCustomerBranch(nameInput).getBranchName();
                        System.out.println("Account under " + nameInput + " found at " + branchInput + " branch.");
                    } else {
                        System.out.println("Account not found.");
                    }
                    endMenuAction();
                }
                case 4 -> {
                    for (Branch branch : bank.getBranchList()) {
                        for (Customer customer : branch.getCustomerList()) {
                            System.out.println(customer.getCustomerName());
                        }
                    }
                    System.out.println();
                    endMenuAction();
                }
                case 5 -> {
                    System.out.println("Going back...");
                    isRunning = false;
                    System.out.println();
                }
                default -> System.out.println("Something went wrong...");
            }
        }
    }

    private void transactionMenu() {
        boolean isRunning = true;
        String nameInput;
        double doubleInput;
        String TRANSACTION_MENU = """
            1 --> Check Balance
            2 --> Make a Deposit
            3 --> Make a Withdrawal
            4 --> Print an Account Statement
            5 --> Go Back
            """;

        while (isRunning) {
            int menuInput = getMenuInput(5, TRANSACTION_MENU);
            switch (menuInput) {
                case 1 -> {
                    nameInput = getStrInput("Enter the name of the account: ");
                    if (bank.isCustomer(nameInput)) {
                        System.out.printf("Account: %s%nCurrent Balance: $%,.2f",nameInput, bank.getCustomer(nameInput).getBalance());
                    } else {
                        System.out.println("Account not found.");
                    }
                    endMenuAction();
                }
                case 2 -> {
                    nameInput = getStrInput("Enter the account name: ");
                    if (bank.isCustomer(nameInput)) {
                        doubleInput = getDoubleInput("Enter the amount to deposit: ");
                        if (doubleInput != -1.0) {
                            bank.getCustomer(nameInput).deposit(doubleInput);
                            System.out.println("Deposit completed.");
                        } else {
                            System.out.println("Transaction cancelled.");
                        }
                    } else {
                        System.out.println("Account not found.");
                    }
                    endMenuAction();
                }
                case 3 -> {
                    nameInput = getStrInput("Enter the account name: ");
                    if (bank.isCustomer(nameInput)) {
                        doubleInput = getDoubleInput("Enter the amount to withdraw: ");
                        if (doubleInput > 0 && doubleInput <= bank.getCustomer(nameInput).getBalance()) {
                            bank.getCustomer(nameInput).withdrawal(doubleInput);
                            System.out.println("Withdrawal completed.");
                        } else if (doubleInput > bank.getCustomer(nameInput).getBalance()) {
                            System.out.println("Insufficient funds.");
                        } else {
                            System.out.println("Transaction cancelled.");
                        }
                    } else {
                        System.out.println("Account not found.");
                    }
                    endMenuAction();
                }
                case 4 -> {
                    nameInput = getStrInput("Enter the account name: ");
                    if (bank.isCustomer(nameInput)) {
                        System.out.println(bank.getCustomer(nameInput).printTransactions());
                    } else {
                        System.out.println("Account not found.");
                    }
                    endMenuAction();
                }
                case 5 -> {
                    System.out.println("Going back...");
                    isRunning = false;
                    System.out.println();
                }
                default -> System.out.println("Something went wrong...");
            }
        }
    }

    private double getDoubleInput(String prompt) {
        return getDoubleInput(prompt, 0);
    }

    private double getDoubleInput(String prompt, double minimumValue) {
        double input;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                input = scanner.nextDouble();
                scanner.nextLine(); // clear buffer after int input
                if (input > 0 && input > minimumValue) {
                    break;
                } else {
                    String exitStr = getStrInput("Invalid number entered. Exit? [Y] ");
                    if ("Yy".contains(exitStr)) {
                        input = -1;
                        break;
                    }
                }
            }
        }
        return input; // returns -1 if user voluntarily exits
    }

    private int getMenuInput(int validRange, String menuOptions) {
        int input;
        System.out.println(menuOptions);
        while (true) {
            System.out.print("Enter command: ");
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                scanner.nextLine(); // clear buffer after int input
                if (input > 0 && input < validRange+1) {
                    break;
                } else if (input == 0) {
                    System.out.println(menuOptions);
                } else {
                    System.out.println("Input not recognized. Enter 0 to see the menu again.");
                }
            } else {
                System.out.println("Input not recognized. Enter 0 to see the menu again.");
                scanner.nextLine(); // string entered, clear buffer
            }
        }
        return input;
    }

    private String getStrInput(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextLine()) {
                input = scanner.nextLine();
                if (!input.isBlank()) {
                    break;
                }
            } else {
                System.out.println(prompt);
            }
        }
        return input;
    }

    private void endMenuAction() {
        System.out.println("Press enter to continue.");
        scanner.nextLine();
        System.out.println();
    }
}
