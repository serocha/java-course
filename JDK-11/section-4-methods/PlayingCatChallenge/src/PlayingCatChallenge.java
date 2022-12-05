public class PlayingCatChallenge {

    public static void main(String[] args) {
        System.out.println(isCatPlaying(true, 45));
        System.out.println(isCatPlaying(false, 45));
        System.out.println(isCatPlaying(true,46));
        System.out.println(isCatPlaying(true, 25));
        System.out.println(isCatPlaying(false, 25));
    }

    public static boolean isCatPlaying(boolean summer, int temperature) {
        int upperBound = 35;
        if (summer) {
            upperBound = 45;
        }
        return temperature >= 25 && temperature <= upperBound;
    }
}
