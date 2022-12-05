public class TeenNumberChecker {
    public static void main(String[] args) {
        // are any of the three numbers between 13 and 19?
        System.out.println(hasTeen(45, 11, 23));
        System.out.println(hasTeen(98, 15, 9));
    }

    public static boolean hasTeen(int numberOne, int numberTwo, int numberThree) {

        if (isTeen(numberOne)) {
            return true;
        } else if (isTeen(numberTwo)) {
            return true;
        } else return isTeen(numberThree);
    }

    public static boolean isTeen(int number) {
        return (number > 12 && number < 20);
    }
}