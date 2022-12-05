public class Main {
    public static void main(String[] args) {
        int result = 1 + 2; // = is an assignment operator, + is the addition operator
        System.out.println("1 + 2 = " + result);
        int previousResult = result;
        System.out.println("previousResult = " + previousResult);
        result = result - 1; // subtraction operator
        System.out.println("3 - 1 = " + result);
        System.out.println("previousResult = " + previousResult);

        result = result * 10; // multiplication
        System.out.println("2 * 10 = " + result);
        result = result / 5; // division
        System.out.println("20 / 5 = " + result);

        result = result % 3; // remainder (4/3 is 1 with 1 left over)
        System.out.println("4 % 3 = " + result);
        // SHORTCUTS: result = result + 1;
        result++; //increment by 1 (1 + 1 in this case)
        System.out.println("1++ -> " + result);

        result--;
        System.out.println("result-- -> " + result);

        result += 2; // increment by a set amount (should be 3)
        System.out.println("result += 2 -> " + result);

        result *= 10; // multiply by amount
        System.out.println("result *= 10 -> " + result);

        result /= 10;
        System.out.println("result /= 10 -> " + result);

        result -= 2;
        System.out.println("result -= 2 -> " + result);

        boolean isAlien = false; // note that the ! operator is a good shortcut instead
        if (isAlien == false) {
            System.out.println("It is not an Alien!");
            System.out.println("And I am scared of aliens...");
        }

        int topScore = 80;
        if (topScore < 100) {
            System.out.println("You got the high score!");
        }

        int secondTopScore = 96; // in general, encapsulating your conditionals makes it easier to read
        if ((topScore > secondTopScore) && (topScore < 100)) {
            System.out.println("Greater than second top score and less than 100");
        }

        if ((topScore > 90) || (secondTopScore <= 90)) {
            System.out.println("Either or both conditions are true");
        }

        int newValue = 50;
        if (newValue == 50) {
            System.out.println("This is true");
        }

        boolean isCar = false; // the NOT operator (!) is useful checking booleans
        if (!isCar) {
            System.out.println("This is false");
        }

        // ternary operator
        boolean wasCar = isCar ? true : false;
        // it can be helpful to wrap the conditional with parenthesis for clarity
        int customerAge = 21;
        boolean isOverEighteen = (customerAge >= 18) ? true : false;
    }
}