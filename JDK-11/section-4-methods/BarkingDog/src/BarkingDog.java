public class BarkingDog {
    // if a dog is barking and the hours are between 11pm and 8am, wake up (true)
    public static boolean shouldWakeUp(boolean barking, int hourOfDay) {
       if (barking) {
           if (hourOfDay > 0 && hourOfDay < 8) {
               return true;
           } else return hourOfDay == 23;
       }
       return false;
    }
}