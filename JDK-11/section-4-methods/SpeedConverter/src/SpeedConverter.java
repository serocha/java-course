public class SpeedConverter {
    public static long toMilesPerHour(double kilometersPerHour) {

        if(kilometersPerHour < 0) {
            return -1;
        } else {
            return Math.round(kilometersPerHour / 1.609);
        }
    }

    public static void printConversion(double kilometersPerHour) {

        long milesPerHour = toMilesPerHour(kilometersPerHour);

        if(milesPerHour < 0) {
            System.out.println("Invalid Value");
            return;
        }

        System.out.println(kilometersPerHour + " km/h = " + milesPerHour + " mi/h");
    }
}