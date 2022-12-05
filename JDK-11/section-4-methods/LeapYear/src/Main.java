public class Main {
    public static void main(String[] args) {
        int year = 1999;
        System.out.println( "Is " + year + " a leap year? " + LeapYear.isLeapYear(year));
        year = 2000;
        System.out.println( "Is " + year + " a leap year? " + LeapYear.isLeapYear(year));
    }
}
