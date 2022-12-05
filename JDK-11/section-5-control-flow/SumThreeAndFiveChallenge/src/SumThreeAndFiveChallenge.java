public class SumThreeAndFiveChallenge {

    public static void main(String[] args) {
        int counter = 0;
        int sum = 0;
        for (int i=15; i <= 1000; i+=15) {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                counter++;
                sum += i;
                System.out.println("Found number = " + i);
            }
            if (counter == 5) {
                break;
            }
        }
        System.out.println("Sum = " + sum);
    }
}
