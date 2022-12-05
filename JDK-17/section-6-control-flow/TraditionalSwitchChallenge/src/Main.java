public class Main {
    public static void main(String[] args) {
        // convert chars to NATO phonetic alphabet (only A-E)

        char letter = 'a';
        natoConverter(letter);
        letter = 'b';
        natoConverter(letter);
        letter = 'f';
        natoConverter(letter);
        letter = '9';
        natoConverter(letter);
        letter = 'E';
        natoConverter(letter);
    }

    public static void natoConverter(char letter) {
        if (Character.isLetter(letter)) {
            letter = Character.toUpperCase(letter);
        } else {
            System.out.println("Non-letter character entered.");
            return;
        }

        switch (letter) {
            case 'A':
                System.out.println(letter + " is Alpha");
                break;
            case 'B':
                System.out.println(letter + " is Bravo");
                break;
            case 'C':
                System.out.println(letter + " is Charlie");
                break;
            case 'D':
                System.out.println(letter + " is Delta");
                break;
            case 'E':
                System.out.println(letter + " is Echo");
                break;
            default:
                System.out.println("Letter" + letter + "not recognized. Use letters between A - E.");
        }
    }
}