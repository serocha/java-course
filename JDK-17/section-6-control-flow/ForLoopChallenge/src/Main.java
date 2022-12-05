public class Main {
    public static void main(String[] args) {
        printIsPrime(0, 20);
        printIsPrime(200, 300);
        printIsPrime(21, 500);
        printIsPrime(170, 412);
        printIsPrime(200, 1000);
        printIsPrime(100, 40);
    }
    public static void printIsPrime(int minRange, int maxRange) {
        // print the first 3 prime numbers in the range
        if (maxRange > 999) {
            System.out.println("Please enter a number less than 1000");
            return;
        } else if (minRange > maxRange) {
            System.out.println("Minimum is greater than maximum. Reversing.");
            int temp = maxRange;
            maxRange = minRange;
            minRange = temp;
        }
        int counter = 0;

        for (int i=minRange; i<maxRange; i++) {
            if (counter >= 3){
                break;
            }

            if (isPrime(i)){
                counter++;
                System.out.println(i);
            }
        }
        System.out.println("Total prime numbers found: " + counter);
    }

    public static boolean isPrime(int wholeNumber) {
        if (wholeNumber <= 2) {
            return (wholeNumber == 2); // 2 is the first prime number
        }
        // checking any numbers divisible by 2 will also be divisible by wholeNumber/2
        // so limiting your loops to wholeNumber/2 reduces the number of iterations
        for (int divisor = 2; divisor <= wholeNumber/2; divisor++) {
            if (wholeNumber % divisor == 0) {
                return false; // found a number that evenly divides wholeNumber
            }
        }
        return true; // didn't find a number
    }
}