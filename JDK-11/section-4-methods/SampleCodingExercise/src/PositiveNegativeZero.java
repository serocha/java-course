public class PositiveNegativeZero {

    public static void main(String[] args) {
        checkNumber(5);
        checkNumber(-5);
        checkNumber(0);
    }

    public static void checkNumber(int number) {

        if(number > 0) {
            System.out.println("The number is positive.");
        } else if(number < 0) {
            System.out.println("The number is negative.");
        } else {
            System.out.println("The number is zero.");
        }
    }
}
