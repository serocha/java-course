public class DayOfTheWeekChallenge {
    public static void main(String[] args) {
        printDayOfTheWeek(0);
        printDayOfTheWeek(-5);
        printDayOfTheWeek(4);

        printDayOfTheWeekIfElse(0);
        printDayOfTheWeekIfElse(-5);
        printDayOfTheWeekIfElse(4);
    }

    private static void printDayOfTheWeek(int day) {

        String dayString;
        switch (day) {
            case 0:
                dayString = "Sunday";
                break;
            case 1:
                dayString = "Monday";
                break;
            case 2:
                dayString = "Tuesday";
                break;
            case 3:
                dayString = "Wednesday";
                break;
            case 4:
                dayString = "Thursday";
                break;
            case 5:
                dayString = "Friday";
                break;
            case 6:
                dayString = "Saturday";
                break;
            default:
                dayString = "Invalid day";
                break;
        }
        System.out.println(dayString);
    }

    private static void printDayOfTheWeekIfElse(int day) {
        String dayString;
        if (day == 0) {
            dayString = "Sunday";
        } else if (day == 1) {
            dayString = "Monday";
        } else if (day == 2) {
            dayString = "Tuesday";
        } else if (day == 3) {
            dayString = "Wednesday";
        } else if (day == 4) {
            dayString = "Thursday";
        } else if (day == 5) {
            dayString = "Friday";
        } else if (day == 6) {
            dayString = "Saturday";
        } else {
            dayString = "Invalid day";
        }
        System.out.println(dayString);
    }
}
