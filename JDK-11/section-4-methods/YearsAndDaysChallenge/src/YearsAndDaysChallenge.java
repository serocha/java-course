public class YearsAndDaysChallenge {
    private static final String INVALID_VALUE_MESSAGE = "Invalid Value";
    public static void main(String[] args) {
    printYearsAndDays(525600);
    printYearsAndDays(1051200);
    }

    public static void printYearsAndDays(long minutes) {
        if (minutes < 0) {
            System.out.println(INVALID_VALUE_MESSAGE);
            return;
        }
        long days = (minutes/60) / 24; // convert to hours, then days
        String daysString = "" + days % 365; // stringify remainder from years
        String yearsString = "" + days / 365; // stringify years
        System.out.println("" + minutes + " min = " + yearsString + " y and " + daysString + " d");
    }
}
