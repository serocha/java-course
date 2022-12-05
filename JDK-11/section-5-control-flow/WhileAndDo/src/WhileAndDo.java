public class WhileAndDo {
    //
    public static void main(String[] args) {
        /*int count = 0;
        while (count != 5) {
            System.out.println("Count value is " + count);
            count++;
        }

        count = 0;
        while (true) {
            if (count == 5) {
                break;
            }
            System.out.println("Count value is " + count);
            count++;
        }

        count = 0;
        do {
            System.out.println("Count value is " + count);
            count++;
        } while (count < 5);*/

        int number = 4;
        int finishNumber = 20;
        int evenCount = 0;
        // test for odd numbers
        while (number <= finishNumber) {
            number++; // when using while, incrementing is often done first to prevent endless looping
            if (!isEvenNumber(number)) {
                continue; // restart from the top
            }
            System.out.println(number + " is an even number"); // executes if continue isn't triggered
            evenCount++;
            if (evenCount >= 5) {
                break;
            }
        }
        System.out.println("Total even numbers found: " + evenCount);
    }

    public static boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }
}
