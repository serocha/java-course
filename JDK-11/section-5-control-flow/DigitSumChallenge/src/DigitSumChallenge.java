public class DigitSumChallenge {
    public static void main(String[] args) {
        System.out.println(sumDigits(-1));
        System.out.println(sumDigits(9));
        System.out.println(sumDigits(10));
        System.out.println(sumDigits(125));
        System.out.println(sumDigits(16495));
    }

    private static int sumDigits(int number) {
        // check if there are at least 2 digits and positive
        if (number < 10) {
            return -1;
        }

        int sum = 0;
        while(number > 0) {
            sum += number % 10; // capture the last digit, then sum
            number /= 10; // remove the last digit
        }
        return sum;
    }
}
