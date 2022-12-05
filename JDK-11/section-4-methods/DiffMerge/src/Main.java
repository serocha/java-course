public class Main {
    public static void main(String[] args) {

        int highScore = calculateScore(true, 5000, 5, 100);
        System.out.println("Your final score was " + highScore);

        highScore = calculateScore(true, 10000, 8, 200);
        System.out.println("Your final score was " + highScore);


        displayHighScorePosition("John", calculateHighScorePosition(50));
        displayHighScorePosition("Michael", calculateHighScorePosition(900));
        displayHighScorePosition("Timmy", calculateHighScorePosition(1500));
        displayHighScorePosition("Alex", calculateHighScorePosition(400));
    }

    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {

        if(gameOver) {
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 2000;
            return finalScore;
        } else {
            return -1; // the return can be outside of the control statement, as the first return will end the method
        }
    }

    public static void displayHighScorePosition (String playerName, int position) {
        System.out.println(playerName + " took position " + position + " on the high score table.");
    }

    public static int calculateHighScorePosition(int score) {

        int position = 4;

        if(score >= 1000) {
            position = 1;
        } else if(score >= 500) {
            position = 2;
        } else if(score >= 100) {
            position = 3;
        }

        return position;
    }
}