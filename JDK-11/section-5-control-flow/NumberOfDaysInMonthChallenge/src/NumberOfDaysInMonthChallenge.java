public class NumberOfDaysInMonthChallenge {

    public static void main(String[] args) {

        System.out.println(isLeapYear(-1600));
        System.out.println(isLeapYear(1600));
        System.out.println(isLeapYear(2017));
        System.out.println(isLeapYear(2000));

        System.out.println(getDaysInMonth(1, 2020));
        System.out.println(getDaysInMonth(2, 2020));
        System.out.println(getDaysInMonth(2, 2018));
        System.out.println(getDaysInMonth(-1, 2020));
        System.out.println(getDaysInMonth(1, -2020));
    }

    public static boolean isLeapYear(int year) {
        // check validity of input
        if (year < 1 || year > 9999) {
            return false;
        }

        // a year is a leap year if divisible by 4 but not 100, or by 400
        if (year % 4 == 0 && year % 100 != 0) {
            return true;
        } else {
            return year % 400 == 0;
        }
    }

    public static int getDaysInMonth(int month, int year) {
        // validity check
        if ((month < 1 || month > 12) || (year < 1 || year > 9999)) {
            return -1;
        }

        boolean leapYear = isLeapYear(year);
        switch (month) {
            case 2:
                // FEB is special case with 28 days (29 during leap years)
                return leapYear ? 29 : 28;
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            default:
                return -1;
        }
    }
}
