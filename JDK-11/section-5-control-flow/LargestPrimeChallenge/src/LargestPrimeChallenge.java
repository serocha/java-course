public class LargestPrimeChallenge {
    public static void main(String[] args) {
        System.out.println(217/2);
        System.out.println(getLargestPrime(21));
        System.out.println(getLargestPrime(217));
        System.out.println(getLargestPrime(0));
        System.out.println(getLargestPrime(45));
        System.out.println(getLargestPrime(7));
    }

    public static int getLargestPrime(int number) {
        if (number < 2) return -1; // 0 and 1 are not prime numbers

        for (int i=2; i < number; i++) {
            // start with the first prime 2
            if (number % i == 0) {
                number /= i; // if number is divisible, reduce it to a factor
                i--; // reset to try dividing by the same number again, then increment and repeat
            }
        }
        return number;
    }
}

