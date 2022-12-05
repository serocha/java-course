public class For {

    public static void main(String[] args){

        for (int i=2; i<9; i++) {
            System.out.println("10,000 at " + i +"% interest = " + String.format("%.2f",calculateInterest(10000.0, (double) i)));
        }
        System.out.println("\n");
        for (int i=8; i>1; i--) {
            System.out.println("10,000 at " + i + "% interest = " + String.format("%.2f", calculateInterest(10000.0, (double) i)));
        }

        numberOfPrimes(10);
    }

    public static void numberOfPrimes(int n) {
        int primeCount = 0;
        // print out the first 3 primes in ascending order from a given number
        for (int i=n; i<=n+40; i++) {
            if (isPrime(i)) {
                System.out.println(i + " is a prime number");
                primeCount++;
                if (primeCount == 10) {
                    break;
                }
            }
        }
    }

    public static boolean isPrime(int n) {

        if (n == 1) {
            return false;
        }

        for (int i=2; i<= (long) Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static double calculateInterest(double amount, double interestRate) {
        return (amount * (interestRate/100));
    }
}
