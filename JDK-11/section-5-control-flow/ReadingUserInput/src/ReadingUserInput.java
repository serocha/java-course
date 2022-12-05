import java.util.Scanner;

public class ReadingUserInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // input

        System.out.println("Please enter your year of birth: ");

        boolean hasNextInt = scanner.hasNextInt(); // check to see if next input is an int (if not returns false)

        if (hasNextInt) {
            int yearOfBirth = scanner.nextInt(); // parse to int
            scanner.nextLine(); // handle next line character (enter key)

            System.out.println("Please enter your name: ");
            String name = scanner.nextLine();
            int age = 2022 - yearOfBirth; // obviously should call a real date instead

            if (age >= 0 && age <= 100) {
                System.out.println("Your name is " + name + ". You are " + age + " years old.");
            } else {
                System.out.println("Invalid year of birth.");
            }
        } else {
            System.out.println("Invalid Number: Unable to parse year of birth.");
        }

        scanner.close(); // delete the instance once it's no longer needed
    }
}
