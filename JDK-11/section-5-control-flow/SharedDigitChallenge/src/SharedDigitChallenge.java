public class SharedDigitChallenge {
    public static void main(String[] args) {
        System.out.println(hasSharedDigit(12, 23));
        System.out.println(hasSharedDigit(12, 42));
        System.out.println(hasSharedDigit(12, 19));
        System.out.println(hasSharedDigit(12, 91));
        System.out.println(hasSharedDigit(12, 45));
    }

    public static boolean hasSharedDigit(int n1, int n2) {
        if ( (n1 < 10 || n1 > 99) || (n2 < 10 || n2 > 99)) {
            return false; // range set by question
        }

        for (int i=n1; i>0; i/=10) {
            for (int j=n2; j>0; j/=10) {
                if (i%10 == j%10) {
                    return true;
                }
            }
        }
        return false;
    }
}
