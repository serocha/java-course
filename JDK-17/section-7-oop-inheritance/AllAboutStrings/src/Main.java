public class Main {
    public static void main(String[] args) {
        printInfo("Hello World");
        printInfo("");
        printInfo("\t              \n");

        String helloWorld = "Hello World";
        System.out.printf("Index of r = %d %n", helloWorld.indexOf('d'));
        System.out.printf("Index of World = %d %n", helloWorld.indexOf("World"));

        System.out.printf("Index of l = %d %n", helloWorld.indexOf('l'));
        System.out.printf("Last index of l = %d %n", helloWorld.lastIndexOf('l'));
        System.out.printf("Index of l = %d %n", helloWorld.indexOf('l', 3));
        System.out.printf("Last index of l = %d %n", helloWorld.lastIndexOf('l', 8));

        String helloWorldLower = helloWorld.toLowerCase();
        if (helloWorld.equals(helloWorldLower)) {
            System.out.println("Values match exactly");
        }
        if (helloWorld.equalsIgnoreCase(helloWorldLower)) {
            System.out.println("Values match when ignoring case");
        }

        if (helloWorld.startsWith("Hello")) {
            System.out.println("String starts with 'Hello'");
        }
        if (helloWorld.endsWith("World")) {
            System.out.println("String ends with 'World'");
        }
        if (helloWorld.contains("World")) {
            System.out.println("String contains 'World'");
        }

        if (helloWorld.contentEquals("Hello World")) {
            System.out.println("Values match exactly");
        }
    }

    public static void printInfo(String string) {
        int length = string.length();
        System.out.printf("Length = %d %n", length);

        if (string.isEmpty()) {
            System.out.println("String is empty");
            return;
        }

        if (string.isBlank()) {
            System.out.println("String is blank");
            return;
        }

        System.out.printf("First Char = %c %n", string.charAt(0));
        System.out.printf("Last Char = %c %n", string.charAt(string.length()-1));
        System.out.printf("Substring starting at index 6 = %s %n", string.substring(6));
    }
}