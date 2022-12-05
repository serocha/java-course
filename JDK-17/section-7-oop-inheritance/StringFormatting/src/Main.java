public class Main {

    public static void main(String[] args) {

        String bulletIt = "Print a bulleted list:\n" +
                "\t\u2022 First Point\n" +
                "\t\t\u2022 Sub Point";
        System.out.println(bulletIt);

        String textBlock = """
                Print a bulleted List:
                    \u2022 First Point
                        \u2022 "Sub Point 1"
                        \u2022 "Sub Point 2"
                """;
        System.out.println(textBlock);
        // note that the text block preserves newlines and tabs without having to use escape chars

        int age = 35;
        System.out.printf("Your age is %d%n", age); // print format, no newline, same as System.out.format()
        // note %n uses the platform-specific new line symbol, while \n might not work cross-platform

        int yearOfBirth = 2023 - age;
        System.out.printf("Your age is %d, year of birth is %d%n", age, yearOfBirth);
        System.out.printf("Float %.2f%n", (float) age);

        for (int i=1; i<=100000; i *= 10) {
            System.out.printf("Printing %6d %n", i);
        }

        String formattedString = String.format("Your age is %d", age);
        System.out.println(formattedString);

        formattedString = "Your age is %d".formatted(age); // you can run this directly on the string
        System.out.println(formattedString);
    }
}