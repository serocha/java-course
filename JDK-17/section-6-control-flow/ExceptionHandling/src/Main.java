import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int currentYear = 2022;

        try {
            System.out.println(getInputFromConsole(currentYear)); // using console() in an IDE will trigger an error
        } catch (NullPointerException e) {
            System.out.println(getInputFromScanner(currentYear)); // Scanner class won't have an error
        }
    }

    public static String getInputFromConsole(int currentYear) {
        String name = System.console().readLine("Hi, what's your name?");
        System.out.println("Thank you " + name + ".");

        String dateOfBirth = System.console().readLine("What year were you born?");
        int age = currentYear - Integer.parseInt(dateOfBirth); // parse to integer
        return "So you are " + age + " years old.";
    }

    public static String getInputFromScanner(int currentYear) {
        Scanner scanner = new Scanner(System.in); // either pass System.in or new File("nameOfFileOnSystem")

        System.out.println("Hi, what's your name?");
        String name = scanner.nextLine(); // takes next line; be careful as any next line printed will be used
        System.out.println("Thank you " + name + ".");

        boolean validDOB = false;
        int age = 0;
        System.out.println("What year were you born?");

        do {
            System.out.println("Enter a year of birth >= " +
                    (currentYear - 125) + " and <= " + currentYear);
            try {
                age = checkData(currentYear, scanner.nextLine()); // validate birth year
                validDOB = age >= 0; // loop condition
            } catch (NumberFormatException badUserData) {
                System.out.println("Characters not allowed. Try again."); // non-numeric characters
            }
        } while (!validDOB);
        return "So you are " + age + " years old.";
    }

    public static int checkData(int currentYear, String dateOfBirth) {
        int dob = Integer.parseInt(dateOfBirth);
        int minimumYear = currentYear - 125;

        if (dob < minimumYear || dob > currentYear) {
            return -1;
        }

        return currentYear - dob;
    }
}