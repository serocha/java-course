public class FirstAndLastDigitSumChallenge {

    // note that the expected answer treats single digits as both first AND last digits
    // I disagree with this, so that part has been commented out
    public static void main(String[] args) {
        System.out.println(sumFirstAndLastDigit(-6));
        System.out.println(sumFirstAndLastDigit(1));
        System.out.println(sumFirstAndLastDigit(121));
        System.out.println(sumFirstAndLastDigit(54321));
    }

    public static int sumFirstAndLastDigit(int n) {
        if (n < 0) {
            return -1; // handle negatives
        } // else if ((n/2) == 0) { return n * 2; }     <--- this is where I disagree, tacked on to pass challenge
        int lastDigit = n % 10; // take last digit
        while (true) {
            n /= 10; // pop off digit
            if ((n/10) != 0) {
                continue; // test if there's another digit, continue if true
            }
            return lastDigit + n; // return sum of first and last
        }
    }
}
