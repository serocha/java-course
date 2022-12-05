public class Switch {

    public static void main(String[] args){

        /*int value = 1;
        if (value == 1) {
            System.out.println("Value is 1");
        } else if (value == 2) {
            System.out.println("Value is 2");
        } else {
            System.out.println("Value is not 1 or 2");
        }*/

        int switchValue = 1;
        switch (switchValue) {
            case 1:
                System.out.println("Value is 1");
                break;
            case 2:
                System.out.println("Value is 2");
                break;
            case 3: case 4: case 5:
                System.out.println("Was a 3, 4, or 5");
                System.out.println("Value is " + switchValue);
                break;
            default:
                System.out.println("Value is over 5");
                break;
        }

        // Challenge: create a switch statement for the char data type
        char switchChar = 'A';
        switch (switchChar) {
            case 'A': case 'B': case 'C': case 'D': case 'E':
                System.out.println("Character " + switchChar + " was detected");
                break;
            default:
                System.out.println("Could not find A, B, C, D, or E");
                break;
        }

        // Strings require precision, so using various String methods can solve this
        String month = "JanUary";
        switch (month.toLowerCase()) {
            case "january":
                System.out.println("Jan");
                break;
            case "february":
                System.out.println("Feb");
                break;
            default:
                System.out.println("Not sure");
                break;
        }
    }
}
