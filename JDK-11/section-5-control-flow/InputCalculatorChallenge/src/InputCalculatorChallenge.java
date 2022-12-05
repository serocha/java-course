import java.util.Scanner;

public class InputCalculatorChallenge {
    public static void main(String[] args) {
        inputThenPrintSumAndAverage();
    }

    public static void inputThenPrintSumAndAverage() {
        System.out.println("This program calculates the sum and average of all numbers you enter.");
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int counter = 0;
        long average = 0;
        boolean isRunning = true;

        while(isRunning) {
            System.out.print("Please enter a number: ");
            boolean isValidInt = scanner.hasNextInt();

            if(isValidInt) {
                int number = scanner.nextInt();
                sum += number;
                counter++;
                System.out.println(11/3);
                average = Math.round((double) (sum)/counter); // cast int to double to work with Math.round
            } else {
                System.out.println("SUM = " + sum + " AVG = " + average);
                isRunning = false;
            }
        }
    }
}
