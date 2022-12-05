public class Main {

    public static void main(String[] args) {
        int myVariable=50; // the full line is the statement
        if (myVariable == 50) {
            System.out.println("Printed");
        }
        myVariable++;
        myVariable--;
        System.out.println("This is a test");

        System.out.println("This is" +
                " another" +
                " still more.");
        // bad practice but legal, as each statement is separated by a semi-colon separator
        int anotherVariable=50;myVariable--;System.out.println("This is another one");

    }
}