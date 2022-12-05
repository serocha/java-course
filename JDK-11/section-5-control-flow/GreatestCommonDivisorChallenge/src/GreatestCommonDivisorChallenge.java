public class GreatestCommonDivisorChallenge {
    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisor(25, 15));
        System.out.println(getGreatestCommonDivisor(20, 20));
        System.out.println(getGreatestCommonDivisor(235, 70));
    }

    public static int getGreatestCommonDivisor(int first, int second) {
        if (first < 10 || second < 10) {
            return -1;
        } else if (first == second) {
            return first; // special case
        }

        for (int i=Math.min(first, second); i>0; i--) {
            if ((first%i == 0) && (second%i == 0)) {
                return i;
            }
        }
        return -1; // something went wrong
    }
}
