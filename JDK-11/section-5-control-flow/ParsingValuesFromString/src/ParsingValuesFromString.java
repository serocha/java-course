public class ParsingValuesFromString {

    public static void main(String[] args) {
        String numberAsString = "2018.125";
        System.out.println("numberAsString = " + numberAsString);

        double number = Double.parseDouble(numberAsString);
        System.out.println("Number = " + number);

        numberAsString += 1; // still a string
        System.out.println("As a string = " + numberAsString);
        number += 1; // parsed to int
        System.out.println("As a double = " + number);
    }


}
