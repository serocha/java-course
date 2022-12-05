public class EvenDigitSumChallenge {
    public static void main(String[] args) {
        System.out.println(getEvenDigitSum(242));
        System.out.println(getEvenDigitSum(13569));
        System.out.println(getEvenDigitSum(12380));
    }

    public static int getEvenDigitSum(int number) {
        if (number < 0) {
            return -1;
        }

        int sum = 0;
        while (number > 0) {
            if ( (number%10) % 2 == 0) {
                sum += number%10;
            }
            number /= 10;
        }
        return sum;
    }
}
