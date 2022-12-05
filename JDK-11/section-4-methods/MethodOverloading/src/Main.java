public class Main {
    public static void main(String[] args) {
        int newScore = calculateScore("Tim", 500);
        System.out.println("New score is " + newScore);
        System.out.println("Overloaded method...");
        System.out.println("New score is " + calculateScore(75));
        calculateScore();

        System.out.println(calculateFeetAndInchesToCentimeters(5, 0));
        System.out.println(calculateFeetAndInchesToCentimeters(54));
    }

    public static int calculateScore(String playerName, int score) {
        System.out.println("Player " + playerName + " scored " + score + " points.");
        return score * 10;
    }

    public static int calculateScore(int score) {
        System.out.println("Unnamed player score: " + score + " pts.");
        return score * 10;
    }

    public static void calculateScore() {
        System.out.println("No player name. No player score.");
    }

    public static double calculateFeetAndInchesToCentimeters(int feet, double inches) {
        if ( (feet < 0) || (inches < 0 || inches >= 12) ) {
            System.out.println("Invalid feet or inches parameter.");
            return -1;
        }
        return 2.54 * (12 * feet + inches); // convert feet to inches, add inches, multiply by 2.54
    }

    public static double calculateFeetAndInchesToCentimeters(double inches) {
        if ( inches < 0) {
            System.out.println("Invalid inches parameter.");
            return -1;
        }
        return 2.54 * inches; // multiply inches by 2.54
    }
}
