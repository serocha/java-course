public class PerfectNumberChallenge {
    public static void main(String[] args) {
        System.out.println(isPerfectNumber(6));
        System.out.println(isPerfectNumber(28));
        System.out.println(isPerfectNumber(5));
    }

    public static boolean isPerfectNumber(int number) {
        if (number < 1) {
            return false;
        }
        int sum = 0;
        for (int i=number-1; i>=1; i--) {
            if (number%i == 0) {
                sum += i;
            }
        }
        return number == sum;
    }
}
