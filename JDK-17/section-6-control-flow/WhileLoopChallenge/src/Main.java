public class Main {
    public static void main(String[] args) {
        printEvens(5, 20);
        printEvens(20, 5);
        printEvens(-1, 5);
    }

    public static void printEvens(int min, int max) {
        if (min < 0 || max < 0) {
            System.out.println("Enter positive numbers");
            return;
        } else if (min > max) {
            System.out.println("Minimum is greater than maximum. Reversing."); // a silly validation just because
            int temp = max;
            max = min;
            min = temp;
        }

        while (min <= max) {
            if (isEvenNumber(min)) {
                System.out.println(min + " is an even number");
            }
            min++;
        }
    }

    public static boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }
}