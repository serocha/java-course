public class Main {

    public static void main(String[] args) {
        // expressions are built with variables, values, operators, and method calls
        double kilometers = (100 * 1.609344); // one type of expression is a var and its value
        int highScore = 50;
        // another is a boolean evaluation
        if(highScore == 50) {
            System.out.println("This is an expression"); // an expression inside a method
        }

        // Challenge: determine what parts of the following code are expressions
        int score = 100; // score = 100
        if (score > 99) { // score > 99
            System.out.println("You got the high score!"); // "You got the high score!"
            score = 0; // score = 0
        }
    }
}