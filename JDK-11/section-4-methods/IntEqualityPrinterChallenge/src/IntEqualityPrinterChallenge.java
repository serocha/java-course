public class IntEqualityPrinterChallenge {

    public static void main(String[] args){
        printEqual(1, 1, 1);
        printEqual(-1, 0, 2);
        printEqual(1, 1, 0);
        printEqual(1, 0, 1);
        printEqual(0, 1, 1);
        printEqual(1, 2, 3);
    }

    public static void printEqual(int firstValue, int secondValue, int thirdValue) {
        if (firstValue < 0 || secondValue < 0 || thirdValue < 0) {
            System.out.println("Invalid Value");
            return;
        }

        if (firstValue == secondValue && firstValue == thirdValue) {
            System.out.println("All numbers are equal");
        } else if (firstValue != secondValue && secondValue != thirdValue && thirdValue != firstValue) {
            System.out.println("All numbers are different");
        } else {
            System.out.println("Neither all are equal or different");
        }
    }
}
