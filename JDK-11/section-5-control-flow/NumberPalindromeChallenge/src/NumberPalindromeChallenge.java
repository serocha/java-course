public class NumberPalindromeChallenge {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-545));
        System.out.println(isPalindrome(-123));
        System.out.println(isPalindrome(0));
        System.out.println(isPalindrome(543));
        System.out.println(isPalindrome(393));
    }

    public static boolean isPalindrome(int number) {
        // first check if negative and correct
        if (number < 0) {
            number = Math.abs(number);
        }
        int reverse = 0;
        int remainingNumber = number; // I'm preserving the original value to compare against later
        while (remainingNumber > 0) {
            reverse *= 10;
            reverse += remainingNumber % 10;
            remainingNumber /= 10;
        }
        return reverse == number;
    }
}
