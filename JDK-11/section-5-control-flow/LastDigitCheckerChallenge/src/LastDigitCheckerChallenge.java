public class LastDigitCheckerChallenge {

    public static void main(String[] args) {
        System.out.println(hasSameLastDigit(200, 54, 91));
        System.out.println(hasSameLastDigit(531, 31, 435));
        System.out.println(hasSameLastDigit(774, 339, 604));
        System.out.println(hasSameLastDigit(33, 678, 98));
    }

    public static boolean hasSameLastDigit(int n1, int n2, int n3) {
        if (isValid(n1) && isValid(n2) && isValid(n3)) {
            return (n1%10) == (n2%10) || (n1%10) == (n3%10) || (n2%10) == (n3%10);
        } else {
            return false;
        }
    }

    public static boolean isValid(int value) {
        return value >= 10 && value <= 1000;
    }
}
