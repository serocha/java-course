import java.util.Scanner;

public class ReadingUserInputChallenge {
    public static void main(String[] args) {
        inputNumbers();
    }

    public static void inputNumbers() {
        Scanner userInput = new Scanner(System.in);
        int counter = 0;
        int max = 10;
        int sum = 0;

        while (counter < max) {
            System.out.print("Enter number #" + (counter + 1) + ": "); // prompt
            boolean isInteger = userInput.hasNextInt(); // expecting next input as number else try again

            if(isInteger) {
                int number = userInput.nextInt(); // get number
                sum += number;
                counter++;
            } else {
                System.out.println("Invalid Number"); // validation
            }
            userInput.nextLine(); // prep for next iteration
        }
        System.out.print("The sum is " + sum);
        userInput.close(); // clean up
    }
}
