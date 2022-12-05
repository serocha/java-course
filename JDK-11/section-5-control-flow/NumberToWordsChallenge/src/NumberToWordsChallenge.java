public class NumberToWordsChallenge {
    // prints each digit as a word; this would make more sense using arrays
    public static void main(String[] args) {
        numberToWords(3472);
        numberToWords(0);
        numberToWords(-2343);
    }

    public static void numberToWords(int number) {
        // this method doesn't handle taking a leading zero, may revisit to fix this
        if (number < 0) {
            System.out.println("Invalid Value");
            return;
        }

        int reversedNumber = reverse(number);
        int trailingZeros = getDigitCount(number) - getDigitCount(reverse(number));
        StringBuilder numberString = new StringBuilder();
        do {
            switch ( reversedNumber % 10 ) {
                case 0:
                    numberString.append("Zero ");
                    break;
                case 1:
                    numberString.append("One ");
                    break;
                case 2:
                    numberString.append("Two ");
                    break;
                case 3:
                    numberString.append("Three ");
                    break;
                case 4:
                    numberString.append("Four ");
                    break;
                case 5:
                    numberString.append("Five ");
                    break;
                case 6:
                    numberString.append("Six ");
                    break;
                case 7:
                    numberString.append("Seven ");
                    break;
                case 8:
                    numberString.append("Eight ");
                    break;
                case 9:
                    numberString.append("Nine ");
                    break;
                default:
                    System.out.println("Something went wrong");
            }
            reversedNumber /= 10;
        } while (reversedNumber != 0);
        numberString.append("Zero ".repeat(Math.max(0, trailingZeros)));
        System.out.println(numberString);
    }

    public static int reverse(int number) {
        int reversed = 0;
        while (number != 0) {
            if (number/10 != 0) {
                reversed += number % 10;
                reversed *= 10;
                number /= 10;
            } else {
                reversed += number;
                break;
            }
        }
        return reversed;
    }

    public static int getDigitCount(int number) {
        if (number < 0) {
            return -1;
        } else if (number == 0) {
            return 1; // edge case quick fix
        }
        int digits = 0;
        while(number > 0) {
            number /= 10;
            digits += 1;
        }
        return digits;
    }
}
