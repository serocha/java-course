public class SecondsAndMinutesChallenge {
    // converts minutes and seconds into a string HH hr MM min SS sec
    private static final String INVALID_VALUE_MESSAGE = "Invalid Value";
    public static void main(String[] arg) {
        System.out.println(getDurationString(59, 52));
        System.out.println(getDurationString(60, 12));
        System.out.println(getDurationString(9001, 0));
        System.out.println(getDurationString(0, 27));

        System.out.println(getDurationString(0));
        System.out.println(getDurationString(59));
        System.out.println(getDurationString(60));
        System.out.println(getDurationString(91452L));
    }

    public static String getDurationString(long minutes, int seconds) {
        if (minutes < 0 || (seconds < 0 || seconds > 59) ) {
            return INVALID_VALUE_MESSAGE + " passed to getDurationString()";
        }
        // numberToString ensures format remains at least 2 digits
        String hoursString = numberToString(minutes >= 60 ? minutes/60 : 0); //  min -> hr, min
        String minutesString = numberToString(minutes%60); // remaining min
        String secondsString = numberToString(seconds);

        return hoursString + "h " + minutesString + "m " + secondsString + "s";
    }

    public static String getDurationString(long seconds) {
        if (seconds < 0) {
            return INVALID_VALUE_MESSAGE + " passed to getDurationString()";
        }
        return getDurationString(seconds/60, (int) (seconds%60)); // seconds -> min, sec
    }

    public static String numberToString(long number) {
        if (number < 0) {
            return INVALID_VALUE_MESSAGE + " passed to numberToString()";
        }

        if (number == 0) {
            return "00"; // ensure 2 digit format in special case
        } else if (number < 10) {
            return "0" + number; // same as above
        }
        return "" + number; // stringify all other results
    }
}
