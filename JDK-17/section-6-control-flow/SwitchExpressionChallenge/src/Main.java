public class Main {
    public static void main(String[] args) {
        printDayOfWeek(0);
        printDayOfWeek(4);
        printDayOfWeek(6);
        printDayOfWeek(7);

        printWeekDay(0);
        printWeekDay(4);
        printWeekDay(6);
        printWeekDay(7);
    }

    public static void printDayOfWeek(int day) {
        // note that in switch expressions, you can get a default return (yield) value directly
        String dayOfTheWeek = switch (day) {
            case 0 -> "Sunday";
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            default -> "an invalid day value";
        };
        System.out.println(day + " is " + dayOfTheWeek);
    }

    public static void printWeekDay(int day) {
        // create same output using if statements
        String dayOfTheWeek;
        if (day == 0) {
            dayOfTheWeek = "Sunday";
        } else if (day == 1) {
            dayOfTheWeek = "Monday";
        } else if (day == 2) {
            dayOfTheWeek = "Tuesday";
        } else if (day == 3) {
            dayOfTheWeek = "Wednesday";
        } else if (day == 4) {
            dayOfTheWeek = "Thursday";
        } else if (day == 5) {
            dayOfTheWeek = "Friday";
        } else if (day == 6) {
            dayOfTheWeek = "Saturday";
        } else {
            dayOfTheWeek = "an invalid day value";
        }
        System.out.println(day + " is " + dayOfTheWeek);
    }
}