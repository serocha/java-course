public class EqualSumChecker {
    public static void main(String[] args) {
        System.out.println("Is the sum of the first two numbers equal to the third? " +
                hasEqualSum(12, 6, 18));
        System.out.println("Is the sum of the first two numbers equal to the third? " +
                hasEqualSum(24, -6, 18));
    }
    public static boolean hasEqualSum(int numberOne, int numberTwo, int numberThree) {
        return (numberOne + numberTwo) == numberThree;
    }
}
