import java.util.Scanner;

public class MinAndMaxInputChallenge {
    public static void main(String[] args) {
        inputMinMax();
    }

    public static void inputMinMax() {
        // enter an endless loop where user inputs numbers
        // entering an invalid number breaks loop (dislike that requirement)
        Scanner scanner = new Scanner(System.in);
        int min = 0;
        int max = 0;
        boolean first = true; // alternative: set min/max to Integer.MAX_VALUE/.MIN_VALUE (all values MUST be in that range)

        while (true) {
            System.out.print("Please enter a number: ");
            boolean isInteger = scanner.hasNextInt(); // check next input is int

            if (isInteger) {
                int number = scanner.nextInt(); // input
                if (number < min || first) {
                    min = number; // check min & special case (first iteration)
                    if (first) {
                        max = number; // special case
                        first = false;
                    }
                } else if (number > max) {
                    max = number; // check max
                }
            } else {
                System.out.println("Invalid Number");
                break; // break if invalidated
            }
            scanner.nextLine(); // prep for next input
        }
        System.out.println("Min: " + min + ", Max: " + max); // report min and max entered
        scanner.close(); // clean
    }
}
